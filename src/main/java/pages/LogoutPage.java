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

    // Locators

    By myAccount =
            By.xpath("//span[text()='My Account']");

    By loginOption =
            By.linkText("Login");

    By logoutOption =
            By.linkText("Logout");

    By continueButton =
            By.linkText("Continue");

    By logoutMessage =
            By.xpath("//h1[contains(text(),'Account Logout')]");

    By rightColumnLogin =
            By.linkText("Login");

    // Methods

    // Open Login Page

    public void clickMyAccount() {

        wait.until(ExpectedConditions
                .elementToBeClickable(myAccount));

        driver.findElement(myAccount)
                .click();
    }

    public void clickLogin() {

        wait.until(ExpectedConditions
                .elementToBeClickable(loginOption));

        driver.findElement(loginOption)
                .click();
    }

    // Logout

    public void clickLogout() {

        wait.until(ExpectedConditions
                .elementToBeClickable(myAccount));

        driver.findElement(myAccount)
                .click();

        wait.until(ExpectedConditions
                .elementToBeClickable(logoutOption));

        driver.findElement(logoutOption)
                .click();
    }

    // Continue Button

    public void clickContinue() {

        wait.until(ExpectedConditions
                .elementToBeClickable(continueButton));

        driver.findElement(continueButton)
                .click();
    }

    // Verify Logout Message

    public String getLogoutMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(logoutMessage));

        return driver.findElement(logoutMessage)
                .getText();
    }

    // Verify Login Option Visible

    public boolean isLoginOptionDisplayed() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(rightColumnLogin));

        return driver.findElement(rightColumnLogin)
                .isDisplayed();
    }
}