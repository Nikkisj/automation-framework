package stepdefinitions;

import org.testng.Assert;

import base.BaseTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.LoginPage;

public class LoginStepDefinition extends BaseTest {

    LoginPage login;

    @When("User clicks on My Account")
    public void user_clicks_on_my_account() {

        login = new LoginPage(driver);

        login.clickMyAccount();
    }

    @And("User clicks on Login")
    public void user_clicks_on_login() {

        login.clickLogin();
    }

    @And("User enters valid email")
    public void user_enters_valid_email() {

        login.enterEmail(
                "nikitajadhav123@gmail.com");
    }

    @And("User enters valid password")
    public void user_enters_valid_password() {

        login.enterPassword("Nikita@123");
    }

    @And("User clicks Login button")
    public void user_clicks_login_button() {

        login.clickLoginButton();
    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("account/account"));

        tearDown();
    }

    @And("User enters invalid email")
    public void user_enters_invalid_email() {

        login.enterEmail("wrong@gmail.com");
    }

    @Then("Warning message should be displayed")
    public void warning_message_should_be_displayed() {

        Assert.assertTrue(
                login.getWarningMessage()
                        .contains("Warning"));

        tearDown();
    }
}