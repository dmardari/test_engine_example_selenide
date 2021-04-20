package com.example.haba.steps;

import com.example.haba.execution.ScenarioContext;
import com.example.haba.pageobject.CartPage;
import com.example.haba.pageobject.MainSite;
import com.example.haba.pageobject.PageTemplate;
import com.example.haba.pageobject.ProductPage;
import com.example.haba.pageobject.elements.cart.CartProductItem;
import com.example.haba.pageobject.elements.cartpopup.CartPopupItem;
import com.example.haba.selenium.AtlasService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.awaitility.Durations.TEN_SECONDS;
import static org.awaitility.pollinterval.FibonacciPollInterval.fibonacci;
import static org.hamcrest.Matchers.*;

public class CartSteps {

    @Autowired
    ScenarioContext scenarioContext;
    @Autowired
    AtlasService atlasService;

    @Given("cart page is open")
    public void cartPageIsOpen() {
        MainSite site = atlasService.get(MainSite.class);
        site.mainPage().cartLink().click();
    }

    @Then("cart is empty")
    public void cartIsEmpty() {
        CartPage page = atlasService.get(CartPage.class);
        page.emptyCartBlock().isDisplayed();
    }

    @When("add to cart button is pressed")
    public void addToCartButtonIsPressed() {
        ProductPage productPage = atlasService.get(ProductPage.class);
        scenarioContext.save("product", productPage.productTitle().getText());
        productPage.addToCartButton().click();
    }

    @Then("cart popup appears")
    public void cartPopupAppears() {
        PageTemplate page = atlasService.get(PageTemplate.class);
        await("wait for cart popup to appear") // TODO 20/04/2021: consider AtlasWebElement::should
                .atMost(TEN_SECONDS)
                .pollInterval(fibonacci(SECONDS))
                .until(() -> page.miniCartPopup().isDisplayed());
    }

    @And("cart popup contains {int} product(s)")
    public void cartPopupContainsNumberOfProducts(int expectedItemsCount) {
        PageTemplate page = atlasService.get(PageTemplate.class);
        page.miniCartPopup().items().should(hasSize(expectedItemsCount));
    }

    @And("cart popup contains selected product")
    public void cartPopupContainsSelectedProduct() {
        String product = scenarioContext.get("product", String.class);
        PageTemplate page = atlasService.get(PageTemplate.class);
        page.miniCartPopup()
                .items()
                .extract(CartPopupItem::name)
                .should(hasItem(hasProperty("text", equalTo(product))));
    }

    @Then("cart contains {int} product(s)")
    public void cartContainsProduct(int expectedItemsCount) {
        CartPage page = atlasService.get(CartPage.class);
        page.productItems().should(hasSize(expectedItemsCount));
    }

    @And("cart contains selected product")
    public void cartContainsSelectedProduct() {
        String product = scenarioContext.get("product", String.class);
        CartPage page = atlasService.get(CartPage.class);
        page.productItems()
                .extract(CartProductItem::name)
                .should(hasItem(hasProperty("text", equalTo(product))));
    }

    @When("remove button is pressed for selected product")
    public void removeButtonIsPressedForSelectedProduct() {
        String product = scenarioContext.get("product", String.class);
        CartPage page = atlasService.get(CartPage.class);
//        page.productItem(product).removeButton().click(); // TODO 20/04/2021: broken library: unable to find removeButton() on page
        page.productItems()
                .filter(item -> product.equals(item.name().getText()))
                .get(0).removeButton().click(); // not recommended according to Atlas docs

    }

    @Then("alert with text {string} appears on the page")
    public void alertWithTextAppearsOnThePage(String expectedText) {
        CartPage page = atlasService.get(CartPage.class);
        page.alertInfo().should(hasProperty("text", containsString(expectedText)));
    }
}
