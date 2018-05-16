package screenplay.user_interface.blastoide;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginFormulario {
    public static final Target USUARIO_FIRST_NAME_INPUT = Target.the("Usuario First Name input box on login").located(By.id("j_idt5:username"));
    public static final Target USUARIO_LAST_NAME_INPUT = Target.the("Usuario Last Name input box on login").located(By.id("j_idt5:password"));
    public static final Target BOTON_INICIAR_SESION = Target.the("boton iniciar sesion").located(By.id("j_idt5:botonIniciarSesion"));


}
