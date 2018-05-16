package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import screenplay.user_interface.earlyBird.EarlyBirdConfirmationPageTripSummarySection;

public class EarlyBirdConfirmationItineraryInSummaryIsCorrectlyDisplayed implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        return Visibility.of(EarlyBirdConfirmationPageTripSummarySection.PURCHASE_SUMMARY_ITINERARY).viewedBy(actor).resolve();
    }
}