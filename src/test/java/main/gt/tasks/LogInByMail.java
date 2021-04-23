package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import core.actions.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

import org.openqa.selenium.WebDriver;

import core.actions.ClickButtonAction;


public class LogInByMail {

    Actor actor;

    @Managed
    WebDriver navegador;


    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

    @When("^da clic sobre el boton ingresar de Móvil$")
    public void seleccionarBoton() {
       actor.attemptsTo(
               new ClickButtonAction().Execute(new GeneralParams(
                       "Usuario da clic en un botón",
                       "Botón ingresar de la pagina de inicio",
                       "//a[1]//button[1]"
               )));
    }


    @And("^selecciona ingresar con email$")
    public void seleccionarBotonIngresar() {
        actor.attemptsTo(
                new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da click en ingresar con email",
                        "Boton Ingresar con email",
                        "//p[contains(text(),'Ingresar con email')]"
                )));
    }


    @And("^Ingresa el email: (.*)$")
    public void ingresarCorreo(String correo) {
        actor.attemptsTo(new EnterTextAction(correo).Execute(new GeneralParams(
                "Usuario ingresa texto en un campo email",
                "Campo email",
                "//input[@id='idEmail']"
        )));
    }


    @And("^Selecciona validar correo$")
    public void validarCorreo() {
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario selecciona Validar",
                "Boton validar correo",
                "//button[@id='continueBtn']"
        )));
    }

    @And("^Ingresa la clave: (.*)$")
    public void ingresarClave(String clave){

        actor.attemptsTo(new EnterTextAction(clave).Execute(
                new GeneralParams(
                        "Usuario ingresa texto en un campo clave",
                        "Campo clave",
                        "//input[@id='password']"
                )
        ));
    }

    @And("^selecciona continuar$")
    public void continuar(){
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da Clic en continuar",
                "Boton continuar",
                "//button[@name='action']"
        )));
    }


    @Then("^deberia ingresar de forma exitosa$")
    public void ingresoExitoso(){
        actor.should(new QuestionValidate("¿Qué deseas hacer hoy?").Execute(
                new GeneralParams(
                        "Usuario valida que ingreso a la pagina principal",
                        "Pagina Principal",
                        "//p[contains(text(),'¿Qué deseas hacer hoy?')] "
                )
        ));
    }
}