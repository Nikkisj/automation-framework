package stepdefinitions;

import org.testng.Assert;

import base.BaseTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutStepDefinition
        extends BaseTest {

    CheckoutPage checkout;

    @When("User logs in and adds HP product")
    public void user_logs_in_and_adds_hp_product() {

        LoginPage login =
                new LoginPage(driver);

        login.clickMyAccount();

        login.clickLogin();

        login.enterEmail(
                "nikitajadhav123@gmail.com");

        login.enterPassword("Nikita@123");

        login.clickLoginButton();

        checkout = new CheckoutPage(driver);

        checkout.searchProduct("HP LP3065");

        checkout.openHPProduct();

        checkout.addProductToCart();

        checkout.openCart();

        checkout.clickCheckout();
    }

    @And("User completes checkout process")
    public void user_completes_checkout_process() {

        checkout.completeCheckoutProcess();
    }

    @Then("Order should be placed successfully")
    public void order_should_be_placed_successfully() {

        Assert.assertTrue(
                checkout.getSuccessMessage()
                        .contains(
                                "Your order has been placed"));

        tearDown();
    }
}