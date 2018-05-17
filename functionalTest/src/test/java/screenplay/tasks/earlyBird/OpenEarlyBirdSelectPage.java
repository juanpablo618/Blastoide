package screenplay.tasks.earlyBird;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.DefaultUrl;
import pages.EarlyBirdSelectPage;
import screenplay.models.AirBookingFlow;

public class OpenEarlyBirdSelectPage implements Task {

    AirBookingFlow airBookingFlow;

    public OpenEarlyBirdSelectPage(AirBookingFlow airBookingFlow){
        this.airBookingFlow = airBookingFlow;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String urlWithFlightInformation = EarlyBirdSelectPage.class.getDeclaredAnnotation(DefaultUrl.class).value()
                .concat("?confirmationNumber=").concat(airBookingFlow.getConfirmationNumber()
                .concat("&passengerFirstName=").concat(airBookingFlow.getFirstName()
                .concat("&passengerLastName=").concat(airBookingFlow.getLastName())));

        actor.attemptsTo(
                Open.url(urlWithFlightInformation)
        );
    }
}