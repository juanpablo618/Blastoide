package screenplay.tasks.carBooking;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screenplay.user_interface.carBooking.SelectCarMatrix;


public class SelectCar implements Task {

    private WebDriver webDriver;

    public SelectCar(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("{0} selects first car available")
    public <T extends Actor> void performAs(T actor) {

        //TODO: Replace Target instead of String
        new WebDriverWait(webDriver, 10).until(
                ExpectedConditions.elementToBeClickable(SelectCarMatrix.CAR_BOOKING_GRID_BUTTON));

        actor.attemptsTo(
            Click.on(SelectCarMatrix.CAR_FARE_BUTTON),
            Click.on(SelectCarMatrix.SELECTED_CAR_CONTINUE_BUTTON)
        );
    }
}
