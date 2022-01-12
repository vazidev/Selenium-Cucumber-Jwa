Feature: feature to test login functionality

  Scenario Outline: Check login is successful with valid credentials
    Given user is on the login page
    When user enters <username> and <password>
    And clicks on the login button
    Then  user is navigated to the Home page that should contain <message>


#Data Driven Testing/Parametarization
    Examples:
      | username | password | message |
      | Tufail   | 12345    | Tufail  |
      | Richard  | 12345    | Richard |
      | Neena    | 12345    | Neena   |
      | Vazidev  | 12345    | Vazidev |
