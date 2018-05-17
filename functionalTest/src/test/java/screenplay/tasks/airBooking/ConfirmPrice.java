package screenplay.tasks.airBooking;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.user_interface.airBooking.TripSummarySection;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmPrice implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        WaitUntil.the(TripSummarySection.CONTINUE_BUTTON, isVisible()).forNoMoreThan(35).seconds();

        actor.attemptsTo(
                Click.on(TripSummarySection.CONTINUE_BUTTON)
        );
    }
}
