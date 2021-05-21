package com.example.haba.pageobject;

import com.codeborne.selenide.SelenideElement;
import com.example.haba.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

@Component
public class MainPage extends PageTemplate {

    private Config config;

    @Autowired
    public MainPage(Config config) {
        this.config = config;
    }

    public void visit() {
        open(config.url);
    }

    public SelenideElement welcomeToHabaBanner() {
        return $(xpath("//*[@id = 'cssLightbox']"));
    }

    public SelenideElement welcomeToHabaBannerClose() {
        return $(xpath("//*[contains(@class, 'hffLightbox-close')]"));
    }

    public SelenideElement acceptAllCookiesButton() {
        return $(xpath("//button[@id = 'onetrust-accept-btn-handler']"));
    }
}