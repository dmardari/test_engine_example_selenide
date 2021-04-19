package com.example.haba.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        plugin = {"pretty", "html:build/cucumber/pretty"},
        glue = {"com.example.haba"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
