package screenplay.tasks.airBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.AnonymousPerformable;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.Keys;
import screenplay.models.AirBookingFlow;
import screenplay.models.EarlyBirdFlowInformation;
import screenplay.models.Passenger;
import screenplay.models.RapidRewardsPassengers;
import screenplay.user_interface.airBooking.WhoIsFlyingForm;

import java.util.ArrayList;
import java.util.List;

public class EnterUnaccompaniedMinorPassengerInformation implements Task {

    private static final int MIN_MINOR_YEAR_PAGEDOWN_AMOUNT = 2;
    private AirBookingFlow airBookingFlow;
    private EarlyBirdFlowInformation earlyBirdFlowInformation;
    private boolean isEarlyBirdFlow;

    public EnterUnaccompaniedMinorPassengerInformation(AirBookingFlow airBookingFlow, EarlyBirdFlowInformation earlyBirdFlowInformation) {
        this.airBookingFlow = airBookingFlow;
        this.earlyBirdFlowInformation = earlyBirdFlowInformation;
        this.isEarlyBirdFlow = true;
    }

    public EnterUnaccompaniedMinorPassengerInformation(AirBookingFlow airBookingFlow) {
        this.airBookingFlow = airBookingFlow;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<Performable> scrollDownYearInteraction = new ArrayList<>();
        List<Performable> enterPassengerAccountNumberList = new ArrayList<>();

        Passenger passenger;
        Performable scrollDownYearAction;
        Performable enterPassengerAccountNumber;

        for (int i = 0; i < airBookingFlow.getPassengers().size(); i++) {

            passenger = airBookingFlow.getPassengers().get(i);

            for (int j = 0; j < MIN_MINOR_YEAR_PAGEDOWN_AMOUNT; j++) {
                scrollDownYearInteraction.add(Hit.the(Keys.PAGE_DOWN).into(WhoIsFlyingForm.getYearOfBirthDropdown(i)));
            }
            scrollDownYearAction = new AnonymousPerformable("Scroll down year dropdown", scrollDownYearInteraction);

            if (passenger.getAccountNumber() != null) {
                enterPassengerAccountNumberList.add(Enter.theValue(RapidRewardsPassengers.A_LIST_PREFERRED_NUMBERS[i]).into(WhoIsFlyingForm.getRapidRewardInput(i)));
            }
            enterPassengerAccountNumber = new AnonymousPerformable("Enter Account Number for passenger " + i, enterPassengerAccountNumberList);

            actor.attemptsTo(
                    Enter.theValue(passenger.getFirstName()).into(WhoIsFlyingForm.getFirstNameInput(i)),
                    Enter.theValue(passenger.getLastName()).into(WhoIsFlyingForm.getLastNameInput(i)),
                    enterPassengerAccountNumber,
                    Click.on(WhoIsFlyingForm.getMonthOfBirthDropDown(i)),
                    Click.on(WhoIsFlyingForm.getMonthOfBirthValue(i)),
                    Click.on(WhoIsFlyingForm.getDayOfBirthDropdown(i)),
                    Click.on(WhoIsFlyingForm.getDayOfBirthValue(i)),
                    Click.on(WhoIsFlyingForm.getYearOfBirthDropdown(i)),
                    scrollDownYearAction,
                    Click.on(WhoIsFlyingForm.getYearOfBirthValue(i)),
                    Click.on(WhoIsFlyingForm.getGenderDropdown(i)),
                    Click.on(WhoIsFlyingForm.getGenderValue(i))
            );

            scrollDownYearInteraction.clear();
            enterPassengerAccountNumberList.clear();
        }
    }
}
