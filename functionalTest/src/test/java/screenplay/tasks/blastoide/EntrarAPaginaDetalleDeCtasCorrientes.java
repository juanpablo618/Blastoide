package screenplay.tasks.blastoide;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.OpenPage;
import net.thucydides.core.annotations.Step;
import pages.PaginaClientes;
import pages.PaginaDetalleDeCtasCorrientes;

public class EntrarAPaginaDetalleDeCtasCorrientes implements Task {


        @Step("{0} ingresa en pagina detalle de cuentas corrientes")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    new OpenPage(
                            new PaginaDetalleDeCtasCorrientes())
            );
            Serenity.takeScreenshot();

        }
    }

