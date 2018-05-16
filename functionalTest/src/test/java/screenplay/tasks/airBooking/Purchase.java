package screenplay.tasks.airBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.AnonymousPerformable;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.models.AirBookingFlow;
import screenplay.user_interface.airBooking.ContactInfoForm;
import screenplay.user_interface.airBooking.PaymentMethodForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Purchase implements Task {

    private AirBookingFlow airBookingFlow;

    public Purchase(AirBookingFlow airBookingFlow) {
        this.airBookingFlow = airBookingFlow;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<Performable> irnActions = new ArrayList<>();
        if (airBookingFlow.getInternalReferenceNumber() != null) {
            irnActions.add(Enter.theValue(airBookingFlow.getInternalReferenceNumber()).into(PaymentMethodForm.INTERNAL_REFERENCE_NUMBER_INPUT));
        }

        Performable irnAction = new AnonymousPerformable("Enter internal reference number", irnActions);

        actor.attemptsTo(
                WaitUntil.the(PaymentMethodForm.PURCHASE_BUTTON, isVisible()).forNoMoreThan(30).seconds()
        );

        actor.attemptsTo(
                irnAction,
                Enter.theValue("test@test.com").into(ContactInfoForm.EMAIL_ADDRESS_INPUT),
                Click.on(PaymentMethodForm.CARD_TYPE_DROPDOWN),
                Click.on(PaymentMethodForm.CARD_TYPE_VALUE),
                Enter.theValue("4012999999999999").into(PaymentMethodForm.CREDIT_CARD_NUMBER_INPUT),
                Click.on(PaymentMethodForm.EXPIRATION_MONTH_DROPDOWN),
                Click.on(PaymentMethodForm.EXPIRATION_MONTH_VALUE),
                Click.on(PaymentMethodForm.EXPIRATION_YEAR_DROPDOWN),
                Click.on(PaymentMethodForm.EXPIRATION_YEAR_VALUE),
                Enter.theValue("123").into(PaymentMethodForm.CVV_INPUT),
                Enter.theValue("John").into(PaymentMethodForm.FIRST_NAME_CARD_INPUT),
                Enter.theValue("Doe").into(PaymentMethodForm.LAST_NAME_CARD_INPUT),
                Enter.theValue("Test Address").into(PaymentMethodForm.STREET_ADDRESS_CARD_INPUT),
                Enter.theValue("75001").into(PaymentMethodForm.ZIP_CODE_INPUT),
                Enter.theValue("Dallas").into(PaymentMethodForm.CITY_TOWN_INPUT),
                Click.on(PaymentMethodForm.STATE_DROPDOWN),
                Click.on(PaymentMethodForm.STATE_VALUE),
                Enter.theValue("12345678912").into(PaymentMethodForm.PHONE_NUMBER),
                Enter.theValue("test@test.com").into(PaymentMethodForm.RECEIPT_EMAIL_ADDRESS_INPUT),
                Click.on(PaymentMethodForm.PURCHASE_BUTTON)
        );
    }
}