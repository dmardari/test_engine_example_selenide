package com.example.haba.selenium;

import com.example.haba.Config;
import com.example.haba.pageobject.MainSite;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtlasService {

    @Autowired
    WebDriverService driverService;

    @Autowired
    Config config;

    public <T> T getPage(Class<T> clazz) {
        WebDriver driver = driverService.getDriver();
        Atlas atlas = new Atlas(new WebDriverConfiguration(driver, config.url));
        return clazz.cast(atlas.create(driver, MainSite.class));
    }
}
