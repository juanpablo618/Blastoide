package screenplay.tasks.blastoide;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.OpenPage;
import net.thucydides.core.annotations.Step;
import pages.PaginaProductosPorProveedor;
import pages.PaginaProductosSinStock;

public class EntrarAPaginaProductosPorProveedor implements Task {


        @Step("{0} ingresa en pagina productos por proveedor")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    new OpenPage(
                            new PaginaProductosPorProveedor())
            );
            Serenity.takeScreenshot();

        }
    }

