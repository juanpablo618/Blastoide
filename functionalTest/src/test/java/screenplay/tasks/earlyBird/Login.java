package screenplay.tasks.earlyBird;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import screenplay.user_interface.earlyBird.LandingPageForm;
import screenplay.user_interface.earlyBird.LoginContainer;

public class Login implements Task {

    private String accountNumber;
    private static final String ACCOUNT_WITH_CREDIT_CARD = "601584782";
    private static final String ACCOUNT_WITHOUT_CREDIT_CARD = "601535045";
    private static final String PASS = "Test1234";

    public Login(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static Login userWithCreditCard() {
        return new Login(ACCOUNT_WITH_CREDIT_CARD);
    }

    public static Login userWithoutCreditCard() {
        return new Login(ACCOUNT_WITHOUT_CREDIT_CARD);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LandingPageForm.LOGIN_LINK),
                Enter.theValue(accountNumber).into(LoginContainer.USERNAME_INPUT),
                Enter.theValue(PASS).into(LoginContainer.PASSWORD_INPUT),
                Click.on(LoginContainer.LOGIN_BUTTON)
        );
    }
}