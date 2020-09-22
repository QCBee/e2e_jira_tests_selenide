package login_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class SuccessfulLoginTest {
    Driver driver = null;
    LoginPage loginPage = null;
    HomePage homePage = null;

    //Test data locators
    String loginURL = "https://jira.hillel.it/secure/Dashboard.jspa";
    String validUsernameTestData = "webinar5";
    String validUserPasswordTestData = "webinar5";

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName) {
        Configuration.browser = browserName;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void successfulLogin() {
        loginPage.openLoginPage(loginURL);
        loginPage.enterUserName(validUsernameTestData);
        loginPage.enterUserPass(validUserPasswordTestData);
        loginPage.clickLoginButton();
        homePage.isUserProfileIconShown();
    }
}
