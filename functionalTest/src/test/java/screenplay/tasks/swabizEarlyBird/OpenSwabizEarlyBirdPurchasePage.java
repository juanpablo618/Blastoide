package screenplay.tasks.swabizEarlyBird;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import pages.SwabizEarlyBirdPurchasePage;

public class OpenSwabizEarlyBirdPurchasePage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(new SwabizEarlyBirdPurchasePage())
        );
    }
}