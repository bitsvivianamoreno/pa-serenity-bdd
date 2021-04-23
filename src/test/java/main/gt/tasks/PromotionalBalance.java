package main.gt.tasks;


import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class PromotionalBalance {

    Actor actor;

    @Managed
    WebDriver navegador;

    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

    @Given("^Usuario se encuentra dentro de la pagina mi cuenta$")
    public void paginaPrincipal() {
        actor.should(new QuestionValidate("¿Qué deseas hacer hoy?").Execute(new GeneralParams(
                "Pagina Principal",
                "//p[contains(text(),'¿Qué deseas hacer hoy?')]"
        )));
    }

    @When("^selecciona una cuenta controlada$")
    public void seleccionarCuenta() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en selector de cuentas",
                "Selector de cuentas",
                "//div[@class='container_line']//span[@class='line']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario selecciona una cuenta con plan controlado",
                "Cuenta con plan controlado",
                "//section[@id='block-accounts']//li[2]//a[1]"
        )));
    }

    @And("^selecciona mis saldos$")
    public void seleccionaMisSaldos() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario selecciona mis saldos",
                "Mis saldos",
                "/html[1]/body[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[2]/a[1]"
        )));
    }

    @Then("^deberia observar el saldo promocional y la información de este$")
    public void saldoPromocional() {
        actor.should(new QuestionValidate("Saldo Promocional").Execute(new GeneralParams(
                "Card saldo promocional",
                "//h2[contains(text(),'Saldo Promocional')]"
        )));
    }
}
