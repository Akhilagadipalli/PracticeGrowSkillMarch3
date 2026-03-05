
@sanity @smoke
Feature: Login Fuctionality for Demo Guru 99

  Scenario Outline: Validate Login Functionality
    Given user opens the browser URL
    And user enters the username as "<username>"
    And user enters the password as "<password>"
    When user click on the login button
   Then validate user navigate to the Homepage of applications
And user closes the browser
    Examples: 
      | username   | password |
      | mngr655088 | arEjeqE  |
