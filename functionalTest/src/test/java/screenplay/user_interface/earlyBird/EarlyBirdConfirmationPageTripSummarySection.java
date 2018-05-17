package screenplay.user_interface.earlyBird;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class EarlyBirdConfirmationPageTripSummarySection {
    public static final Target EARLY_BIRD_CONFIRMATION_NUMBER = Target.the("Early Bird Confirmation Number value")
            .located(By.cssSelector(".early-bird-trip-summary-item--content-confirmation-number span"));

    public static final Target PURCHASE_SUMMARY_ITINERARY = Target.the("Purchase Summary Itinerary")
            .located(By.className("early-bird-trip-summary-item--content-departure-arrival"));
}