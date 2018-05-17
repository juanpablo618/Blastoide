package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Value;
import net.serenitybdd.screenplay.targets.Target;
import screenplay.user_interface.airBooking.PaymentMethodForm;

public class PaymentMethodFieldInput implements Question<Boolean> {

    private Target field;

    public PaymentMethodFieldInput(Target field) {
        this.field = field;
    }

    public static PaymentMethodFieldInput forFirstName() {
        return new PaymentMethodFieldInput(PaymentMethodForm.FIRST_NAME_CARD_INPUT);
    }

    public static PaymentMethodFieldInput forLastName() {
        return new PaymentMethodFieldInput(PaymentMethodForm.LAST_NAME_CARD_INPUT);
    }

    public static PaymentMethodFieldInput forStreetAddress() {
        return new PaymentMethodFieldInput(PaymentMethodForm.STREET_ADDRESS_CARD_INPUT);
    }

    public static PaymentMethodFieldInput forCityTown() {
        return new PaymentMethodFieldInput(PaymentMethodForm.CITY_TOWN_INPUT);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return !Value.of(field).viewedBy(actor).resolve().equals("");
    }
}