package screenplay.user_interface.carBooking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TripSummarySection {

    public static final Target TRIP_SUMMARY_CAR_CONFIRMATION_NUMBER = Target.the("Trip Summary Car Confirmation Number")
            .located(By.cssSelector(".trip-summary--item_second-last .trip-summary-item--confirmation span"));
}
