package screenplay.tasks.airBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import screenplay.user_interface.airBooking.WhoIsFlyingForm;

public class AddEarlyBird implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(WhoIsFlyingForm.ADD_EARLY_BIRD_RADIO_BUTTON)
        );
    }
}
