@Web @Saucedemo @Login
Feature: User be able to login

  Background:
    Given user open saucedemo homepage

  @non-locked-user @positive @login
  Scenario Outline: user success login using valid data
    When user input <type> username
    And  user input <type> password
    And user click login button
    Then standard user see inventory page

    Examples:
      | type        |
      | standard    |
      | problem     |
      | performance |

  @locked-user @positive @login
  Scenario: locked user can not login and see error message
    When user input locked username
    And user input locked password
    And user click login button
    Then user see error toast displayed
    And user see "Epic sadface: Sorry, this user has been locked out." displayed

  @invalid-data-user @negative @login
  Scenario Outline: user with invalid data can not login and see error message
    When user input <username> username
    And user input <password> password
    And user click login button
    Then user see error toast displayed
    And user see "<message>" displayed

    Examples:
      | username  | password       | message                                                                   |
      | adidrmwan | 123            | Epic sadface: Username and password do not match any user in this service |
      | empty     | empty          | Epic sadface: Username is required                                        |
      | empty     | 123            | Epic sadface: Username is required                                        |
      | adidrmwan | empty          | Epic sadface: Password is required                                        |
      | standard  | wrong-password | Epic sadface: Username and password do not match any user in this service |