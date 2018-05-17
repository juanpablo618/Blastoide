package screenplay.user_interface.airBooking;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CancelFlightForm {

    public static final Target CANCEL_FLIGHT_BUTTON = Target.the("Cancel flight button")
            .located(By.className("search-results--cancel-flight-button"));

    public static final Target REFUND_METHOD_DROPDOWN = Target.the("Refund method dropdown")
            .located(By.id("refundType"));

    public static final Target REFUND_METHOD_ITEM = Target.the("Refund method item")
            .located(By.id("refundType--item-1"));
}