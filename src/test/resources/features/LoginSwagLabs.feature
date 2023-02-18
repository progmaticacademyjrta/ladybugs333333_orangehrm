Feature: Login to SwagLabs in different ways

  Scenario: Login with valid username and valid password
    Given Webpage has been loaded "https://www.saucedemo.com"
    When The user enters the username as "standard_user" and password as "secret_sauce" and click to Login button
    Then the user should be able to login successfully.

  Scenario Outline: Login with invalid username and valid password
    Given Webpage has been loaded "https://www.saucedemo.com"
    When The user enters the username as "<username>" and password as "<password>" and click to Login button
    Then the user should NOT be able to login successfully and "<errorMessage>" error message comes.
    Examples:
      | username      | password      | errorMessage                                                              |
      | standard_user | wrongpassword | Epic sadface: Username and password do not match any user in this service |
      | wrongusername | wrongpassword | Epic sadface: Username and password do not match any user in this service |
      | wrongusername | secret_sauce  | Epic sadface: Username and password do not match any user in this service |
