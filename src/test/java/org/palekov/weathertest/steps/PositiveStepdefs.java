package org.palekov.weathertest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.palekov.weathertest.assertions.SoftAssertionFactory;
import org.palekov.weathertest.models.WeatherResponseDto;

import java.io.File;
import java.io.IOException;

public class PositiveStepdefs extends AbstractStep {

    private final SoftAssertionFactory softAssertionFactory = new SoftAssertionFactory();

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
        Assert.assertEquals(expectedCode, statusCode);
    }

    @And("I receive correct json response for the city {string}")
    public void iReceiveCorrectJsonResponseForTheCity(String cityName) throws IOException {
        File file = new File("src/test/resources/testdata/" + cityName + ".json");
        WeatherResponseDto expectedResponse = objectMapper.readValue(file, WeatherResponseDto.class);
        WeatherResponseDto actualResponse = response.then().extract().as(WeatherResponseDto.class);

        softAssertionFactory.assertThat(actualResponse)
                .hasLocationName(expectedResponse.getLocation().getName())
                .hasRegion(expectedResponse.getLocation().getRegion())
                .hasCountry(expectedResponse.getLocation().getCountry())
                .hasLat(expectedResponse.getLocation().getLat())
                .hasLon(expectedResponse.getLocation().getLon())
                .hasTzId(expectedResponse.getLocation().getTzId())
                .hasLocaltimeEpoch()
                .hasLocaltime()
                .hasLastUpdatedEpoch()
                .hasLastUpdated()
                .hasTempC(expectedResponse.getCurrent().getTempC())
                .hasTempF(expectedResponse.getCurrent().getTempC())
                .hasIsDay(expectedResponse.getCurrent().getIsDay())
                .hasConditionText(expectedResponse.getCurrent().getCondition().getText())
                .hasConditionIcon(expectedResponse.getCurrent().getCondition().getIcon())
                .hasConditionCode(expectedResponse.getCurrent().getCondition().getCode());
        softAssertionFactory.assertAll();
    }
}
