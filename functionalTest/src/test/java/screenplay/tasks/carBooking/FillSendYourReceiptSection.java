package screenplay.tasks.carBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import screenplay.models.WhoIsDrivingInfo;
import screenplay.user_interface.carBooking.SendYourReceiptForm;

public class FillSendYourReceiptSection implements Task{

    WhoIsDrivingInfo whoIsDrivingInfo = new WhoIsDrivingInfo();

    @Step("{0} fills Send Your Receipt section")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(whoIsDrivingInfo.getEmail()).into(SendYourReceiptForm.RECEIPT_EMAIL_INPUT)
        );
    }
}
