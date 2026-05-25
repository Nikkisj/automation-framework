package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends BaseTest {

    // Common Login Method

    public void login() {

        LoginPage login =
                new LoginPage(driver);

        login.clickMyAccount();

        login.clickLogin();

        login.enterEmail("nikitajadhav123@gmail.com");

        login.enterPassword("Nikita@123");

        login.clickLoginButton();
    }

    // 1. Logout successfully

    @Test(priority = 1)
    public void logoutSuccessfully() {

        login();

        LogoutPage logout =
                new LogoutPage(driver);

        logout.clickLogout();

        Assert.assertTrue(
                logout.getLogoutMessage()
                        .contains("Account Logout"));
    }

    // 2. Verify redirect after logout

    @Test(priority = 2)
    public void verifyRedirectAfterLogout() {

        login();

        LogoutPage logout =
                new LogoutPage(driver);

        logout.clickLogout();

        logout.clickContinue();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("common/home"));
    }

    // 3. Verify logout confirmation message

    @Test(priority = 3)
    public void verifyLogoutMessage() {

        login();

        LogoutPage logout =
                new LogoutPage(driver);

        logout.clickLogout();

        Assert.assertEquals(
                logout.getLogoutMessage(),
                "Account Logout");
    }

    // 4. Verify session ends after logout

    @Test(priority = 4)
    public void verifySessionEndsAfterLogout() {

        login();

        LogoutPage logout =
                new LogoutPage(driver);

        logout.clickLogout();

        logout.clickContinue();

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("common/home"));
    }

    // 5. Verify My Account options after logout

    @Test(priority = 5)
    public void verifyMyAccountOptionsAfterLogout() {

        login();

        LogoutPage logout =
                new LogoutPage(driver);

        logout.clickLogout();

        Assert.assertTrue(
                logout.isLoginOptionDisplayed());
    }
}