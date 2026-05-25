package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators

    By myAccount = By.xpath("//span[text()='My Account']");

    By registerLink = By.linkText("Register");

    By firstName = By.id("input-firstname");

    By lastName = By.id("input-lastname");

    By email = By.id("input-email");

    By telephone = By.id("input-telephone");

    By password = By.id("input-password");

    By confirmPassword = By.id("input-confirm");

    By privacyPolicy = By.name("agree");

    By continueBtn =
            By.xpath("//input[@value='Continue']");

    By successMsg =
            By.xpath("//h1[text()='Your Account Has Been Created!']");

    By warningMsg =
            By.xpath("//div[contains(@class,'alert-danger')]");

    By passwordMismatchMsg =
            By.xpath("//div[contains(text(),'Password confirmation')]");

    // Methods

    public void clickMyAccount() {

        wait.until(ExpectedConditions
                .elementToBeClickable(myAccount));

        driver.findElement(myAccount).click();
    }

    public void clickRegister() {

        wait.until(ExpectedConditions
                .elementToBeClickable(registerLink));

        driver.findElement(registerLink).click();
    }

    public void enterFirstName(String fname) {

        driver.findElement(firstName).clear();

        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {

        driver.findElement(lastName).clear();

        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String mail) {

        driver.findElement(email).clear();

        driver.findElement(email).sendKeys(mail);
    }

    public void enterTelephone(String phone) {

        driver.findElement(telephone).clear();

        driver.findElement(telephone).sendKeys(phone);
    }

    public void enterPassword(String pwd) {

        driver.findElement(password).clear();

        driver.findElement(password).sendKeys(pwd);
    }

    public void enterConfirmPassword(String cpwd) {

        driver.findElement(confirmPassword).clear();

        driver.findElement(confirmPassword).sendKeys(cpwd);
    }

    public void selectPrivacyPolicy() {

        driver.findElement(privacyPolicy).click();
    }

    public void clickContinue() {

        driver.findElement(continueBtn).click();
    }

    public String getSuccessMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(successMsg));

        return driver.findElement(successMsg).getText();
    }

    public String getWarningMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(warningMsg));

        return driver.findElement(warningMsg).getText();
    }

    public String getPasswordMismatchMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(passwordMismatchMsg));

        return driver.findElement(passwordMismatchMsg).getText();
    }
}