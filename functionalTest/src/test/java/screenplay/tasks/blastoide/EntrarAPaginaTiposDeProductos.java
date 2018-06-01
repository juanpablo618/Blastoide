package screenplay.tasks.blastoide;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.OpenPage;
import net.thucydides.core.annotations.Step;
import pages.PaginaTiposDeProductos;

public class EntrarAPaginaTiposDeProductos implements Task {


        @Step("{0} ingresa en pagina tipos de Productos")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    new OpenPage(
                            new PaginaTiposDeProductos())
            );
            Serenity.takeScreenshot();

        }
    }

