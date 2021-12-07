@Web @Saucedemo @Login
Feature: User be able to login

  Background:
    Given user open saucedemo homepage

  @standard-user @positive @login
  Scenario: user success login using valid data
    When standard user input email
    And standard user input password
    And user click login button
    Then standard user see homepage