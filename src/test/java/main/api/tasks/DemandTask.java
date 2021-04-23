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

public class DemandTask {
    @Dado("^Que Administrador desea ver la demanda por Fecha de transporte: (.*), Punto de recogida: (.*), con el usuario: (.*) y clave: (.*)\\.$")
    public void tokenAndHeader(String date, String point, String userName, String userPassword) {
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
                .params("puntoTransporte", point,
                        "fechaTransporte", date
                )
                .headers("Authorization", token);
    }


    @Cuando("^Administrador realiza la solicitud\\.$")
    public void sendRequest() {
        when()
                .get(EndPoints.DEMAND.getUrl());
    }

    @Entonces("^Administrador debe poder ver resultado con filtro\\.$")
    public void codeChecks() {
        then()
                .statusCode(200)
                .body("resultado.codigo", equalTo(Arrays.asList(200)));
    }
}
