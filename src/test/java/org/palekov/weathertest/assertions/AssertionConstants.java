package org.palekov.weathertest.assertions;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AssertionConstants {

    public final String FIELD_VERIFICATION_FAILURE_MESSAGE =
            "Verification for '%s' field failed: Expected value is: '%s'. Actual value is: '%s'.";

    public final String FIELD_VERIFICATION_RESPONSE_MESSAGE = "Value '%s' must be present on response %s";

}
