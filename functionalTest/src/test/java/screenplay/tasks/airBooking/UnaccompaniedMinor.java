package screenplay.tasks.airBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.models.AirBookingFlow;
import screenplay.user_interface.airBooking.UnaccompaniedMinorForm;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class UnaccompaniedMinor implements Task {
    private AirBookingFlow airBookingFlow;

    public UnaccompaniedMinor(AirBookingFlow airBookingFlow) {
        this.airBookingFlow = airBookingFlow;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean isOneWay = airBookingFlow.getItineraryType().equals("One-way");

        actor.attemptsTo(
        WaitUntil.the(UnaccompaniedMinorForm.UNACCOMPANIED_MINOR_CONTINUE_BUTTON, isVisible()).forNoMoreThan(30).seconds()
        );

        actor.attemptsTo(
                Enter.theValue("Mario").into(UnaccompaniedMinorForm.DEPARTING_DROP_OFF_FIRST_NAME),
                Enter.theValue("Bros").into(UnaccompaniedMinorForm.DEPARTING_DROP_OFF_LAST_NAME),
                Enter.theValue("Father").into(UnaccompaniedMinorForm.DEPARTING_DROP_OFF_RELATIONSHIP),
                Enter.theValue("Levin St 152").into(UnaccompaniedMinorForm.DEPARTING_DROP_OFF_STREET_ADDRESS),
                Enter.theValue("Dallas").into(UnaccompaniedMinorForm.DEPARTING_DROP_OFF_CITY),
                Click.on(UnaccompaniedMinorForm.DEPARTING_DROP_OFF_STATE),
                Click.on(UnaccompaniedMinorForm.DEPARTING_DROP_OFF_STATE_ITEM),
                Enter.theValue("55123").into(UnaccompaniedMinorForm.DEPARTING_DROP_OFF_ZIP),
                Enter.theValue("5514278942").into(UnaccompaniedMinorForm.DEPARTING_DROP_OFF_PHONE_NUMBER),
                Click.on(UnaccompaniedMinorForm.DEPARTING_DROP_OFF_CONTACT_METHOD),
                Click.on(UnaccompaniedMinorForm.DEPARTING_DROP_OFF_CONTACT_METHOD_ITEM),
                Enter.theValue("Luigi").into(UnaccompaniedMinorForm.DEPARTING_PICK_UP_FIRST_NAME),
                Enter.theValue("Bros").into(UnaccompaniedMinorForm.DEPARTING_PICK_UP_LAST_NAME),
                Enter.theValue("Uncle").into(UnaccompaniedMinorForm.DEPARTING_PICK_UP_RELATIONSHIP),
                Enter.theValue("Levin St 152").into(UnaccompaniedMinorForm.DEPARTING_PICK_UP_STREET_ADDRESS),
                Enter.theValue("Dallas").into(UnaccompaniedMinorForm.DEPARTING_PICK_UP_CITY),
                Click.on(UnaccompaniedMinorForm.DEPARTING_PICK_UP_STATE),
                Click.on(UnaccompaniedMinorForm.DEPARTING_PICK_UP_STATE_ITEM),
                Enter.theValue("55123").into(UnaccompaniedMinorForm.DEPARTING_PICK_UP_ZIP),
                Enter.theValue("5514278943").into(UnaccompaniedMinorForm.DEPARTING_PICK_UP_PHONE_NUMBER),
                Click.on(UnaccompaniedMinorForm.DEPARTING_PICK_UP_CONTACT_METHOD),
                Click.on(UnaccompaniedMinorForm.DEPARTING_PICK_UP_CONTACT_METHOD_ITEM),
                Enter.theValue("Wario").into(UnaccompaniedMinorForm.DEPARTING_ALTERNATIVE_FIRST_NAME),
                Enter.theValue("Bros").into(UnaccompaniedMinorForm.DEPARTING_ALTERNATIVE_LAST_NAME),
                Enter.theValue("Uncle").into(UnaccompaniedMinorForm.DEPARTING_ALTERNATIVE_RELATIONSHIP),
                Enter.theValue("Levin St 152").into(UnaccompaniedMinorForm.DEPARTING_ALTERNATIVE_STREET_ADDRESS),
                Enter.theValue("Dallas").into(UnaccompaniedMinorForm.DEPARTING_ALTERNATIVE_CITY),
                Click.on(UnaccompaniedMinorForm.DEPARTING_ALTERNATIVE_STATE),
                Click.on(UnaccompaniedMinorForm.DEPARTING_ALTERNATIVE_STATE_ITEM),
                Enter.theValue("55123").into(UnaccompaniedMinorForm.DEPARTING_ALTERNATIVE_ZIP),
                Enter.theValue("5514278944").into(UnaccompaniedMinorForm.DEPARTING_ALTERNATIVE_PHONE_NUMBER),
                Click.on(UnaccompaniedMinorForm.DEPARTING_ALTERNATIVE_CONTACT_METHOD),
                Click.on(UnaccompaniedMinorForm.DEPARTING_ALTERNATIVE_CONTACT_METHOD_ITEM)
        );

        if(!isOneWay) {
            actor.attemptsTo(
                    Enter.theValue("Rosalina").into(UnaccompaniedMinorForm.RETURNING_DROP_OFF_FIRST_NAME),
                    Enter.theValue("Bros").into(UnaccompaniedMinorForm.RETURNING_DROP_OFF_LAST_NAME),
                    Enter.theValue("Aunt").into(UnaccompaniedMinorForm.RETURNING_DROP_OFF_RELATIONSHIP),
                    Enter.theValue("Levin St 152").into(UnaccompaniedMinorForm.RETURNING_DROP_OFF_STREET_ADDRESS),
                    Enter.theValue("Dallas").into(UnaccompaniedMinorForm.RETURNING_DROP_OFF_CITY),
                    Click.on(UnaccompaniedMinorForm.RETURNING_DROP_OFF_STATE),
                    Click.on(UnaccompaniedMinorForm.RETURNING_DROP_OFF_STATE_ITEM),
                    Enter.theValue("55123").into(UnaccompaniedMinorForm.RETURNING_DROP_OFF_ZIP),
                    Enter.theValue("5514278947").into(UnaccompaniedMinorForm.RETURNING_DROP_OFF_PHONE_NUMBER),
                    Click.on(UnaccompaniedMinorForm.RETURNING_DROP_OFF_CONTACT_METHOD),
                    Click.on(UnaccompaniedMinorForm.RETURNING_DROP_OFF_CONTACT_METHOD_ITEM),
                    Enter.theValue("Peach").into(UnaccompaniedMinorForm.RETURNING_PICK_UP_FIRST_NAME),
                    Enter.theValue("Bros").into(UnaccompaniedMinorForm.RETURNING_PICK_UP_LAST_NAME),
                    Enter.theValue("Mother").into(UnaccompaniedMinorForm.RETURNING_PICK_UP_RELATIONSHIP),
                    Enter.theValue("Levin St 152").into(UnaccompaniedMinorForm.RETURNING_PICK_UP_STREET_ADDRESS),
                    Enter.theValue("Dallas").into(UnaccompaniedMinorForm.RETURNING_PICK_UP_CITY),
                    Click.on(UnaccompaniedMinorForm.RETURNING_PICK_UP_STATE),
                    Click.on(UnaccompaniedMinorForm.RETURNING_PICK_UP_STATE_ITEM),
                    Enter.theValue("55123").into(UnaccompaniedMinorForm.RETURNING_PICK_UP_ZIP),
                    Enter.theValue("5514278946").into(UnaccompaniedMinorForm.RETURNING_PICK_UP_PHONE_NUMBER),
                    Click.on(UnaccompaniedMinorForm.RETURNING_PICK_UP_CONTACT_METHOD),
                    Click.on(UnaccompaniedMinorForm.RETURNING_PICK_UP_CONTACT_METHOD_ITEM),
                    Enter.theValue("Bowser").into(UnaccompaniedMinorForm.RETURNING_ALTERNATIVE_FIRST_NAME),
                    Enter.theValue("Bros").into(UnaccompaniedMinorForm.RETURNING_ALTERNATIVE_LAST_NAME),
                    Enter.theValue("Uncle").into(UnaccompaniedMinorForm.RETURNING_ALTERNATIVE_RELATIONSHIP),
                    Enter.theValue("Levin St 152").into(UnaccompaniedMinorForm.RETURNING_ALTERNATIVE_STREET_ADDRESS),
                    Enter.theValue("Dallas").into(UnaccompaniedMinorForm.RETURNING_ALTERNATIVE_CITY),
                    Click.on(UnaccompaniedMinorForm.RETURNING_ALTERNATIVE_STATE),
                    Click.on(UnaccompaniedMinorForm.RETURNING_ALTERNATIVE_STATE_ITEM),
                    Enter.theValue("55123").into(UnaccompaniedMinorForm.RETURNING_ALTERNATIVE_ZIP),
                    Enter.theValue("5514278845").into(UnaccompaniedMinorForm.RETURNING_ALTERNATIVE_PHONE_NUMBER),
                    Click.on(UnaccompaniedMinorForm.RETURNING_ALTERNATIVE_CONTACT_METHOD),
                    Click.on(UnaccompaniedMinorForm.RETURNING_ALTERNATIVE_CONTACT_METHOD_ITEM)
            );
        }

        actor.attemptsTo(
                Click.on(UnaccompaniedMinorForm.UNACCOMPANIED_MINOR_CONTINUE_BUTTON)
        );
    }
}
