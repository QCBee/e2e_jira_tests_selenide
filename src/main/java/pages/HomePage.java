package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private Driver driver;
    private SelenideElement dashboard = $(byId("dashboard"));
    private SelenideElement createIssueButton = $(byId("create_link"));
    private SelenideElement issueCreatedNotification = $(byId("aui-flag-container"));
    private SelenideElement linkToCreatedIssue = $(byXpath("//*[contains(text(),' - Test Summary')]"));

    public HomePage(Driver driver) {
        this.driver = driver;
    }

    public boolean isDashboardShown(){
        return dashboard.shouldBe(Condition.visible).isDisplayed();
    }

    public void clickCreateIssueButton(){
        createIssueButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isIssueCreateNotificationShown(){
        return issueCreatedNotification.shouldBe(Condition.visible).isDisplayed();
    }

    public void clickIssueLinkOnNotification(){
        linkToCreatedIssue.click();
    }
}
