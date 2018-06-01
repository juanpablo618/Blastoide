package screenplay.user_interface.blastoide;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaDeFacturacion {
    public static final Target LABEL_CLIENTE = Target.the("Label para elegir usuario").located(By.id("frmCliente:seleccionarCliente"));

    public static final Target PRUDUCTO_INPUT = Target.the("input text de producto").located(By.id("formDeProducto:productoCodBarra"));

    public static final Target BOTON_AGREGAR = Target.the("boton agregar").located(By.id("formDeProducto:botonAgregar"));

    public static final Target BOTON_FACTURAR = Target.the("boton facturar").located(By.id("tablaDetalleVenta:botonFacturar"));

    public static final Target SELECT_CLIENTE = Target.the("Label para elegir usuario").located(By.className("ui-selectonemenu-item ui-selectonemenu-list-item ui-corner-all"));


    public static final Target TITULO_MUNDO_LIMPIEZA = Target.the("boton facturar").located(By.id("j_idt14:OutPutlabelMundoLimpieza"));

}
