package screenplay.tasks.blastoide;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import screenplay.models.UsuarioInfo;
import screenplay.user_interface.blastoide.LoginFormulario;

        public class LlenarUsuarioDelSistema implements Task {

            UsuarioInfo usuarioInfo = new UsuarioInfo();

   public LlenarUsuarioDelSistema(String firstName, String lastName) {
            this.usuarioInfo.setUsuarioFirstName(firstName);
            this.usuarioInfo.setUsuarioLastName(lastName);
            }


   @Step("{0} fills Who is Driving data")
   public <T extends Actor> void performAs(T actor) {
          actor.attemptsTo(
                Enter.theValue(usuarioInfo.getUsuarioFirstName()).into(LoginFormulario.USUARIO_FIRST_NAME_INPUT),
                Enter.theValue(usuarioInfo.getUsuarioLastName()).into(LoginFormulario.USUARIO_LAST_NAME_INPUT),
                Click.on(LoginFormulario.BOTON_INICIAR_SESION)
                );
            }
}
