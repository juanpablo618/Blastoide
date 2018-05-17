package steps;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import screenplay.questions.ConfirmationNumberDisplayed;
import screenplay.tasks.blastoide.AccederAPaginaDeLogin;
import screenplay.tasks.blastoide.FacturarProducto;
import screenplay.tasks.blastoide.LlenarUsuarioDelSistema;
import screenplay.tasks.carBooking.*;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

public class CarBookingSteps {

    private Actor actor;

    @Managed()
    private WebDriver webDriver;

    @Given("I am on the Car Search page")
    public void goToCarSearchPage() {
        actor = Actor.named("Pepe").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(new AccesToCarSearchPage());
    }

    @Given("Yo estoy en la pagina de Login")
    public void irAPaginaDeLogin() {
        actor = Actor.named("Pepe").can(BrowseTheWeb.with(webDriver));
        webDriver.manage().window().maximize();
        actor.attemptsTo(new AccederAPaginaDeLogin());
    }

    @When("I book a car with $firstName and $lastName")
    public void completeCarSearchPage(String firstName, String lastName) {

        actor.attemptsTo(
                new SearchCar(),
                new SelectCar(webDriver),
                new ContinueToPurchasePage(),
                new FillWhoIsDrivingData(firstName, lastName),
                new FillSendYourReceiptSection(),
                new ContinueToConfirmationPage()
        );
    }

    @When("Yo entro con el usuario $firstName y la password $lastName")
    public void completarCompraDeUnProducto(String firstName, String lastName) {

        actor.attemptsTo(
                new LlenarUsuarioDelSistema(firstName, lastName),
                new FacturarProducto()

        );
    }

    @Then("I validate the confirmation number")
    public void validateConfirmationNumber() {
        actor.should(eventually(seeThat(new ConfirmationNumberDisplayed(), not(isEmptyString()))));
    }
}
