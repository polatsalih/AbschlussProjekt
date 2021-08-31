Feature: Country functionality

  Background:


    Given Navigate to basqar
    When Enter username and password and click login button
    Then User login successfully

  Scenario: Creat a country
    And Navigate to country page
    When Create a country
    Then "Success" message should be displayed

  Scenario: Creat a cities
    And Navigate to cities page
    When Create a cities
    Then "Success" message should be displayed


  Scenario: Delete a country
    When User delete the "cikolataUlkesi"
    Then "Error" message should be displayed