@logout
  Feature:Log out Functionality
    User Story:
    As a user, I should be able to log out

    Accounts are: posManager, salesManager

    Background:For the scenarios in the feature file user is expected to be on login page
    Given user is on the login page




  Scenario Outline: User can log out and ends up in login page
      When  user enters valid username "<username>"
      And  user enters valid password "<password>"
      And  user clicks the Log in button
      And  User clicks on their username which is on the up right side of the page
      And  User clicks Log out text button
      Then User should land on login page
      Examples:
        | username                | password     |
        | posmanager15@info.com   | posmanager   |
        | posmanager100@info.com  | posmanager   |
        | posmanager150@info.com  | posmanager   |
        | salesmanager50@info.com | salesmanager |
        | salesmanager65@info.com | salesmanager |
        | salesmanager85@info.com | salesmanager |


  Scenario Outline:  The user can not go to the home page again by clicking the step back button after successfully logging out.
    When user enters valid username "<username>"
    And  user enters valid password "<password>"
    And  user clicks the Log in button
    And  User clicks on their username which is on the up right side of the page
    And  User clicks Log out text button
    And  User clicks the go back button which is on the up left corner of the browser page
    And  User sees the Odoo Session Expired text
    And  User clicks the Ok button
    Then User should not be able to go to the home page again and sees the title as Odoo
    Examples:
      | username                | password     |
      | posmanager15@info.com   | posmanager   |
      | posmanager100@info.com  | posmanager   |
      | posmanager150@info.com  | posmanager   |
      | salesmanager50@info.com | salesmanager |
      | salesmanager65@info.com | salesmanager |
      | salesmanager85@info.com | salesmanager |