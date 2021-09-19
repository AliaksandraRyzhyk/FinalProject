package api.steps.importContact;

import config.UserConfig;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UnsubscribeEmailTest {
    @Then("Unsubscribe e-mail address of a contact from one list \\(tag unsubscribed)")
    public void unsubscribeEmail() {
        Map<String, String> params = new HashMap<>();

        params.put("format", UserConfig.getFormat());
        params.put("api_key", UserConfig.getApiKey());
        params.put("contact", UserConfig.getUserName());
        params.put("contact_type", UserConfig.getContactType());

        RestAssured.baseURI = UserConfig.getBaseURI();
        RestAssured.basePath = "/unsubscribe";

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
