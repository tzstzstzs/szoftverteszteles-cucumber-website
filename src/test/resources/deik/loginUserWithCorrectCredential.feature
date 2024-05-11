Feature: Login user with correct credentials
  Background:
    Given Homepage is opened

  Scenario Outline: Successfully login and logout user
    Given the user clicks on Login link: "/html/body/header/div/div/div/div[2]/div/ul/li[4]/a"
    Then 'Login to your account' text should be visible
    When '<email>' and '<password>' entered
    And Login button is clicked
    Then logged in as '<name>' is visible
    Then Logout link is clicked
    Examples:
      | email           | password  | name            |
      | user99@user.com  | 123456    | user99         |
      | user111@user.com | 123456    | user111 Suzy   |
      | user222@user.com | 123456    | user222 Geza   |
      | user333@user.com | 123456    | user333        |
      | user444@user.com | 123456    | user444        |