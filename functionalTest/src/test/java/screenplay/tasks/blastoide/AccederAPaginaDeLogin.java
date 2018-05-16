package screenplay.tasks.blastoide;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import pages.PaginaDeLogin;

public class AccederAPaginaDeLogin implements Task {

            PaginaDeLogin paginaDeLogin;

    @Step("{0} accede a la pagina de login del sistema")
    public <T extends Actor> void performAs(T actor) {
                actor.attemptsTo(
                                Open.browserOn(paginaDeLogin)
                                );
            }
}