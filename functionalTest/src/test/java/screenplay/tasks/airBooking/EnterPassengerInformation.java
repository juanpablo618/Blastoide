package screenplay.tasks.airBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.AnonymousPerformable;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import screenplay.models.AirBookingFlow;
import screenplay.models.EarlyBirdFlowInformation;
import screenplay.models.Passenger;
import screenplay.user_interface.airBooking.WhoIsFlyingForm;

import java.util.ArrayList;
import java.util.List;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterPassengerInformation implements Task {

    private static final int MIN_ADULT_YEAR_PAGEDOWN_AMOUNT = 4;
    private static final int MIN_SENIOR_YEAR_PAGEDOWN_AMOUNT = 8;

    private AirBookingFlow airBookingFlow;
    private EarlyBirdFlowInformation earlyBirdFlowInformation;
    private boolean isEarlyBirdFlow;

    public EnterPassengerInformation(AirBookingFlow airBookingFlow, EarlyBirdFlowInformation earlyBirdFlowInformation) {
        this.airBookingFlow = airBookingFlow;
        this.earlyBirdFlowInformation = earlyBirdFlowInformation;
        this.isEarlyBirdFlow = true;
    }

    public EnterPassengerInformation(AirBookingFlow airBookingFlow) {
        this.airBookingFlow = airBookingFlow;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<Performable> scrollDownYearInteraction = new ArrayList<>();
        List<Performable> enterPassengerAccountNumberList = new ArrayList<>();
        List<Performable> enterPassengerMiddleNameList = new ArrayList<>();

        Passenger passenger;
        Performable scrollDownYearAction;
        Performable enterPassengerAccountNumber;
        Performable enterPassengerMiddleName;

        for (int passengerIndex = 0; passengerIndex < airBookingFlow.getPassengers().size(); passengerIndex++) {

            passenger = airBookingFlow.getPassengers().get(passengerIndex);

            int pageDownAmount;

            if (passenger.getPassengerType().equalsIgnoreCase("Adult")) {
                pageDownAmount = MIN_ADULT_YEAR_PAGEDOWN_AMOUNT;
            } else {
                pageDownAmount = MIN_SENIOR_YEAR_PAGEDOWN_AMOUNT;
            }
            
            for (int j = 0; j < pageDownAmount; j++) {
                scrollDownYearInteraction.add(Hit.the(Keys.PAGE_DOWN).into(WhoIsFlyingForm.getYearOfBirthDropdown(passengerIndex)));
                scrollDownYearInteraction.add(WaitUntil.the(WhoIsFlyingForm.getYearOfBirthOption(passengerIndex, (j+1)*10 - 1), isVisible()).forNoMoreThan(60).seconds());
            }
            scrollDownYearAction = new AnonymousPerformable("Scroll down year dropdown", scrollDownYearInteraction);

            if (passenger.getAccountNumber() != null) {
                enterPassengerAccountNumberList.add(Enter.theValue(passenger.getAccountNumber()).into(WhoIsFlyingForm
                        .getRapidRewardInput(passengerIndex)));
            }
            enterPassengerAccountNumber = new AnonymousPerformable("Enter Account Number for passenger " + passengerIndex, enterPassengerAccountNumberList);

            if (passenger.getMiddleName() != null) {
                enterPassengerMiddleNameList.add(Enter.theValue(passenger.getMiddleName()).into(WhoIsFlyingForm
                        .getMiddleNameInput(passengerIndex)));
            }
            enterPassengerMiddleName = new AnonymousPerformable("Enter Middle Name for passenger " + passengerIndex,
                    enterPassengerMiddleNameList);

            actor.attemptsTo(
                    Enter.theValue(passenger.getFirstName()).into(WhoIsFlyingForm.getFirstNameInput(passengerIndex)),
                    enterPassengerMiddleName,
                    Enter.theValue(passenger.getLastName()).into(WhoIsFlyingForm.getLastNameInput(passengerIndex)),
                    enterPassengerAccountNumber,
                    Click.on(WhoIsFlyingForm.getMonthOfBirthDropDown(passengerIndex)),
                    Click.on(WhoIsFlyingForm.getMonthOfBirthValue(passengerIndex)),
                    Click.on(WhoIsFlyingForm.getDayOfBirthDropdown(passengerIndex)),
                    Click.on(WhoIsFlyingForm.getDayOfBirthValue(passengerIndex)),
                    Click.on(WhoIsFlyingForm.getYearOfBirthDropdown(passengerIndex)),
                    scrollDownYearAction,
                    Click.on(WhoIsFlyingForm.getYearOfBirthValue(passengerIndex)),
                    Click.on(WhoIsFlyingForm.getGenderDropdown(passengerIndex)),
                    Click.on(WhoIsFlyingForm.getGenderValue(passengerIndex))
            );

            scrollDownYearInteraction.clear();
            enterPassengerAccountNumberList.clear();
            enterPassengerMiddleNameList.clear();
        }
    }
}
