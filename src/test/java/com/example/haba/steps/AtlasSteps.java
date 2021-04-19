package com.example.haba.steps;

import com.example.haba.Config;
import com.example.haba.pageobject.MainSite;
import com.example.haba.selenium.DriverWrapper;
import io.cucumber.java.en.Given;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class AtlasSteps {

    @Autowired
    Config config;

    @Given("main page is opened")
    public void mainPageIsOpened() {
        WebDriver driver = DriverWrapper.getDriver();
        Atlas atlas = new Atlas(new WebDriverConfiguration(driver, config.url));
        MainSite site = atlas.create(driver, MainSite.class);
        site.mainPage().open();
    }
}
