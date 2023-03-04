Feature: Login to Orange HRM in different ways

  Scenario: Login with valid username and valid password
    Given Webpage has been loaded "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters the username as "Admin" and password as "admin123" and click to Login button
    Then the user should be able to login successfully.

  Scenario: Login with invalid username and valid password
    Given Webpage has been loaded "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters the username as "wrongUsername" and password as "admin123" and click to Login button
    Then the user should NOT be able to login successfully and "Invalid credentials" error message comes.

  Scenario: Login with valid username and invalid password
    Given Webpage has been loaded "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters the username as "Admin" and password as "admin" and click to Login button
    Then the user should NOT be able to login successfully and "Invalid credentials" error message comes.

  Scenario: Login with invalid username and invalid password
    Given Webpage has been loaded "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters the username as "Admin1" and password as "admin" and click to Login button
    Then the user should NOT be able to login successfully and "Invalid credentials" error message comes.

  Scenario: Login with empty username and valid password
    Given Webpage has been loaded "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters the username as "" and password as "admin123" and click to Login button
    Then the user should NOT be able to login successfully and "Required" error message comes.

  Scenario: Login with valid username and empty password
    Given Webpage has been loaded "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters the username as "Admin" and password as "" and click to Login button
    Then the user should NOT be able to login successfully and "Required" error message comes.

  Scenario: Login with empty username and empty password
    Given Webpage has been loaded "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When The user enters the username as "" and password as "" and click to Login button
    Then the user should NOT be able to login successfully and "Required" error message comes.

