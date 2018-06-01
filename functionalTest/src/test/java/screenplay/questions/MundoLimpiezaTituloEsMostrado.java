package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.user_interface.airBooking.TripSummaryForm;
import screenplay.user_interface.blastoide.PaginaDeFacturacion;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class MundoLimpiezaTituloEsMostrado implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(PaginaDeFacturacion.TITULO_MUNDO_LIMPIEZA, isVisible()).forNoMoreThan(60).seconds()
        );

        return Text.of(PaginaDeFacturacion.TITULO_MUNDO_LIMPIEZA).viewedBy(actor).asString();
    }
}
