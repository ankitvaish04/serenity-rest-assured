package stepdefinitions.rest;

import Utilities.Datareader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONException;
import java.io.*;
import static org.hamcrest.Matchers.is;

/**
 * Created by ankit.vaish on 09-02-2018.
 */
public class GetPostRequest {

    private RequestSpecification rs = null;
    private Response response = null;
    private String basePath = null;

    //GET request scenario
    @Given("^I have a Base URI \"([^\"]*)\" and base path (.*) for the REST API$")
    public void baseUriGET(String baseURI, String basePath) throws JSONException, IOException {
        this.basePath = basePath;
        rs = SerenityRest.given().contentType("application/json")
                .baseUri(baseURI)
                .basePath(basePath);
    }

    @When("^I send the GET request to RestAPI$")
    public void sendRequestGET() {
        response = rs.when().get();
    }

    @Then("^the Rest API for GET should return me a valid response$")
    public void validateResponseGET() {
        if(basePath.equalsIgnoreCase("Noida")){
            //response.then().statusCode(200);
            //response.then().body("City", is("Noida"));
        }
        else if(basePath.equalsIgnoreCase("Mumbai")){
            //response.then().statusCode(200);
            //response.then().body("City", is("Mumbai"));
        }
    }

    //POST request scenario
    @Given("^I have a Base URI \"([^\"]*)\" and base path (.*) for the REST API and JSON file to post as \"([^\"]*)\"$")
    public void baseUriPOST(String baseURI, String basePath, String fileName) throws JSONException, IOException {

        //Files for POST request should be placed under \src\test\resources\json package and fileName to be updated in the feature file
        fileName = System.getProperty("user.dir") + "\\src\\test\\resources\\json\\" + fileName;
        String data = Datareader.readJson(fileName);
        rs = SerenityRest.given().contentType("application/json")
                .content(data)
                .baseUri(baseURI)
                .basePath(basePath);
    }

    @When("^I send the POST request to RestAPI$")
    public void sendRequestPOST() {
        response = rs.when().post();
    }

    @Then("^the Rest API for POST should return me a valid response$")
    public void validateResponsePOST() {
        response.then().statusCode(200);
        response.then().body("success", is(true));
    }
}