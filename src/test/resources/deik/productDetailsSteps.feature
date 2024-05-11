Feature: Verify all products text and product detail page
  Background:
    Given Homepage is opened

  Scenario Outline: "ALL PRODUCTS" text is visible and product details are visible
    Given  I click on the link named 'products'
    Then 'ALL PRODUCTS' is visible
    When view product '<button>' is clicked
    Then the '<name>' of the product matches
    And the '<price>' of the product is correct
    And the '<availability>' matches
    Examples:
      | name              | price    | availability           | button                        |
      | Blue Top          | Rs. 500  | Availability: In Stock | a[href="/product_details/1"]  |
      | Men Tshirt        | Rs. 400  | Availability: In Stock | a[href="/product_details/2"]  |
      | Sleeveless Dress  | Rs. 1000 | Availability: In Stock | a[href="/product_details/3"]  |
      | Stylish Dress     | Rs. 1500 | Availability: In Stock | a[href="/product_details/4"]  |
      | Winter Top        | Rs. 600  | Availability: In Stock | a[href="/product_details/5"]  |