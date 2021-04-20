package com.example.haba.pageobject.elements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ProductTile extends AtlasWebElement {

    @FindBy(".//*[contains(@class, 'item_inStock')]")
    AtlasWebElement inStock();

    @FindBy(".//*[contains(@class, 'item_deliveredLater')]")
    AtlasWebElement onlyInSpecializedStores();
}
