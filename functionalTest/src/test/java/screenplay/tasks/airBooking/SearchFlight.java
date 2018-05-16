package screenplay.tasks.airBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.type.TypeValueIntoTarget;
import org.openqa.selenium.Keys;
import screenplay.models.AirBookingFlow;
import screenplay.user_interface.airBooking.BookingWidgetForm;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SearchFlight implements Task {

    private String itineraryType;
    private int departureDate;
    private int returnDate;
    private String departureAirport;
    private String destinationAirport;
    private String arrivalAirport;
    private int adultPassengerCount;
    private int seniorPassengerCount;
    private DateFormat dateFormat = new SimpleDateFormat("MM/dd");
    private static final String MULTI_CITY = "Multi-city";
    private static final String ROUNDTRIP = "Roundtrip";
    private static final String ONE_WAY = "One-way";

    public SearchFlight(AirBookingFlow airBookingFlow) {
        this.itineraryType = airBookingFlow.getItineraryType();
        this.departureDate = airBookingFlow.getDepartureDate();
        this.returnDate = airBookingFlow.getReturnDate();
        this.adultPassengerCount = airBookingFlow.getAdultPassengerCount();
        this.seniorPassengerCount = airBookingFlow.getSeniorPassengerCount();
        this.departureAirport = airBookingFlow.getDepartureAirport();
        this.arrivalAirport = airBookingFlow.getArrivalAirport();
        this.destinationAirport = airBookingFlow.getDestinationAirport();
    }

    public static SearchFlight byItineraryType(AirBookingFlow airBookingFlow) {
       return new SearchFlight(airBookingFlow);
    }

    public String setDate(int numberOfDeferredDays) {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + numberOfDeferredDays);
        return dateFormat.format(cal.getTime());
    }

    private <T extends Actor> void searchOneWay(T actor) {
        actor.attemptsTo(
                Click.on(BookingWidgetForm.ONE_WAY_RADIO_BUTTON),
                Enter.theValue(departureAirport).into(BookingWidgetForm.DEPARTURE_INPUT_FIELD),
                Enter.theValue(arrivalAirport).into(BookingWidgetForm.ARRIVAL_INPUT_FIELD),
                Enter.theValue(setDate(departureDate)).into(BookingWidgetForm.DEPART_DATE_INPUT),
                Hit.the(Keys.ESCAPE).into(BookingWidgetForm.DEPART_DATE_INPUT),
                new TypeValueIntoTarget(String.valueOf(seniorPassengerCount), BookingWidgetForm.SENIOR_PASSENGERS_COUNT_BUTTON),
                new TypeValueIntoTarget(String.valueOf(adultPassengerCount), BookingWidgetForm.ADULTS_PASSENGERS_COUNT_BUTTON),
                Click.on(BookingWidgetForm.CONTINUE_BUTTON)
        );
    }

    private <T extends Actor> void searchRoundtrip(T actor) {
        actor.attemptsTo(
                Enter.theValue(departureAirport).into(BookingWidgetForm.DEPARTURE_INPUT_FIELD),
                Enter.theValue(arrivalAirport).into(BookingWidgetForm.ARRIVAL_INPUT_FIELD),
                Enter.theValue(setDate(departureDate)).into(BookingWidgetForm.DEPART_DATE_INPUT),
                Enter.theValue(setDate(returnDate)).into(BookingWidgetForm.RETURN_DATE_INPUT),
                Hit.the(Keys.ESCAPE).into(BookingWidgetForm.RETURN_DATE_INPUT),
                new TypeValueIntoTarget(String.valueOf(seniorPassengerCount), BookingWidgetForm.SENIOR_PASSENGERS_COUNT_BUTTON),
                new TypeValueIntoTarget(String.valueOf(adultPassengerCount), BookingWidgetForm.ADULTS_PASSENGERS_COUNT_BUTTON),
                Click.on(BookingWidgetForm.CONTINUE_BUTTON)
        );
    }

    private <T extends Actor> void searchMultiCity(T actor) {
        actor.attemptsTo(
                Click.on(BookingWidgetForm.MULTI_CITY_RADIO_BUTTON),
                Enter.theValue(departureAirport).into(BookingWidgetForm.DEPARTURE_INPUT_FIELD),
                Enter.theValue(arrivalAirport).into(BookingWidgetForm.DESTINATION_AIRPORT_CODE),
                Enter.theValue(destinationAirport).into(BookingWidgetForm.RETURN_AIRPORT_CODE),
                Enter.theValue(setDate(departureDate)).into(BookingWidgetForm.DEPART_DATE_INPUT),
                Enter.theValue(setDate(returnDate)).into(BookingWidgetForm.RETURN_DATE_INPUT),
                Hit.the(Keys.ESCAPE).into(BookingWidgetForm.RETURN_DATE_INPUT),
                new TypeValueIntoTarget(String.valueOf(seniorPassengerCount), BookingWidgetForm.SENIOR_PASSENGERS_COUNT_BUTTON),
                new TypeValueIntoTarget(String.valueOf(adultPassengerCount), BookingWidgetForm.ADULTS_PASSENGERS_COUNT_BUTTON),
                Click.on(BookingWidgetForm.CONTINUE_BUTTON)
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (itineraryType.equals(ONE_WAY)) {
            searchOneWay(actor);
        }else if(itineraryType.equals(ROUNDTRIP)){
            searchRoundtrip(actor);
        }else{
            searchMultiCity(actor);
        }
    }
}