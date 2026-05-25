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
                Duration.ofSeconds(15));
    }

    // Locators

    By searchBox =
            By.name("search");

    By searchButton =
            By.xpath("//button[contains(@class,'btn-default')]");

    By addToCartButton =
            By.xpath("(//span[text()='Add to Cart'])[1]");

    By successMessage =
            By.xpath("//div[contains(@class,'alert-success')]");

    By cartButton =
            By.id("cart-total");

    By viewCart =
            By.xpath("//strong[contains(text(),'View Cart')]");

    By productName =
            By.linkText("iPhone");

    By totalAmount =
            By.xpath("(//td[@class='text-right'])[last()]");

    By quantityBox =
            By.xpath("//input[contains(@name,'quantity')]");

    By updateButton =
            By.xpath("//button[@data-original-title='Update']");

    By removeButton =
            By.xpath("//button[contains(@data-original-title,'Remove')]");

    By emptyCartMessage =
            By.xpath("//p[contains(text(),'Your shopping cart is empty')]");

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

    // Add Product

    public void addProductToCart() {

        wait.until(ExpectedConditions
                .elementToBeClickable(addToCartButton));

        driver.findElement(addToCartButton)
                .click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(successMessage));
    }

    // Old Method Support

    public void clickAddToCart() {

        addProductToCart();
    }

    // Success Message

    public String getSuccessMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(successMessage));

        return driver.findElement(successMessage)
                .getText();
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

    // Verify Product

    public boolean isProductDisplayed() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(productName));

        return driver.findElement(productName)
                .isDisplayed();
    }

    // Verify Total

    public boolean isTotalDisplayed() {

        wait.until(ExpectedConditions
                .presenceOfElementLocated(totalAmount));

        return driver.findElement(totalAmount)
                .isDisplayed();
    }

    // Get Total Amount

    public String getTotalAmount() {

        wait.until(ExpectedConditions
                .presenceOfElementLocated(totalAmount));

        return driver.findElement(totalAmount)
                .getText();
    }

    // Quantity Value

    public String getQuantityValue() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(quantityBox));

        return driver.findElement(quantityBox)
                .getAttribute("value");
    }

    // Update Quantity

    public void updateQuantity(String qty) {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(quantityBox));

        WebElement quantity =
                driver.findElement(quantityBox);

        quantity.clear();

        quantity.sendKeys(qty);

        wait.until(ExpectedConditions
                .elementToBeClickable(updateButton));

        driver.findElement(updateButton)
                .click();
    }

    // Remove Product

    public void removeProduct() {

        wait.until(ExpectedConditions
                .elementToBeClickable(removeButton));

        driver.findElement(removeButton)
                .click();
    }

    // Empty Cart Message

    public String getEmptyCartMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(emptyCartMessage));

        return driver.findElement(emptyCartMessage)
                .getText();
    }
}