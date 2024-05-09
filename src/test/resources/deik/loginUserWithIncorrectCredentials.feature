#Feature: Login user with incorrect credentials
#  Background:
#  Given Homepage is opened again
#
#  Scenario Outline: Deny access of user with incorrect credentials
#    Given Login link is clicked: "/html/body/header/div/div/div/div[2]/div/ul/li[4]/a"
#    Then 'Login to your account' text should displayed
#    When incorrect '<email>' and '<password>' entered
#    And Login button is clicked
#    Then error message should be displayed: "Your email or password is incorrect!"
#    Examples:
#      | email            | password  |
#      | user99@user.com  | 1234      |
#      | user111@user     | 123456    |