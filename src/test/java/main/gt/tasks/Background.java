package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.actions.OpenUrlAction;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class Background {

    Actor actor;

    @Managed
    WebDriver navegador;


    @Given("^Que usuario ingresa a la pagina de inicio$")
    public void ingresarAUrl() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
        actor.has(new OpenUrlAction().Execute(new GeneralParams(
                "http://localhost:4200/#/login")));
    }

    @And("^Inicia sesión$")
    public void iniciarSesion() {
        actor.attemptsTo(new EnterTextAction("yulymode").Execute(new GeneralParams(
                "#actorName ingresa texto en un campo usuario",
                "Campo usuario",
                "#userName"
        )));
        actor.attemptsTo(new EnterTextAction("Colombia1+").Execute(new GeneralParams(
                "#actorName ingresa texto en un campo contraseña",
                "Campo contraseña",
                "#password"
        )));
        actor.attemptsTo(
                new ClickButtonAction().Execute(new GeneralParams(
                        "Usuario da clic en un botón ingresar",
                        "Botón ingresar",
                        ".btn-blue"
                )));
    }


}
