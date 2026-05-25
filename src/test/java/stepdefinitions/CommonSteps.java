package stepdefinitions;

import base.BaseTest;

import io.cucumber.java.en.Given;

public class CommonSteps extends BaseTest {

    @Given("User launches the application")
    public void user_launches_the_application() {

        setup();
    }
}