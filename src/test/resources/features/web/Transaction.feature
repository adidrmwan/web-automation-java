@Web @Saucedemo @Transaction
Feature: User be able to create transaction

  Background:
    Given user open saucedemo homepage

  @transaction-success @positive
  Scenario Outline: standard user be able to create success transaction
    When user input standard username
    And  user input standard password
    And user click login button
    And standard user see inventory page
    And user choose "<product>" name
    And user click cart button
    And user on cart page
    And user validate "<product>" name existing on the cart
    And user click checkout button
    And user on checkout page
    And user input information needed
    And user click continue button
    And user on checkout review page
    And user validate the total prices
    And user click finish button
    Then user on checkout complete page
    And user see the product has been ordered

    Examples:
      | product  |
      | backpack |
      | bike     |
      | bolt     |
      | fleece   |
      | onesie   |



