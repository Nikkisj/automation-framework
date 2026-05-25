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

    // Locators

    By myAccount =
            By.xpath("(//span[contains(text(),'My Account')])[1]");

    By loginLink =
            By.linkText("Login");

    By email =
            By.id("input-email");

    By password =
            By.id("input-password");

    By loginButton =
            By.xpath("//input[@value='Login']");

    By myAccountHeader =
            By.xpath("//h2[text()='My Account']");

    By warningMessage =
            By.xpath("//div[contains(@class,'alert-danger')]");

    // Methods

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

        driver.findElement(password).clear();

        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLoginButton() {

        driver.findElement(loginButton).click();
    }

    public boolean isMyAccountDisplayed() {

        try {

            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(
                            myAccountHeader));

            return driver.findElement(
                    myAccountHeader).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public String getWarningMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        warningMessage));

        return driver.findElement(
                warningMessage).getText();
    }
}