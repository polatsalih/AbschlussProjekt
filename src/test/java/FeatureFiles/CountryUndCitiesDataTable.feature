Feature: Country functionality

  Scenario: Creat a country


    Given Navigate to basqar
    When Enter username and password and click login button
    Then User login successfully


    When user click on the element in the leftNav Class
    | setup|
    | parameters|
    | countries|


    When user click on the element in the dialogContent
      | addFormButton|

    When user send the keys on the element in the dialogContent
      | formCountryName| cikolataUlkesi4|
      | formCode| 123|

    When user click on the element in the dialogContent
      | formSave|

    Then "Success" message should be displayed


    When user click on the element in the leftNav Class
      | cities|

    And user click on the element in the dialogContent
      | addFormButton|
      | dropDown|

    And user select "cikolataUlkesi4"

    And user send the keys on the element in the dialogContent
      | formName| Ay|

    And user click on the element in the dialogContent
      | formSave|

    Then "Success" message should be displayed


    When user click on the element in the leftNav Class
      | countries|

And user delete "cikolataUlkesi4"

    Then "Error" message should be displayed












