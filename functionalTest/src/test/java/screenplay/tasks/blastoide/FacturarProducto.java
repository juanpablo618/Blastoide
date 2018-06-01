package screenplay.tasks.blastoide;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.OpenPage;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import pages.PaginaFacturar;
import screenplay.user_interface.airBooking.PaymentMethodForm;
import screenplay.user_interface.blastoide.PaginaDeFacturacion;

import java.util.ArrayList;
import java.util.List;

public class FacturarProducto implements Task {

    List<Performable> scrollDownYearInteraction = new ArrayList<>();


    @Step("{0} ingresa en caja - facturar y hace una venta")
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    new OpenPage(
                            new PaginaFacturar()),
                            Click.on(PaginaDeFacturacion.LABEL_CLIENTE),

                            Hit.the(Keys.ARROW_DOWN).into(PaginaDeFacturacion.LABEL_CLIENTE),
                            Hit.the(Keys.ARROW_DOWN).into(PaginaDeFacturacion.LABEL_CLIENTE),

                            Hit.the(Keys.ENTER).into(PaginaDeFacturacion.LABEL_CLIENTE),

                            Enter.theValue("7790520009944").into(PaginaDeFacturacion.PRUDUCTO_INPUT),
                            Hit.the(Keys.ENTER).into(PaginaDeFacturacion.BOTON_AGREGAR),


                            Enter.theValue("7790520009609").into(PaginaDeFacturacion.PRUDUCTO_INPUT),
                            Hit.the(Keys.ENTER).into(PaginaDeFacturacion.BOTON_AGREGAR),


                            Enter.theValue("7798184680707").into(PaginaDeFacturacion.PRUDUCTO_INPUT),
                            Hit.the(Keys.ENTER).into(PaginaDeFacturacion.BOTON_AGREGAR),

                            Click.on(PaginaDeFacturacion.BOTON_FACTURAR)

                    );
        Serenity.takeScreenshot();

        }
    }