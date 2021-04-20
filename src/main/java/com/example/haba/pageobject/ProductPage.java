package com.example.haba.pageobject;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ProductPage extends PageTemplate{
    @FindBy("//button[@id = 'addToCartButton']")
    AtlasWebElement addToCartButton();

    @FindBy("//div[contains(@class, 'product-title')]")
    AtlasWebElement productTitle();
}
