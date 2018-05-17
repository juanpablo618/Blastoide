package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import screenplay.models.AirBookingFlow;
import screenplay.models.EarlyBirdFlowInformation;
import screenplay.user_interface.earlyBird.EarlyBirdSelectPageForm;

public class IneligibleBoundIsCorrectlyDisplayed implements Question<Boolean> {

    private AirBookingFlow airBookingFlow;
    private EarlyBirdFlowInformation earlyBirdFlowInformation;
    private int ineligibleBound;
    private static final int OUTBOUND = 1;
    private static final int INBOUND = 2;
    private static final String BUSINESS_SELECT = "Business select";
    private static final String OUTSIDE_PURCHASE_WINDOW = "Flight outside purchase window";
    private static final String BUSINESS_SELECT_REASON = "Business Select gets you A1-A15";

    public IneligibleBoundIsCorrectlyDisplayed(AirBookingFlow airBookingFlow, EarlyBirdFlowInformation earlyBirdFlowInformation) {
        this.airBookingFlow = airBookingFlow;
        this.earlyBirdFlowInformation = earlyBirdFlowInformation;
        setInelegibleBoundAndReason();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(EarlyBirdSelectPageForm.getIneligibleBound(ineligibleBound)).viewedBy(actor).resolve();
    }

    private void setInelegibleBoundAndReason() {
        if (airBookingFlow.getDepartureDate() <= 1 || BUSINESS_SELECT.equals(airBookingFlow.getFareTypeOB())) {
            ineligibleBound = OUTBOUND;
            earlyBirdFlowInformation.setIneligibleBound("OUTBOUND");

            earlyBirdFlowInformation.setIneligibilityReason(OUTSIDE_PURCHASE_WINDOW);

            if (BUSINESS_SELECT.equals(airBookingFlow.getFareTypeOB())) {
                earlyBirdFlowInformation.setIneligibilityReason(BUSINESS_SELECT_REASON);
            }

        } else {
            ineligibleBound = INBOUND;
            earlyBirdFlowInformation.setIneligibleBound("INBOUND");

            earlyBirdFlowInformation.setIneligibilityReason(OUTSIDE_PURCHASE_WINDOW);

            if (BUSINESS_SELECT.equals(airBookingFlow.getFareTypeIB())) {
                earlyBirdFlowInformation.setIneligibilityReason(BUSINESS_SELECT_REASON);
            }
        }
    }
}