Feature: User Registration and Deletion on Automation Exercise Site

  Scenario Outline: Successfully register and delete a user
    Given the user clicks on "/html/body/header/div/div/div/div[2]/div/ul/li[4]/a"
    Then 'New User Signup!' should be visible
    When the user enters name '<Username>' and email '<E-mail>'
    And Signup button is clicked
    Then 'ENTER ACCOUNT INFORMATION' should be displayed
    When the '<Title>' button is selected
    And the 'Name' field is filled with '<Name>'
    And the 'Password' field is filled with '<Password>'
    And the '<Day>', '<Month>' and '<Year>' of birth is set
    And newsletter checkbox is checked
    And partners checkbox is checked
    And the 'FirstName' field is filled with '<FirstName>'
    And the 'LastName' field is filled with '<LastName>'
    And the 'Address' field is filled with '<Address>'
    And the '<Country>' is seleced
    And the 'State' field is filled with '<State>'
    And the 'City' field is filled with '<City>'
    And the 'Zipcode' field is filled with '<Zipcode>'
    And the 'MobileNumber' field is filled with '<MobileNumber>'
    And Create Account button is clicked
    Then '<Message>!' should be seen
    When Continue button is clicked
    Then logged in as '<Name>' label is seen
    When Delete button is clicked
    Then Account deleted text should be seen
    Examples:
      | Username  | E-mail          | Title   | Name         | Password | Day | Month | Year | FirstName   | LastName    | Address       | Country     | State       | City     | Zipcode | MobileNumber  | Message         |
      | user77    | user77@user.com | Mrs     | User77 Anna  | 123456   | 1   | 4     | 2000 | Anna        | User77      | P.O. Box 77   | Australia   | Queensland  | Brisbane | 12345   | 1234567890    | ACCOUNT CREATED |
