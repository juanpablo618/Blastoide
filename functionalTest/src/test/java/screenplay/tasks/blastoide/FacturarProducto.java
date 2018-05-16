package screenplay.tasks.blastoide;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.OpenPage;
import net.thucydides.core.annotations.Step;
import pages.PaginaFacturar;

public class FacturarProducto implements Task {

        @Step("{0} ingresa en caja - facturar")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    new OpenPage(new PaginaFacturar())
            );
        }

    }