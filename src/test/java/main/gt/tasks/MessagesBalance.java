package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.ScrollingAction;
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

public class MessagesBalance {

    Actor usuario;

    @Managed
    WebDriver navegador;


    @Before
    public void ingresar() {
        usuario = Actor.named("usuario");
        usuario.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

    @Given("^Que ingresa a la pagina resumen de la cuenta$")
    public  void ingresoEnPagina(){
        usuario.should(new QuestionValidate(
                "¿Qué deseas hacer hoy?").Execute(new GeneralParams(
                "Pagina principal",
                "//p[contains(text(),'¿Qué deseas hacer hoy?')]")));
    }

    @When("^hace click sobre un Plan Prepago$")
    public  void  seleccionaUnaCuentaPrepago (){

        usuario.attemptsTo( new ClickButtonAction().Execute(new GeneralParams(
                "Usuario ubica el menu para seleccionar un plan",
                "Campo seleccionar plan",
                "//div[@class='container_line']")));

        usuario.attemptsTo( new ClickButtonAction().Execute(new GeneralParams(
                "Usuario ubica una cuenta prepago",
                "cuenta prepago",
                "//section[@id='block-accounts']//li[4]//a[1]")));

    }

    @And("^selecciona la opcion del Menu Mis Saldos$")
    public  void seleccionaOpcionMenuMisSaldos() throws InterruptedException {

        Thread.sleep(2502);
        usuario.attemptsTo( new ClickButtonAction().Execute(new GeneralParams(
                "Usuario ubica el menu Mis Saldos",
                "Menu Mis saldos",
                "//nav[@class='block block--menu block--selfcaremenu block--selfcaremenuprepago']//a[@class='mis saldos-icon is-active'][contains(text(),'Mis Saldos')]")));

    }

    @Then("^visualiza la información del saldo de mensajes: (.*)$")
    public  void validarInformacion(String titulo ) throws InterruptedException {

        Thread.sleep(5000);
        usuario.attemptsTo(new ScrollingAction().Execute(new GeneralParams(
                "hace scroll a card saldo internet",
                "ir a elemento saldo internet",
                "//section[@class='block block-tol block-internet-usage clearfix']//div[@class='wrapper-block']")));

        Thread.sleep(5000);
        usuario.should(new QuestionValidate(
                titulo).Execute(new GeneralParams(
                "Card Saldo de Internet",
                "//h2[contains(text(),'Saldo de Internet')]")));

        Thread.sleep(5000);
        usuario.should(new QuestionValidate(
                "No cuentas con un paquetigo de Internet activo, adquiere uno para seguir navegando.").Execute(new GeneralParams(
                "Card saldo de internet",
                "//div[contains(text(),'No cuentas con un paquetigo de Internet activo, ad')]")));

//        usuario.should(new QuestionValidate(
//                "Vigencia").Execute(new GeneralParams(
//                "Card Saldo de mensajes",
//                "")));

    }


}
