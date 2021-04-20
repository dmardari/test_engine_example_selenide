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

  Scenario: Any element can be added to cart
    Given random navigation button is pressed
    And random available product tile is pressed
    When add to cart button is pressed
    Then cart popup appears
    And cart popup contains 1 product
    And cart popup contains selected product
    When cart page is open
    Then cart contains 1 product
    And cart contains selected product