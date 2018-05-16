package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.models.AirBookingFlow;
import screenplay.models.EarlyBirdFlowInformation;
import screenplay.user_interface.earlyBird.EarlyBirdSelectPageForm;

public class EarlyBirdPriceIsCorrectlyDisplayed implements Question<Boolean> {

    private EarlyBirdFlowInformation earlyBirdFlowInformation;
    private AirBookingFlow airBookingFlow;
    private double priceEB;
    private double subTotalIB;
    private double subTotalOB;
    private double totalEB;

    public EarlyBirdPriceIsCorrectlyDisplayed(EarlyBirdFlowInformation earlyBirdFlowInformation, AirBookingFlow airBookingFlow) {
        this.earlyBirdFlowInformation = earlyBirdFlowInformation;
        this.airBookingFlow = airBookingFlow;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        earlyBirdFlowInformation.setSubTotalOB(Double.parseDouble(Text.of(EarlyBirdSelectPageForm.SUB_TOTAL_OUTBOUND).viewedBy(actor).asString()));
        priceEB = earlyBirdFlowInformation.getPriceEB();
        subTotalOB = priceEB * earlyBirdFlowInformation.getNumberOfSelectedPassengerOB();
        boolean isOneWay = airBookingFlow.getItineraryType().equals("One-way");
        if (!isOneWay) {
            earlyBirdFlowInformation.setSubTotalIB(Double.parseDouble(Text.of(EarlyBirdSelectPageForm.SUB_TOTAL_INBOUND).viewedBy(actor).asString()));
            subTotalIB = priceEB * earlyBirdFlowInformation.getNumberOfSelectedPassengerIB();
        }
        earlyBirdFlowInformation.setTotalEB(Double.parseDouble(Text.of(EarlyBirdSelectPageForm.ESTIMATED_TOTAL).viewedBy(actor).asString()));
        totalEB = subTotalIB + subTotalOB;
        return (earlyBirdFlowInformation.getSubTotalOB() == subTotalOB &&
                (isOneWay || earlyBirdFlowInformation.getSubTotalIB() == subTotalIB) &&
                earlyBirdFlowInformation.getTotalEB() == totalEB);
    }
}