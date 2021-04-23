package main.api.tasks;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import main.services.EndPoints;
import main.services.LoginObject;

import java.util.Arrays;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;

public class PointsTask {
    @Dado("^Que Administrador desea listar los puntos de transporte con usuario: (.*) y clave: (.*)$")
    public void tokenAndHeader(String userName, String userPassword) {
        LoginObject loginObject = new LoginObject(userName, userPassword);

        JsonPath jsonPath = given()
                .contentType(ContentType.JSON)
                .body(loginObject)
                .post(EndPoints.LOGIN.getUrl())
                .then()
                .extract().jsonPath();
        ;

        String token = ( jsonPath.get("body.token").toString());

        given()
                .contentType(ContentType.JSON)
                .headers("Authorization", token);
    }

    @Cuando("^Administrador realiza la solicitud$")
    public void sendRequestd() {
        when()
                .get(EndPoints.POINTS.getUrl());
    }

    @Entonces("^Administrador debe visualizar los puntos\\.$")
    public void codeChecks() {
        then()
                .statusCode(200)
                .body("resultado.codigo", equalTo(Arrays.asList(200)));
    }
}
