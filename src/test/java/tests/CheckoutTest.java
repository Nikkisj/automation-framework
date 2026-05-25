package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {

    // Login Method

    public void login() {

        LoginPage login =
                new LoginPage(driver);

        login.clickMyAccount();

        login.clickLogin();

        login.enterEmail("nikitajadhav123@gmail.com");

        login.enterPassword("Nikita@123");

        login.clickLoginButton();
    }

    // 1. Proceed to checkout

    @Test(priority = 1)
    public void proceedToCheckout() {

        login();

        CheckoutPage checkout =
                new CheckoutPage(driver);

        checkout.searchProduct("HP LP3065");

        checkout.openHPProduct();

        checkout.addProductToCart();

        checkout.openCart();

        checkout.clickCheckout();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("checkout"));
    }

    // 2. Verify billing details

    @Test(priority = 2)
    public void verifyBillingDetails() {

        login();

        CheckoutPage checkout =
                new CheckoutPage(driver);

        checkout.searchProduct("HP LP3065");

        checkout.openHPProduct();

        checkout.addProductToCart();

        checkout.openCart();

        checkout.clickCheckout();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Billing Details"));
    }

    // 3. Verify delivery details

    @Test(priority = 3)
    public void verifyDeliveryDetails() {

        login();

        CheckoutPage checkout =
                new CheckoutPage(driver);

        checkout.searchProduct("HP LP3065");

        checkout.openHPProduct();

        checkout.addProductToCart();

        checkout.openCart();

        checkout.clickCheckout();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Delivery Details"));
    }

    // 4. Verify payment method

    @Test(priority = 4)
    public void verifyPaymentMethod() {

        login();

        CheckoutPage checkout =
                new CheckoutPage(driver);

        checkout.searchProduct("HP LP3065");

        checkout.openHPProduct();

        checkout.addProductToCart();

        checkout.openCart();

        checkout.clickCheckout();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Payment Method"));
    }

    // 5. Confirm order successfully

    @Test(priority = 5)
    public void confirmOrderSuccessfully() {

        login();

        CheckoutPage checkout =
                new CheckoutPage(driver);

        checkout.searchProduct("HP LP3065");

        checkout.openHPProduct();

        checkout.addProductToCart();

        checkout.openCart();

        checkout.clickCheckout();

        checkout.completeCheckoutProcess();

        Assert.assertTrue(
                checkout.getSuccessMessage()
                        .contains("Your order has been placed"));
    }
}