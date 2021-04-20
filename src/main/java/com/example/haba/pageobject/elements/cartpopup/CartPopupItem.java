package com.example.haba.pageobject.elements.cartpopup;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CartPopupItem extends AtlasWebElement {
    @FindBy(".//*[contains(@class, 'name')]")
    AtlasWebElement name();

    @FindBy(".//*[contains(@class, 'qty')]")
    AtlasWebElement qty();
}
