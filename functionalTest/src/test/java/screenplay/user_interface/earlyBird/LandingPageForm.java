package screenplay.user_interface.earlyBird;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LandingPageForm {
    public static final Target CONFIRMATION_NUMBER_INPUT = Target.the("Confirmation number input field")
            .located(By.id("confirmationNumber"));

    public static final Target FIRST_NAME_INPUT = Target.the("First name input field")
            .located(By.id("passengerFirstName"));

    public static final Target LAST_NAME_INPUT = Target.the("Last name input field")
            .located(By.id("passengerLastName"));

    public static final Target CONTINUE_BUTTON = Target.the("Continue button")
            .located(By.id("form-mixin--submit-button"));

    public static final Target OOPS_ERROR_MESSAGE = Target.the("Oops error message")
            .located(By.className("message_error"));

    public static final Target ERROR_DETAIL_BUTTON = Target.the("Error detail code button")
            .located(By.cssSelector(".accordion-panel--toggle-trigger.button"));

    public static final Target ERROR_DETAIL_CODE = Target.the("Error detail code text")
            .located(By.cssSelector(".accordion-panel--details-content > div > div"));

    public static final Target LOGIN_LINK = Target.the("Login link")
            .located(By.cssSelector(".header-control .actionable_prefix"));

    public static final Target SOUTHWEST_CONTENT = Target.the("Southwest Content")
            .located(By.className("swa-content"));
}