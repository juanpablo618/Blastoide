package screenplay.tasks.airBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.models.AirBookingFlow;
import screenplay.user_interface.airBooking.SelectFlightResultsMatrix;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectNonStopFlights implements Task {
    AirBookingFlow airBookingFlow;
    private static final String ONE_WAY = "One-way";

    public SelectNonStopFlights(AirBookingFlow airBookingFlow) {
        this.airBookingFlow = airBookingFlow;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean isOneWay = ONE_WAY.equalsIgnoreCase(airBookingFlow.getItineraryType());

        actor.attemptsTo(
                WaitUntil.the(SelectFlightResultsMatrix.DEPARTING_NON_STOP_BUTTON, isVisible()).forNoMoreThan(30).seconds()
        );
        actor.attemptsTo(
                Click.on(SelectFlightResultsMatrix.DEPARTING_NON_STOP_BUTTON)
        );

        if(!isOneWay) {
            actor.attemptsTo(Click.on(SelectFlightResultsMatrix.RETURNING_NON_STOP_BUTTON));
        }
    }
}
