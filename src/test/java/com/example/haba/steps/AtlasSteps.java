package com.example.haba.steps;

import com.example.haba.pageobject.MainPage;
import com.example.haba.pageobject.MainSite;
import com.example.haba.selenium.AtlasService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

public class AtlasSteps {

    @Autowired
    AtlasService atlasService;

    @Given("main page is opened")
    public void mainPageIsOpened() {
        MainSite site = atlasService.get(MainSite.class);
        site.mainPage().open();
    }

    @Then("main page contains header")
    public void mainPageContainsHeader() {
        MainSite site = atlasService.get(MainSite.class);
        site.mainPage().header().isDisplayed();
    }

    @And("welcome popup is closed")
    public void welcomePopupIsClosed() {
        MainPage mainPage = atlasService.get(MainSite.class).mainPage();
        if (mainPage.findElements(By.xpath("//*[@id = 'cssLightbox']")).size() > 0)
            mainPage.welcomeToHabaBannerClose().click();
    }

    @And("cookies popup is closed")
    public void cookiesPopupIsClosed() {
        MainPage mainPage = atlasService.get(MainSite.class).mainPage();
        if (mainPage.findElements(By.xpath("//button[@id = 'onetrust-accept-btn-handler']")).size() > 0)
            mainPage.acceptAllCookiesButton().click();
    }
}
