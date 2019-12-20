Feature: Create account
  As a customer, I want to be able to create an account

@restassured
Scenario: Successfully create an account
    Given a customer does not have an account
    When they register
    Then an employee is created