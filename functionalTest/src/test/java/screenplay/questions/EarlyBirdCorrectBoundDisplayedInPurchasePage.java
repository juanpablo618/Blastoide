package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import screenplay.user_interface.earlyBird.EarlyBirdPurchasePageForm;

public class EarlyBirdCorrectBoundDisplayedInPurchasePage implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
         if(EarlyBirdPurchasePageForm.PURCHASE_BOUNDS.resolveAllFor(actor).size()<=1){
             return true;
         }
        return false;
    }
}
