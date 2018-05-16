package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import screenplay.user_interface.earlyBird.EarlyBirdSelectPageForm;


public class CorrectAmountOfPassengersDisplayed implements Question<Boolean> {

    private Target checkBox;

    public CorrectAmountOfPassengersDisplayed(Target checkBox) {
        this.checkBox = checkBox;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(checkBox).viewedBy(actor).resolve();
    }

    public static CorrectAmountOfPassengersDisplayed forOutbound() {
        return new CorrectAmountOfPassengersDisplayed(EarlyBirdSelectPageForm.OUTBOUND_CHECKBOX_BY_PASSENGER);
    }

    public static CorrectAmountOfPassengersDisplayed forInbound() {
        return new CorrectAmountOfPassengersDisplayed(EarlyBirdSelectPageForm.INBOUND_CHECKBOX_BY_PASSENGER);
    }
}