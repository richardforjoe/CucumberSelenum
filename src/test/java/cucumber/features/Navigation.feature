Feature: Navigation
  As a customer, I want to Navigate through the website

Scenario: Navigate to the blogs page via Navigation menu
    Given I am on the Home page
    When I click the Blogs page link
    Then I am taken to the Blogs page
    And a list of Blogs are shown

Scenario: Navigate to the blogs page via Blogs section
    Given I am on the Home page
    And I scroll to the Blog section
    When i click first blog
    Then I am taken to the Blogs article page
