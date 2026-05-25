package stepdefinitions;

import org.testng.Assert;

import base.BaseTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.RegisterPage;

public class RegistrationStepDefinition
        extends BaseTest {

    RegisterPage register;

    @When("User navigates to Register page")
    public void user_navigates_to_register_page() {

        register = new RegisterPage(driver);

        register.clickMyAccount();

        register.clickRegister();
    }

    @And("User enters registration details")
    public void user_enters_registration_details() {

        String email =
                "nikita"
                + System.currentTimeMillis()
                + "@gmail.com";

        register.enterFirstName("Nikita");

        register.enterLastName("Jadhav");

        register.enterEmail(email);

        register.enterTelephone("9876543210");

        register.enterPassword("Nikita@123");

        register.enterConfirmPassword("Nikita@123");

        // UPDATED METHOD

        register.clickPrivacyPolicy();
    }

    @And("User clicks Continue button")
    public void user_clicks_continue_button() {

        register.clickContinue();
    }

    @Then("Account should be created successfully")
    public void account_should_be_created_successfully() {

        Assert.assertTrue(
                register.getSuccessMessage()
                        .contains(
                                "Your Account Has Been Created"));

        tearDown();
    }
}