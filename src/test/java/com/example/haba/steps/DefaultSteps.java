package com.example.haba.steps;

import io.cucumber.java.en.Given;

public class DefaultSteps {

    @Given("empty step")
    public void emptyStep() {
        // nothing should be here
        System.out.println(); // just need a line of code to attach debugger
    }
}
