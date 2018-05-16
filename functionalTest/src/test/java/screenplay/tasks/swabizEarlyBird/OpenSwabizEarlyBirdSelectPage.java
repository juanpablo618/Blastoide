package screenplay.tasks.swabizEarlyBird;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.DefaultUrl;
import pages.SwabizEarlyBirdSelectPage;
import screenplay.models.AirBookingFlow;

public class OpenSwabizEarlyBirdSelectPage implements Task {

    AirBookingFlow airBookingFlow;

    public OpenSwabizEarlyBirdSelectPage(AirBookingFlow airBookingFlow){
        this.airBookingFlow = airBookingFlow;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String urlWithFlightInformation = SwabizEarlyBirdSelectPage.class.getDeclaredAnnotation(DefaultUrl.class).value()
                .concat("?confirmationNumber=").concat(airBookingFlow.getConfirmationNumber()
                .concat("&passengerFirstName=").concat(airBookingFlow.getFirstName()
                .concat("&passengerLastName=").concat(airBookingFlow.getLastName())));

        actor.attemptsTo(
                Open.url(urlWithFlightInformation)
        );
    }
}