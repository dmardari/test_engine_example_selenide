package com.example.haba.pageobject;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface MainPage extends PageTemplate {

    @FindBy("//header")
    AtlasWebElement header();

    @FindBy("//*[@id = 'cssLightbox']")
    AtlasWebElement welcomeToHabaBanner();

    @FindBy("//*[contains(@class, 'hffLightbox-close')]")
    AtlasWebElement welcomeToHabaBannerClose();

    @FindBy("//button[@id = 'onetrust-accept-btn-handler']")
    AtlasWebElement acceptAllCookiesButton();
}