package screenplay.tasks.earlyBird;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.models.AirBookingFlow;
import screenplay.models.EarlyBirdFlowInformation;
import screenplay.user_interface.earlyBird.EarlyBirdSelectPageForm;

public class StoreEarlyFlowInformation implements Task {

    EarlyBirdFlowInformation earlyBirdFlowInformation;
    AirBookingFlow airBookingFlow;

    public StoreEarlyFlowInformation(EarlyBirdFlowInformation earlyBirdFlowInformation, AirBookingFlow airBookingFlow) {
        this.earlyBirdFlowInformation = earlyBirdFlowInformation;
        this.airBookingFlow = airBookingFlow;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        earlyBirdFlowInformation.setSubTotalOB(Double.parseDouble(Text.of(EarlyBirdSelectPageForm.SUB_TOTAL_OUTBOUND).viewedBy(actor).asString()));

        boolean isOneWay = airBookingFlow.getItineraryType().equals("One-way");

        if (!isOneWay) {
            earlyBirdFlowInformation.setSubTotalIB(Double.parseDouble(Text.of(EarlyBirdSelectPageForm.SUB_TOTAL_INBOUND).viewedBy(actor).asString()));
        }

        earlyBirdFlowInformation.setTotalEB(Double.parseDouble(Text.of(EarlyBirdSelectPageForm.ESTIMATED_TOTAL).viewedBy(actor).asString()));

    }

}
