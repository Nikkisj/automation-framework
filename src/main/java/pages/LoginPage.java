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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators

    By myAccount = By.xpath("//span[text()='My Account']");

    By loginLink = By.linkText("Login");

    By email = By.id("input-email");

    By password = By.id("input-password");

    By loginBtn = By.xpath("//input[@value='Login']");

    By warningMsg =
            By.xpath("//div[contains(@class,'alert-danger')]");

    // Actions / Methods

    public void clickMyAccount() {

        wait.until(ExpectedConditions
                .elementToBeClickable(myAccount));

        driver.findElement(myAccount).click();
    }

    public void clickLogin() {

        wait.until(ExpectedConditions
                .elementToBeClickable(loginLink));

        driver.findElement(loginLink).click();
    }

    public void enterEmail(String mail) {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(email));

        driver.findElement(email).clear();

        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pwd) {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(password));

        driver.findElement(password).clear();

        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLoginButton() {

        wait.until(ExpectedConditions
                .elementToBeClickable(loginBtn));

        driver.findElement(loginBtn).click();
    }

    public String getWarningMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(warningMsg));

        return driver.findElement(warningMsg).getText();
    }
}