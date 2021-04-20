package com.example.haba.selenium;

import com.example.haba.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class WebDriverService {

    private final Config config;
    private final Object LOCK = new Object();

    private WebDriver driver = null;

    public WebDriverService(Config config) {
        this.config = config;
    }

    public WebDriver getDriver() {
        synchronized (LOCK) {
            if (driver == null) {
                driver = instantiateDriver(Browser.get(config.browser), "--start-maximized", "--disable-notifications");
            }
        }
        return driver;
    }

    public boolean isClosed() {
        synchronized (LOCK) {
            return driver == null;
        }
    }

    public void closeBrowser() {
        synchronized (LOCK) {
            if (driver != null) {
                try {
                    driver.close();
                } catch (Exception e) {
                    // TODO 20/04/2021: log a warning
                } finally {
                    try {
                        driver.quit();
                    } catch (Exception e) {
                        // TODO 20/04/2021: log a warning
                    } finally {
                        driver = null;
                    }
                }
            }
        }
    }

    private WebDriver instantiateDriver(Browser browser, String... arguments) {
        System.setProperty(browser.driverProperty, "src/main/resources/" + browser.getDriverPath());
        switch (browser) {
            case CHROME:
                return new ChromeDriver(new ChromeOptions().addArguments(arguments));
            case FIREFOX:
                return new FirefoxDriver(new FirefoxOptions().addArguments(arguments));
            case SAFARI:
                return new SafariDriver(new SafariOptions());
            default:
                throw new RuntimeException(format("Could not create a new instance of driver for %s", browser.name));
        }
    }
}
