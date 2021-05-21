package com.example.haba.steps;

import com.example.haba.execution.ScenarioContext;
import com.example.haba.pageobject.CartPage;
import com.example.haba.pageobject.MainPage;
import com.example.haba.pageobject.PageTemplate;
import com.example.haba.pageobject.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;

public class CartSteps {

    @Autowired
    ScenarioContext scenarioContext;
    @Autowired
    CartPage cartPage;
    @Autowired
    MainPage mainPage;
    @Autowired
    ProductPage productPage;
    @Autowired
    PageTemplate pageTemplate;

    @Given("cart page is open")
    public void cartPageIsOpen() {
        mainPage.cartLink().click();
    }

    @Then("cart is empty")
    public void cartIsEmpty() {
        cartPage.emptyCartBlock().isDisplayed();
    }

    @When("add to cart button is pressed")
    public void addToCartButtonIsPressed() {
        scenarioContext.save("product", productPage.productTitle().getText());
        productPage.addToCartButton().click();
    }

    @Then("cart popup appears")
    public void cartPopupAppears() {
        pageTemplate.miniCartPopup().should(appear);
    }

    @And("cart popup contains {int} product(s)")
    public void cartPopupContainsNumberOfProducts(int expectedItemsCount) {
        pageTemplate.miniCartPopupElements().shouldHave(size(expectedItemsCount));
    }

    @And("cart popup contains selected product")
    public void cartPopupContainsSelectedProduct() {
        String product = scenarioContext.get("product", String.class);
        pageTemplate.miniCartPopupElements().shouldHave(itemWithText(product));
    }

    @Then("cart contains {int} product(s)")
    public void cartContainsProduct(int expectedItemsCount) {
        cartPage.productItems().shouldHave(size(expectedItemsCount));
    }

    @And("cart contains selected product")
    public void cartContainsSelectedProduct() {
        String product = scenarioContext.get("product", String.class);
        cartPage.productItems().shouldHave(itemWithText(product));
    }

    @When("remove button is pressed for selected product")
    public void removeButtonIsPressedForSelectedProduct() {
        String product = scenarioContext.get("product", String.class);
        cartPage.productItemRemoveButton(product).click();

    }

    @Then("alert with text {string} appears on the page")
    public void alertWithTextAppearsOnThePage(String expectedText) {
        cartPage.alertInfo().shouldHave(text(expectedText));
    }
}
