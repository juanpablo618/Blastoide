package screenplay.tasks.earlyBird;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.models.AirBookingFlow;
import screenplay.user_interface.airBooking.PaymentMethodForm;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PaymentFormWithSpecificCreditCard implements Task {

    private AirBookingFlow airBookingFlow;

    public PaymentFormWithSpecificCreditCard(AirBookingFlow airBookingFlow) {
        this.airBookingFlow = airBookingFlow;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(PaymentMethodForm.PURCHASE_EARLY_BIRD_BUTTON, isVisible()).forNoMoreThan(30).seconds()
        );

        actor.attemptsTo(
                Click.on(PaymentMethodForm.CARD_TYPE_DROPDOWN),
                Click.on(PaymentMethodForm.getCardTypeValueInput(airBookingFlow.getPositionOfCCSelector())),
                Enter.theValue(airBookingFlow.getCreditCardNumber()).into(PaymentMethodForm.CREDIT_CARD_NUMBER_INPUT),
                Click.on(PaymentMethodForm.EXPIRATION_MONTH_DROPDOWN),
                Click.on(PaymentMethodForm.EXPIRATION_MONTH_VALUE),
                Click.on(PaymentMethodForm.EXPIRATION_YEAR_DROPDOWN),
                Click.on(PaymentMethodForm.EXPIRATION_YEAR_VALUE));

        if(!(airBookingFlow.getCreditCardNumber().equalsIgnoreCase("135412345678911"))){
            actor.attemptsTo(
                    Enter.theValue(airBookingFlow.getCvvNumber()).into(PaymentMethodForm.CVV_INPUT)
            );
        }

        actor.attemptsTo(
                Enter.theValue("John").into(PaymentMethodForm.FIRST_NAME_CARD_INPUT),
                Enter.theValue("Doe").into(PaymentMethodForm.LAST_NAME_CARD_INPUT),
                Enter.theValue("Test Address").into(PaymentMethodForm.STREET_ADDRESS_CARD_INPUT),
                Enter.theValue("75001").into(PaymentMethodForm.ZIP_CODE_INPUT),
                Enter.theValue("Dallas").into(PaymentMethodForm.CITY_TOWN_INPUT),
                Click.on(PaymentMethodForm.STATE_DROPDOWN),
                Click.on(PaymentMethodForm.STATE_VALUE),
                Enter.theValue("test@test.com").into(PaymentMethodForm.RECEIPT_EMAIL_ADDRESS_INPUT),
                Click.on(PaymentMethodForm.PURCHASE_EARLY_BIRD_BUTTON)
        );
    }
}