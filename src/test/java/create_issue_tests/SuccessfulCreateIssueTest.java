package create_issue_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CreateIssuePage;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;

public class SuccessfulCreateIssueTest {
    Driver driver = null;
    LoginPage loginPage = null;
    HomePage homePage = null;
    TicketPage ticketPage = null;
    CreateIssuePage createIssuePage = null;

    //Test data
    String loginURL = "https://jira.hillel.it/secure/Dashboard.jspa";
    String validUsernameTestData = "webinar5";
    String validUserPasswordTestData = "webinar5";

    //Test data for create issue tests
    String projectNameValue = "Webinar (WEBINAR)";
    String issueTypeValue = "Task";
    String summaryValue = "Test Summary";
    String reporterValue = "webinar5";
    String descriptionValue = "Test description";
    String priorityValue = "Lowest";

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName){
        Configuration.browser = browserName;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        ticketPage = new TicketPage(driver);
        createIssuePage = new CreateIssuePage(driver);

        loginPage.openLoginPage(loginURL);
        loginPage.enterUserName(validUsernameTestData);
        loginPage.enterUserPass(validUserPasswordTestData);
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isDashboardShown());
    }

    @Test
    public void successfulCreateTicketOnlyRequiredFields(){
        homePage.clickCreateIssueButton();
        Assert.assertTrue(createIssuePage.isCreateIssuePopUpShown());
        Assert.assertTrue(createIssuePage.isProjectInputEnabled());
        Assert.assertTrue(createIssuePage.isTypeIssueInputEnabled());
        Assert.assertTrue(createIssuePage.isSummaryInputEnabled());

        createIssuePage.enterProject(projectNameValue);
        createIssuePage.enterTypeIssue(issueTypeValue);
        createIssuePage.enterSummary(summaryValue);
        createIssuePage.enterReporter(reporterValue);
        createIssuePage.clickCreateButton();
        Assert.assertTrue(homePage.isIssueCreateNotificationShown());
    }

}
