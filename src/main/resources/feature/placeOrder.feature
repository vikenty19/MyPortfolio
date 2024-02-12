Feature:Place the Order
  Scenario: user can place the order
    Given I open url
    And I switch to the book page
    When I enter my name
    And I enter my last name
    And I enter my address
    And I click submit button
    Then I placed the order