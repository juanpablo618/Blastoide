package screenplay.tasks.earlyBird;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.user_interface.earlyBird.EarlyBirdSelectPageForm;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ContinueToEarlyBirdPurchasePage implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(EarlyBirdSelectPageForm.CONTINUE_BUTTON, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(EarlyBirdSelectPageForm.CONTINUE_BUTTON)
        );
    }
}