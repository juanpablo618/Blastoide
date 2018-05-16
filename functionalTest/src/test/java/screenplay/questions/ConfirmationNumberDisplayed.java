package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.user_interface.airBooking.TripSummaryForm;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmationNumberDisplayed implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(TripSummaryForm.CONFIRMATION_NUMBER, isVisible()).forNoMoreThan(60).seconds()
        );

        return Text.of(TripSummaryForm.CONFIRMATION_NUMBER).viewedBy(actor).asString();
    }
}
