Feature: Login functionality using Data Driver

  Scenario Outline: Login Data Driven Excel
    When user navigates to login page
    Then user redirected to the Myaccount page by passing username and password from the excel "<index_count>"

    Examples: 
      | index_count |
      |           1 |
      |           2 |
      |           3 |
      |           4 |
