package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SearchPage;

public class SearchTest extends BaseTest {

    // 1. Search product using valid keyword

    @Test(priority = 1)
    public void searchWithValidKeyword() {

        SearchPage search =
                new SearchPage(driver);

        search.enterProductName("iPhone");

        search.clickSearchButton();

        Assert.assertTrue(
                search.isProductDisplayed());
    }

    // 2. Search product using invalid keyword

    @Test(priority = 2)
    public void searchWithInvalidKeyword() {

        SearchPage search =
                new SearchPage(driver);

        search.enterProductName("Nokia123");

        search.clickSearchButton();

        Assert.assertTrue(
                search.getNoProductMessage()
                        .contains("There is no product"));
    }

    // 3. Search product with empty field

    @Test(priority = 3)
    public void searchWithEmptyField() {

        SearchPage search =
                new SearchPage(driver);

        search.enterProductName("");

        search.clickSearchButton();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Search"));
    }

    // 4. Verify search results

    @Test(priority = 4)
    public void verifySearchResults() {

        SearchPage search =
                new SearchPage(driver);

        search.enterProductName("iPhone");

        search.clickSearchButton();

        Assert.assertTrue(
                search.isProductDisplayed());
    }

    // 5. Verify product details

    @Test(priority = 5)
    public void verifyProductDetails() {

        SearchPage search =
                new SearchPage(driver);

        search.enterProductName("iPhone");

        search.clickSearchButton();

        Assert.assertTrue(
                search.isProductImageDisplayed());

        Assert.assertTrue(
                search.isProductPriceDisplayed());
    }
}