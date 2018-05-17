package screenplay.user_interface.airBooking;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class TripSummarySection {

    public static final Target CONTINUE_BUTTON = Target.the("Price Continue button")
            .located(By.className("checkout-price-continue-button"));

}
