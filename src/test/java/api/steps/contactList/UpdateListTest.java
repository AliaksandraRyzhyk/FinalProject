package api.steps.contactList;

import config.UserConfig;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class UpdateListTest {
    @Then("Update our contact list")
    public void updateContactList() {
        Map<String, String> params = new HashMap<>();

        params.put("format", UserConfig.getFormat());
        params.put("api_key", UserConfig.getApiKey());
        params.put("list_id", UserConfig.getListId());
        params.put("title", UserConfig.getTitle());

        RestAssured.baseURI = UserConfig.getBaseURI();
        RestAssured.basePath = "/updateList";

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

