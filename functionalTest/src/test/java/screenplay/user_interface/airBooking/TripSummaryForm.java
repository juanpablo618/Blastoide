package screenplay.user_interface.airBooking;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class TripSummaryForm {

    public static final Target CONFIRMATION_NUMBER = Target.the("Confirmation number")
            .located(By.className("trip-summary-item--confirmation-number"));

    public static final Target CONFIRMATION_NUMBER_CANCELLED_BUTTON = Target.the("Confirmation number cancelled button")
            .located(By.cssSelector(".product-action-menu .horizontal-list li:nth-child(3)"));
}