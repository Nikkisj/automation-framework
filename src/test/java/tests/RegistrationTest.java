package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegisterPage;

public class RegistrationTest extends BaseTest {

    // 1. Register with mandatory fields

    @Test(priority = 1)
    public void registerWithMandatoryFields() {

        RegisterPage register =
                new RegisterPage(driver);

        register.clickMyAccount();

        register.clickRegister();

        register.enterFirstName("Nikita");

        register.enterLastName("Jadhav");

        String email =
                "nikita" + System.currentTimeMillis()
                + "@gmail.com";

        register.enterEmail(email);

        register.enterTelephone("9876543210");

        register.enterPassword("Nikita@123");

        register.enterConfirmPassword("Nikita@123");

        // UPDATED METHOD

        register.clickPrivacyPolicy();

        register.clickContinue();

        Assert.assertTrue(
                register.getSuccessMessage()
                        .contains(
                                "Your Account Has Been Created"));
    }

    // 2. Register with existing email

    @Test(priority = 2)
    public void registerWithExistingEmail() {

        RegisterPage register =
                new RegisterPage(driver);

        register.clickMyAccount();

        register.clickRegister();

        register.enterFirstName("Nikita");

        register.enterLastName("Jadhav");

        register.enterEmail(
                "nikitajadhav123@gmail.com");

        register.enterTelephone("9876543210");

        register.enterPassword("Nikita@123");

        register.enterConfirmPassword("Nikita@123");

        register.clickPrivacyPolicy();

        register.clickContinue();

        Assert.assertTrue(
                register.getWarningMessage()
                        .contains("Warning"));
    }

    // 3. Register without filling fields

    @Test(priority = 3)
    public void registerWithoutFillingFields() {

        RegisterPage register =
                new RegisterPage(driver);

        register.clickMyAccount();

        register.clickRegister();

        register.clickContinue();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("First Name"));
    }

    // 4. Verify password mismatch

    @Test(priority = 4)
    public void verifyPasswordMismatch() {

        RegisterPage register =
                new RegisterPage(driver);

        register.clickMyAccount();

        register.clickRegister();

        register.enterFirstName("Nikita");

        register.enterLastName("Jadhav");

        String email =
                "nikita" + System.currentTimeMillis()
                + "@gmail.com";

        register.enterEmail(email);

        register.enterTelephone("9876543210");

        register.enterPassword("Nikita@123");

        register.enterConfirmPassword(
                "WrongPassword");

        register.clickPrivacyPolicy();

        register.clickContinue();

        Assert.assertTrue(
                register.getPasswordMismatchMessage()
                        .contains(
                                "Password confirmation"));
    }

    // 5. Verify Privacy Policy warning

    @Test(priority = 5)
    public void verifyPrivacyPolicyWarning() {

        RegisterPage register =
                new RegisterPage(driver);

        register.clickMyAccount();

        register.clickRegister();

        register.enterFirstName("Nikita");

        register.enterLastName("Jadhav");

        String email =
                "nikita" + System.currentTimeMillis()
                + "@gmail.com";

        register.enterEmail(email);

        register.enterTelephone("9876543210");

        register.enterPassword("Nikita@123");

        register.enterConfirmPassword("Nikita@123");

        register.clickContinue();

        Assert.assertTrue(
                register.getWarningMessage()
                        .contains("Warning"));
    }

    // 6. Verify Successful Account Creation

    @Test(priority = 6)
    public void verifySuccessfulAccountCreation() {

        RegisterPage register =
                new RegisterPage(driver);

        register.clickMyAccount();

        register.clickRegister();

        register.enterFirstName("Nikita");

        register.enterLastName("Jadhav");

        String email =
                "nikita" + System.currentTimeMillis()
                + "@gmail.com";

        register.enterEmail(email);

        register.enterTelephone("9876543210");

        register.enterPassword("Nikita@123");

        register.enterConfirmPassword("Nikita@123");

        register.clickPrivacyPolicy();

        register.clickContinue();

        Assert.assertTrue(
                register.getSuccessMessage()
                        .contains(
                                "Your Account Has Been Created"));
    }
}