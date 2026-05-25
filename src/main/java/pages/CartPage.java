package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    By searchBox =
            By.name("search");

    By searchButton =
            By.xpath(
            "//button[contains(@class,'btn-default')]");

    By addToCartButton =
            By.xpath(
            "(//button[contains(@onclick,'cart.add')])[1]");

    By successMessage =
            By.xpath(
            "//div[contains(@class,'alert-success')]");

    By cartButton =
            By.id("cart-total");

    By viewCart =
            By.xpath(
            "//strong[contains(text(),'View Cart')]");

    By quantityField =
            By.xpath(
            "//input[contains(@name,'quantity')]");

    By updateButton =
            By.xpath(
            "//button[@data-original-title='Update']");

    // FINAL WORKING LOCATOR

    By totalAmount =
            By.xpath(
            "(//td[@class='text-right'])[last()]");

    By removeButton =
            By.xpath(
            "//button[@data-original-title='Remove']");

    By emptyCartMessage =
            By.xpath(
            "//div[@id='content']/p");

    // Search Product

    public void searchProduct(String product) {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        searchBox));

        driver.findElement(searchBox)
                .clear();

        driver.findElement(searchBox)
                .sendKeys(product);

        driver.findElement(searchButton)
                .click();
    }

    // Add Product

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

    // Compatibility Method

    public void clickAddToCart() {

        addProductToCart();
    }

    // Success Message

    public String getSuccessMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        successMessage));

        return driver.findElement(
                successMessage)
                .getText();
    }

    // FINAL UPDATED OPEN CART METHOD

    public void openCart() {

        try {

            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(
                            successMessage));

            ((JavascriptExecutor) driver)
                    .executeScript(
                    "window.scrollTo(0,0)");

            wait.until(ExpectedConditions
                    .presenceOfElementLocated(
                            cartButton));

            WebElement cart =
                    driver.findElement(
                            cartButton);

            ((JavascriptExecutor) driver)
                    .executeScript(
                    "arguments[0].click();",
                    cart);

            Thread.sleep(2000);

            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(
                            viewCart));

            WebElement view =
                    driver.findElement(
                            viewCart);

            ((JavascriptExecutor) driver)
                    .executeScript(
                    "arguments[0].click();",
                    view);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // Update Quantity

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

    // Get Quantity

    public String getQuantityValue() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        quantityField));

        return driver.findElement(
                quantityField)
                .getAttribute("value");
    }

    // FINAL UPDATED TOTAL METHOD

    public String getTotalAmount() {

        try {

            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(
                            totalAmount));

            String amount =
                    driver.findElement(
                            totalAmount)
                            .getText();

            return amount;

        } catch (Exception e) {

            e.printStackTrace();

            return "";
        }
    }

    // FINAL UPDATED REMOVE METHOD

    public void removeProduct() {

        try {

            wait.until(ExpectedConditions
                    .presenceOfElementLocated(
                            removeButton));

            WebElement remove =
                    driver.findElement(
                            removeButton);

            ((JavascriptExecutor) driver)
                    .executeScript(
                    "arguments[0].scrollIntoView(true);",
                    remove);

            Thread.sleep(2000);

            ((JavascriptExecutor) driver)
                    .executeScript(
                    "arguments[0].click();",
                    remove);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // Empty Cart Message

    public String getEmptyCartMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        emptyCartMessage));

        return driver.findElement(
                emptyCartMessage)
                .getText();
    }
}