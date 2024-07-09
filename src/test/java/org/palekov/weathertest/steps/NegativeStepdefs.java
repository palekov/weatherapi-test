package org.palekov.weathertest.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class NegativeStepdefs extends AbstractStep {

    private int responseErrorCode;
    private String responseErrorMessage;
    @When("I requesting current weather with body contains invalid parameter {string}")
    public void iRequestingCurrentWeatherForTheCityWithBodyContainsInvalidParameter(String requestParam) {
        RequestSpecification request = RestAssured.given();
        response = request.get("http://api.weatherapi.com/v1" + requestParam);
        statusCode = response.getStatusCode();
    }

    @Then("I receive {int} code and response body with error {int} and message {string}")
    public void iReceiveRESPONSECodeAndResponseBodyWithError(int expectedCode, int expectedErrorCode, String expectedErrorMessage) {
        JsonPath path = response.body().jsonPath();
        if (path!=null) {
            responseErrorCode = path.get("error.code");
            responseErrorMessage = path.get("error.message");
        }
        Assert.assertEquals(expectedCode, statusCode);
        Assert.assertEquals(expectedErrorCode, responseErrorCode);
        Assert.assertEquals(expectedErrorMessage, responseErrorMessage);
    }

}
