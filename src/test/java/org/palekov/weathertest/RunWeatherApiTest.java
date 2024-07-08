package org.palekov.weathertest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@positiveTest", features = "src/test/resources/features", glue = "org/palekov/weathertest/steps")
public class RunWeatherApiTest {
}
