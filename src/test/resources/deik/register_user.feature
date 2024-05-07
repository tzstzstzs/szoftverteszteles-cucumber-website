Feature: User Registration and Deletion on Automation Exercise Site

  Scenario Outline: Successfully register and delete a user
    Given the user clicks on "/html/body/header/div/div/div/div[2]/div/ul/li[4]/a"
    Then 'New User Signup!' should be visible
    And the user enters name "user77" and email "user77@user.com"
    Then 'Signup' button is clicked
    And 'ENTER ACCOUNT INFORMATION' should be displayed
    Then the '<Title>' button is selected
    And the 'Name' field is filled with '<Name>'
    Then the 'Password' field is filled with '<Password>'
    Examples:
      | Title   | Name            | Password      |
      | Mrs     | User77 Anna     | 123456        |