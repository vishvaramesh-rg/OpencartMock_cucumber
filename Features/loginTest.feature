Feature: Login functionality

  Scenario: Login successful with valid credentials
    Given user is on the login page
    When user enters the valid username and password
    And user clicks the login button
    Then user navigates to the login page and click logout

  Scenario Outline: Login Using Data Driven method
    Given user is on the login page
    When user enters the "<username>" and "<password>"
    And user clicks the login button
    Then user navigates to the login page and click logout

    Examples: 
      | username    | password  |
      | NxsU@gm.com | hwQr@9207 |
      | znjQ@gm.com | TbBC@6211 |
