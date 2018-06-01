package screenplay.tasks.blastoide;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.OpenPage;
import net.thucydides.core.annotations.Step;
import pages.PaginaProductos;
import pages.PaginaProductosSinStock;

public class EntrarAPaginaProductosSinStock implements Task {


        @Step("{0} ingresa en pagina productos sin stock")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    new OpenPage(
                            new PaginaProductosSinStock())
            );
            Serenity.takeScreenshot();

        }
    }

