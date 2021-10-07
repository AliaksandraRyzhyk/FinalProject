package api.steps.importContact;

import config.UserConfig;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetEmailList {
    private static String response;

    @Then("Get email address list")
    public void testGetListOfEmail() {
        Map<String, String> params = new HashMap<>();

        params.put("format", UserConfig.getFormat());
        params.put("api_key", UserConfig.getApiKey());

        RestAssured.baseURI = UserConfig.getBaseURI();
        RestAssured.basePath = "/getLists";

        setResponse(given()
                .contentType("application/json")
                .queryParams(params)
                .when()
                .get()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getString("result.id[0]"));
    }

    public static String getResponse() {
        return response;
    }

    public static void setResponse(String responseNew) {
        response = responseNew;
    }
}

