package org.palekov.weathertest.assertions;

import org.assertj.core.api.AbstractAssert;
import org.palekov.weathertest.models.WeatherResponseDto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Custom AssertJ assertion for validation of API response {@linkplain WeatherResponseDto}.
 */
public class WeatherResponseDtoAssertion extends AbstractAssert<WeatherResponseDtoAssertion, WeatherResponseDto> {

    private final String FIELD_VERIFICATION_FAILURE_MESSAGE =
            "Verification for '%s' field failed: Expected value is: '%s'. Actual value is: '%s'.";

    protected WeatherResponseDtoAssertion(WeatherResponseDto response, Class<?> selfType) {
        super(response, selfType);
    }

    public WeatherResponseDtoAssertion(WeatherResponseDto actual) {
        this(actual, WeatherResponseDtoAssertion.class);
    }

    public WeatherResponseDtoAssertion hasLocationName(String expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getName(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "name", expected, actual.getLocation().getName());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasRegion(String expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getRegion(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "region", expected, actual.getLocation().getRegion());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasCountry(String expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getCountry(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "country", expected, actual.getLocation().getCountry());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasLat(Float expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getLat(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "lat", expected, actual.getLocation().getLat());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasLon(Float expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getLat(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "lat", expected, actual.getLocation().getLat());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasTzId(String expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getTzId(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "lat", expected, actual.getLocation().getTzId());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasLocaltimeEpoch(Long expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getLocaltimeEpoch(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "lat", expected, actual.getLocation().getLocaltimeEpoch());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasLocaltime(LocalDateTime expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getLocaltime(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "lat", expected, actual.getLocation().getLocaltime());
        }
        return this;
    }


}

