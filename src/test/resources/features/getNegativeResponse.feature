@negativeTest
Feature: Get response with error code

  Scenario Outline: Get current weather with invalid request parameter "<REQUEST_PARAM>"
    When I requesting current weather with body contains invalid parameter "<REQUEST_PARAM>"
    Then I receive <RESPONSE> code and response body with error <ERROR_CODE> and message "<ERROR_MESSAGE>"

    Examples:
      | REQUEST_PARAM                                         | RESPONSE |  ERROR_CODE  | ERROR_MESSAGE                             |
      | /current.json?key=70194649043645f69d770805240707      |    400   |     1003     | Parameter 'q' not provided.               |
      | /current.json?q=x&key=70194649043645f69d770805240707  |    400   |     1006     | No location found matching parameter 'q'  |
      | /current.json?q=Chicago                               |    401   |     1002     | API key not provided.                     |
      | /current.json?q=Minsk&key=xxx                         |    401   |     2006     | API key provided is invalid               |
