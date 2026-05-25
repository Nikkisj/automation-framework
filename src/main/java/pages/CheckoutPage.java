package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor

    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(20));
    }

    // Search

    By searchBox =
            By.name("search");

    By searchButton =
            By.xpath("//button[contains(@class,'btn-default')]");

    // Product

    By hpProduct =
            By.linkText("HP LP3065");

    By addToCartButton =
            By.id("button-cart");

    By successMessage =
            By.xpath("//div[contains(@class,'alert-success')]");

    // Cart

    By cartButton =
            By.id("cart-total");

    By viewCart =
            By.xpath("//strong[contains(text(),'View Cart')]");

    By checkoutButton =
            By.linkText("Checkout");

    // Checkout Steps

    By billingContinue =
            By.id("button-payment-address");

    By deliveryContinue =
            By.id("button-shipping-address");

    By deliveryMethodContinue =
            By.id("button-shipping-method");

    By termsCondition =
            By.name("agree");

    By paymentContinue =
            By.id("button-payment-method");

    By confirmOrderButton =
            By.id("button-confirm");

    // Success Message

    By successOrderMessage =
            By.xpath("//h1[contains(text(),'Your order has been placed')]");

    // Search Product

    public void searchProduct(String product) {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(searchBox));

        driver.findElement(searchBox)
                .clear();

        driver.findElement(searchBox)
                .sendKeys(product);

        driver.findElement(searchButton)
                .click();
    }

    // Open HP Product

    public void openHPProduct() {

        wait.until(ExpectedConditions
                .elementToBeClickable(hpProduct));

        driver.findElement(hpProduct)
                .click();
    }

    // Add Product

    public void addProductToCart() {

        wait.until(ExpectedConditions
                .elementToBeClickable(addToCartButton));

        driver.findElement(addToCartButton)
                .click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(successMessage));
    }

    // UPDATED OPEN CART

    public void openCart() {

        try {

            Thread.sleep(2000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        wait.until(ExpectedConditions
                .presenceOfElementLocated(cartButton));

        WebElement cart =
                driver.findElement(cartButton);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView(true);",
                        cart);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        cart);

        wait.until(ExpectedConditions
                .presenceOfElementLocated(viewCart));

        WebElement viewCartElement =
                driver.findElement(viewCart);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        viewCartElement);
    }

    // Checkout

    public void clickCheckout() {

        wait.until(ExpectedConditions
                .elementToBeClickable(checkoutButton));

        driver.findElement(checkoutButton)
                .click();
    }

    // Complete Checkout

    public void completeCheckoutProcess() {

        wait.until(ExpectedConditions
                .elementToBeClickable(billingContinue));

        driver.findElement(billingContinue)
                .click();

        wait.until(ExpectedConditions
                .elementToBeClickable(deliveryContinue));

        driver.findElement(deliveryContinue)
                .click();

        wait.until(ExpectedConditions
                .elementToBeClickable(deliveryMethodContinue));

        driver.findElement(deliveryMethodContinue)
                .click();

        wait.until(ExpectedConditions
                .elementToBeClickable(termsCondition));

        driver.findElement(termsCondition)
                .click();

        wait.until(ExpectedConditions
                .elementToBeClickable(paymentContinue));

        driver.findElement(paymentContinue)
                .click();

        wait.until(ExpectedConditions
                .elementToBeClickable(confirmOrderButton));

        driver.findElement(confirmOrderButton)
                .click();
    }

    // Success Message

    public String getSuccessMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(successOrderMessage));

        return driver.findElement(successOrderMessage)
                .getText();
    }
}