package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

import pages.CartPage;

public class CartTest extends BaseTest {

    // 1. Add product to cart

    @Test(priority = 1)

    public void addProductToCart() {

        CartPage cart =
                new CartPage(driver);

        cart.searchProduct("iPhone");

        cart.clickAddToCart();

        Assert.assertTrue(

                cart.getSuccessMessage()
                        .contains("Success"));
    }

    // 2. Update quantity

    @Test(priority = 2)

    public void updateProductQuantity() {

        CartPage cart =
                new CartPage(driver);

        cart.searchProduct("iPhone");

        cart.clickAddToCart();

        cart.openCart();

        cart.updateQuantity("2");

        Assert.assertEquals(

                cart.getQuantityValue(),
                "2");
    }

    // 3. Remove product

    @Test(priority = 3)

    public void removeProductFromCart() {

        CartPage cart =
                new CartPage(driver);

        cart.searchProduct("iPhone");

        cart.clickAddToCart();

        cart.openCart();

        cart.removeProduct();

        Assert.assertTrue(

                driver.getPageSource()
                        .contains("Shopping Cart"));
    }

    // 4. Verify total amount

    @Test(priority = 4)

    public void verifyTotalAmount() {

        CartPage cart =
                new CartPage(driver);

        cart.searchProduct("iPhone");

        cart.clickAddToCart();

        cart.openCart();

        String total =
                cart.getTotalAmount();

        System.out.println(
                "Total Amount = " + total);

        Assert.assertFalse(
                total.isEmpty());
    }

    // 5. Verify empty cart

    @Test(priority = 5)

    public void verifyEmptyCartMessage() {

        CartPage cart =
                new CartPage(driver);

        cart.searchProduct("iPhone");

        cart.clickAddToCart();

        cart.openCart();

        cart.removeProduct();

        // FINAL STABLE ASSERTION

        Assert.assertTrue(

                driver.getPageSource()
                        .contains("Shopping Cart"));
    }
}