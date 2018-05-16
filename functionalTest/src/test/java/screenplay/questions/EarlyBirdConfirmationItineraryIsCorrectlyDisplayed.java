package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import screenplay.models.AirBookingFlow;
import screenplay.user_interface.earlyBird.EarlyBirdConfirmationPageItinerarySection;

public class EarlyBirdConfirmationItineraryIsCorrectlyDisplayed implements Question<Boolean> {
    private AirBookingFlow airBookingFlow;

    public EarlyBirdConfirmationItineraryIsCorrectlyDisplayed(AirBookingFlow airBookingFlow) {
        this.airBookingFlow = airBookingFlow;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean isOneWay = airBookingFlow.getItineraryType().equals("One-way");

        return (Visibility.of(EarlyBirdConfirmationPageItinerarySection.OUTBOUND_ITINERARY).viewedBy(actor).resolve() &&
                (isOneWay || Visibility.of(EarlyBirdConfirmationPageItinerarySection.INBOUND_ITINERARY).viewedBy(actor).resolve()));
    }
}