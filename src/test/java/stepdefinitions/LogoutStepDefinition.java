package stepdefinitions;

import org.testng.Assert;

import base.BaseTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.LoginPage;
import pages.LogoutPage;

public class LogoutStepDefinition
        extends BaseTest {

    LogoutPage logout;

    @When("User logs in")
    public void user_logs_in() {

        LoginPage login =
                new LoginPage(driver);

        login.clickMyAccount();

        login.clickLogin();

        login.enterEmail(
                "nikitajadhav123@gmail.com");

        login.enterPassword("Nikita@123");

        login.clickLoginButton();
    }

    @And("User clicks logout")
    public void user_clicks_logout() {

        logout = new LogoutPage(driver);

        logout.clickLogout();
    }

    @Then("User should logout successfully")
    public void user_should_logout_successfully() {

        Assert.assertTrue(
                logout.getLogoutMessage()
                        .contains("Account Logout"));

        tearDown();
    }
}