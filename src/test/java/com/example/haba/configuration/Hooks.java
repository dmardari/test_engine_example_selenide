package com.example.haba.configuration;

import com.example.haba.selenium.DriverWrapper;
import io.cucumber.java.After;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration
@SpringBootTest
public class Hooks {

    @After
    public void closeBrowser() {
        if (DriverWrapper.isOpened()) {
            WebDriver driver = DriverWrapper.getDriver();
            try {
                driver.close();
            } finally {
                driver.quit();
            }
        }
    }
}
