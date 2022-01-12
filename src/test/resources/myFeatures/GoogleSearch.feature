Feature: feature to test the google login functionality

  Scenario Outline: Validate google search is working
    Given browser is open
    And user is on the google search page
    When  user enters a <text> in the search box
    And hits enter
    Then user is navigated to the <text> results

    #Data Driven Testing/Parametarization
    Examples:
      | text                        |
      | Iphone                      |
      | OnePlus                     |
      | Laptops                     |
      | Razor Gaming Laptop i7 core |