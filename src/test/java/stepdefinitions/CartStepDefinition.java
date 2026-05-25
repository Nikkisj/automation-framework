package stepdefinitions;

import org.testng.Assert;

import base.BaseTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.CartPage;
import pages.SearchPage;

public class CartStepDefinition extends BaseTest {

    CartPage cart;

    SearchPage search;

    @When("User adds product to cart")
    public void user_adds_product_to_cart() {

        search =
                new SearchPage(driver);

        cart =
                new CartPage(driver);

        search.enterProductName("iPhone");

        search.clickSearchButton();

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