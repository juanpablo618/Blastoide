package screenplay.tasks.earlyBird;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.AnonymousPerformable;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import screenplay.models.AirBookingFlow;
import screenplay.models.EarlyBirdFlowInformation;
import screenplay.user_interface.earlyBird.EarlyBirdSelectPageForm;

import java.util.ArrayList;
import java.util.List;

public class SelectEarlyBirdPassengers implements Task {

    private static final int PASSENGER_LIST_OUTBOUND_INDEX = 0;
    private static final int PASSENGER_LIST_INBOUND_INDEX = 1;
    private int oBPassengersToUncheck;
    private int iBPassengersToUncheck;

    public SelectEarlyBirdPassengers(AirBookingFlow airBookingFlow, EarlyBirdFlowInformation earlyBirdFlowInformation) {
        this.oBPassengersToUncheck = airBookingFlow.getAdultPassengerCount() - earlyBirdFlowInformation.getNumberOfSelectedPassengerOB();
        if (!airBookingFlow.getItineraryType().equals("One-way")) {
            this.iBPassengersToUncheck = airBookingFlow.getAdultPassengerCount() - earlyBirdFlowInformation.getNumberOfSelectedPassengerIB();
        }
    }

    private <T extends Actor> void uncheckPassengers(T actor, int amount, int bound) {

        List<Performable> uncheckPassengersList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            uncheckPassengersList.add(Click.on(EarlyBirdSelectPageForm.getPassengerCheckBox(bound, i)));
        }
        Performable uncheckPassengersAction = new AnonymousPerformable("Uncheck " + (bound == 0? "outbound" : "inbound") + " passengers", uncheckPassengersList);

        actor.attemptsTo(
                uncheckPassengersAction
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(oBPassengersToUncheck > 0){
            uncheckPassengers(actor, oBPassengersToUncheck, PASSENGER_LIST_OUTBOUND_INDEX);
        }
        if(iBPassengersToUncheck > 0){
            uncheckPassengers(actor, iBPassengersToUncheck, PASSENGER_LIST_INBOUND_INDEX);
        }
    }
}