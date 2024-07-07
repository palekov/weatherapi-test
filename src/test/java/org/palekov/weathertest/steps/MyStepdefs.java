package org.palekov.weathertest.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class MyStepdefs {
    private Response response;
    JsonPath path;
    private int statusCode;

    @When("I requesting current weather for the city {string}")
    public void iRequestingCurrentWeatherForTheCity(String cityName) {
        RequestSpecification request = RestAssured.given();
        response = request.get("http://api.weatherapi.com/v1?q=" + cityName + "&key=70194649043645f69d770805240707");
        System.out.println("Requesting weather for the city: " + cityName);
        statusCode = response.getStatusCode();
    }

    @Then("I receive {int} code")
    public void receiveCode(int expectedCode) {
        System.out.println(response.asString());
        Assert.assertEquals(expectedCode, statusCode);
    }
}
