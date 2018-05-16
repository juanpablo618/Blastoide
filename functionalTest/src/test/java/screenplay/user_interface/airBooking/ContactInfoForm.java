package screenplay.user_interface.airBooking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContactInfoForm {

    public static final Target EMAIL_ADDRESS_INPUT = Target.the("Email address input")
            .located(By.id("contactEmailAddress"));
}
