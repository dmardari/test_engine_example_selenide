package com.example.haba.steps;

import com.example.haba.pageobject.MainSite;
import com.example.haba.selenium.AtlasService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class AtlasSteps {

    @Autowired
    AtlasService atlasService;

    @Given("main page is opened")
    public void mainPageIsOpened() {
        MainSite site = atlasService.getPage(MainSite.class);
        site.mainPage().open();
    }

    @Then("main page contains header")
    public void mainPageContainsHeader() {
        MainSite site = atlasService.getPage(MainSite.class);
        site.mainPage().header().isDisplayed();
    }
}
