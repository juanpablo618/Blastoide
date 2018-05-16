package screenplay.user_interface.airBooking;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class BookingWidgetForm {

    public static final Target DEPARTURE_INPUT_FIELD = Target.the("Departure airport input field")
            .located(By.id("originationAirportCode"));

    public static final Target ARRIVAL_INPUT_FIELD = Target.the("Arrival airport input field")
            .located(By.id("destinationAirportCode"));

    public static final Target CONTINUE_BUTTON = Target.the("Continue button")
            .located(By.id("form-mixin--submit-button"));

    public static final Target DEPART_DATE_INPUT = Target.the("Departure date input")
            .located(By.id("departureDate"));

    public static final Target RETURN_DATE_INPUT = Target.the("Return date input")
            .located(By.id("returnDate"));

    public static final Target ONE_WAY_RADIO_BUTTON = Target.the("One way radio button")
            .located(By.cssSelector(".radio-button--input[value='oneway']"));

    public static final Target ADULTS_PASSENGERS_COUNT_BUTTON = Target.the("Adults Passengers count button")
            .located(By.id("adultPassengersCount"));

    public static final Target SENIOR_PASSENGERS_COUNT_BUTTON = Target.the("Seniors Passengers count button")
            .located(By.id("seniorPassengersCount"));

    public static final Target MULTI_CITY_RADIO_BUTTON = Target.the("Multi city radio button")
            .located(By.cssSelector(".radio-button--input[value='multicity']"));

    public static final Target DESTINATION_AIRPORT_CODE = Target.the("Destination airport input field")
            .located(By.id("destinationAirportCode"));

    public static final Target RETURN_AIRPORT_CODE = Target.the("Return airport input field")
            .located(By.id("returnAirportCode"));

}