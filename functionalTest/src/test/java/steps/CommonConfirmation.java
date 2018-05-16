package steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.models.AirBookingFlow;
import screenplay.questions.ConfirmationNumberDisplayed;
import screenplay.user_interface.airBooking.TripSummaryForm;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class CommonConfirmation {

    protected Actor actor;
    protected AirBookingFlow airBookingFlow;

    protected void validateConfirmationNumber(AirBookingFlow airBookingFlow) {
        actor.should(eventually(seeThat(new ConfirmationNumberDisplayed(), not(isEmptyString()))));

        airBookingFlow.setConfirmationNumber(Text.of(TripSummaryForm.CONFIRMATION_NUMBER).viewedBy(actor).asString());
    }

    protected void setConfirmationNumber() {
        AirBookingFlow airBookingFlow = sessionVariableCalled("airBookingInformation");
        airBookingFlow.setConfirmationNumber(Text.of(TripSummaryForm.CONFIRMATION_NUMBER).viewedBy(actor).asString());
        Serenity.setSessionVariable("airBookingInformation").to(airBookingFlow);
    }
}
