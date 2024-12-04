Feature: Registration functionality

  Scenario: Registraton flow with valid details
    Given user is on registration page
    When user enters the details in the respective fields
      | FirstName | Will       |
      | LastName  | jack       |
      | Phone     | 9988776655 |
    And user accept the terms and click the submit button
    Then user navigates to the Registration page with confirmation message
