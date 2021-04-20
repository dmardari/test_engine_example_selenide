Feature: Cart
  As a HABA Customer I want to add an item to the shopping cart to be able to
  collect all items before I finalize the shopping.

  Background:
  Given main page is opened
    And welcome popup is closed
    And cookies popup is closed

  Scenario: Cart is always empty by default
    Given cart page is open
    Then cart is empty