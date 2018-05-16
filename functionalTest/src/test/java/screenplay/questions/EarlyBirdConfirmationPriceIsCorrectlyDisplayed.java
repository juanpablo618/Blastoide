package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.models.AirBookingFlow;
import screenplay.models.EarlyBirdFlowInformation;
import screenplay.user_interface.earlyBird.EarlyBirdConfirmationPageItinerarySection;
import screenplay.user_interface.earlyBird.EarlyBirdConfirmationPagePaymentSection;

public class EarlyBirdConfirmationPriceIsCorrectlyDisplayed implements Question<Boolean> {

    private EarlyBirdFlowInformation earlyBirdFlowInformation;
    private AirBookingFlow airBookingFlow;
    private double priceEB;
    private double subTotalIB;
    private double subTotalOB;
    private static final String ONE_WAY = "One-way";

    public EarlyBirdConfirmationPriceIsCorrectlyDisplayed(EarlyBirdFlowInformation earlyBirdFlowInformation, AirBookingFlow airBookingFlow) {
        this.earlyBirdFlowInformation = earlyBirdFlowInformation;
        this.airBookingFlow = airBookingFlow;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        earlyBirdFlowInformation.setSubTotalOB(Double.parseDouble(Text.of(EarlyBirdConfirmationPageItinerarySection.OUTBOUND_SUBTOTAL).viewedBy(actor).asString()));
        priceEB = earlyBirdFlowInformation.getPriceEB();
        subTotalOB = priceEB * (airBookingFlow.getAdultPassengerCount() + airBookingFlow.getSeniorPassengerCount() -
                airBookingFlow.getExtraSeatPassengerCount() - airBookingFlow.getAListPreferredUsersCount());
        boolean isOneWay = ONE_WAY.equalsIgnoreCase(airBookingFlow.getItineraryType());
        if (!isOneWay) {
            earlyBirdFlowInformation.setSubTotalIB(Double.parseDouble(Text.of(EarlyBirdConfirmationPageItinerarySection.INBOUND_SUBTOTAL).viewedBy(actor).asString()));
            subTotalIB = priceEB * (airBookingFlow.getAdultPassengerCount() + airBookingFlow.getSeniorPassengerCount()-
                    airBookingFlow.getExtraSeatPassengerCount() - airBookingFlow.getAListPreferredUsersCount());
        }

        return (earlyBirdFlowInformation.getSubTotalOB() == subTotalOB &&
                (isOneWay || earlyBirdFlowInformation.getSubTotalIB() == subTotalIB) &&
                (Double.parseDouble(Text.of(EarlyBirdConfirmationPagePaymentSection.PAYMENT_SUMMARY_TOTAL).viewedBy(actor).asString())
                        >= (subTotalOB + subTotalIB)));
    }
}