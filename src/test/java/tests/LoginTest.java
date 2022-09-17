package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest {
    protected final static String EXPECTED_ERROR = "Invalid login credentials. Please try again.";
    protected final static String EXPECTED_LOGOUT_MESSAGE = "You have been successfully logged out of the system.";

    @Test(groups = {"smoke"})
    @Description("Authorization with correct data")
    public void positiveLoginTest() {
        loginPage.login(EMAIL, PASSWORD);
        Assert.assertTrue(homePage.isUserIconDisplayed(), "User icon should be on display");
    }

    @Test(groups = {"negative"}, dataProvider = "negativeLoginTestForEmailData")
    @Description("Authorization with incorrect email")
    public void negativeLoginTestForEmail(String email, String password, String errorMessage) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageForEmailDisplayed(), "Error message should be on display");
        Assert.assertEquals(loginPage.getErrorMessageForEmailText(), errorMessage, "Error message should be: " + errorMessage);
    }

    @DataProvider
    public Object[][] negativeLoginTestForEmailData() {
        return new Object[][]{
                {"abc", PASSWORD, "Please enter a valid email address."},
                {"", PASSWORD, "Please enter your e-mail address."}
        };
    }

    @Test(groups = {"negative"})
    @Description("Authorization with incorrect password")
    public void negativeLoginTestForPassword() {
        loginPage.setEmail(EMAIL);
        loginPage.setPassword("wrong_password");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageForFormDisplayed(), "Error message should be on display");
        Assert.assertEquals(loginPage.getErrorMessageForFormText(), EXPECTED_ERROR, "Error message should be: " + EXPECTED_ERROR);
    }

    @Test(groups = {"regression"})
    @Description("Logout")
    public void logoutTest() {
        loginPage.login(EMAIL, PASSWORD);
        homePage.clickLogoutButton();
        Assert.assertTrue(logoutPage.isLogoutMessageDisplayed(), "Logout message should be on display");
        Assert.assertEquals(logoutPage.getLogoutMessageText(), EXPECTED_LOGOUT_MESSAGE, "Logout message should be: " + EXPECTED_LOGOUT_MESSAGE);
    }

}
