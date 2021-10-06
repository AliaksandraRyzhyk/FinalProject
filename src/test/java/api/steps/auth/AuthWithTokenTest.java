package api.steps.auth;

import config.UserConfig;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthWithTokenTest {

    @Then("Input login and password")
    public void testToken() {
        Map<String, String> params = new HashMap<>();

        params.put("login", "ryzhyk.aliaksandra@yandex.by");
        params.put("password", UserConfig.USER_PASSWORD);


        RestAssured.baseURI = "https://apig.unisender.com";
        RestAssured.basePath = "/auth/token";

        String tokenResponse = given()
                .contentType("application/json")
                .body(params)
                .when()
                .post()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getString("result.token");

        System.out.println("Token: " + tokenResponse);
    }

}
