Feature: Test the Search functionality on Amazon.com

  Scenario: Test the search functionality
    Given browser is open
    Given user is on the Amazon landing page
    When  user enters a text in the Amazon search box
    And user clicks on the search button
    Then  user is directed to the results page