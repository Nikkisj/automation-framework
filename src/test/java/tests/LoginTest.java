package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    // 1. Login with valid credentials

    @Test(priority = 1)

    public void loginWithValidCredentials() {

        LoginPage login =
                new LoginPage(driver);

        login.clickMyAccount();

        login.clickLogin();

        login.enterEmail(
                "nikitajadhav123@gmail.com");

        login.enterPassword(
                "Nikita@123");

        login.clickLoginButton();

        // UPDATED STABLE ASSERTION

        Assert.assertTrue(
                login.isMyAccountDisplayed());
    }

    // 2. Login with invalid email

    @Test(priority = 2)

    public void loginWithInvalidEmail() {

        LoginPage login =
                new LoginPage(driver);

        login.clickMyAccount();

        login.clickLogin();

        login.enterEmail(
                "wrong@gmail.com");

        login.enterPassword(
                "Nikita@123");

        login.clickLoginButton();

        Assert.assertTrue(
                login.getWarningMessage()
                        .contains("Warning"));
    }

    // 3. Login with invalid password

    @Test(priority = 3)

    public void loginWithInvalidPassword() {

        LoginPage login =
                new LoginPage(driver);

        login.clickMyAccount();

        login.clickLogin();

        login.enterEmail(
                "nikitajadhav123@gmail.com");

        login.enterPassword(
                "WrongPassword");

        login.clickLoginButton();

        Assert.assertTrue(
                login.getWarningMessage()
                        .contains("Warning"));
    }

    // 4. Login with blank credentials

    @Test(priority = 4)

    public void loginWithBlankCredentials() {

        LoginPage login =
                new LoginPage(driver);

        login.clickMyAccount();

        login.clickLogin();

        login.clickLoginButton();

        Assert.assertTrue(
                login.getWarningMessage()
                        .contains("Warning"));
    }

    // 5. Verify warning message

    @Test(priority = 5)

    public void verifyWarningMessage() {

        LoginPage login =
                new LoginPage(driver);

        login.clickMyAccount();

        login.clickLogin();

        login.enterEmail(
                "wrong@gmail.com");

        login.enterPassword(
                "wrong123");

        login.clickLoginButton();

        Assert.assertTrue(
                login.getWarningMessage()
                        .contains(
                                "No match for E-Mail Address"));
    }

    // 6. Verify Login Page UI

    @Test(priority = 6)

    public void verifyLoginPageUI() {

        LoginPage login =
                new LoginPage(driver);

        login.clickMyAccount();

        login.clickLogin();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Returning Customer"));
    }
}