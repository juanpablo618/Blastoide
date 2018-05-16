package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.user_interface.earlyBird.EarlyBirdConfirmationPageItinerarySection;
import screenplay.user_interface.earlyBird.EarlyBirdConfirmationPageTripSummarySection;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EarlyBirdInternalReferenceNumberDisplayed implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(EarlyBirdConfirmationPageTripSummarySection.EARLY_BIRD_CONFIRMATION_NUMBER, isVisible()).forNoMoreThan(30).seconds()
        );
        return Visibility.of(EarlyBirdConfirmationPageItinerarySection.EARLY_BIRD_INTERNAL_REFERENCE_NUMBER).viewedBy(actor).resolve();
    }
}
