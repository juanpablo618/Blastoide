package screenplay.tasks.blastoide;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.OpenPage;
import net.thucydides.core.annotations.Step;
import pages.PaginaCajaDiaria;
import pages.PaginaTipoDeIva;

public class EntrarAPaginaTipoDeIva implements Task {


        @Step("{0} ingresa en pagina Tipo de Iva de los clientes")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    new OpenPage(
                            new PaginaTipoDeIva())
            );
            Serenity.takeScreenshot();

        }
    }

