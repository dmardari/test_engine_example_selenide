package com.example.haba.pageobject;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface CartPage extends WebPage {

    @FindBy("//header")
    AtlasWebElement header();

    @FindBy("//div[contains(@class, 'empty-cart')]")
    AtlasWebElement emptyCartBlock();

}