package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    WebDriverWait wait;

    // Constructor

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(15));
    }

    // LOCATORS

    By myAccount =
            By.linkText("My Account");

    By loginOption =
            By.linkText("Login");

    By emailField =
            By.id("input-email");

    By passwordField =
            By.id("input-password");

    By loginButton =
            By.xpath("//input[@value='Login']");

    By warningMessage =
            By.xpath("//div[contains(@class,'alert-danger')]");

    By myAccountText =
            By.linkText("My Account");

    // METHODS

    public void clickMyAccount() {

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        myAccount));

        driver.findElement(myAccount)
                .click();
    }

    public void clickLogin() {

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        loginOption));

        driver.findElement(loginOption)
                .click();
    }

    public void enterEmail(String email) {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        emailField));

        driver.findElement(emailField)
                .clear();

        driver.findElement(emailField)
                .sendKeys(email);
    }

    public void enterPassword(String password) {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        passwordField));

        driver.findElement(passwordField)
                .clear();

        driver.findElement(passwordField)
                .sendKeys(password);
    }

    public void clickLoginButton() {

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        loginButton));

        driver.findElement(loginButton)
                .click();
    }

    public String getWarningMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        warningMessage));

        return driver.findElement(
                warningMessage)
                .getText();
    }

    public boolean isMyAccountDisplayed() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        myAccountText));

        return driver.findElement(
                myAccountText)
                .isDisplayed();
    }
}