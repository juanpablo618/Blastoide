package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;
import org.apache.bcel.generic.RETURN;
import screenplay.user_interface.earlyBird.LandingPageForm;

public class LandingPageInputsFieldsAreNotEmpty implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        if (Value.of(LandingPageForm.CONFIRMATION_NUMBER_INPUT).viewedBy(actor).asString().isEmpty() ||
                Value.of(LandingPageForm.FIRST_NAME_INPUT).viewedBy(actor).asString().isEmpty() ||
                Value.of(LandingPageForm.LAST_NAME_INPUT).viewedBy(actor).asString().isEmpty()) {
            return false;
        }
        return true;
    }
}
