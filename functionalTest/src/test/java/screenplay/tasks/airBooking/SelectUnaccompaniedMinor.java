package screenplay.tasks.airBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.user_interface.airBooking.Purchase_Minor_Modal;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class SelectUnaccompaniedMinor implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(Purchase_Minor_Modal.ACCOMPANIED_MINOR_MODAL_NO_ACCOMPANIED_BUTTON, isVisible()).forNoMoreThan(30).seconds()
        );
        actor.attemptsTo(
                Click.on(Purchase_Minor_Modal.ACCOMPANIED_MINOR_MODAL_NO_ACCOMPANIED_BUTTON)
        );
    }
}
