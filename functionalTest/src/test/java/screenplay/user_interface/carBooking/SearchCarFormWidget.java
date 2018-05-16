package screenplay.user_interface.carBooking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchCarFormWidget {

    public static final Target PICK_UP_LOCATION_INPUT = Target.the("Pickup Location input box").located(By.id("pickUpLocation"));
    public static final Target RETURN_LOCATION_INPUT = Target.the("Return Location input box").located(By.id("returnLocation"));
    public static final Target SEARCH_BUTTON = Target.the("Search button").located(By.id("form-mixin--submit-button"));
}
