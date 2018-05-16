package screenplay.user_interface.carBooking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PriceContinueSection {

    public static final Target PRICE_CONTINUE_BUTTON = Target.the("Price Continue button").located(By.className("checkout-price-continue-button"));
}
