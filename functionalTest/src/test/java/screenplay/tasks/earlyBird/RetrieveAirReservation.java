package screenplay.tasks.earlyBird;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import screenplay.models.AirBookingFlow;
import screenplay.models.AnonymousPassengers;
import screenplay.user_interface.earlyBird.LandingPageForm;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;

public class RetrieveAirReservation implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        AirBookingFlow airBookingFlow = sessionVariableCalled("airBookingInformation");

        actor.attemptsTo(
                Enter.theValue(airBookingFlow.getConfirmationNumber()).into(LandingPageForm.CONFIRMATION_NUMBER_INPUT),
                Enter.theValue(airBookingFlow.getFirstName()).into(LandingPageForm.FIRST_NAME_INPUT),
                Enter.theValue(airBookingFlow.getLastName()).into(LandingPageForm.LAST_NAME_INPUT),
                Click.on(LandingPageForm.CONTINUE_BUTTON)
        );
    }

    public static RetrieveAirReservation withAnInvalidPNR() {
        AirBookingFlow airBookingFlow = sessionVariableCalled("airBookingInformation");
        airBookingFlow.setConfirmationNumber("ASD123");
        Serenity.setSessionVariable("airBookingInformation").to(airBookingFlow);
        return new RetrieveAirReservation();
    }

    public static RetrieveAirReservation withAnInvalidPassenger() {
        AirBookingFlow airBookingFlow = sessionVariableCalled("airBookingInformation");
        airBookingFlow.setFirstName("Sheldon");
        airBookingFlow.setLastName(AnonymousPassengers.LAST_NAMES[1]);
        Serenity.setSessionVariable("airBookingInformation").to(airBookingFlow);
        return new RetrieveAirReservation();
    }
}
