package screenplay.user_interface.airBooking;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class WhoIsFlyingForm {

    public static Target getFirstNameInput(int index) {
        return Target.the("Passenger " + index + " first name input")
                .located(By.id("passengerFirstName-" + index));
    }

    public static Target getMiddleNameInput(int index) {
        return Target.the("Passenger " + index + " middle name input")
                .located(By.id("passengerMiddleName-" + index));
    }

    public static Target getLastNameInput(int index) {
        return Target.the("Passenger " + index + " last name input")
                .located(By.id("passengerLastName-" + index));
    }

    public static Target getMonthOfBirthDropDown(int index) {
        return Target.the("Passenger " + index + " month of birth dropdown")
                .located(By.id("passengerDateOfBirthMonth-" + index));
    }

    public static Target getMonthOfBirthValue(int index) {
        return Target.the("Passenger " + index + " month of birth value")
                .located(By.cssSelector("#passengerDateOfBirthMonth-" + index + "--item-1 .actionable_vertical-menu"));
    }

    public static Target getDayOfBirthDropdown(int index) {
        return Target.the("Passenger " + index + " day of birth dropdown")
                .located(By.id("passengerDateOfBirthDay-" + index));
    }

    public static Target getDayOfBirthValue(int index) {
        return Target.the("Passenger " + index + " day of birth value")
                .located(By.cssSelector("#passengerDateOfBirthDay-" + index + "--item-1 .actionable_vertical-menu"));
    }

    public static Target getYearOfBirthDropdown(int index) {
        return Target.the("Passenger " + index + " year of birth dropdown")
                .located(By.id("passengerDateOfBirthYear-" + index));
    }

    public static Target getYearOfBirthValue(int index) {
        return Target.the("Passenger " + index + " year of birth value for adult")
                .located(By.cssSelector("#passengerDateOfBirthYear-"+ index +"--menu .list-item"));
    }

    public static Target getYearOfBirthOption(int passengerIndex, int optionIndex) {
        return Target.the("Passenger " + passengerIndex + " year of birth value for adult")
                .located(By.id("passengerDateOfBirthYear-" + passengerIndex + "--item-" + optionIndex));
    }

    public static Target getGenderDropdown(int index) {
        return Target.the("Passenger " + index + " gender dropdown")
                .located(By.id("passengerGender-" + index));
    }

    public static Target getGenderValue(int index) {
        return Target.the("Passenger " + index + " gender value")
                .located(By.id("passengerGender-" + index + "--item-1"));
    }

    public static Target getRapidRewardInput(int index) {
        return Target.the("Passenger " + index + " Rapid Reward input")
                .located(By.id("passengerRapidRewards-" + index));
    }

    public static Target getSuffix(int index) {
        return Target.the("Passenger " + index + " suffix input")
                .located(By.id("passengerSuffix-" + index));
    }

    public static Target getSuffixValue(int index, int value) {
        return Target.the("Passenger " + index + " suffix input value")
                .located(By.id("passengerSuffix-" + index + "--item-" + value));
    }

    public static final Target ADD_EARLY_BIRD_RADIO_BUTTON = Target.the("Add Early bird radio button")
            .located(By.className(".checkout-early-bird--banner .input-group--item:nth-child(1) .radio-button"));
}