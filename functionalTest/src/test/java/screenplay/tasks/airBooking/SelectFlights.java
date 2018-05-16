package screenplay.tasks.airBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.AnonymousPerformable;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import screenplay.models.AirBookingFlow;
import screenplay.user_interface.airBooking.SelectFlightResultsMatrix;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectFlights implements Task {

    private String itineraryType;
    private int outboundStops;
    private int inboundStops;
    private String fareTypeOB;
    private String fareTypeIB;

    private static final String MULTI_CITY = "Multi-city";
    private static final String ROUNDTRIP = "Roundtrip";
    private int amountOfAdultPassengers;
    private int amountOfSeniorsPassengers;

    @Managed()
    private WebDriver webDriver;

    public SelectFlights(AirBookingFlow airBookingFlow) {
        this.itineraryType = airBookingFlow.getItineraryType();
        this.outboundStops = airBookingFlow.getOutboundStops();
        this.inboundStops = airBookingFlow.getInboundStops();
        this.fareTypeOB = airBookingFlow.getFareTypeOB();
        this.fareTypeIB = airBookingFlow.getFareTypeIB();
        this.amountOfAdultPassengers = airBookingFlow.getAdultPassengerCount();
        this.amountOfSeniorsPassengers = airBookingFlow.getSeniorPassengerCount();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<Performable> actions = new ArrayList<>();
        List<Performable> actionsForSeniorsPassengers = new ArrayList<>();

        if (amountOfSeniorsPassengers > 0) {
            if (outboundStops == 0) {
                actionsForSeniorsPassengers.add(Click.on(SelectFlightResultsMatrix.getFlightButtonByFareAndBound(fareTypeOB, 0)));
            } else {
                actionsForSeniorsPassengers.add(Click.on(SelectFlightResultsMatrix.getFlightButtonByAmountOfStopsByFareAndBound(0, outboundStops, fareTypeOB)));
            }

            if (itineraryType.equalsIgnoreCase(ROUNDTRIP) || itineraryType.equalsIgnoreCase(MULTI_CITY)) {
                if (inboundStops == 0) {
                    actionsForSeniorsPassengers.add(Click.on(SelectFlightResultsMatrix.getFlightButtonByFareAndBound(fareTypeIB, 1)));
                } else {
                    actionsForSeniorsPassengers.add(Click.on(SelectFlightResultsMatrix.getFlightButtonByAmountOfStopsByFareAndBound(1, inboundStops, fareTypeIB)));
                }
            }
        }

        Performable selectFlightForSeniorPassengers = new AnonymousPerformable("Select flight for Seniors passengers", actionsForSeniorsPassengers);

        if (outboundStops == 0) {
            actions.add(Click.on(SelectFlightResultsMatrix.getFlightButtonByFareAndBound(fareTypeOB, 0)));
        } else {
            actions.add(Click.on(SelectFlightResultsMatrix.getFlightButtonByAmountOfStopsByFareAndBound(0, outboundStops, fareTypeOB)));
        }

        if (itineraryType.equalsIgnoreCase(ROUNDTRIP) || itineraryType.equalsIgnoreCase(MULTI_CITY)) {
            if (inboundStops == 0) {
                actions.add(Click.on(SelectFlightResultsMatrix.getFlightButtonByFareAndBound(fareTypeIB, 1)));
            } else {
                actions.add(Click.on(SelectFlightResultsMatrix.getFlightButtonByAmountOfStopsByFareAndBound(1, inboundStops, fareTypeIB)));
            }
        }

        Performable selectFlight = new AnonymousPerformable("Select flight for Adult passengers", actions);

        actor.attemptsTo(
                WaitUntil.the(SelectFlightResultsMatrix.UNLOCK_HEADER_BUTTON, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(SelectFlightResultsMatrix.UNLOCK_HEADER_BUTTON)
        );

        if (amountOfSeniorsPassengers > 0) {
            actor.attemptsTo(
                    selectFlightForSeniorPassengers,
                    Click.on(SelectFlightResultsMatrix.CONTINUE_BUTTON)
            );
        }

        if (amountOfAdultPassengers > 0) {
            actor.attemptsTo(
                    selectFlight,
                    Click.on(SelectFlightResultsMatrix.CONTINUE_BUTTON)
            );
        }

        if (Visibility.of(SelectFlightResultsMatrix.UPGRADE_BUTTON_CONTINUE).viewedBy(actor).resolve()) {
            actor.attemptsTo(
                    Hit.the(Keys.ENTER).into(SelectFlightResultsMatrix.UPGRADE_BUTTON_CONTINUE)
            );
        }
    }
}