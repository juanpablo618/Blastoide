package steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.WebDriver;
import screenplay.models.AirBookingFlow;
import screenplay.models.EarlyBirdFlowInformation;
import screenplay.questions.*;
import screenplay.tasks.airBooking.*;
import screenplay.tasks.earlyBird.*;
import screenplay.tasks.swabizAirBooking.AccessToSwabizSearchPage;
import screenplay.tasks.swabizAirBooking.OpenSwabizPlanATrip;
import screenplay.tasks.swabizEarlyBird.OpenSwabizEarlyBirdLandingPage;
import screenplay.tasks.swabizEarlyBird.OpenSwabizEarlyBirdPurchasePage;
import screenplay.tasks.swabizEarlyBird.OpenSwabizEarlyBirdSelectPage;
import screenplay.tasks.swabizEarlyBird.OpenSwabizEarlyBirdSelectPageWithoutFlightInformation;
import screenplay.user_interface.airBooking.PaymentMethodForm;
import screenplay.user_interface.earlyBird.EarlyBirdConfirmationPageItinerarySection;
import screenplay.user_interface.earlyBird.EarlyBirdConfirmationPageTripSummarySection;
import screenplay.user_interface.earlyBird.LandingPageForm;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;

public class SwabizEarlyBirdStep extends CommonConfirmation {

    private EarlyBirdFlowInformation earlyBirdFlowInformation;
    private static final double PRICE_EB = 15.00;
    private static final String ONE_WAY = "One-way";
    private static final String EARLY_BIRD_HOME_PAGE = ".com/early-bird/";

    @Managed()
    private WebDriver webDriver;

    @Given("an anonymous traveller on Swabiz")
    public void setTraveler() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
    }

    @Given("a swabiz PNR with the following Itinerary: $table")
    public void setTraveler(ExamplesTable table) {

        airBookingFlow = AirBookingFlow.storeAirBookingFlowData(table);
        earlyBirdFlowInformation = new EarlyBirdFlowInformation();
        earlyBirdFlowInformation.setPriceEB(PRICE_EB);

        if (System.getProperty("mode.live").equals("true")) {
            actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
            webDriver.manage().window().maximize();

            actor.attemptsTo(
                    new OpenSwabizPlanATrip(),
                    new AccessToSwabizSearchPage(),
                    SearchFlight.byItineraryType(airBookingFlow),
                    new SelectFlights(airBookingFlow),
                    new ConfirmPrice(),
                    new EnterPassengerInformation(airBookingFlow, earlyBirdFlowInformation),
                    new PurchaseOnSwabiz(airBookingFlow)
            );
            validateConfirmationNumber(airBookingFlow);
        }

        Serenity.setSessionVariable("airBookingInformation").to(airBookingFlow);
        Serenity.setSessionVariable("earlyBirdFlowInformation").to(earlyBirdFlowInformation);
    }

    @Given("a cancelled swabiz PNR with the following Itinerary: $table")
    public void setTravelerCancelled(ExamplesTable table) {

        airBookingFlow = AirBookingFlow.storeAirBookingFlowData(table);
        earlyBirdFlowInformation = new EarlyBirdFlowInformation();
        earlyBirdFlowInformation.setPriceEB(PRICE_EB);

        if (System.getProperty("mode.live").equals("true")) {
            actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
            webDriver.manage().window().maximize();

            actor.attemptsTo(
                    new OpenSwabizPlanATrip(),
                    new AccessToSwabizSearchPage(),
                    SearchFlight.byItineraryType(airBookingFlow),
                    new SelectFlights(airBookingFlow),
                    new ConfirmPrice(),
                    new EnterPassengerInformation(airBookingFlow, earlyBirdFlowInformation),
                    new PurchaseOnSwabiz(airBookingFlow)
            );
            validateConfirmationNumber(airBookingFlow);

            actor.attemptsTo(
                    new CancelFlightReservation()
            );
        }

        Serenity.setSessionVariable("airBookingInformation").to(airBookingFlow);
        Serenity.setSessionVariable("earlyBirdFlowInformation").to(earlyBirdFlowInformation);
    }

    @When("I add the early-bird option on Swabiz")
    public void addEarlyBirdOnSwabiz() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        airBookingFlow = sessionVariableCalled("airBookingInformation");

        actor.attemptsTo(
                new OpenSwabizEarlyBirdLandingPage());

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }

        actor.attemptsTo(
                new RetrieveAirReservation(),
                new ContinueToEarlyBirdPurchasePage(),
                new CompletePaymentFormOnSwabiz(airBookingFlow)
        );
    }

    @When("I add the early-bird option with specific CC on swabiz")
    public void addEarlyBirdWithSpecificCreditCard() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        airBookingFlow = sessionVariableCalled("airBookingInformation");

        actor.attemptsTo(
                new OpenSwabizEarlyBirdLandingPage()
                );

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }

        actor.attemptsTo(
                new RetrieveAirReservation(),
                new ContinueToEarlyBirdPurchasePage(),
                new CompletePaymentFormWithSpecificCreditCardOnSwabiz(airBookingFlow)
        );
    }

    @When("access to swabiz purchase page")
    public void accessToPurchase() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        actor.attemptsTo(
                new OpenSwabizEarlyBirdPurchasePage()
        );

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }
    }

    @When("access to swabiz select page without flight information")
    public void accessToSelectPageWithoutPNR() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        actor.attemptsTo(
                new OpenSwabizEarlyBirdSelectPageWithoutFlightInformation()
        );

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }
    }

    @When("access to swabiz select page with flight information")
    public void accessToSelectPage() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(
                new OpenSwabizEarlyBirdLandingPage()
        );

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }

        actor.attemptsTo(
                new OpenSwabizEarlyBirdSelectPage(airBookingFlow)
        );
    }

    @When("access to confirmation page with flight information and return to the landing page on swabiz")
    public void navigateBackFromConfirmationToLanding() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(
                new OpenSwabizEarlyBirdLandingPage()
        );
        earlyBirdFlowInformation.setCurrentUrl(EARLY_BIRD_HOME_PAGE + "index.html");

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }

        actor.attemptsTo(
                new RetrieveAirReservation(),
                new ContinueToEarlyBirdPurchasePage(),
                new CompletePaymentFormOnSwabiz(airBookingFlow)
        );
        actor.attemptsTo(WaitUntil.the(EarlyBirdConfirmationPageTripSummarySection.EARLY_BIRD_CONFIRMATION_NUMBER, isVisible()).forNoMoreThan(60).seconds());
        webDriver.navigate().back();
    }

    @When("access to select page with flight information and return to the entrypoint on swabiz")
    public void accessToSelectPageAndReturnToTheEntryPoint() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(
                new OpenSwabizEarlyBirdLandingPage()
        );
        earlyBirdFlowInformation.setCurrentUrl(EARLY_BIRD_HOME_PAGE);

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }

        actor.attemptsTo(
                new OpenEarlyBirdSelectPage(airBookingFlow)
        );
        webDriver.navigate().back();
    }

    @When("I retrieve reservation for early bird purchase on swabiz")
    public void retrieveReservationForEarlyBird() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(
                new OpenSwabizEarlyBirdLandingPage()
        );

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }

        actor.attemptsTo(
                new RetrieveAirReservation()
        );
    }

    @When("navigate between select and purchase on swabiz")
    public void navigateBetweenSelectAndPurchase() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(
                new OpenSwabizEarlyBirdLandingPage()
        );

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }
        actor.attemptsTo(
                new RetrieveAirReservation(),
                new ContinueToEarlyBirdPurchasePage()
        );
        actor.attemptsTo(WaitUntil.the(PaymentMethodForm.CREDIT_CARD_NUMBER_INPUT, isVisible()).forNoMoreThan(60).seconds());
        webDriver.navigate().back();
        webDriver.navigate().forward();
    }

    @When("I retrieve a swabiz reservation to select passengers for Early Bird: $table")
    public void checkPassengers(ExamplesTable table) {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        earlyBirdFlowInformation = EarlyBirdFlowInformation.storeSelectPassengerForEB(table, earlyBirdFlowInformation);

        actor.attemptsTo(
                new OpenSwabizEarlyBirdLandingPage()
        );

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }

        actor.attemptsTo(
                new RetrieveAirReservation(),
                new SelectEarlyBirdPassengers(airBookingFlow, earlyBirdFlowInformation)
        );
    }

    @When("I retrieve reservation for early bird to swabiz purchase page")
    public void retrieveReservationForEarlyBirdToPurchasePage() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(
                new OpenSwabizEarlyBirdLandingPage()
        );

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }

        actor.attemptsTo(
                new RetrieveAirReservation(),
                new ContinueToEarlyBirdPurchasePage()
        );
    }

    @When("I confirm the passenger to add early bird on swabiz")
    public void retrieveReservationToPurchasePage() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(
                new OpenSwabizEarlyBirdLandingPage()
        );

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }
        actor.attemptsTo(
                new RetrieveAirReservation(),
                new StoreEarlyFlowInformation(earlyBirdFlowInformation, airBookingFlow),
                new ContinueToEarlyBirdPurchasePage()
        );
    }

    @When("I complete the early bird landing form with an invalid passenger information on swabiz")
    public void completeLandingPageWithInvalidPassenger() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        actor.attemptsTo(
                new OpenEarlyBirdLandingPage()
        );

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }

        actor.attemptsTo(
                RetrieveAirReservation.withAnInvalidPassenger()
        );
    }

    @When("I complete the early bird landing form with an invalid confirmation number on swabiz")
    public void completeLandingPageWithInvalidPNR() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        actor.attemptsTo(
                new OpenEarlyBirdLandingPage()
                );

        if(!webDriver.getCurrentUrl().contains(EARLY_BIRD_HOME_PAGE)) {
            actor.attemptsTo(
                    new AccessToSwabizSearchPage()
            );
        }
        actor.attemptsTo(
                RetrieveAirReservation.withAnInvalidPNR()
        );
    }

    @When("I refresh the early bird landing on swabiz")
    public void refreshEarlyBirdLandingPage() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        webDriver.navigate().refresh();
        actor.attemptsTo(WaitUntil.the(LandingPageForm.FIRST_NAME_INPUT, isVisible()).forNoMoreThan(60).seconds());
    }

    @Then("an air confirmation number is displayed on Swabiz Early Bird Confirmation page for adult passengers")
    public void validateConfirmationNumberDisplayedForAdultPassengers() {
        actor.should(eventually(seeThat(new EarlyBirdConfirmationNumberDisplayed())));

        actor.should(eventually(seeThat(EarlyBirdConfirmationFields.forOutboundPassengers(), containsString(airBookingFlow.getAdultPassengerCount() -
                airBookingFlow.getAListPreferredUsersCount() - airBookingFlow.getExtraSeatPassengerCount()+ " Adult"))));
        if (!airBookingFlow.getItineraryType().equals(ONE_WAY)){
            actor.should(eventually(seeThat(EarlyBirdConfirmationFields.forInboundPassengers(), containsString(airBookingFlow.getAdultPassengerCount() - airBookingFlow.getAListPreferredUsersCount() -
                            airBookingFlow.getExtraSeatPassengerCount() + " Adult"))));
        }
        actor.should(eventually(seeThat(new EarlyBirdConfirmationItineraryIsCorrectlyDisplayed(airBookingFlow))));
    }

    @Then("an air confirmation number is displayed on Swabiz Early Bird Confirmation page")
    public void validateConfirmationNumberDisplayed() {
        actor.should(eventually(seeThat(new EarlyBirdConfirmationNumberDisplayed())));

        actor.should(eventually(seeThat(EarlyBirdConfirmationFields.forOutboundPassengers(),
                containsString(airBookingFlow.getAdultPassengerCount() - airBookingFlow.getAListPreferredUsersCount() -
                        airBookingFlow.getExtraSeatPassengerCount() + " Adult"))));
        if (!airBookingFlow.getItineraryType().equals(ONE_WAY)){
            actor.should(eventually(seeThat(EarlyBirdConfirmationFields.forInboundPassengers(),
                    containsString(airBookingFlow.getAdultPassengerCount() - airBookingFlow.getAListPreferredUsersCount() -
                            airBookingFlow.getExtraSeatPassengerCount() + " Adult"))));
        }
        actor.should(eventually(seeThat(new EarlyBirdConfirmationItineraryIsCorrectlyDisplayed(airBookingFlow))));
    }

    @Then("an air confirmation number is displayed on Swabiz Early Bird Confirmation page for seniors")
    public void validateConfirmationNumberDisplayedForSenior() {
        actor.should(eventually(seeThat(new EarlyBirdConfirmationNumberDisplayed())));

        actor.should(eventually(seeThat(EarlyBirdConfirmationFields.forOutboundPassengers(), containsString(airBookingFlow.getSeniorPassengerCount() -
                airBookingFlow.getAListPreferredUsersCount() -airBookingFlow.getExtraSeatPassengerCount() + " Senior"))));
        if (!airBookingFlow.getItineraryType().equals(ONE_WAY)){
            actor.should(eventually(seeThat(EarlyBirdConfirmationFields.forInboundPassengers(), containsString
                    (airBookingFlow.getSeniorPassengerCount() - airBookingFlow.getAListPreferredUsersCount() -
                            airBookingFlow.getExtraSeatPassengerCount() +" Senior"))));
        }
        actor.should(eventually(seeThat(new EarlyBirdConfirmationItineraryIsCorrectlyDisplayed(airBookingFlow))));
    }

    @Then("an air internal reference number is displayed on Swabiz Early Bird confirmation page")
    public void validateInternalReferenceDisplayed() {
        actor.should(eventually(seeThat(new EarlyBirdInternalReferenceNumberDisplayed())));
    }

    @Then("reservation and passenger details are correctly displayed on swabiz")
    public void seeCorrectItineraryData() {
        actor.should(eventually(seeThat(CorrectBoundsDisplayed.forOutbound(airBookingFlow))));
        actor.should(eventually(seeThat(CorrectAmountOfPassengersDisplayed.forOutbound())));

        if (!airBookingFlow.getItineraryType().equals(ONE_WAY)) {
            actor.should(eventually(seeThat(CorrectBoundsDisplayed.forInbound(airBookingFlow))));
            actor.should(eventually(seeThat(CorrectAmountOfPassengersDisplayed.forInbound())));
        }
    }

    @Then("the cancelled reservation oops message is displayed on swabiz landing page")
    public void seeLandingPageWithCancelledOopsMessage() {
        actor.attemptsTo(
                WaitUntil.the(LandingPageForm.OOPS_ERROR_MESSAGE, isVisible())
                        .forNoMoreThan(60).seconds()
        );
        actor.should(eventually(seeThat(new OopsMessageIsDisplayed())));
        actor.attemptsTo(
                new ClickOnErrorDetailButton()
        );
        actor.should(eventually(seeThat(ErrorDetailCodeIsDisplayed.forCancelledPNR())));
    }

    @Then("webpage to the entrypoint is correctly displayed on swabiz")
    public void validatePageToTheEntryPointIsDisplayed() {
        actor.should(eventually(seeThat(new PreviousPageIsCorrectlyDisplayed(webDriver, earlyBirdFlowInformation))));
    }

    @Then("The ineligible bound is not displayed in swabiz confirmation page")
    public void validateIneligibleBoundIsNotDisplayedInConfirmationPage(){
        actor.attemptsTo(
                WaitUntil.the(EarlyBirdConfirmationPageItinerarySection.CONFIRMATION_BOUNDS, isVisible()).forNoMoreThan(60).seconds()
        );

        actor.should(eventually(seeThat(new EarlyBirdCorrectBoundDisplayedInConfirmationPage())));
    }

    @Then("The correct ineligible bound is displayed on swabiz")
    public void seeCorrectIneligibleBound() {
        actor.should(eventually(seeThat(new IneligibleBoundIsCorrectlyDisplayed(airBookingFlow, earlyBirdFlowInformation))));
        actor.should(eventually(seeThat(new IneligibleReasonIsCorrectlyDisplayed(earlyBirdFlowInformation))));
    }

    @Then("The correct amount of ineligible passenger is displayed on swabiz")
    public void seeCorrectIneligiblePassengerAmount() {
        actor.should(eventually(seeThat(new IneligiblePassengerAmountIsCorrectlyDisplayed(airBookingFlow))));
    }

    @Then("All the inputs fields are empty on the purchase page on swabiz")
    public void validateInputsFieldsAreEmptyOnThePurchasePage() {
        actor.attemptsTo(WaitUntil.the(PaymentMethodForm.CREDIT_CARD_NUMBER_INPUT, isVisible()).forNoMoreThan(60).seconds());
        actor.should(eventually(seeThat(new InputsFieldOnPurchasePageAreEmpty())));
    }

    @Then("Subtotal and estimated total is displayed on swabiz")
    public void validateEarlyBirdPrice() {
        actor.should(eventually(seeThat(new EarlyBirdPriceIsCorrectlyDisplayed(earlyBirdFlowInformation, airBookingFlow))));
    }

    @Then("the continue button is $continueButtonState on swabiz")
    public void validateContinueButtonState(String continueButtonState) {
        actor.should(eventually(seeThat(EarlyBirdContinueToPurchaseIsCorrectlyDisplayed.byState(continueButtonState))));
    }

    @Then("The ineligible bound is not displayed in swabiz purchase page")
    public void validateIneligibleBoundIsNotDisplayedInPurchasePage(){
        actor.should(eventually(seeThat(new EarlyBirdCorrectBoundDisplayedInPurchasePage())));
    }

    @Then("purchase itinerary section is correctly displayed on swabiz")
    public void validateItinerarySectionDisplayed() {

        actor.should(eventually(seeThat(EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage.forSubTotalOutbound(earlyBirdFlowInformation))));

        boolean isOneWay = airBookingFlow.getItineraryType().equals(ONE_WAY);

        if (!isOneWay) {
            actor.should(eventually(seeThat(EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage.forSubTotalInbound(earlyBirdFlowInformation))));
        }

        actor.should(eventually(seeThat(EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage.forTotalPrice(earlyBirdFlowInformation))));
    }

    @Then("the oops message is not displayed and the entered information persist on landing page on swabiz")
    public void validateOopsMessageIsNotDisplayed() {
        actor.should(eventually(seeThat(new OopsMessageIsNotDisplayed())));
        actor.should(eventually(seeThat(new LandingPageInputsFieldsAreNotEmpty())));
    }

    @Then("an invalid passenger error is displayed on swabiz")
    public void seeInvalidPassengerIsDisplayed() {
        actor.attemptsTo(
                new ClickOnErrorDetailButton()
        );
        actor.should(eventually(seeThat(new OopsMessageIsDisplayed())));
        actor.should(eventually(seeThat(ErrorDetailCodeIsDisplayed.forInvalidPassenger())));
    }

    @Then("a not found confirmation number error is displayed on swabiz")
    public void seeNotFoundConfirmationNumberErrorIsDisplayed() {
        actor.attemptsTo(
                new ClickOnErrorDetailButton()
        );
        actor.should(eventually(seeThat(new OopsMessageIsDisplayed())));
        actor.should(eventually(seeThat(ErrorDetailCodeIsDisplayed.forInvalidPNR())));
    }

    @Then("the bounds ineligible oops message is displayed on swabiz landing page")
    public void seeLandingPageWithBoundIneligibleOopsMessage() {
        actor.attemptsTo(
                new ClickOnErrorDetailButton()
        );
        actor.should(eventually(seeThat(new OopsMessageIsDisplayed())));
        actor.should(eventually(seeThat(ErrorDetailCodeIsDisplayed.forBoundInelegible())));
    }

    @Then("the passengers ineligible oops message is displayed on swabiz landing page")
    public void seeLandingPageWithPassengerIneligibleOopsMessage() {
        actor.attemptsTo(
                new ClickOnErrorDetailButton()
        );
        actor.should(eventually(seeThat(new OopsMessageIsDisplayed())));
        actor.should(eventually(seeThat(ErrorDetailCodeIsDisplayed.forPassengerInelegible())));
    }
}
