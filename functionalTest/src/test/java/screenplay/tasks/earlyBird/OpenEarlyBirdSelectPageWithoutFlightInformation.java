package screenplay.tasks.earlyBird;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import pages.EarlyBirdSelectPage;

public class OpenEarlyBirdSelectPageWithoutFlightInformation implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.browserOn(new EarlyBirdSelectPage())
        );
    }
}