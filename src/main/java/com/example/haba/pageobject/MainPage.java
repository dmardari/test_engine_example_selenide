package com.example.haba.pageobject;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface MainPage extends WebPage {

    @FindBy("//header")
    AtlasWebElement header();

    @FindBy("//*[@id = 'cssLightbox']")
    AtlasWebElement welcomeToHabaBanner();

    @FindBy("//*[contains(@class, 'hffLightbox-close')]")
    AtlasWebElement welcomeToHabaBannerClose();

    @FindBy("//*[contains(@class, 'mini-cart-icon')]")
    AtlasWebElement cartLink();

    @FindBy("//button[@id = 'onetrust-accept-btn-handler']")
    AtlasWebElement acceptAllCookiesButton();
}