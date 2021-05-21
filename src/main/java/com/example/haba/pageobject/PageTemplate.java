package com.example.haba.pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class PageTemplate {
    // TODO 20/04/2021: may be rewritten as ElementsCollection
    public SelenideElement cartLink() {
        return $(xpath("//*[contains(@class, 'mini-cart-icon')]"));
    }

    public SelenideElement miniCartPopup() {
        return $(xpath("//div[contains(@class, 'mini-cart-link')]/div[contains(@class, 'mini-popup')]"));
    }

    public ElementsCollection miniCartPopupElements() {
        return miniCartPopup().findAll(xpath(".//li[contains(@class, 'mini-cart-item')]"));
    }

    public ElementsCollection navigationButtons() {
        return $$(xpath("//*[contains(@class, 'js-touch-navigation')]"));
    }

    public SelenideElement welcomeElement() {
        return $(xpath("//*[@id = 'cssLightbox']"));
    }
}
