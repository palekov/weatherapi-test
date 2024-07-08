@positiveTest
Feature: Get current weather

  Scenario Outline: Get current weather by city name
    When I requesting current weather for the city "<CITY_NAME>"
    Then I receive <RESPONSE> code
    And I receive correct json response for the city "<CITY_NAME>"

    Examples:
      | CITY_NAME | RESPONSE |
      | Moscow    |   200    |
      | Minsk     |   200    |
      | Ankara    |   200    |
      | Chicago   |   200    |
      | London    |   200    |