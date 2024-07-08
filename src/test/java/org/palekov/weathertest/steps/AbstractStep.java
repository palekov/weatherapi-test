package org.palekov.weathertest.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractStep {
    protected Response response;
    protected final String apiKey = "70194649043645f69d770805240707";
    JsonPath path;
    protected int statusCode;

    ObjectMapper objectMapper = new ObjectMapper();
}
