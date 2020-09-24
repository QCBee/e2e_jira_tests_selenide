package login_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ForgotLoginPage;
import pages.LoginPage;

public class ForgotLoginTest {
    Driver driver = null;
    LoginPage loginPage = null;
    ForgotLoginPage forgotLoginPage = null;

    String loginURL = "https://jira.hillel.it/secure/Dashboard.jspa";

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName){
        Configuration.browser = browserName;
        loginPage = new LoginPage(driver);
        forgotLoginPage = new ForgotLoginPage(driver);
    }

    @Test
    public void openResetPasswordPageFromLoginFormTest(){
        loginPage.openLoginPage(loginURL);
        loginPage.clickCanAccessAccountLink();
        Assert.assertTrue(forgotLoginPage.isForgotLoginFormShown());
    }

    @AfterMethod
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
