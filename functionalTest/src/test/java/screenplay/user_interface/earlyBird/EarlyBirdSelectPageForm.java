package screenplay.user_interface.earlyBird;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class EarlyBirdSelectPageForm {

    public static final Target OUTBOUND_SWA_ICON_PLANE = Target.the("Departing Swa icon")
            .located(By.className("swa-icon_departing"));

    public static final Target INBOUND_SWA_ICON_PLANE = Target.the("Returning Swa icon")
            .located(By.className("swa-icon_returning"));

    public static final Target OUTBOUND_FLIGHT_STOP_ICONS = Target.the("Outbound flight stop icons")
            .located(By.cssSelector(".early-bird-flight-itinerary-container--details:nth-child(1) > div.early-bird-flight-itinerary-container--details-bound .early-bird-flight-stops--item"));

    public static final Target INBOUND_FLIGHT_STOP_ICONS = Target.the("Inbound flight stop icons")
            .located(By.cssSelector(".early-bird-flight-itinerary-container--details:nth-child(2) > div.early-bird-flight-itinerary-container--details-bound .early-bird-flight-stops--item"));

    public static final Target OUTBOUND_CHECKBOX_BY_PASSENGER = Target.the("Outbound checkbox by passenger")
            .located(By.cssSelector(".early-bird-flight-itinerary-container--details:nth-child(1) .checkbox"));

    public static final Target INBOUND_CHECKBOX_BY_PASSENGER = Target.the("Inbound checkbox by passenger")
            .located(By.cssSelector(".early-bird-flight-itinerary-container--details:nth-child(1) .checkbox"));

    public static final Target SUB_TOTAL_OUTBOUND = Target.the("Sub total outbound")
            .located(By.cssSelector(".early-bird-flight-itinerary-container--details:nth-child(1) .currency_dollars > span:not(.swa-g-screen-reader-only) > span:not(.currency--symbol)"));

    public static final Target SUB_TOTAL_INBOUND = Target.the("Sub total inbound")
            .located(By.cssSelector(".early-bird-flight-itinerary-container--details:nth-child(2) .currency_dollars > span:not(.swa-g-screen-reader-only) > span:not(.currency--symbol)"));

    public static final Target ESTIMATED_TOTAL = Target.the("Estimated total")
            .located(By.cssSelector(".early-bird-flight-total--container-content-currency > span > span > span:not(.currency--symbol)"));

    public static final Target CONTINUE_BUTTON = Target.the("Continue button")
            .located(By.className("early-bird-flight-details-container--submit-continue-button"));

    public static final Target CONTINUE_BUTTON_DISABLED = Target.the("Disabled Continue button")
            .located(By.cssSelector(".early-bird-flight-details-container--submit-continue-button.swa-g-disabled"));

    public static final Target CONTINUE_BUTTON_ENABLED = Target.the("Enabled Continue button")
            .located(By.cssSelector("button.early-bird-flight-details-container--submit-continue-button:not(.swa-g-disabled)"));

    public static final Target OUTBOUND_ELIGIBLE_PASSENGER_LIST = Target.the("Outbound eligible passenger list")
            .located(By.cssSelector("#eligiblePassengers_bound0  .checkbox--input"));

    public static final Target OUTBOUND_INELIGIBLE_PASSENGER_LIST = Target.the("Outbound ineligible passenger list")
            .located(By.cssSelector("#ineligiblePassengers_bound0  .checkbox--input"));

    public static final Target INELIGIBLE_REASON_BY_OUTBOUND = Target.the("Outbound ineligible reason")
            .located(By.cssSelector(".early-bird-flight-itinerary-container--details:nth-child(1) .early-bird-ineligible-reason--text"));

    public static final Target INELIGIBLE_REASON_BY_INBOUND = Target.the("Inbound ineligible reason")
            .located(By.cssSelector(".early-bird-flight-itinerary-container--details:nth-child(2) .early-bird-ineligible-reason--text"));

    public static Target getPassengerCheckBox(int bound, int index) {
        return  Target.the("Bound " + (bound==0?"outbound":"inbound") + " Passenger " + index + " CheckBox")
                .located(By.id("bound_" + bound + "-passenger_" + index + "-eligible"));
    }

    public static Target getIneligibleBound(int ineligibleBound) {
        return  Target.the((ineligibleBound == 1)? "Outbound" : "Inbound" + "ineligible")
                .located(By.cssSelector(".early-bird-flight-itinerary-container--details:nth-child(" + ineligibleBound + ") .early-bird-flight-itinerary-container--details-summary_disabled"));
    }
}