package screenplay.tasks.earlyBird;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.user_interface.earlyBird.LandingPageForm;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickOnErrorDetailButton implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(LandingPageForm.ERROR_DETAIL_BUTTON, isVisible()).forNoMoreThan(60).seconds(),
            Click.on(LandingPageForm.ERROR_DETAIL_BUTTON)
        );
    }
}
