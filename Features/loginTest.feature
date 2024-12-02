Feature: Login functionality

  Scenario: Login successful with valid credentials
    Given user is on the login page
    When user enters the valid username and password
    And user clicks the login button
    Then user navigates to the login page and click logout
