@smoke
Feature: Create NewAccount

  Background: Given user opens the browser URL
    And user enters the username as "mngr655088"
    And user enters the password as "arEjeqE"
    When user click on the login button
    Then validate user navigate to the Homepage of applications

  Scenario Outline: Create new account using captured customer id
    Given user click on new account link
    And user enters the customer id from excel
    And user selects account type as "<AccountType>"
    And user enters initial deposit as "<Deposit>"
    When user click on account submit button
    Then account should be created successfully
    And user captures the account id
    And verify account id in excel sheet
    And user closes the browser

    Examples: 
      | AccountType | Deposit |
      | Savings     |    5000 |
