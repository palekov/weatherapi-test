@getCurrentWeather
Feature: Get get current weather

  Scenario Outline: Get get current weather by city name
    When I requesting current weather for the city "<CITY_NAME>"
    Then I receive <RESPONSE> code

    Examples:
      | CITY_NAME | RESPONSE |
      | Moscow    |   200    |
      | Minsk     |   200    |
      | Ankara    |   200    |
      | Chicago   |   200    |
      | London    |   200    |