package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import screenplay.models.AirBookingFlow;
import screenplay.user_interface.earlyBird.EarlyBirdSelectPageForm;

public class IneligiblePassengerAmountIsCorrectlyDisplayed implements Question<Boolean> {
    private int ineligiblePassengerAmount;
    private int eligiblePassengerAmount;

    public IneligiblePassengerAmountIsCorrectlyDisplayed(AirBookingFlow airBookingFlow) {
        this.ineligiblePassengerAmount = airBookingFlow.getAListPreferredUsersCount();
        this.eligiblePassengerAmount = airBookingFlow.getAdultPassengerCount() - airBookingFlow.getAListPreferredUsersCount();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return ((Visibility.of(EarlyBirdSelectPageForm.OUTBOUND_ELIGIBLE_PASSENGER_LIST).viewedBy(actor).resolveAll().size() == eligiblePassengerAmount) &&
                Visibility.of(EarlyBirdSelectPageForm.OUTBOUND_INELIGIBLE_PASSENGER_LIST).viewedBy(actor).resolveAll().size() == ineligiblePassengerAmount);
    }
}
