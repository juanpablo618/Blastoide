package screenplay.user_interface.carBooking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ReserveSection {

    public static final Target RESERVE_BUTTON = Target.the("Reserve button").located(By.className("purchase-form--button"));
}
