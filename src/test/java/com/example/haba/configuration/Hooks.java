package com.example.haba.configuration;

import com.example.haba.selenium.WebDriverService;
import io.cucumber.java.After;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration
@SpringBootTest
public class Hooks {
    @Autowired
    WebDriverService driverService;

    @After
    public void closeBrowser() {
        if (driverService.isOpened()) {
            WebDriver driver = driverService.getDriver();
            try {
                driver.close();
            } finally {
                driver.quit();
            }
        }
    }
}
