package com.example.haba.pageobject;

import com.example.haba.pageobject.elements.cartpopup.CartPopup;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface PageTemplate extends WebPage {

    // TODO 20/04/2021: may be rewritten as ElementsCollection
    @FindBy("//*[contains(@class, 'mini-cart-icon')]")
    AtlasWebElement cartLink();

    @FindBy("//div[contains(@class, 'mini-cart-link')]/div[contains(@class, 'mini-popup')]")
    CartPopup miniCartPopup();

    @FindBy("//*[contains(@class, 'js-touch-navigation')]")
    ElementsCollection<AtlasWebElement> navigationButtons();
}
