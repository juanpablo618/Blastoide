package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import screenplay.user_interface.earlyBird.EarlyBirdConfirmationPageItinerarySection;

public class EarlyBirdCorrectBoundDisplayedInConfirmationPage implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
         if(EarlyBirdConfirmationPageItinerarySection.CONFIRMATION_BOUNDS.resolveAllFor(actor).size()<=1){
             return true;
         }
        return false;
    }
}
