package screenplay.user_interface.earlyBird;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class EarlyBirdConfirmationPageItinerarySection {
    public static final Target OUTBOUND_ITINERARY = Target.the("Outbound Itinerary")
            .located(By.cssSelector(".early-bird-itinerary-section--bound:nth-child(1) .itinerary-bound--row-info-content"));

    public static final Target INBOUND_ITINERARY = Target.the("Inbound Itinerary")
            .located(By.cssSelector(".early-bird-itinerary-section--bound:nth-child(2) .itinerary-bound--row-info-content"));

    public static final Target OUTBOUND_PASSENGERS = Target.the("Outbound Passengers")
            .located(By.cssSelector(".early-bird-itinerary-section--bound:nth-child(1) .early-bird-passenger-fare-detail > span:nth-child(1)"));

    public static final Target INBOUND_PASSENGERS = Target.the("Inbound Passengers")
            .located(By.cssSelector(".early-bird-itinerary-section--bound:nth-child(2) .early-bird-passenger-fare-detail > span:nth-child(1)"));

    public static final Target OUTBOUND_SUBTOTAL = Target.the("Outbound Subtotal")
            .located(By.cssSelector(".early-bird-itinerary-section--bound:nth-child(1) .early-bird-flight-subtotal--content-currency span span span:not(.currency--symbol)"));

    public static final Target INBOUND_SUBTOTAL = Target.the("Inbound Subtotal")
            .located(By.cssSelector(".early-bird-itinerary-section--bound:nth-child(2) .early-bird-flight-subtotal--content-currency span span span:not(.currency--symbol)"));

    public static final Target EARLY_BIRD_INTERNAL_REFERENCE_NUMBER = Target.the("Early Bird internal reference number value")
            .located(By.className("checkout-reservation-confirmation-number--internal-reference-number-text"));

    public static final Target CONFIRMATION_BOUNDS = Target.the("Confirmation Bounds")
            .located(By.className("early-bird-itinerary-section--bound"));
}
