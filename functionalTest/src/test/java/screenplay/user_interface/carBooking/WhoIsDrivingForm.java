package screenplay.user_interface.carBooking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class WhoIsDrivingForm {

    public static final Target DRIVER_FIRST_NAME_INPUT = Target.the("Driver First Name input box").located(By.id("whoIsDrivingFirstName"));
    public static final Target DRIVER_LAST_NAME_INPUT = Target.the("Driver Last Name input box").located(By.id("whoIsDrivingLastName"));
    public static final Target DRIVER_PHONE_NUMBER_INPUT = Target.the("Driver Phone Number input box").located(By.id("whoIsDrivingPhoneNumber"));
}
