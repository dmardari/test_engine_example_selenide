package com.example.haba.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// TODO 19/04/2021: switch to Spring service
public class DriverWrapper {

    private static final Object LOCK = new Object();

    private static WebDriver driver = null;

    public static WebDriver getDriver() {
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

    public static boolean isOpened() {
        synchronized (LOCK) {
            return driver != null;
        }
    }
}
