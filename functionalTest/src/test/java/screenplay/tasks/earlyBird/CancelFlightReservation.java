package screenplay.tasks.earlyBird;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import screenplay.user_interface.airBooking.CancelFlightForm;
import screenplay.user_interface.airBooking.TripSummaryForm;

public class CancelFlightReservation implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(TripSummaryForm.CONFIRMATION_NUMBER_CANCELLED_BUTTON),
                Click.on(CancelFlightForm.REFUND_METHOD_DROPDOWN),
                Click.on(CancelFlightForm.REFUND_METHOD_ITEM),
                Click.on(CancelFlightForm.CANCEL_FLIGHT_BUTTON)
        );
    }
}