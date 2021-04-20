package com.example.haba.pageobject;

import com.example.haba.pageobject.elements.ProductTile;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ProductListPage extends PageTemplate {

    @FindBy("//li[contains(@class, 'product-tile')]")
    ElementsCollection<ProductTile> products();
}
