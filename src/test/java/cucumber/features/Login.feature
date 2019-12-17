Feature: Homepage login
  As a customer, I want to be able to login to my account

@login
Scenario: Successful login to herokuapp app
    Given User is on Home Page
    When User navigate to Form Authentication
    Then User enters tomsmith and SuperSecretPassword!
    Then User should get logged in with Message displayed You logged into a secure area!


