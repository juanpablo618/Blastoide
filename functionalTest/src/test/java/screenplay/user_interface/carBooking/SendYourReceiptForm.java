package screenplay.user_interface.carBooking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SendYourReceiptForm {

    public static final Target RECEIPT_EMAIL_INPUT = Target.the("Receipt E-mail Input box").located(By.id("sendYourReceiptEmail"));
}
