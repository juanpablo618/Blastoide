package screenplay.tasks.swabizAirBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import pages.SwabizLandingPage;

public class OpenSwabizPlanATrip implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(new SwabizLandingPage())
        );
    }

}