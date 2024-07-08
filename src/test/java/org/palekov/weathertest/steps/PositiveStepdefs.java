package org.palekov.weathertest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.palekov.weathertest.models.WeatherResponseDto;

import java.io.File;
import java.io.IOException;

public class PositiveStepdefs extends AbstractStep {

    @When("I requesting current weather for the city {string}")
    public void iRequestingCurrentWeatherForTheCity(String cityName) {
        RequestSpecification request = RestAssured.given();
        response = request.get("http://api.weatherapi.com/v1/current.json?q="
                + cityName + "&key=" + apiKey);
        System.out.println("Requesting weather for the city: " + cityName);
        statusCode = response.getStatusCode();
    }

    @Then("I receive {int} code")
    public void receiveCode(int expectedCode) {
        System.out.println(response.asString());
        Assert.assertEquals(expectedCode, statusCode);
    }

    @And("I receive correct json response for the city {string}")
    public void iReceiveCorrectJsonResponseForTheCity(String cityName) throws IOException {
        File file = new File("src/test/resources/" + cityName + ".json");
        WeatherResponseDto response = objectMapper.readValue(file, WeatherResponseDto.class);
        System.out.println(response);

    }
}
