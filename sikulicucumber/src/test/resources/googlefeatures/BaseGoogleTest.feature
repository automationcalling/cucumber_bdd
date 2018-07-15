Feature: This is simple test about to verify google search

  Scenario: Verification of google search
    Given I open a browser
    When I enter the following text in google search page
      | MethodName | Action            |
      | enterText  | automationcalling |
    Then I click on google search button

  Scenario: Verification of google search using reflection and action in datatable
    Given I open a browser
    When I use reusable Sikuli Utils with following actions
      | MethodName      | Action                            |
      | initializeImage | GoogleHomePage.googleTextbox      |
      | enterText       | automationcalling                 |
      | initializeImage | GoogleHomePage.googleSearchButton |
      | clickAction     |                                   |