package screenplay.tasks.swabizAirBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import screenplay.user_interface.swabizAirBooking.SwabizTravelForm;

public class AccessToSwabizSearchPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
               Enter.theValue("99243955").into(SwabizTravelForm.COMPANY_ID_INPUT),
                Click.on(SwabizTravelForm.COMPANY_ID_BUTTON)
        );

    }
}
