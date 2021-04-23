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

public class OpeningBalance {

    Actor actor;

    @Managed
    WebDriver navegador;


    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

    @Given("^Que ingresa a la pagina principal$")
    public  void ingresoPage(){
        actor.should(new QuestionValidate(
                "¿Qué deseas hacer hoy?").Execute(new GeneralParams(
                "Pagina principal",
                "//p[contains(text(),'¿Qué deseas hacer hoy?')]")));

    }
    @When("^hace click sobre un plan prepago$")
    public  void  seleccionaCuentaPrepago (){
        actor.attemptsTo( new ClickButtonAction().Execute(new GeneralParams(
                "Usuario ubica el menu selecciona un plan",
                "Campo seleccionar plan",
                "//div[@class='container_line']")));

        actor.attemptsTo( new ClickButtonAction().Execute(new GeneralParams(
                "Usuario ubica una cuenta prepago",
                "cuenta prepago",
                "//section[@id='block-accounts']//li[4]//a[1]")));

    }

    @And("^selecciona el menu Mis Saldos$")
    public  void seleccionaMenuMisSaldos() throws InterruptedException {
        Thread.sleep(2502);
        actor.attemptsTo( new ClickButtonAction().Execute(new GeneralParams(
                "Usuario ubica el menu Mis Saldos",
                "Menu Mis saldos",
                "//nav[@class='block block--menu block--selfcaremenu block--selfcaremenuprepago']//a[@class='mis saldos-icon is-active'][contains(text(),'Mis Saldos')]")));
    }

    @Then("^valida que se visualice el texto saldo principal y moneda$")
    public  void validarTexto() {
        actor.should(new QuestionValidate(
                "Mi Saldo Principal").Execute(new GeneralParams(
                "Card Mis Saldos",
                "/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/section[2]/div[1]/h2[1]")));

        actor.should(new QuestionValidate(
                "Q34.8").Execute(new GeneralParams(
                "Card Mis Saldos",
                "/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[1]")));
    }
}
