Feature: Link navigation verification

  Scenario Outline: User clicks on a link text and navigates to the correct page
    Given I am on the homepage of "https://automationexercise.com"
    When I click on the link with xpath '<link>'
    Then I should be redirected to '<webpage>'
    Examples:
      | link                                                 | webpage                                        |
      | /html/body/header/div/div/div/div[2]/div/ul/li[2]/a  | https://automationexercise.com/products        |
