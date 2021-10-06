package api.steps.importContact;

import config.UserConfig;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SubscribeEmailTest {
    @Then("Add email address of a contact to one list")
    public void addEmail() {
        String response = GetEmailList.getResponse();
        Map<String, String> params = new HashMap<>();

        params.put("format", UserConfig.getFormat());
        params.put("api_key", UserConfig.getApiKey());
        params.put("list_ids", response);
        params.put("fields[email]", UserConfig.getUserName());
        params.put("double_optin", UserConfig.getDoubleOption());

        RestAssured.baseURI = UserConfig.getBaseURI();
        RestAssured.basePath = "/ui/subscribe";

        given()
                .contentType("application/json")
                .queryParams(params)
                .when()
                .post()
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}

