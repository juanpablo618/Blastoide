package screenplay.tasks.blastoide;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.OpenPage;
import net.thucydides.core.annotations.Step;
import pages.PaginaTipoDeClientes;
import pages.PaginaTipoDeIva;

public class EntrarAPaginaTipoDeClientes implements Task {


        @Step("{0} ingresa en pagina Tipo de Clientes")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    new OpenPage(
                            new PaginaTipoDeClientes())
            );
            Serenity.takeScreenshot();

        }
    }

