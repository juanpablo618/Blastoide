package screenplay.user_interface.earlyBird;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginContainer {
    public static final Target USERNAME_INPUT = Target.the("Username input field")
            .located(By.id("username"));

    public static final Target PASSWORD_INPUT = Target.the("Password input field")
            .located(By.id("password"));

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .located(By.id("login-form--submit-button"));
}