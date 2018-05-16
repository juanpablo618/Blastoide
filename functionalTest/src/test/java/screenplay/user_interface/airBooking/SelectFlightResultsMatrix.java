package screenplay.user_interface.airBooking;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SelectFlightResultsMatrix {

    public static final Target UNLOCK_HEADER_BUTTON = Target.the("Unlock header button")
            .located(By.className("header-control--sticky-toggle"));

    public static final Target CONTINUE_BUTTON = Target.the("Continue button")
            .located(By.className("air-shopping-continue-button"));

    public static final Target UPGRADE_BUTTON_CONTINUE = Target.the("Upgrade to business fare")
            .located(By.cssSelector(".upgrade-modal--upgrades .actionable_no-outline.actionable_primary.button"));

    public static final Target DEPARTING_NON_STOP_BUTTON = Target.the("Select only Non-Stop for departing flights")
            .located(By.cssSelector("#air-booking-product-0 .filters--filter-area-nonstop button"));

    public static final Target RETURNING_NON_STOP_BUTTON = Target.the("Select only Non-Stop for Returning flights")
            .located(By.cssSelector("#air-booking-product-1 .filters--filter-area-nonstop button"));

    public static Target getFlightButtonByFareAndBound(String fare, int bound) {
        String color = getColorForFareTypeButton(fare);
        return Target.the((bound == 0? "Departing" : "Returning") + " flight button")
                .located(By.cssSelector("#air-booking-product-" + bound + " .fare-button_" + (fare.equalsIgnoreCase("Anytime")? "secondary-" : "primary-") + color + " .actionable_button:not(.swa-g-inactive)"));
    }

    public static Target getFlightButtonByAmountOfStopsByFareAndBound(int bound, int stops, String fare) {
        String color = getColorForFareTypeButton(fare);
        return Target.the("Departing flight button " + (bound == 0? "Outbound" : "Inbound") + " with " + stops + "stops")
                .located(net.serenitybdd.core.annotations.findby.By.xpath("//*[@id=\"air-booking-product-" + bound + "\"]//*[text()=\"" + stops + " stop\"]/parent::div/parent::li/div[@class=\"select-detail--fares\"]/div[@class=\"fare-button fare-button_" + (fare.equalsIgnoreCase("Anytime")? "secondary-" : "primary-") + color + " select-detail--fare\"]/button\n"));
    }

    private static String getColorForFareTypeButton(String fare) {
        String color;
        if(fare.equalsIgnoreCase("Business select")){
             color = "blue";
        }else if(fare.equalsIgnoreCase("Anytime")){
            color = "light-blue";
        }else {
            color = "yellow";
        }
        return color;
    }
}