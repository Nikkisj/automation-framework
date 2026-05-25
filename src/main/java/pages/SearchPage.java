package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor

    public SearchPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(10));
    }

    // Locators

    By searchBox =
            By.name("search");

    By searchButton =
            By.xpath("//button[contains(@class,'btn-default')]");

    By validProduct =
            By.linkText("iPhone");

    By noProductMessage =
            By.xpath("//input[@id='button-search']/following-sibling::p");

    By productImage =
            By.xpath("//img[contains(@title,'iPhone')]");

    // UPDATED PRICE LOCATOR

    By productPrice =
            By.xpath("//p[@class='price']");

    // Methods

    public void enterProductName(String product) {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(searchBox));

        driver.findElement(searchBox).clear();

        driver.findElement(searchBox)
                .sendKeys(product);
    }

    public void clickSearchButton() {

        wait.until(ExpectedConditions
                .elementToBeClickable(searchButton));

        driver.findElement(searchButton).click();
    }

    public boolean isProductDisplayed() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(validProduct));

        return driver.findElement(validProduct)
                .isDisplayed();
    }

    public String getNoProductMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(noProductMessage));

        return driver.findElement(noProductMessage)
                .getText();
    }

    public boolean isProductImageDisplayed() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(productImage));

        return driver.findElement(productImage)
                .isDisplayed();
    }

    // UPDATED METHOD

    public boolean isProductPriceDisplayed() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(productPrice));

        return driver.findElement(productPrice)
                .getText()
                .length() > 0;
    }

    public void clickProduct() {

        wait.until(ExpectedConditions
                .elementToBeClickable(validProduct));

        driver.findElement(validProduct).click();
    }
}