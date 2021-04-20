package com.example.haba.selenium;

import com.example.haba.Config;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
public class AtlasService {

    private static final String atlasWebsiteUrl = "ATLAS_WEBSITE_URL";

    private final WebDriverService driverService;
    private final Config config;

    private final Object LOCK = new Object();

    private Atlas atlas = null;

    public AtlasService(WebDriverService driverService, Config config) {
        this.driverService = driverService;
        this.config = config;
    }

    private Atlas instantiateAtlas() {
        WebDriver driver = driverService.getDriver();
        System.setProperty(atlasWebsiteUrl, config.url); // required for some internal Atlas operations
        return new Atlas(new WebDriverConfiguration(driver, config.url));// TODO 20/04/2021: always defaults to main page
    }

    public <T> T get(Class<T> clazz) {
        synchronized (LOCK) {
            if (atlas == null)
                atlas = instantiateAtlas();
        }
        return clazz.cast(atlas.create(driverService.getDriver(), clazz));
    }
}
