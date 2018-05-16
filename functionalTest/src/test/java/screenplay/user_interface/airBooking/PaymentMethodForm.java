package screenplay.user_interface.airBooking;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PaymentMethodForm {

    public static final Target CARD_TYPE_DROPDOWN = Target.the("Card type dropdown")
            .located(By.id("creditCardType"));

    public static Target getCardTypeValueInput(int index) {
        return Target.the("Card type value " + index + " selected")
                .located(By.id("creditCardType--item-" + index));
    }

    public static final Target CARD_TYPE_VALUE = Target.the("Card type value")
            .located(By.id("creditCardType--item-2"));

    public static final Target CREDIT_CARD_NUMBER_INPUT = Target.the("Credit card number input")
            .located(By.id("creditCardNumber"));

    public static final Target EXPIRATION_MONTH_DROPDOWN = Target.the("Expiration month dropdown")
            .located(By.id("creditCardExpirationDateMonth"));

    public static final Target EXPIRATION_MONTH_VALUE = Target.the("Expiration month value")
            .located(By.id("creditCardExpirationDateMonth--item-2"));

    public static final Target EXPIRATION_YEAR_DROPDOWN = Target.the("Expiration year dropdown")
            .located(By.id("creditCardExpirationDateYear"));

    public static final Target EXPIRATION_YEAR_VALUE = Target.the("Expiration year value")
            .located(By.id("creditCardExpirationDateYear--item-3"));

    public static final Target FIRST_NAME_CARD_INPUT = Target.the("First name on card")
            .located(By.id("creditCardFirstNameOnCard"));

    public static final Target LAST_NAME_CARD_INPUT = Target.the("Last name on card")
            .located(By.id("creditCardLastNameOnCard"));

    public static final Target STREET_ADDRESS_CARD_INPUT = Target.the("Street address on card")
            .located(By.id("creditCardStreetAddress"));

    public static final Target ZIP_CODE_INPUT = Target.the("Zip code input")
            .located(By.id("creditCardZipCode"));

    public static final Target CITY_TOWN_INPUT = Target.the("City/Town input")
            .located(By.id("creditCardCityTown"));

    public static final Target STATE_DROPDOWN = Target.the("State on card dropdown")
            .located(By.id("creditCardState"));

    public static final Target STATE_VALUE = Target.the("State on card value")
            .located(By.id("creditCardState--item-1"));

    public static final Target PHONE_NUMBER = Target.the("Phone number input")
            .located(By.id("creditCardPhoneNumber"));

    public static final Target RECEIPT_EMAIL_ADDRESS_INPUT = Target.the("Receipt email address input")
            .located(By.id("sendYourReceiptEmail"));

    public static final Target PURCHASE_BUTTON = Target.the("Purchase button").
            located(By.className("purchase-form--button"));

    public static final Target PURCHASE_EARLY_BIRD_BUTTON = Target.the("Purchase button").
            located(By.id("form-mixin--submit-button"));

    public static final Target CVV_INPUT = Target.the("CVV input")
            .located(By.id("creditCardNewVerificationValue"));

    public static final Target INTERNAL_REFERENCE_NUMBER_INPUT = Target.the("IRNs input")
            .located(By.id("internalReferenceNumberInput"));
}
