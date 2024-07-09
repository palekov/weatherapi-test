package org.palekov.weathertest.assertions;

import org.assertj.core.api.AbstractAssert;
import org.palekov.weathertest.models.WeatherResponseDto;

import java.util.Objects;

import static org.palekov.weathertest.assertions.AssertionConstants.FIELD_VERIFICATION_FAILURE_MESSAGE;
import static org.palekov.weathertest.assertions.AssertionConstants.FIELD_VERIFICATION_RESPONSE_MESSAGE;

/**
 * Custom AssertJ assertion for validation of API response {@linkplain WeatherResponseDto}.
 */
public class WeatherResponseDtoAssertion extends AbstractAssert<WeatherResponseDtoAssertion, WeatherResponseDto> {

    protected WeatherResponseDtoAssertion(WeatherResponseDto response, Class<?> selfType) {
        super(response, selfType);
    }

    public WeatherResponseDtoAssertion(WeatherResponseDto actual) {
        this(actual, WeatherResponseDtoAssertion.class);
    }

    public WeatherResponseDtoAssertion hasLocationName(String expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getName(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "location.name",
                    expected, actual.getLocation().getName());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasRegion(String expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getRegion(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "location.region",
                    expected, actual.getLocation().getRegion());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasCountry(String expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getCountry(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "location.country",
                    expected, actual.getLocation().getCountry());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasLat(Float expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getLat(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "location.lat",
                    expected, actual.getLocation().getLat());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasLon(Float expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getLon(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "location.lon",
                    expected, actual.getLocation().getLon());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasTzId(String expected) {
        isNotNull();
        if (!Objects.equals(actual.getLocation().getTzId(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "location.tz_id",
                    expected, actual.getLocation().getTzId());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasLocaltimeEpoch() {
        if (actual.getLocation().getLocaltimeEpoch() == null || actual.getLocation().getLocaltimeEpoch() == 0) {
            failWithMessage(FIELD_VERIFICATION_RESPONSE_MESSAGE, "location.localtime_epoch", actual);
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasLocaltime() {
        if (actual.getLocation().getLocaltime() == null) {
            failWithMessage(FIELD_VERIFICATION_RESPONSE_MESSAGE, "location.localtime", actual);
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasLastUpdatedEpoch() {
        if (actual.getCurrent().getLastUpdatedEpoch() == null || actual.getCurrent().getLastUpdatedEpoch() == 0) {
            failWithMessage(FIELD_VERIFICATION_RESPONSE_MESSAGE, "current.last_updated_epoch", actual);
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasLastUpdated() {
        if (actual.getCurrent().getLastUpdated() == null) {
            failWithMessage(FIELD_VERIFICATION_RESPONSE_MESSAGE, "current.last_updated", actual);
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasTempC(Float expected) {
        isNotNull();
        if (!Objects.equals(actual.getCurrent().getTempC(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "current.temp_c", expected, actual.getCurrent().getTempC());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasTempF(Float expected) {
        isNotNull();
        if (!Objects.equals(actual.getCurrent().getTempF(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "current.temp_f", expected, actual.getCurrent().getTempF());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasIsDay(Integer expected) {
        isNotNull();
        if (!Objects.equals(actual.getCurrent().getIsDay(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "current.is_day", expected, actual.getCurrent().getIsDay());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasConditionText(String expected) {
        isNotNull();
        if (!Objects.equals(actual.getCurrent().getCondition().getText(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "current.condition.text", expected,
                    actual.getCurrent().getCondition().getText());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasConditionIcon(String expected) {
        isNotNull();
        if (!Objects.equals(actual.getCurrent().getCondition().getIcon(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "current.condition.icon", expected,
                    actual.getCurrent().getCondition().getIcon());
        }
        return this;
    }

    public WeatherResponseDtoAssertion hasConditionCode(Integer expected) {
        isNotNull();
        if (!Objects.equals(actual.getCurrent().getCondition().getCode(), expected)) {
            failWithMessage(FIELD_VERIFICATION_FAILURE_MESSAGE, "current.condition.code", expected,
                    actual.getCurrent().getCondition().getCode());
        }
        return this;
    }

    // TODO: other assertions
}

