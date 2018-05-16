package screenplay.user_interface.earlyBird;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class EarlyBirdConfirmationPagePaymentSection {
    public static final Target PAYMENT_SUMMARY_TOTAL= Target.the("Payment Summary Total")
            .located(By.cssSelector(".early-bird-flight-total--container-content-currency > .currency span > span:nth-child(2)"));
}