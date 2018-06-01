package screenplay.tasks.blastoide;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.OpenPage;
import net.thucydides.core.annotations.Step;
import pages.PaginaFacturar;

public class EntrarAPaginaFacturar implements Task {

    @Step("{0} ingresa en pagina facturar")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                new OpenPage(
                        new PaginaFacturar())
        );
        Serenity.takeScreenshot();

    }
}