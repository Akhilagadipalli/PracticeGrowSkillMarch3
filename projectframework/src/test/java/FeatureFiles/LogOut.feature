@smoke
Feature: Successfully logout the application

Background:  Given user opens the browser URL
    And user enters the username as "mngr655088"
    And user enters the password as "arEjeqE"
    When user click on the login button
    Then validate user navigate to the Homepage of applications

Scenario: user successfully logout the application
Given user enters the logout button

And user verifies alert message
Then user closes the browser
