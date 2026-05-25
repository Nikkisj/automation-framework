package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

import pages.CartPage;
import pages.SearchPage;

public class CartTest extends BaseTest {

    // 1. Add product to cart

    @Test(priority = 1)

    public void addProductToCart() {

        SearchPage search =
                new SearchPage(driver);

        CartPage cart =
                new CartPage(driver);

        search.enterProductName("iPhone");

        search.clickSearchButton();

        cart.clickAddToCart();

        Assert.assertTrue(
                cart.getSuccessMessage()
                        .contains("Success"));
    }

    // 2. Update product quantity

    @Test(priority = 2)

    public void updateProductQuantity() {

        SearchPage search =
                new SearchPage(driver);

        CartPage cart =
                new CartPage(driver);

        search.enterProductName("iPhone");

        search.clickSearchButton();

        cart.clickAddToCart();

        cart.openCart();

        cart.updateQuantity("2");

        Assert.assertEquals(
                cart.getQuantityValue(),
                "2");
    }

    // 3. Remove product from cart

    @Test(priority = 3)

    public void removeProductFromCart() {

        SearchPage search =
                new SearchPage(driver);

        CartPage cart =
                new CartPage(driver);

        search.enterProductName("iPhone");

        search.clickSearchButton();

        cart.clickAddToCart();

        cart.openCart();

        cart.removeProduct();

        Assert.assertTrue(
                driver.getTitle()
                        .contains("Shopping Cart"));
    }

    // 4. Verify total amount

    @Test(priority = 4)

    public void verifyTotalAmount() {

        SearchPage search =
                new SearchPage(driver);

        CartPage cart =
                new CartPage(driver);

        search.enterProductName("iPhone");

        search.clickSearchButton();

        cart.clickAddToCart();

        cart.openCart();

        Assert.assertTrue(
                cart.getTotalAmount()
                        .contains("$"));
    }

    // 5. Verify empty cart message

    @Test(priority = 5)

    public void verifyEmptyCartMessage() {

        SearchPage search =
                new SearchPage(driver);

        CartPage cart =
                new CartPage(driver);

        search.enterProductName("iPhone");

        search.clickSearchButton();

        cart.clickAddToCart();

        cart.openCart();

        cart.removeProduct();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("checkout/cart"));
    }
}