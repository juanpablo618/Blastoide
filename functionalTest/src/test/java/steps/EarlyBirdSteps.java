package steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.WebDriver;
import screenplay.models.AirBookingFlow;
import screenplay.models.EarlyBirdFlowInformation;
import screenplay.questions.*;
import screenplay.tasks.airBooking.*;
import screenplay.tasks.earlyBird.*;
import screenplay.user_interface.airBooking.PaymentMethodForm;
import screenplay.user_interface.earlyBird.EarlyBirdConfirmationPageTripSummarySection;
import screenplay.user_interface.earlyBird.LandingPageForm;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.hamcrest.Matchers.*;

public class EarlyBirdSteps extends CommonConfirmation {

    private static final String ONE_WAY = "One-way";
    private static final double PRICE_EB = 15.00;
    private static final int JMX_PORT = 14425;
    private static final String JMX_HOST = "localhost";
    private static final String JMX_URL = "service:jmx:rmi:///jndi/rmi://" + JMX_HOST + ":" + JMX_PORT + "/jmxrmi";
    private static JMXServiceURL serviceUrl;
    private static JMXConnector jmxConnector;

    public static final String ENABLE_CREDIT_CARD_TOKEN_VALIDATION = "enableCreditCardTokenValidationFeature";

    private EarlyBirdFlowInformation earlyBirdFlowInformation;

    @Managed()
    private WebDriver webDriver;

    @BeforeStories
    public void beforeStories() throws Exception {
        if (isLocalEnvironment()) {
            serviceUrl = new JMXServiceURL(JMX_URL);
            jmxConnector = JMXConnectorFactory.connect(serviceUrl, null);
            changeFeatureToggle(ENABLE_CREDIT_CARD_TOKEN_VALIDATION, false);
        }
    }

    @AfterStories
    public void afterStories() throws Exception {
        if (isLocalEnvironment()) {
            changeFeatureToggle(ENABLE_CREDIT_CARD_TOKEN_VALIDATION, true);
        }
    }

    @Given("a PNR with the following Itinerary: $table")
    public void setTraveler(ExamplesTable table) {

        airBookingFlow = AirBookingFlow.storeAirBookingFlowData(table);
        earlyBirdFlowInformation = new EarlyBirdFlowInformation();
        earlyBirdFlowInformation.setPriceEB(PRICE_EB);

        if (System.getProperty("mode.live").equals("true")) {
            actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
            webDriver.manage().window().maximize();

            actor.attemptsTo(
                    new OpenPlanATripPage(),
                    SearchFlight.byItineraryType(airBookingFlow),
                    new SelectFlights(airBookingFlow),
                    new ConfirmPrice(),
                    new EnterPassengerInformation(airBookingFlow, earlyBirdFlowInformation),
                    new Purchase(airBookingFlow)
            );
            validateConfirmationNumber(airBookingFlow);
        }

        Serenity.setSessionVariable("airBookingInformation").to(airBookingFlow);
        Serenity.setSessionVariable("earlyBirdFlowInformation").to(earlyBirdFlowInformation);
    }

    @Given("a unaccompanied minor PNR with the following Itinerary: $table")
    public void setTravelerUnaccompaniedMinor(ExamplesTable table) {

        airBookingFlow = AirBookingFlow.storeAirBookingFlowData(table);
        earlyBirdFlowInformation = new EarlyBirdFlowInformation();
        earlyBirdFlowInformation.setPriceEB(PRICE_EB);

        if (System.getProperty("mode.live").equals("true")) {
            actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
            webDriver.manage().window().maximize();

            actor.attemptsTo(
                    new OpenPlanATripPage(),
                    SearchFlight.byItineraryType(airBookingFlow),
                    new SelectNonStopFlights(airBookingFlow),
                    new SelectFlights(airBookingFlow),
                    new ConfirmPrice(),
                    new EnterUnaccompaniedMinorPassengerInformation(airBookingFlow, earlyBirdFlowInformation),
                    new Purchase(airBookingFlow),
                    new SelectUnaccompaniedMinor(),
                    new UnaccompaniedMinor(airBookingFlow),
                    new Purchase(airBookingFlow)
            );
            validateConfirmationNumber(airBookingFlow);
        }

        Serenity.setSessionVariable("airBookingInformation").to(airBookingFlow);
        Serenity.setSessionVariable("earlyBirdFlowInformation").to(earlyBirdFlowInformation);
    }

    @Given("a cancelled PNR with the following Itinerary: $table")
    public void setTravelerCancelled(ExamplesTable table) {

        airBookingFlow = AirBookingFlow.storeAirBookingFlowData(table);
        earlyBirdFlowInformation = new EarlyBirdFlowInformation();
        earlyBirdFlowInformation.setPriceEB(PRICE_EB);

        if (System.getProperty("mode.live").equals("true")) {
            actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
            webDriver.manage().window().maximize();

            actor.attemptsTo(
                    new OpenPlanATripPage(),
                    SearchFlight.byItineraryType(airBookingFlow),
                    new SelectFlights(airBookingFlow),
                    new ConfirmPrice(),
                    new EnterPassengerInformation(airBookingFlow, earlyBirdFlowInformation),
                    new Purchase(airBookingFlow)
            );
            validateConfirmationNumber(airBookingFlow);

            actor.attemptsTo(
                    new CancelFlightReservation()
            );
        }

        Serenity.setSessionVariable("airBookingInformation").to(airBookingFlow);
        Serenity.setSessionVariable("earlyBirdFlowInformation").to(earlyBirdFlowInformation);
    }

    @Given("a PNR with the following Itinerary with early bird: $table")
    public void setTravelerWithEB(ExamplesTable table) {

        airBookingFlow = AirBookingFlow.storeAirBookingFlowData(table);
        earlyBirdFlowInformation = new EarlyBirdFlowInformation();
        earlyBirdFlowInformation.setPriceEB(PRICE_EB);

        if (System.getProperty("mode.live").equals("true")) {
            actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
            webDriver.manage().window().maximize();

            actor.attemptsTo(
                    new OpenPlanATripPage(),
                    SearchFlight.byItineraryType(airBookingFlow),
                    new SelectFlights(airBookingFlow),
                    new ConfirmPrice(),
                    new EnterPassengerInformation(airBookingFlow, earlyBirdFlowInformation),
                    new AddEarlyBird(),
                    new Purchase(airBookingFlow)
            );
            validateConfirmationNumber(airBookingFlow);
        }

        Serenity.setSessionVariable("airBookingInformation").to(airBookingFlow);
        Serenity.setSessionVariable("earlyBirdFlowInformation").to(earlyBirdFlowInformation);
    }

    @Given("an anonymous user")
    public void setAnonymus() {
        if (System.getProperty("mode.live").equals("true")) {
            actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
            webDriver.manage().window().maximize();

            actor.attemptsTo(
                    new OpenPlanATripPage()
            );
        }
    }

    @Given("a PNR with the following Itinerary with suffix, middle name and large first name: $table")
    public void setTravelerWithLargeNamesAndSuffix(ExamplesTable table) {

        airBookingFlow = AirBookingFlow.storeAirBookingFlowData(table);
        airBookingFlow.getPassengers().get(0).setFirstName(airBookingFlow.getFirstName().concat("IRSTNAMEFIRSTNAMEFIRSTNAM"));
        airBookingFlow.getPassengers().get(0).setLastName(airBookingFlow.getLastName().concat("LASTNAMELASTNAMELASTNAMELT"));
        airBookingFlow.setFirstName(airBookingFlow.getFirstName().concat("IRSTNAMEFIRSTNAMEFIRSTNAM"));
        airBookingFlow.setLastName(airBookingFlow.getLastName().concat("LASTNAMELASTNAMELASTNAMELT"));

        earlyBirdFlowInformation = new EarlyBirdFlowInformation();
        earlyBirdFlowInformation.setPriceEB(PRICE_EB);

        if (System.getProperty("mode.live").equals("true")) {
            actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
            webDriver.manage().window().maximize();

            actor.attemptsTo(
                    new OpenPlanATripPage(),
                    SearchFlight.byItineraryType(airBookingFlow),
                    new SelectFlights(airBookingFlow),
                    new ConfirmPrice(),
                    new EnterPassengerInformationWithLargeNamesAndSuffix(airBookingFlow, earlyBirdFlowInformation),
                    new Purchase(airBookingFlow)
            );
            validateConfirmationNumber(airBookingFlow);
        }
        Serenity.setSessionVariable("airBookingInformation").to(airBookingFlow);
        Serenity.setSessionVariable("earlyBirdFlowInformation").to(earlyBirdFlowInformation);
    }

    @When("I add the early-bird option")
    public void addEarlyBird() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        airBookingFlow = sessionVariableCalled("airBookingInformation");

        actor.attemptsTo(
                new OpenEarlyBirdLandingPage(),
                new RetrieveAirReservation(),
                new ContinueToEarlyBirdPurchasePage(),
                new PaymentForm(airBookingFlow)
        );
    }

    @When("I add the early-bird option with specific CC")
    public void addEarlyBirdWithSpecificCreditCard() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        airBookingFlow = sessionVariableCalled("airBookingInformation");

        actor.attemptsTo(
                new OpenEarlyBirdLandingPage(),
                new RetrieveAirReservation(),
                new ContinueToEarlyBirdPurchasePage(),
                new PaymentFormWithSpecificCreditCard(airBookingFlow)
        );
    }

    @When("I retrieve reservation for early bird purchase")
    public void retrieveReservationForEarlyBird() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(
                new OpenEarlyBirdLandingPage(),
                new RetrieveAirReservation()
        );
    }

    @When("I retrieve reservation for early bird to purchase page")
    public void retrieveReservationForEarlyBirdToPurchasePage() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(
                new OpenEarlyBirdLandingPage(),
                new RetrieveAirReservation(),
                new ContinueToEarlyBirdPurchasePage()
        );
    }

    @When("I retrieve a reservation to select passengers for Early Bird: $table")
    public void checkPassengers(ExamplesTable table) {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        earlyBirdFlowInformation = EarlyBirdFlowInformation.storeSelectPassengerForEB(table, earlyBirdFlowInformation);

        actor.attemptsTo(
                new OpenEarlyBirdLandingPage(),
                new RetrieveAirReservation(),
                new SelectEarlyBirdPassengers(airBookingFlow, earlyBirdFlowInformation)
        );
    }

    @When("I complete the early bird landing form with an invalid passenger information")
    public void completeLandingPageWithInvalidPassenger() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        actor.attemptsTo(
                new OpenEarlyBirdLandingPage(),
                RetrieveAirReservation.withAnInvalidPassenger()
        );
    }

    @When("I complete the early bird landing form with an invalid confirmation number")
    public void completeLandingPageWithInvalidPNR() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        actor.attemptsTo(
                new OpenEarlyBirdLandingPage(),
                RetrieveAirReservation.withAnInvalidPNR()
        );
    }

    @When("I refresh the early bird landing")
    public void refreshEarlyBirdLandingPage() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        webDriver.navigate().refresh();
        actor.attemptsTo(WaitUntil.the(LandingPageForm.FIRST_NAME_INPUT, isVisible()).forNoMoreThan(60).seconds());
    }

    @When("I confirm the passenger to add early bird")
    public void retrieveReservationToPurchasePage() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(
                new OpenEarlyBirdLandingPage(),
                new RetrieveAirReservation(),
                new StoreEarlyFlowInformation(earlyBirdFlowInformation, airBookingFlow),
                new ContinueToEarlyBirdPurchasePage()
        );
    }

    @When("I buy an Early bird option with a saved credit card")
    public void addEarlyBirdWithASavedCreditCard() {
        actor = Actor.named("user logged in").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        actor.attemptsTo(
                new OpenEarlyBirdLandingPage(),
                Login.userWithCreditCard(),
                new RetrieveAirReservation(),
                new ContinueToEarlyBirdPurchasePage()
        );
    }

    @When("I buy an Early bird option with a new credit card")
    public void addEarlyBirdWithANewCreditCard() {
        actor = Actor.named("user logged in").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        actor.attemptsTo(
                new OpenEarlyBirdLandingPage(),
                Login.userWithoutCreditCard(),
                new RetrieveAirReservation(),
                new ContinueToEarlyBirdPurchasePage()
        );
    }

    @When("access to select page with flight information")
    public void accessToSelectPage() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        actor.attemptsTo(
                new OpenEarlyBirdSelectPage(airBookingFlow)
        );
    }

    @When("access to select page with flight information and return to the entrypoint")
    public void accessToSelectPageAndReturnToTheEntryPoint() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(
                new OpenEarlyBirdLandingPage()
        );
        earlyBirdFlowInformation.setCurrentUrl(webDriver.getCurrentUrl());
        actor.attemptsTo(
                new OpenEarlyBirdSelectPage(airBookingFlow)
        );
        webDriver.navigate().back();
    }

    @When("navigate between select and purchase")
    public void navigateBetweenSelectAndPurchase() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(
                new OpenEarlyBirdLandingPage(),
                new RetrieveAirReservation(),
                new ContinueToEarlyBirdPurchasePage()
        );
        actor.attemptsTo(WaitUntil.the(PaymentMethodForm.CREDIT_CARD_NUMBER_INPUT, isVisible()).forNoMoreThan(60).seconds());
        webDriver.navigate().back();
        webDriver.navigate().forward();
    }

    @When("access to confirmation page with flight information and return to the landing page")
    public void navigateBackFromConfirmationToLanding() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(
                new OpenEarlyBirdLandingPage()
        );
        earlyBirdFlowInformation.setCurrentUrl(webDriver.getCurrentUrl());
        actor.attemptsTo(
                new RetrieveAirReservation(),
                new ContinueToEarlyBirdPurchasePage(),
                new PaymentForm(airBookingFlow)
        );
        actor.attemptsTo(WaitUntil.the(EarlyBirdConfirmationPageTripSummarySection.EARLY_BIRD_CONFIRMATION_NUMBER, isVisible()).forNoMoreThan(60).seconds());
        webDriver.navigate().back();
    }

    @When("access to purchase page")
    public void accessToPurchase() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        actor.attemptsTo(
                new OpenEarlyBirdPurchasePage()
        );
    }

    @When("access to select page without flight information")
    public void accessToSelectPageWithoutPNR() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        actor.attemptsTo(
                new OpenEarlyBirdSelectPageWithoutFlightInformation()
        );
    }

    @Then("All the inputs fields are empty on the purchase page")
    public void validateInputsFieldsAreEmptyOnThePurchasePage() {
        actor.should(eventually(seeThat(new InputsFieldOnPurchasePageAreEmpty())));
    }

    @Then("webpage to the entrypoint is correctly displayed")
    public void validatePageToTheEntryPointIsDisplayed() {
        actor.should(eventually(seeThat(new PreviousPageIsCorrectlyDisplayed(webDriver, earlyBirdFlowInformation))));
    }

    @Then("the oops message is not displayed and the entered information persist on landing page")
    public void validateOopsMessageIsNotDisplayed() {
        actor.should(eventually(seeThat(new OopsMessageIsNotDisplayed())));
        actor.should(eventually(seeThat(new LandingPageInputsFieldsAreNotEmpty())));
    }

    @Then("The ineligible bound is not displayed in purchase page")
    public void validateIneligibleBoundIsNotDisplayedInPurchasePage(){
       actor.should(eventually(seeThat(new EarlyBirdCorrectBoundDisplayedInPurchasePage())));
    }

    @Then("The ineligible bound is not displayed in confirmation page")
    public void validateIneligibleBoundIsNotDisplayedInConfirmationPage(){
        actor.should(eventually(seeThat(new EarlyBirdCorrectBoundDisplayedInConfirmationPage())));
    }

    @Then("purchase itinerary section is correctly displayed")
    public void validateItinerarySectionDisplayed() {

        actor.should(eventually(seeThat(EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage.forSubTotalOutbound(earlyBirdFlowInformation))));

        boolean isOneWay = airBookingFlow.getItineraryType().equals(ONE_WAY);

        if (!isOneWay) {
            actor.should(eventually(seeThat(EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage.forSubTotalInbound(earlyBirdFlowInformation))));
        }

        actor.should(eventually(seeThat(EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage.forTotalPrice(earlyBirdFlowInformation))));
    }

    @Then("Subtotal and estimated total is displayed")
    public void validateEarlyBirdPrice() {
        actor.should(eventually(seeThat(new EarlyBirdPriceIsCorrectlyDisplayed(earlyBirdFlowInformation, airBookingFlow))));
    }

    @Then("the continue button is $continueButtonState")
    public void validateContinueButtonState(String continueButtonState) {
        actor.should(eventually(seeThat(EarlyBirdContinueToPurchaseIsCorrectlyDisplayed.byState(continueButtonState))));
    }

    @Then("reservation and passenger details are correctly displayed")
    public void seeCorrectItineraryData() {
        actor.should(eventually(seeThat(CorrectBoundsDisplayed.forOutbound(airBookingFlow))));
        actor.should(eventually(seeThat(CorrectAmountOfPassengersDisplayed.forOutbound())));

        if (!airBookingFlow.getItineraryType().equals(ONE_WAY)) {
            actor.should(eventually(seeThat(CorrectBoundsDisplayed.forInbound(airBookingFlow))));
            actor.should(eventually(seeThat(CorrectAmountOfPassengersDisplayed.forInbound())));
        }
    }

    @Then("an invalid passenger error is displayed")
    public void seeInvalidPassengerIsDisplayed() {
        actor.attemptsTo(
            new ClickOnErrorDetailButton()
        );
        actor.should(eventually(seeThat(new OopsMessageIsDisplayed())));
        actor.should(eventually(seeThat(ErrorDetailCodeIsDisplayed.forInvalidPassenger())));
    }

    @Then("a not found confirmation number error is displayed")
    public void seeNotFoundConfirmationNumberErrorIsDisplayed() {
        actor.attemptsTo(
                new ClickOnErrorDetailButton()
        );
        actor.should(eventually(seeThat(new OopsMessageIsDisplayed())));
        actor.should(eventually(seeThat(ErrorDetailCodeIsDisplayed.forInvalidPNR())));
    }

    @Then("The correct amount of ineligible passenger is displayed")
    public void seeCorrectIneligiblePassengerAmount() {
        actor.should(eventually(seeThat(new IneligiblePassengerAmountIsCorrectlyDisplayed(airBookingFlow))));
    }

    @Then("The correct ineligible bound is displayed")
    public void seeCorrectIneligibleBound() {
        actor.should(eventually(seeThat(new IneligibleBoundIsCorrectlyDisplayed(airBookingFlow, earlyBirdFlowInformation))));
        actor.should(eventually(seeThat(new IneligibleReasonIsCorrectlyDisplayed(earlyBirdFlowInformation))));
    }

    @Then("saved credit card radio button is selected by default")
    public void seeSavedCreditCardButtonSelected() {
        actor.should(eventually(seeThat(new SavedCreditCardButtonSelected())));
    }

    @Then("landing page is displayed")
    public void seeLandingPageWithoutOopsMessage() {
        actor.should(eventually(seeThat(new LandingPageIsCorrectlyDisplayed())));
    }

    @Then("an oops message is displayed on landing page")
    public void seeLandingPageWithOopsMessage() {
        actor.should(eventually(seeThat(new LandingPageIsCorrectlyDisplayed())));
        actor.should(eventually(seeThat(new OopsMessageIsDisplayed())));
    }

    @Then("the cancelled reservation oops message is displayed on landing page")
    public void seeLandingPageWithCancelledOopsMessage() {
        actor.attemptsTo(
                new ClickOnErrorDetailButton()
        );
        actor.should(eventually(seeThat(new OopsMessageIsDisplayed())));
        actor.should(eventually(seeThat(ErrorDetailCodeIsDisplayed.forCancelledPNR())));
    }

    @Then("the unaccompanied minor reservation oops message is displayed on landing page")
    public void seeLandingPageWithUnaccompaniedMinorOopsMessage() {
        actor.attemptsTo(
                new ClickOnErrorDetailButton()
        );
        actor.should(eventually(seeThat(new OopsMessageIsDisplayed())));
        actor.should(eventually(seeThat(ErrorDetailCodeIsDisplayed.forUnaccompaniedMinor())));
    }

    @Then("the bounds ineligible oops message is displayed on landing page")
    public void seeLandingPageWithBoundIneligibleOopsMessage() {
        actor.attemptsTo(
                new ClickOnErrorDetailButton()
        );
        actor.should(eventually(seeThat(new OopsMessageIsDisplayed())));
        actor.should(eventually(seeThat(ErrorDetailCodeIsDisplayed.forBoundInelegible())));
    }

    @Then("the passengers ineligible oops message is displayed on landing page")
    public void seeLandingPageWithPassengerIneligibleOopsMessage() {
        actor.attemptsTo(
                new ClickOnErrorDetailButton()
        );
        actor.should(eventually(seeThat(new OopsMessageIsDisplayed())));
        actor.should(eventually(seeThat(ErrorDetailCodeIsDisplayed.forPassengerInelegible())));
    }

    @Then("credit card form is displayed")
    public void seeCreditCardFormIsDisplayed() {
        actor.should(eventually(seeThat(new SavedCreditCardButtonIsNotDisplayed())));
        actor.should(eventually(seeThat(PaymentMethodFieldInput.forFirstName())));
        actor.should(eventually(seeThat(PaymentMethodFieldInput.forLastName())));
        actor.should(eventually(seeThat(PaymentMethodFieldInput.forStreetAddress())));
        actor.should(eventually(seeThat(PaymentMethodFieldInput.forCityTown())));
    }

    @Then("confirmation page is displayed containing the correct information")
    public void seeConfirmationPageIsCorrectlyDisplayed() throws InterruptedException {

        actor.attemptsTo(WaitUntil.the(EarlyBirdConfirmationPageTripSummarySection.EARLY_BIRD_CONFIRMATION_NUMBER, isVisible()).forNoMoreThan(60).seconds());
        actor.should(eventually(seeThat(EarlyBirdConfirmationFields.forEarlyBirdConfirmationNumber(), equalTo(airBookingFlow.getConfirmationNumber()))));
        actor.should(eventually(seeThat(new EarlyBirdConfirmationItineraryInSummaryIsCorrectlyDisplayed())));
        actor.should(eventually(seeThat(EarlyBirdConfirmationFields.forOutboundPassengers(), containsString(
                (airBookingFlow.getAdultPassengerCount() - airBookingFlow.getAListPreferredUsersCount() -
                        airBookingFlow.getExtraSeatPassengerCount()) + " Adult"))));
        if (!airBookingFlow.getItineraryType().equals(ONE_WAY)){
            actor.should(eventually(seeThat(EarlyBirdConfirmationFields.forInboundPassengers(), containsString(
                    (airBookingFlow.getAdultPassengerCount() - airBookingFlow.getAListPreferredUsersCount() -
                            airBookingFlow.getExtraSeatPassengerCount()) + " Adult"))));
        }
        actor.should(eventually(seeThat(new EarlyBirdConfirmationItineraryIsCorrectlyDisplayed(airBookingFlow))));
        actor.should(eventually(seeThat(new EarlyBirdConfirmationPriceIsCorrectlyDisplayed(earlyBirdFlowInformation, airBookingFlow))));
    }

    @Then("confirmation page is displayed containing the correct information for Senior Passengers")
    public void seeConfirmationPageIsCorrectlyDisplayedForSeniorPassengers() {

        actor.attemptsTo(WaitUntil.the(EarlyBirdConfirmationPageTripSummarySection.EARLY_BIRD_CONFIRMATION_NUMBER, isVisible()).forNoMoreThan(60).seconds());
        actor.should(eventually(seeThat(new EarlyBirdConfirmationItineraryInSummaryIsCorrectlyDisplayed())));
        actor.should(eventually(seeThat(EarlyBirdConfirmationFields.forOutboundPassengers(), containsString
                ((airBookingFlow.getSeniorPassengerCount() - airBookingFlow.getAListPreferredUsersCount() -
                        airBookingFlow.getExtraSeatPassengerCount()) + " Senior"))));
        if (!airBookingFlow.getItineraryType().equals(ONE_WAY)){
            actor.should(eventually(seeThat(EarlyBirdConfirmationFields.forInboundPassengers(), containsString((airBookingFlow
                    .getSeniorPassengerCount() - airBookingFlow.getAListPreferredUsersCount() -
                    airBookingFlow.getExtraSeatPassengerCount()) + " Senior"))));
        }
        actor.should(eventually(seeThat(new EarlyBirdConfirmationItineraryIsCorrectlyDisplayed(airBookingFlow))));
        actor.should(eventually(seeThat(new EarlyBirdConfirmationPriceIsCorrectlyDisplayed(earlyBirdFlowInformation, airBookingFlow))));
    }

    private boolean isLocalEnvironment() {
        String baseUrl = System.getProperty("webdriver.base.url");
        return !isEmpty(baseUrl) && baseUrl.contains("local");
    }

    private static Object isResourceAvailable(MBeanServerConnection mBeanServerConnection, ObjectName name) throws
            Exception {
        return mBeanServerConnection.invoke(name, "isAvailable", null, null);
    }

    private static void changeFeatureToggle(String toggleName, boolean toggleOn) throws Exception {
        changeToggle("com.swacorp.dotcom.api.toggles.features:name=", toggleName, toggleOn);
    }

    private static void changeToggle(String objectName, String toggleName, boolean toggleOn) throws Exception {
        MBeanServerConnection mBeanServerConnection = jmxConnector.getMBeanServerConnection();

        ObjectName name = new ObjectName(objectName + toggleName);

        Object isAvailable = isResourceAvailable(mBeanServerConnection, name);
        if (Boolean.parseBoolean(isAvailable.toString()) != toggleOn) {
            mBeanServerConnection.invoke(name, "toggle", null, null);
        }
    }

}