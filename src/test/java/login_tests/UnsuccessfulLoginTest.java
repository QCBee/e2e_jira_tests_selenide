package login_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class UnsuccessfulLoginTest {
    Driver driver = null;
    LoginPage loginPage = null;

    //Test data locators
    String loginURL = "https://jira.hillel.it/secure/Dashboard.jspa";
    String validUsernameTestData = "webinar5";
    String validUserPasswordTestData = "webinar5";
    String invalidUserNameTestData = "invalidName";
    String invalidUserPasswordTestData = "invalidPass";
    String emptyUserNameTestData = "";
    String emptyUserPasswordTestData = "";

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName) {
        Configuration.browser = browserName;
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "UnsuccessfullLoginsTestDataList")
    public Object[][] createData(){
        return new Object[][]{
                {validUsernameTestData, invalidUserPasswordTestData},
                {invalidUserNameTestData, validUserPasswordTestData},
                {validUsernameTestData, emptyUserPasswordTestData},
                {emptyUserNameTestData, validUserPasswordTestData},
                {emptyUserNameTestData, emptyUserPasswordTestData}
        };
    }

    @Test(dataProvider = "UnsuccessfullLoginsTestDataList")
    public void unsuccessfulLoginTest(String userName, String userPass){
        loginPage.openLoginPage(loginURL);
        loginPage.enterUserName(userName);
        loginPage.enterUserPass(userPass);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorNotificationShown());
        Assert.assertTrue(loginPage.isLoginIconShown());
    }


}
