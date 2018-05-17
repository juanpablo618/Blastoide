package screenplay.user_interface.earlyBird;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class EarlyBirdPurchasePageForm {

    public static final Target OUTBOUND_SUB_TOTAL = Target.the("Sub total outbound")
            .located(By.cssSelector(".early-bird-itinerary-section--bound:nth-child(1) .early-bird-flight-subtotal--content-currency span span span:not(.currency--symbol)"));

    public static final Target INBOUND_SUB_TOTAL = Target.the("Sub total inbound")
            .located(By.cssSelector(".early-bird-itinerary-section--bound:nth-child(2) .early-bird-flight-subtotal--content-currency span span span:not(.currency--symbol)"));

    public static final Target TOTAL = Target.the("Estimated total")
            .located(By.cssSelector(".header-early-bird--total-amount span span:not(.currency--symbol)"));

    public static final Target SAVED_CREDIT_CARD_SELECTED_RADIO_BUTTON = Target.the("Saved credit card radio button selected")
            .located(By.cssSelector(".saved-credit-cards .input-group--item:nth-child(1) .radio-button--input[type=\"radio\"]:checked"));

    public static final Target SAVED_CREDIT_CARD_RADIO_BUTTON = Target.the("Saved credit card radio button")
            .located(By.cssSelector(".saved-credit-cards .input-group--item:nth-child(1) .radio-button--input"));

    public static final Target CREDIT_CARD_DROPDOWN = Target.the("Credit Card dropdown")
            .located(By.id("savedCreditCardToken"));

    public static final Target PURCHASE_BOUNDS = Target.the("Purchase bounds")
            .located(By.className("early-bird-itinerary-section--bound"));
}
