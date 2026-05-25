package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    WebDriver driver;

    WebDriverWait wait;

    // Constructor

    public LogoutPage(WebDriver driver) {

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

    By logoutOption =
            By.linkText("Logout");

    By logoutMessage =
            By.xpath("//div[@id='content']/h1");

    By continueButton =
            By.linkText("Continue");

    // METHODS

    public void login() {

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        myAccount));

        driver.findElement(myAccount)
                .click();

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        loginOption));

        driver.findElement(loginOption)
                .click();

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        emailField));

        driver.findElement(emailField)
                .clear();

        driver.findElement(emailField)
                .sendKeys(
                        "nikitajadhav123@gmail.com");

        driver.findElement(passwordField)
                .clear();

        driver.findElement(passwordField)
                .sendKeys("Nikita@123");

        driver.findElement(loginButton)
                .click();
    }

    public void clickLogout() {

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        myAccount));

        driver.findElement(myAccount)
                .click();

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        logoutOption));

        driver.findElement(logoutOption)
                .click();
    }

    public void clickContinue() {

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        continueButton));

        driver.findElement(continueButton)
                .click();
    }

    public String getLogoutMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        logoutMessage));

        return driver.findElement(
                logoutMessage)
                .getText();
    }

    public boolean isLoginOptionDisplayed() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        loginOption));

        return driver.findElement(
                loginOption)
                .isDisplayed();
    }
}