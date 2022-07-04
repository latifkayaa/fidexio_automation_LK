@login
Feature: Login functionality and 'Reset password' title verification
  User Story:
  As a user, I should be able to log in so that I can land on homepage

  Accounts are: posManager, salesManager


  Background: For the scenarios in the feature file user is expected to be on login page
    Given user is on the login page

  Scenario Outline:Verify that Users can login with valid credentials
    When user enters valid username "<username>"
    And user enters valid password "<password>"
    And user clicks the Log in button
    Then user should land on home page
    Examples:
      | username                | password     |
      | posmanager15@info.com   | posmanager   |
      | posmanager100@info.com  | posmanager   |
      | posmanager150@info.com  | posmanager   |
      | salesmanager50@info.com | salesmanager |
      | salesmanager65@info.com | salesmanager |
      | salesmanager85@info.com | salesmanager |

  Scenario Outline: Verify that "Wrong login/password" should be displayed for invalid (valid username-invalid password and
  invalid username-valid password) credentials
    When user enters invalid-valid username "<username>"
    And user enters invalid-valid password "<password>"
    And user clicks the Log in button
    Then Wrong login-password error message should be displayed.
    Examples:
      | username                | password           |
      | salesmanager50@info.com | 15790              |
      | salesmanager65@info.com | abc123             |
      | salesmanager85@info.com | qwe654             |
      | posmanager15@info.com   | 456tyu             |
      | posmanager100@info.com  | 876fbv             |
      | posmanager150@info.com  | 987hyt             |
      | abc123@info.com         | salesmanager       |
      | qwe987@gmail.com        | salesmanager       |
      | salm157@info.com        | salesmanager       |
      | posm123@yahoo.com       | posmanager         |
      | posm988@info.com        | posmanager         |
      | posm061@info.com        | posmanager         |
      | sal56@info.com          | salesmanager377543 |
      | possal871@info.com      | salesmanager348    |
      | salpos234@info.com      | salposmanager      |
      | qwelk_b97@info.com      | possalmanager      |


  Scenario Outline: Verify that "Please fill out this field" message should be displayed if the password field is empty
    When user enters valid username "<username>"
    And user clicks the Log in button
    Then Please fill out this field error message should be displayed for password
    Examples:
      | username                |
      | salesmanager50@info.com |
      | salesmanager65@info.com |


  Scenario Outline: Verify that "Please fill out this field" message should be displayed if the username field is empty
    When user enters valid password "<password>"
    And user clicks the Log in button
    Then Please fill out this field error message should be displayed for username
    Examples:
      | password     |
      | salesmanager |
      | posmanager   |

  Scenario Outline: Verify that ‘Enter’ key of the keyboard is working correctly on the login page.
    When user enters valid username "<username>"
    And user enters valid password "<password>"
    And user presses the ENTER key of the keyboard
    Then user should land on home page
    Examples:
      | username               | password   |
      | posmanager15@info.com  | posmanager |
      | posmanager100@info.com | posmanager |

  Scenario: Verify that ‘Enter’ key of the keyboard is working correctly on the login page.
    When user presses the ENTER key of the keyboard
    Then Please fill out this field error message should be displayed for username


  Scenario: User land on the ‘reset password’ page after clicking on the "Reset password" button.
    When user clicks the Reset password button
    Then user should land on the ‘reset password’ page


  Scenario: Verify that when user enters password, he sees them as bullet signs by default
    When user enters valid password "<password>"
    Then user sees the password as masked