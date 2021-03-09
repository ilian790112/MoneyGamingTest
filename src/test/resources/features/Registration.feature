Feature: Registration Page
  Registration Page functionality

  @registration
  Scenario: Register new user
    Given I navigate to "https://moneygaming.qa.gameaccount.com/"
    And I click "Join Now!" button
    And I select title "Mr"
    And I enter firstname and surname:
      | firstName | surName |
      | Ilian     | Topchiev|
    And I check the tickbox with text I accept the Terms and Conditions
    When I click submit button
    Then I should receive a validation message with text "This field is required" under the date of birth box

