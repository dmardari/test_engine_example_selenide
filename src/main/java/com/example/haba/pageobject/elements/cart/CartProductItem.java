package com.example.haba.pageobject.elements.cart;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CartProductItem extends AtlasWebElement {
    @FindBy(".//*[contains(@class, 'name')]")
    AtlasWebElement name();
}
