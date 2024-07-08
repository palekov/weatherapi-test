package org.palekov.weathertest.assertions;

import org.assertj.core.api.SoftAssertions;
import org.palekov.weathertest.models.WeatherResponseDto;

public class SoftAssertionFactory extends SoftAssertions {

    public WeatherResponseDtoAssertion assertThat(WeatherResponseDto response) {
        return proxy(WeatherResponseDtoAssertion.class, WeatherResponseDto.class, response);
    }
}