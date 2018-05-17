package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import org.openqa.selenium.WebDriver;
import screenplay.user_interface.earlyBird.EarlyBirdSelectPageForm;

public class EarlyBirdContinueToPurchaseIsCorrectlyDisplayed implements Question<Boolean> {

    private static WebDriver webDriver;
    private static String continueButtonState;

    public EarlyBirdContinueToPurchaseIsCorrectlyDisplayed(WebDriver webDriver, String continueButtonState) {
        this.webDriver = webDriver;
        this.continueButtonState = continueButtonState;
    }

    public static EarlyBirdContinueToPurchaseIsCorrectlyDisplayed byState(String continueButtonState) {
        return new EarlyBirdContinueToPurchaseIsCorrectlyDisplayed(webDriver, continueButtonState);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        if (continueButtonState.equals("Enable")) {
            return Visibility.of(EarlyBirdSelectPageForm.CONTINUE_BUTTON_ENABLED).viewedBy(actor).resolve();
        } else {
            return Visibility.of(EarlyBirdSelectPageForm.CONTINUE_BUTTON_DISABLED).viewedBy(actor).resolve();
        }
    }
}