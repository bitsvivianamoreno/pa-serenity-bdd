package main.api.tasks;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import io.restassured.http.ContentType;
import main.services.EndPoints;
import main.services.LoginObject;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;

public class LoginTask {
    Actor actor;

    @Dado("^Que (.*) desea ingresar con usuario: (.*) y clave: (.*)$")
    public void Header(String actorName, String userName, String userPassword) {
        actor.named(actorName);
        LoginObject loginObject = new LoginObject(userName, userPassword);
        given()
                .contentType(ContentType.JSON)
                .body(loginObject);
    }

    @Cuando("^(.*) realiza la consulta$")
    public void sendRequest(String actorName) {
        actor.named(actorName);
        when()
                .post(EndPoints.LOGIN.getUrl());
    }

    @Entonces("^(.*) deberia recibir respuesta exitosa\\.$")
    public void codeChecks(String actorName) {
        actor.named(actorName);
        then()
                .statusCode(200)
                .body("code", equalTo("200"));
    }
}
