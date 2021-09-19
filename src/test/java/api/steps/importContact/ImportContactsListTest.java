package api.steps.importContact;

import config.UserConfig;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ImportContactsListTest {
    @Then("Get the final contact list")
    public void getEmailList() {
        Map<String, String> params = new HashMap<>();

        params.put("format", UserConfig.getFormat());
        params.put("api_key", UserConfig.getApiKey());
        params.put("field_names[0]", UserConfig.getContactType());
        params.put("data[0][0]", "ryzhik.sasha@list.ru");
        params.put("data[N][0]", UserConfig.getUserEmail());


        RestAssured.baseURI = UserConfig.getBaseURI();
        RestAssured.basePath = "/importContacts";

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
