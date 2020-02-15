Feature: Navigation
  As a customer, I want to Navigate through the website

Scenario: Navigate to the blogs page via Navigation menu
    Given I am on the Home page
    When I click the Blogs page link
    Then I am taken to the Blogs page
    And a list of Blogs are shown

Scenario: Navigate to the first Blog article via Blogs section
    Given I am on the Home page
    And I scroll to the Blog section
    When i click first blog
    Then I am taken to the Blogs article page

Scenario: Navigate to the second Blog article via Blogs section
    Given I am on the Home page
    And I scroll to the Blog section
    When i click second blog
    Then I am taken to the Blogs article page

Scenario: Navigate to the third Blog article via Blogs section
    Given I am on the Home page
    And I scroll to the Blog section
    When i click third blog
    Then I am taken to the Blogs article page

Scenario: Search for Mulesoft via Navigation menu
    Given I am on the Home page
    When I search for Mulesoft via search menu
    Then I am shown search results containing mulesoft on the search results page