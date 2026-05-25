package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;

    WebDriverWait wait;

    // Constructor

    public CartPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(20));
    }

    // Locators

    By addToCartButton =
            By.xpath(
            "(//button[contains(@onclick,'cart.add')])[1]");

    By successMessage =
            By.xpath("//div[contains(@class,'alert-success')]");

    By cartButton =
            By.id("cart-total");

    By viewCart =
            By.linkText("View Cart");

    By quantityField =
            By.xpath("//input[contains(@name,'quantity')]");

    By updateButton =
            By.xpath(
            "//button[@data-original-title='Update']");

    By totalAmount =
            By.xpath(
            "(//td[@class='text-right'])[last()]");

    By removeButton =
            By.xpath(
            "//button[@data-original-title='Remove']");

    By emptyCartMessage =
            By.xpath("//div[@id='content']/p");

    // Methods

    public void addProductToCart() {

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        addToCartButton));

        driver.findElement(addToCartButton)
                .click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        successMessage));
    }

    // Compatibility method

    public void clickAddToCart() {

        addProductToCart();
    }

    public String getSuccessMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        successMessage));

        return driver.findElement(
                successMessage).getText();
    }

    // UPDATED OPEN CART METHOD

    public void openCart() {

        try {

            wait.until(ExpectedConditions
                    .presenceOfElementLocated(
                            cartButton));

            wait.until(ExpectedConditions
                    .elementToBeClickable(
                            cartButton));

            driver.findElement(cartButton)
                    .click();

        } catch (Exception e) {

            // RETRY FOR STALE ELEMENT

            wait.until(ExpectedConditions
                    .presenceOfElementLocated(
                            cartButton));

            driver.findElement(cartButton)
                    .click();
        }

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        viewCart));

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        viewCart));

        driver.findElement(viewCart)
                .click();
    }

    public void updateQuantity(String qty) {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        quantityField));

        driver.findElement(quantityField)
                .clear();

        driver.findElement(quantityField)
                .sendKeys(qty);

        driver.findElement(updateButton)
                .click();
    }

    public String getQuantityValue() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        quantityField));

        return driver.findElement(
                quantityField)
                .getAttribute("value");
    }

    public String getTotalAmount() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        totalAmount));

        return driver.findElement(
                totalAmount).getText();
    }

    public void removeProduct() {

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        removeButton));

        driver.findElement(removeButton)
                .click();
    }

    public String getEmptyCartMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        emptyCartMessage));

        return driver.findElement(
                emptyCartMessage).getText();
    }
}