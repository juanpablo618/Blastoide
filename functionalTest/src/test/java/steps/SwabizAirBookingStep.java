package steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.WebDriver;
import screenplay.models.AirBookingFlow;
import screenplay.questions.ConfirmationNumberDisplayed;
import screenplay.tasks.airBooking.*;
import screenplay.tasks.swabizAirBooking.AccessToSwabizSearchPage;
import screenplay.tasks.swabizAirBooking.OpenSwabizPlanATrip;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class SwabizAirBookingStep extends CommonConfirmation {

    @Managed()
    private WebDriver webDriver;

    @Given("an anonymous traveller on Swabiz")
    public void setTraveler() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
    }

    @Given("I book a flight on Swabiz with the following itinerary: $table")
    public void bookASwabizFlight(ExamplesTable table) {
        airBookingFlow = AirBookingFlow.storeAirBookingFlowData(table);

        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();

        actor.attemptsTo(
                new OpenSwabizPlanATrip(),
                new AccessToSwabizSearchPage(),
                SearchFlight.byItineraryType(airBookingFlow),
                new SelectFlights(airBookingFlow),
                new ConfirmPrice(),
                new EnterPassengerInformation(airBookingFlow),
                new PurchaseOnSwabiz(airBookingFlow)
        );
        validateConfirmationNumber(airBookingFlow);
        Serenity.setSessionVariable("airBookingInformation").to(airBookingFlow);
    }

    @Then("an air confirmation number is displayed on Swabiz confirmation page")
    public void validateConfirmationNumber() {
        actor.should(eventually(seeThat(new ConfirmationNumberDisplayed(), not(isEmptyString()))));
        setConfirmationNumber();
    }
}