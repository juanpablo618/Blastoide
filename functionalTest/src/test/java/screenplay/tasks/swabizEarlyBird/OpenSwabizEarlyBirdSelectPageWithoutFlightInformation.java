package screenplay.tasks.swabizEarlyBird;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import pages.SwabizEarlyBirdSelectPage;

public class OpenSwabizEarlyBirdSelectPageWithoutFlightInformation implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.browserOn(new SwabizEarlyBirdSelectPage())
        );
    }
}