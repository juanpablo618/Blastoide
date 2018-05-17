package screenplay.user_interface.carBooking;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By.*;

public class SelectCarMatrix {

    public static final Target CAR_FARE_BUTTON = Target.the("Car Fare button").located(By.cssSelector(".car-booking-grid-button .actionable_button"));
    public static final Target SELECTED_CAR_CONTINUE_BUTTON = Target.the("Selected Car Continue button").located(By.cssSelector(".submit-button.drawer--actions-continue"));

    public static final ByCssSelector CAR_BOOKING_GRID_BUTTON = new ByCssSelector(".car-booking-grid-button .actionable_button");
}
