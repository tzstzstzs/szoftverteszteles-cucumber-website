Feature: Login user with incorrect credentials
  Background:
  Given Homepage is opened

  Scenario Outline: Deny access of user with incorrect credentials
    Given the user clicks on Login link: "/html/body/header/div/div/div/div[2]/div/ul/li[4]/a"
    Then 'Login to your account' text should be visible
    When '<email>' and '<password>' entered
    And Login button is clicked
    Then error message should be displayed: "Your email or password is incorrect!"
    Examples:
      | email            | password  |
      | user99@user.com  | 1234      |
      | user111@user     | 123456    |
      | user222user.@com | 123456    |
      | user333@user.com | 123 456   |
      | user444@u        | 123456    |