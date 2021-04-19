package com.example.haba.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

@Service
public class WebDriverService {

    private final Object LOCK = new Object();

    private WebDriver driver = null;

    public WebDriver getDriver() {
        synchronized (LOCK) {
            if (driver == null) {
                // TODO 19/04/2021: hardcoded for now
                System.setProperty("webdriver.chrome.driver", "src/main/resources/selenium/driver/macos/chromedriver");

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized", "--disable-notifications");
                driver = new ChromeDriver(options);
            }
        }
        return driver;
    }

    public boolean isOpened() {
        synchronized (LOCK) {
            return driver != null;
        }
    }
}
