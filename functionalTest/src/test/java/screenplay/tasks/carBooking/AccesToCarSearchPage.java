package screenplay.tasks.carBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import pages.CarSearchPage;

public class AccesToCarSearchPage implements Task {

    CarSearchPage carSearchPage;

    @Step("{0} accesses to the Car Search page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Open.browserOn(carSearchPage)
        );
    }
}
