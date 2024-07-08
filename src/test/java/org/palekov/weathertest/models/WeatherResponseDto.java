package org.palekov.weathertest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponseDto {

    @JsonProperty("location")
    LocationDto location;

    @JsonProperty("current")
    CurrentDto current;
}
