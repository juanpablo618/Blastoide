package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import screenplay.user_interface.earlyBird.LandingPageForm;

public class LandingPageIsCorrectlyDisplayed implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(LandingPageForm.CONFIRMATION_NUMBER_INPUT).viewedBy(actor).resolve();
    }
}
