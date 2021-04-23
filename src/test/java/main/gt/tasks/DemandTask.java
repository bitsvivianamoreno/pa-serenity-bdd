package main.gt.tasks;

import core.Helpers.GeneralParams;
import core.actions.ClickButtonAction;
import core.actions.EnterTextAction;
import core.actions.OpenUrlAction;
import core.actions.SelectFromOptionsAction;
import core.questions.QuestionValidate;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Evaluate;
import net.serenitybdd.screenplay.questions.Attribute;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.springframework.util.StringUtils;

import java.util.List;

public class DemandTask {
    Actor actor;

    @Managed
    WebDriver navegador;


    @Before
    public void abrirNavegador() {
        actor = Actor.named("usuario");
        actor.can(BrowseTheWeb.with(navegador)); //Abrir navegador
        actor.has(new OpenUrlAction().Execute(new GeneralParams(
                "http://localhost:4200/#/login")));
    }

    @Dado("^Que (.*) entra al portal de transporte con usuario: (.*) y clave: (.*)$")
    public void enterToLogin(String actorName, String userName, String userPassword) {
        actor.named(actorName);
        actor.attemptsTo(new EnterTextAction(userName).Execute(new GeneralParams(
                "#actorName ingresa texto en un campo usuario",
                "Campo usuario",
                "#userName"
        )));
        actor.attemptsTo(new EnterTextAction(userPassword).Execute(new GeneralParams(
                "#actorName ingresa texto en un campo contraseña",
                "Campo contraseña",
                "#password"
        )));
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da clic en un botón ingresar",
                "Botón ingresar",
                ".btn-blue"
        )));
    }

    @Cuando("^(.*) ingresa a la sección de demanda de transporte$")
    public void enterToDemand(String actorName) {
        actor.named(actorName);
        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da click a la sección de demanda de transporte",
                "Click a la sección de demanda de transporte",
                "/html/body/app-root/app-main-layout/div/div/section/app-nav-dash/nav/ul/li[4]/a"
        )));
    }

    @Entonces("^(.*) debería visualizar la pantalla de demanda de trasporte con título: (.*)")
    public void validateTitle(String actorName, String namePage) {
        actor.named(actorName);

        actor.should(new QuestionValidate(namePage).Execute(new GeneralParams(
                "Titulo",
                "//h1[contains(text(),'Demanda')]")));
    }

    @Entonces("^(.*) debería visualizar una tabla con las cabeceras de: (.*), (.*) y (.*)")
    public void validateHeadersTitles(String actorName, String dateName, String pointName, String totalName) {
        actor.named(actorName);
        actor.should(new QuestionValidate(dateName).Execute(new GeneralParams(
                "Titulo de la columna No 1",
                "//th[contains(text(),'Fecha de transporte')]")));
        actor.should(new QuestionValidate(pointName).Execute(new GeneralParams(
                "Titulo de la columna No 2",
                "//th[contains(text(),'Punto de recogida')]")));
        actor.should(new QuestionValidate(totalName).Execute(new GeneralParams(
                "Titulo de la columna No 3",
                "//th[contains(text(),'Total de personas')]")));
    }

    @Entonces("^(.*) debería poder filtrar por Fecha de transporte: (.*) y Punto de recogida: (.*)")
    public void validateFilters(String actorName, String date, String point) throws InterruptedException {
        actor.named(actorName);

        if( StringUtils.hasLength(point) ) {
            actor.attemptsTo(new SelectFromOptionsAction(point).Execute(new GeneralParams(
                    "#actorName seleccionar el punto de recogida",
                    "Punto de recogida",
                    "//select[@id='transporter']"
            )));
        }

        actor.attemptsTo(new EnterTextAction(date).Execute(new GeneralParams(
                "#actorName ingresa fecha de transporte",
                "Fecha de transporte",
                "//body/app-root[1]/app-main-layout[1]/div[1]/div[1]/section[1]/app-demand[1]/div[1]/form[1]/div[2]/div[2]/div[1]/input[1]"
        )));

        actor.attemptsTo(new ClickButtonAction().Execute(new GeneralParams(
                "Usuario da click en el boton de consultar",
                "Click al boton de consultar",
                "//button[contains(text(),'Consultar')]"
        )));

        Thread.sleep(5000);
        if( StringUtils.hasLength(date) ) {
            actor.should(new QuestionValidate(date).Execute(new GeneralParams(
                    "Valor de la columna No 1",
                    "//tbody/tr[1]/td[1]")));
        }

        if( StringUtils.hasLength(point) ) {
            actor.should(new QuestionValidate(point).Execute(new GeneralParams(
                    "Valor de la columna No 2",
                    "//tbody/tr[1]/td[2]")));
        }

    }
}
