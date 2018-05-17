package screenplay.tasks.blastoide;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.OpenPage;
import net.thucydides.core.annotations.Step;
import pages.PaginaFacturar;
import screenplay.user_interface.blastoide.PaginaDeFacturacion;

import java.util.ArrayList;
import java.util.List;

public class FacturarProducto implements Task {

    List<Performable> scrollDownYearInteraction = new ArrayList<>();


    @Step("{0} ingresa en caja - facturar y hace una venta")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    new OpenPage(new PaginaFacturar()),
                            Click.on(PaginaDeFacturacion.LABEL_CLIENTE)

            );
        }
    }