package api.steps.contactList;

import config.UserConfig;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

public class DeleteListTest {
    @Then("Change contact list properties")
    public void deleteOneContact() {
        Map<String, String> params = new HashMap<>();

        params.put("format", UserConfig.getFormat());
        params.put("api_key", UserConfig.getApiKey());
        params.put("list_id", UserConfig.getListId());


        RestAssured.baseURI = UserConfig.getBaseURI();
        RestAssured.basePath = "/deleteList";

        given()
                .contentType("application/json")
                .queryParams(params)
                .when()
                .post()//по документации через пост
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}