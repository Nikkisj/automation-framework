package stepdefinitions;

import org.testng.Assert;

import base.BaseTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.CartPage;

public class CartStepDefinition extends BaseTest {

    CartPage cart;

    @When("User adds product to cart")
    public void user_adds_product_to_cart() {

        cart = new CartPage(driver);

        cart.searchProduct("iPhone");

        cart.addProductToCart();
    }

    @Then("Product should be added successfully")
    public void product_should_be_added_successfully() {

        Assert.assertTrue(
                cart.getSuccessMessage()
                        .contains("Success"));

        tearDown();
    }
}