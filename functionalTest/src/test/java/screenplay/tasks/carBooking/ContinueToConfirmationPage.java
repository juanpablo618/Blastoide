package screenplay.tasks.carBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import screenplay.user_interface.carBooking.ReserveSection;

public class ContinueToConfirmationPage implements Task{

    @Step("{0} continues to Confirmation page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ReserveSection.RESERVE_BUTTON)
        );
    }
}
