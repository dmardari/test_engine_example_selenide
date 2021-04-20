package com.example.haba.pageobject.elements.cartpopup;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CartPopup extends AtlasWebElement {

    @FindBy(".//li[contains(@class, 'mini-cart-item')]")
    ElementsCollection<CartPopupItem> items();
}
