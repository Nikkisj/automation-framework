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

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(15));
    }

    // LOCATORS

    By myAccount =
            By.linkText("My Account");

    By registerOption =
            By.linkText("Register");

    By firstName =
            By.id("input-firstname");

    By lastName =
            By.id("input-lastname");

    By email =
            By.id("input-email");

    By telephone =
            By.id("input-telephone");

    By password =
            By.id("input-password");

    By confirmPassword =
            By.id("input-confirm");

    By privacyPolicy =
            By.name("agree");

    By continueButton =
            By.xpath("//input[@value='Continue']");

    By successMessage =
            By.xpath("//div[@id='content']/h1");

    By warningMessage =
            By.xpath("//div[contains(@class,'alert-danger')]");

    By passwordMismatchMessage =
            By.xpath("//div[contains(@class,'text-danger')]");

    // METHODS

    public void clickMyAccount() {

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        myAccount));

        driver.findElement(myAccount)
                .click();
    }

    public void clickRegister() {

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        registerOption));

        driver.findElement(registerOption)
                .click();
    }

    public void enterFirstName(String fname) {

        driver.findElement(firstName)
                .sendKeys(fname);
    }

    public void enterLastName(String lname) {

        driver.findElement(lastName)
                .sendKeys(lname);
    }

    public void enterEmail(String mail) {

        driver.findElement(email)
                .sendKeys(mail);
    }

    public void enterTelephone(String phone) {

        driver.findElement(telephone)
                .sendKeys(phone);
    }

    public void enterPassword(String pwd) {

        driver.findElement(password)
                .sendKeys(pwd);
    }

    public void enterConfirmPassword(String cpwd) {

        driver.findElement(confirmPassword)
                .sendKeys(cpwd);
    }

    public void clickPrivacyPolicy() {

        driver.findElement(privacyPolicy)
                .click();
    }

    public void clickContinue() {

        wait.until(ExpectedConditions
                .elementToBeClickable(
                        continueButton));

        driver.findElement(continueButton)
                .click();
    }

    public String getSuccessMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        successMessage));

        return driver.findElement(
                successMessage)
                .getText();
    }

    public String getWarningMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        warningMessage));

        return driver.findElement(
                warningMessage)
                .getText();
    }

    public String getPasswordMismatchMessage() {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        passwordMismatchMessage));

        return driver.findElement(
                passwordMismatchMessage)
                .getText();
    }
}