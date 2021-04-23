package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class TigoAwards {

    Actor actor;

    @Managed
    WebDriver navegador;


    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
    }

    @When("selecciona una cuenta prepago$")
    public void seleccionarCuentaPrepago(){
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en selector de cuentas",
                "Selector de cuentas",
                "//div[@class='container_line']//span[@class='line']"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario selecciona una cuenta con plan prepago",
                "Cuenta con plan prepago",
                "//section[@id='block-accounts']//li[4]//a[1]"
        )));
    }

    @Then("^deberia observar los puntos acumulados y la meta$")
    public void informacionTigoPremios(){
        actor.should(new QuestionValidate("Puntos Acumulados")
                .Execute(new GeneralParams(
                "Card tigo premios",
                "//div[@class='premios-cont-bar']//p[@class='txt-gris-claro one'][contains(text(),'Puntos Acumulados')]"
        )));

        actor.should(new QuestionValidate("Meta")
                .Execute(new GeneralParams(
                        "Card tigo premios",
                        "//p[@class='txt-gris-claro txt-right two']"
                )));
    }

}
