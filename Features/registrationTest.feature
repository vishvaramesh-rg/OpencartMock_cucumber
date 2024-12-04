Feature: Registration fuctionality

  Scenario: Registering site with valid user details
    Given user is on the registration page
    When user enters the details in all the fields
    And user accept the terms and clicks the submit button
    Then user receives the account created page and click logout
    And user login with the same credetials
