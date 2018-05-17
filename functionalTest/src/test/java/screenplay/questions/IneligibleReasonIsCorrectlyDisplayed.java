package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import screenplay.models.EarlyBirdFlowInformation;
import screenplay.user_interface.earlyBird.EarlyBirdSelectPageForm;

public class IneligibleReasonIsCorrectlyDisplayed implements Question<Boolean> {

    private EarlyBirdFlowInformation earlyBirdFlowInformation;

    public IneligibleReasonIsCorrectlyDisplayed(EarlyBirdFlowInformation earlyBirdFlowInformation) {
        this.earlyBirdFlowInformation = earlyBirdFlowInformation;
    }

    public String retrieveIneligibleBound() {
        return earlyBirdFlowInformation.getIneligibleBound();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String ineligibleReason;

        if (retrieveIneligibleBound().equals("OUTBOUND")) {
            ineligibleReason = Text.of(EarlyBirdSelectPageForm.INELIGIBLE_REASON_BY_OUTBOUND).viewedBy(actor).asString();
        } else {
            ineligibleReason = Text.of(EarlyBirdSelectPageForm.INELIGIBLE_REASON_BY_INBOUND).viewedBy(actor).asString();
        }
        return earlyBirdFlowInformation.getIneligibilityReason().equalsIgnoreCase(ineligibleReason);
    }
}
