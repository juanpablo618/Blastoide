package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import screenplay.user_interface.earlyBird.EarlyBirdPurchasePageForm;

public class SavedCreditCardButtonIsNotDisplayed implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return !Visibility.of(EarlyBirdPurchasePageForm.SAVED_CREDIT_CARD_RADIO_BUTTON).viewedBy(actor).resolve();
    }
}