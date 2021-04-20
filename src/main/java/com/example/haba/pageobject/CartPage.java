package com.example.haba.pageobject;

import com.example.haba.pageobject.elements.cart.CartProductItem;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface CartPage extends PageTemplate {
    @FindBy("//div[contains(@class, 'empty-cart')]")
    AtlasWebElement emptyCartBlock();

    @FindBy("//li[contains(@id, 'productItem')]")
    ElementsCollection<CartProductItem> productItems();

    @FindBy("//li[contains(@id, 'productItem')]//*[contains(@class, 'name') and normalize-space() = '{{ productName }}']")
    CartProductItem productItem(@Param("productName") String productName);

    @FindBy("//div[contains(@class, 'alert-info')]")
    AtlasWebElement alertInfo();
}