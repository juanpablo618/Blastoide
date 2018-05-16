package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import screenplay.models.EarlyBirdFlowInformation;
import screenplay.user_interface.earlyBird.EarlyBirdPurchasePageForm;

public class EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage implements Question<Boolean> {

    private Double earlyBirdFlowInformationPrice;
    private Target priceTarget;

    public EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage(Target priceTarget, Double earlyBirdFlowInformationPrice) {
        this.earlyBirdFlowInformationPrice = earlyBirdFlowInformationPrice;
        this.priceTarget = priceTarget;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        double totalDisplayed = Double.parseDouble(Text.of(priceTarget).viewedBy(actor).asString());

        return earlyBirdFlowInformationPrice == totalDisplayed;
    }

    public static EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage forSubTotalOutbound(EarlyBirdFlowInformation earlyBirdFlowInformation) {

        return new EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage(EarlyBirdPurchasePageForm.OUTBOUND_SUB_TOTAL, earlyBirdFlowInformation.getSubTotalOB());
    }

    public static EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage forSubTotalInbound(EarlyBirdFlowInformation earlyBirdFlowInformation) {

        return new EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage(EarlyBirdPurchasePageForm.INBOUND_SUB_TOTAL, earlyBirdFlowInformation.getSubTotalIB());
    }

    public static EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage forTotalPrice(EarlyBirdFlowInformation earlyBirdFlowInformation) {

        return new EarlyBirdPriceIsCorrectlyDisplayedInPurchasePage(EarlyBirdPurchasePageForm.TOTAL, earlyBirdFlowInformation.getTotalEB());
    }
}