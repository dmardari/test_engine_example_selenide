package com.example.haba.steps;

import com.example.haba.pageobject.CartPage;
import com.example.haba.pageobject.MainSite;
import com.example.haba.selenium.AtlasService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class CartSteps {

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
}
