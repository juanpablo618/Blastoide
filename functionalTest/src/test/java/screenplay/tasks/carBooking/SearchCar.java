package screenplay.tasks.carBooking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import screenplay.models.CarBooking;
import screenplay.user_interface.carBooking.SearchCarFormWidget;

public class SearchCar implements Task {

    private CarBooking carBooking = new CarBooking();

    @Step("{0} searches a car with a data")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(carBooking.getPickUpLocation()).into(SearchCarFormWidget.PICK_UP_LOCATION_INPUT),
                Enter.theValue(carBooking.getReturnLocation()).into(SearchCarFormWidget.RETURN_LOCATION_INPUT),
                Click.on(SearchCarFormWidget.SEARCH_BUTTON)
        );
    }
}
