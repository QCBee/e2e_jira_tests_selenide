package add_comment_ticket_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DeleteCommentPage;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;

public class SuccessfulAddCommentTest {
    Driver driver = null;
    LoginPage loginPage = null;
    HomePage homePage = null;
    TicketPage ticketPage = null;
    DeleteCommentPage deleteCommentPage = null;

    //Test data for preconditions
    String loginURL = "https://jira.hillel.it/secure/Dashboard.jspa";
    String validUsernameTestData = "webinar5";
    String validUserPasswordTestData = "webinar5";

    //Test data for view ticket test
    String ticketUrl = "https://jira.hillel.it/browse/WEBINAR-12303";

    //Test data for tests with comments
    String commentValue = "I am a test comment";

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName){
        Configuration.browser = browserName;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        ticketPage = new TicketPage(driver);
        deleteCommentPage = new DeleteCommentPage(driver);

        loginPage.openLoginPage(loginURL);
        loginPage.enterUserName(validUsernameTestData);
        loginPage.enterUserPass(validUserPasswordTestData);
        loginPage.clickLoginButton();
    }

    @Test
    public void createComment(){
        ticketPage.navigateToTicketPage(ticketUrl);
        Assert.assertTrue(ticketPage.isCommentTabSelected());
        Assert.assertTrue(ticketPage.isAddCommentFooterButtonEnabled());

        ticketPage.clickAddCommentFooterButton();
        Assert.assertTrue(ticketPage.isAddCommentAreaShown());
        Assert.assertTrue(ticketPage.isAddCommentFooterButtonDisabled());
        Assert.assertTrue(ticketPage.isAddCommentButtonDisabled());
        Assert.assertTrue(ticketPage.isCancelButtonEnabled());

        ticketPage.selectTextModeForComment();
        Assert.assertTrue(ticketPage.isTextModeForCommentSelected());

        ticketPage.enterComment(commentValue);
        Assert.assertTrue(ticketPage.isAddCommentButtonEnabled());

        ticketPage.clickAddCommentButton();
        Assert.assertTrue(ticketPage.isLogIssueAreaShown());
        Assert.assertTrue(ticketPage.isAddedCommentShown());

        ticketPage.clickDeleteCommentIcon();

        deleteCommentPage.clickDeleteButton();
        Assert.assertTrue(ticketPage.isUpdateIssueNotificationShown());
        Assert.assertTrue(ticketPage.isAnyCommentNotAdded());
    }

    @AfterMethod
    public void deleteAddedComment(){
        ticketPage.clickDeleteCommentIcon();
        Assert.assertTrue(deleteCommentPage.isDeletePopUpShown());
        Assert.assertTrue(deleteCommentPage.isDeleteButtonShown());

        deleteCommentPage.clickDeleteButton();
        Assert.assertTrue(deleteCommentPage.isDeletePopUpClosed());
        Assert.assertTrue(ticketPage.isUpdateIssueNotificationShown());
        Assert.assertTrue(ticketPage.isAnyCommentNotAdded());
    }
}
