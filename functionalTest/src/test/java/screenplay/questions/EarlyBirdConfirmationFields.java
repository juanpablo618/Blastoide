package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import screenplay.user_interface.earlyBird.EarlyBirdConfirmationPageItinerarySection;
import screenplay.user_interface.earlyBird.EarlyBirdConfirmationPageTripSummarySection;

public class EarlyBirdConfirmationFields implements Question<String> {

    private Target field;

    public EarlyBirdConfirmationFields(Target field) {
        this.field = field;
    }

    public static EarlyBirdConfirmationFields forEarlyBirdConfirmationNumber() {
        return new EarlyBirdConfirmationFields(EarlyBirdConfirmationPageTripSummarySection.EARLY_BIRD_CONFIRMATION_NUMBER);
    }

    public static EarlyBirdConfirmationFields forOutboundPassengers() {
        return new EarlyBirdConfirmationFields(EarlyBirdConfirmationPageItinerarySection.OUTBOUND_PASSENGERS);
    }

    public static EarlyBirdConfirmationFields forInboundPassengers() {
        return new EarlyBirdConfirmationFields(EarlyBirdConfirmationPageItinerarySection.INBOUND_PASSENGERS);
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(field).viewedBy(actor).asString();
    }
}
