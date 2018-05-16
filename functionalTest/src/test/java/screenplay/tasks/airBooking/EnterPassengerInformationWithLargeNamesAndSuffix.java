package screenplay.tasks.airBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.AnonymousPerformable;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;
import screenplay.models.AirBookingFlow;
import screenplay.models.EarlyBirdFlowInformation;
import screenplay.models.Passenger;
import screenplay.user_interface.airBooking.WhoIsFlyingForm;

import java.util.ArrayList;
import java.util.List;

public class EnterPassengerInformationWithLargeNamesAndSuffix implements Task {

    private static final int MIN_ADULT_YEAR_PAGEDOWN_AMOUNT = 4;
    private static final int MIN_SENIOR_YEAR_PAGEDOWN_AMOUNT = 8;

    private AirBookingFlow airBookingFlow;
    private EarlyBirdFlowInformation earlyBirdFlowInformation;
    private boolean isEarlyBirdFlow;

    public EnterPassengerInformationWithLargeNamesAndSuffix(AirBookingFlow airBookingFlow, EarlyBirdFlowInformation earlyBirdFlowInformation) {
        this.airBookingFlow = airBookingFlow;
        this.earlyBirdFlowInformation = earlyBirdFlowInformation;
        this.isEarlyBirdFlow = true;
    }

    public EnterPassengerInformationWithLargeNamesAndSuffix(AirBookingFlow airBookingFlow) {
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

        for (int i = 0; i < airBookingFlow.getPassengers().size(); i++) {

            passenger = airBookingFlow.getPassengers().get(i);

            int pageDownAmount;

            if (passenger.getPassengerType().equalsIgnoreCase("Adult")) {
                pageDownAmount = MIN_ADULT_YEAR_PAGEDOWN_AMOUNT;
            } else {
                pageDownAmount = MIN_SENIOR_YEAR_PAGEDOWN_AMOUNT;
            }

            for (int j = 0; j < pageDownAmount; j++) {
                scrollDownYearInteraction.add(Hit.the(Keys.PAGE_DOWN).into(WhoIsFlyingForm.getYearOfBirthDropdown(i)));
            }
            scrollDownYearAction = new AnonymousPerformable("Scroll down year dropdown", scrollDownYearInteraction);

            if (passenger.getAccountNumber() != null) {
                enterPassengerAccountNumberList.add(Enter.theValue(passenger.getAccountNumber()).into(WhoIsFlyingForm
                        .getRapidRewardInput(i)));
            }
            enterPassengerAccountNumber = new AnonymousPerformable("Enter Account Number for passenger " + i, enterPassengerAccountNumberList);

            if (passenger.getMiddleName() != null) {
                enterPassengerMiddleNameList.add(Enter.theValue(passenger.getMiddleName()).into(WhoIsFlyingForm
                        .getMiddleNameInput(i)));
            }
            enterPassengerMiddleName = new AnonymousPerformable("Enter Middle Name for passenger " + i,
                    enterPassengerMiddleNameList);

            int randomNumber = (int) (Math.random() * 4) + 1;

            actor.attemptsTo(
                    Enter.theValue(passenger.getFirstName()).into(WhoIsFlyingForm.getFirstNameInput(i)),
                    enterPassengerMiddleName,
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
                    Click.on(WhoIsFlyingForm.getGenderValue(i)),
                    Click.on(WhoIsFlyingForm.getSuffix(i)),
                    Click.on(WhoIsFlyingForm.getSuffixValue(i,randomNumber)
                    ));
            scrollDownYearInteraction.clear();
            enterPassengerAccountNumberList.clear();
        }
    }
}