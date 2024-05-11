Feature: Register user with existing e-mail
  Background:
    Given Homepage is opened

    Scenario Outline: Deny registration with existing e-mail
      Given the user clicks on Login link: "/html/body/header/div/div/div/div[2]/div/ul/li[4]/a"
      Then 'New User Signup!' should be visible
      When the user enters name '<Username>' and email '<E-mail>'
      And Signup button is clicked
      Then error message should be visible: "Email Address already exist!"
      Examples:
        | E-mail           | Username  |
        | user99@user.com  | user99    |
        | user111@user.com | user111   |
        | user222@user.com | user222   |
        | user333@user.com | user333   |
        | user444@user.com | user444   |