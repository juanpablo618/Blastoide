package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;
import screenplay.user_interface.airBooking.PaymentMethodForm;

public class InputsFieldOnPurchasePageAreEmpty implements Question<Boolean> {
    
    @Override
    public Boolean answeredBy(Actor actor) {
        
        return Value.of(PaymentMethodForm.CREDIT_CARD_NUMBER_INPUT).viewedBy(actor).asString().isEmpty() &&
                Value.of(PaymentMethodForm.CITY_TOWN_INPUT).viewedBy(actor).asString().isEmpty() &&
                Value.of(PaymentMethodForm.FIRST_NAME_CARD_INPUT).viewedBy(actor).asString().isEmpty() &&
                Value.of(PaymentMethodForm.LAST_NAME_CARD_INPUT).viewedBy(actor).asString().isEmpty() &&
                Value.of(PaymentMethodForm.ZIP_CODE_INPUT).viewedBy(actor).asString().isEmpty() &&
                Value.of(PaymentMethodForm.RECEIPT_EMAIL_ADDRESS_INPUT).viewedBy(actor).asString().isEmpty() &&
                Value.of(PaymentMethodForm.STREET_ADDRESS_CARD_INPUT).viewedBy(actor).asString().isEmpty() ;
    }
}