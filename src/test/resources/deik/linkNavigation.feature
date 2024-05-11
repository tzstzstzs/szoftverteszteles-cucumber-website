Feature: Link navigation verification
  Background:
    Given Homepage is opened

  Scenario Outline: User clicks on a link text and navigates to the correct page
    Given I am on the homepage of "https://automationexercise.com"
    When I click on the link named '<link_name>'
    Then I should be redirected to '<webpage>'
    Examples:
      | link_name   | webpage                                         |
      | products    | https://automationexercise.com/products         |
      | view_cart   | https://automationexercise.com/view_cart        |
      | login       | https://automationexercise.com/login            |
      | test_cases  | https://automationexercise.com/test_cases       |
      | api_list    | https://automationexercise.com/api_list         |