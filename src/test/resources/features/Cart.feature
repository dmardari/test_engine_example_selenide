Feature: Cart
  As a HABA Customer I want to add an item to the shopping cart to be able to
  collect all items before I finalize the shopping.

  Background: All default popups (country selection, GDPR) should be closed before running any test
    Given main page is opened
    And welcome popup is closed
    And cookies popup is closed


  Scenario: Cart is always empty by default
    Given cart page is open
    Then cart is empty
    And cart contains 0 products
    And cart popup contains 0 products


  Scenario: Customer can add any available item to cart
    Given random navigation button is pressed
    And random available product tile is pressed

    When add to cart button is pressed
    Then cart popup appears
    And cart popup contains 1 product
    And cart popup contains selected product

    When cart page is open
    Then cart contains 1 product
    And cart contains selected product


  Scenario: Customer can remove item from cart
    Given random navigation button is pressed
    And random available product tile is pressed
    And add to cart button is pressed
    And cart page is open

    When remove button is pressed for selected product
    Then alert with text 'Product has been removed from your cart.' appears on the page
    And cart contains 0 products
    And cart popup contains 0 products