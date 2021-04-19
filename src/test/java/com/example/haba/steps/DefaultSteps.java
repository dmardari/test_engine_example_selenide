package com.example.haba.steps;

import com.example.haba.selenium.DriverWrapper;
import io.cucumber.java.en.Given;

public class DefaultSteps {
    @Given("empty step")
    public void emptyStep() {
        // nothing should be here
    }

    @Given("page {string} is opened")
    public void pageWithUrlIsOpened(String url) {
        DriverWrapper.getDriver().get(url);
    }
}
