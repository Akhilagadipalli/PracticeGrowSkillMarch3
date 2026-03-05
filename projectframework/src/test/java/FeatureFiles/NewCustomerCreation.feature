@smoke 

Feature: Creation of new Customer

  Background: 
    Given user opens the browser URL
    And user enters the username as "mngr655088"
    And user enters the password as "arEjeqE"
    When user click on the login button
    Then validate user navigate to the Homepage of applications

  Scenario: Create new customer using DataTable
  Given user is on the homepage of the application
  And user click on the new customer link 
  When user enters the customer details
      | cust_name | dob        | address   | city      | state     | pin    | mobile     | email  | password   |
      | Akhila    | 2024-10-20 | Hyderabad | Hyderabad | telangana | 502311 | 9876543210 | akhila | Akhila@123 |
And user click on the submit button 
Then a new customer will be created
And user caputures the customerId
And verify customerId in excel sheet
And user closes the browser

 #Scenario Outline: Create new account using captured customer id
    #Given user click on new account link
    #And user enters the customer id from excel
    #And user selects account type as "<AccountType>"
    #And user enters initial deposit as "<Deposit>"
    #When user click on account submit button
    #Then account should be created successfully
    #And user captures the account id
#
    #Examples: 
      #| AccountType | Deposit |
      #| Savings     |    5000 |
