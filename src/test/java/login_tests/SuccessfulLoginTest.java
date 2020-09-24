package login_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.*;
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

    @DataProvider(name = "Successful Test Data List")
    public Object[][] createData(){
        return new Object [][]{
                {validUsernameTestData, validUserPasswordTestData},
        };
    }

    @Test(dataProvider = "Successful Test Data List")
    public void successfulLogin(String userName, String userPass) {
        loginPage.openLoginPage(loginURL);
        loginPage.enterUserName(userName);
        loginPage.enterUserPass(userPass);
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isDashboardShown());
    }

    @AfterMethod
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
