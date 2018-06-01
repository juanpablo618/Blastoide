package steps;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import screenplay.questions.ConfirmationNumberDisplayed;
import screenplay.questions.MundoLimpiezaTituloEsMostrado;
import screenplay.tasks.blastoide.*;
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
        actor = Actor.named("Administrador del sistema").can(BrowseTheWeb.with(webDriver));
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

    @When("Yo entro a todas las paginas con el usuario $firstName y la password $lastName")
    public void entrarAtodasLasPaginas(String firstName, String lastName) {

        actor.attemptsTo(
                new LlenarUsuarioDelSistema(firstName, lastName),
                new EntrarAPaginaFacturar(),
                new EntrarAPaginaCajaDiaria(),
                new EntrarAPaginaTipoDeIva(),
                new EntrarAPaginaTipoDeClientes(),
                new EntrarAPaginaClientes(),
                new EntrarAPaginaDetalleDeCtasCorrientes(),
                new EntrarAPaginaProductos(),
                new EntrarAPaginaProductosSinStock(),
                new EntrarAPaginaProductosPorProveedor(),
                new EntrarAPaginaTiposDeProductos()

                );
    }

    @When("Yo entro a la pagina facturar con el usuario $firstName y la password $lastName")
    public void entrarALaPaginaFacturar(String firstName, String lastName) {

        actor.attemptsTo(
                new LlenarUsuarioDelSistema(firstName, lastName),
                new EntrarAPaginaFacturar()
        );
    }

    @When("Yo entro a la pagina Caja Diaria con el usuario $firstName y la password $lastName")
    public void entrarALaPaginaCajadiaria(String firstName, String lastName) {

        actor.attemptsTo(
                new LlenarUsuarioDelSistema(firstName, lastName),
                new EntrarAPaginaCajaDiaria()
        );
    }

    @When("Yo entro a la pagina Tipo de iva con el usuario $firstName y la password $lastName")
    public void entrarALaPaginaTipoDeIva(String firstName, String lastName) {

        actor.attemptsTo(
                new LlenarUsuarioDelSistema(firstName, lastName),
                new EntrarAPaginaTipoDeIva()
        );
    }

    @When("Yo entro a la pagina Tipo de clientes con el usuario $firstName y la password $lastName")
    public void entrarALaPaginaTipoDeClientes(String firstName, String lastName) {

        actor.attemptsTo(
                new LlenarUsuarioDelSistema(firstName, lastName),
                new EntrarAPaginaTipoDeClientes()
        );
    }

    @When("Yo entro a la pagina clientes con el usuario $firstName y la password $lastName")
    public void entrarALaPaginaClientes(String firstName, String lastName) {

        actor.attemptsTo(
                new LlenarUsuarioDelSistema(firstName, lastName),
                new EntrarAPaginaClientes()
        );
    }

    @When("Yo entro a la pagina detalle de ctas corrientes con el usuario $firstName y la password $lastName")
    public void entrarALaPaginaDetalleDeCtasCorrientes(String firstName, String lastName) {

        actor.attemptsTo(
                new LlenarUsuarioDelSistema(firstName, lastName),
                new EntrarAPaginaDetalleDeCtasCorrientes()
        );
    }

    @When("Yo entro a la pagina productos con el usuario $firstName y la password $lastName")
    public void entrarALaPaginaProductos(String firstName, String lastName) {

        actor.attemptsTo(
                new LlenarUsuarioDelSistema(firstName, lastName),
                new EntrarAPaginaProductos()
        );
    }

    @When("Yo entro a la pagina productos sin stock con el usuario $firstName y la password $lastName")
    public void entrarALaPaginaProductosSinStock(String firstName, String lastName) {

        actor.attemptsTo(
                new LlenarUsuarioDelSistema(firstName, lastName),
                new EntrarAPaginaProductosSinStock()
        );
    }

    @When("Yo entro a la pagina productos por proveedor con el usuario $firstName y la password $lastName")
    public void entrarALaPaginaProductosPorProveedor(String firstName, String lastName) {

        actor.attemptsTo(
                new LlenarUsuarioDelSistema(firstName, lastName),
                new EntrarAPaginaProductosPorProveedor()
        );
    }

    @When("Yo entro a la pagina tipos de productos con el usuario $firstName y la password $lastName")
    public void entrarALaPaginaTiposDeProductos(String firstName, String lastName) {

        actor.attemptsTo(
                new LlenarUsuarioDelSistema(firstName, lastName),
                new EntrarAPaginaTiposDeProductos()
        );
    }

    @Then("Yo valido que el titulo este presente")
    public void validateConfirmationNumber() {
        actor.should(eventually(seeThat(new MundoLimpiezaTituloEsMostrado(), not(isEmptyString()))));
    }
}
