package steps;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.openqa.selenium.WebDriver;
import screenplay.models.AirBookingFlow;
import screenplay.questions.ConfirmationNumberDisplayed;
import screenplay.tasks.airBooking.*;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class AirBookingStep extends CommonConfirmation {

    @Managed()
    private WebDriver webDriver;

    @Given("an anonymous traveller")
    public void setTraveler() {
        actor = Actor.named("anonymous").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
    }

    @When("I book a flight with the following itinerary: $table")
    public void bookAFlightWitItinerary(ExamplesTable table) {
        AirBookingFlow airBookingFlow = AirBookingFlow.storeAirBookingFlowData(table);

        actor.attemptsTo(
                new OpenPlanATripPage(),
                SearchFlight.byItineraryType(airBookingFlow),
                new SelectFlights(airBookingFlow),
                new ConfirmPrice(),
                new EnterPassengerInformation(airBookingFlow),
                new Purchase(airBookingFlow)
        );
    }

    @Then("an air confirmation number is displayed")
    public void validateConfirmationNumber() {
        actor.should(eventually(seeThat(new ConfirmationNumberDisplayed(), not(isEmptyString()))));
        setConfirmationNumber();
    }
}