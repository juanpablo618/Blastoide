package screenplay.tasks.carBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import screenplay.user_interface.carBooking.PriceContinueSection;

public class ContinueToPurchasePage implements Task {

    @Step("{0} continues to Purchase page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PriceContinueSection.PRICE_CONTINUE_BUTTON)
        );
    }
}
