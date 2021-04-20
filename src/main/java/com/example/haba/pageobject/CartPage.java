package com.example.haba.pageobject;

import com.example.haba.pageobject.elements.cart.CartProductItem;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CartPage extends PageTemplate {

    @FindBy("//header")
    AtlasWebElement header();

    @FindBy("//div[contains(@class, 'empty-cart')]")
    AtlasWebElement emptyCartBlock();

    @FindBy("//li[contains(@id, 'productItem')]")
    ElementsCollection<CartProductItem> productItems();
}