package stepdefinitions;

import org.testng.Assert;

import base.BaseTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.SearchPage;

public class SearchStepDefinition extends BaseTest {

    SearchPage searchPage;

    @When("User searches for a valid product")
    public void user_searches_for_a_valid_product() {

        searchPage =
                new SearchPage(driver);

        searchPage.enterProductName("iPhone");

        searchPage.clickSearchButton();
    }

    @Then("Product should be displayed")
    public void product_should_be_displayed() {

        Assert.assertTrue(
                searchPage.isProductDisplayed());

        tearDown();
    }
}