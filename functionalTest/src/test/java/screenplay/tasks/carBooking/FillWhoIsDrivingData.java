package screenplay.tasks.carBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import screenplay.models.WhoIsDrivingInfo;
import screenplay.user_interface.carBooking.WhoIsDrivingForm;

public class FillWhoIsDrivingData implements Task {

    WhoIsDrivingInfo whoIsDrivingInfo = new WhoIsDrivingInfo();

    public FillWhoIsDrivingData(String firstName, String lastName) {
        this.whoIsDrivingInfo.setFirstName(firstName);
        this.whoIsDrivingInfo.setLastName(lastName);
    }


    @Step("{0} fills Who is Driving data")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(whoIsDrivingInfo.getFirstName()).into(WhoIsDrivingForm.DRIVER_FIRST_NAME_INPUT),
                Enter.theValue(whoIsDrivingInfo.getLastName()).into(WhoIsDrivingForm.DRIVER_LAST_NAME_INPUT),
                Enter.theValue(whoIsDrivingInfo.getPhoneNumber()).into(WhoIsDrivingForm.DRIVER_PHONE_NUMBER_INPUT)
        );
    }
}
