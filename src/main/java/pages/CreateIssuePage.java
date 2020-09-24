package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.TimeoutException;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CreateIssuePage {
    private Driver driver;

    public CreateIssuePage(Driver driver) {
        this.driver = driver;
    }

    //List of used locators - locators for actions
    private SelenideElement createIssuePopPup = $(byId("create-issue-dialog"));
    private SelenideElement projectInput = $(byId("project-field"));
    private SelenideElement issueTypeInputEnabled = $(byXpath("//*[@id='issuetype-field'][not(@disabled)]"));
    private SelenideElement issueTypeInput = $(byId("issuetype-field"));
    private SelenideElement summaryInputEnabled = $(byXpath("//*[@id='summary'][not(@disabled)]"));
    private SelenideElement summaryInput = $(byId("summary"));
    private SelenideElement reporterInput = $(byId("reporter-field"));
    private SelenideElement createButton = $(byId("create-issue-submit"));
    private SelenideElement cancelButton = $(byCssSelector("[title = 'Press undefined+` to cancel']"));
    private SelenideElement descriptionInput = $(byId("tinymce"));
    private SelenideElement priorityInput = $(byId("priority-single-select"));
    private SelenideElement textModeForDescription = $(byXpath("//*[@data-mode='source']//child::a"));

    public boolean isCreateIssuePopUpShown(){
        return createIssuePopPup.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isCreateIssuePopUpNotShown(){
        return createIssuePopPup.shouldNot(Condition.visible).isDisplayed();
    }

    public boolean isProjectInputEnabled(){
        return projectInput.shouldBe(Condition.enabled).isEnabled();
    }

    public void enterProject(String projectValue){
        projectInput.clear();
        projectInput.setValue(projectValue);
    }

    public boolean isTypeIssueInputEnabled(){
        return issueTypeInputEnabled.shouldBe(Condition.enabled).isEnabled();
    }

    public void enterTypeIssue(String typeValue){
        clickOnElementWithRetry(issueTypeInput,issueTypeInputEnabled,4,50);
        issueTypeInputEnabled.clear();
        issueTypeInputEnabled.setValue(typeValue);
    }

    public boolean isSummaryInputEnabled(){
        return summaryInput.shouldBe(Condition.enabled).isEnabled();
    }

    public void enterSummary(String summaryValue){
        summaryInput.setValue(summaryValue);
    }

    public void enterReporter(String reporterValue){
        reporterInput.clear();
        reporterInput.setValue(reporterValue);
    }

    public void clickCreateButton(){
        createButton.click();
    }
    //public boolean doProjectNameValueMatch(String projectNameValue) {
    //        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(TimeOutTypes.LOW.getTimeOutInSec()).getSeconds());
    //        return wait.until(ExpectedConditions.textToBePresentInElementLocated(projectInput, projectNameValue));
    //    }
    //
    //    public boolean doTypeIssueValueMatch(String typeIssueValue) {
    //        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(TimeOutTypes.LOW.getTimeOutInSec()).getSeconds());
    //        return wait.until(ExpectedConditions.textToBePresentInElementLocated(issueTypeInputEnabled, typeIssueValue));
    //    }
    //
    //    public boolean doSummaryValueMatch(String summaryValue) {
    //        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(TimeOutTypes.LOW.getTimeOutInSec()).getSeconds());
    //        return wait.until(ExpectedConditions.textToBePresentInElementLocated(summaryInput, summaryValue));
    //    }
    //
    //    public boolean doReporterValueMatch(String reporterValue) {
    //        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(TimeOutTypes.LOW.getTimeOutInSec()).getSeconds());
    //        return wait.until(ExpectedConditions.textToBePresentInElementLocated(reporterInput, reporterValue));
    //    }

    private void clickOnElementWithRetry(SelenideElement elementToBeClickable, SelenideElement successCriteria, int attempts, int timeOutInSec){
        for (int i = 0; i < attempts; i++) {
            elementToBeClickable.click();
            successCriteria.shouldBe(Condition.visible).isDisplayed();
            try{
                successCriteria.shouldBe(Condition.visible).isDisplayed();
                break;
            } catch (TimeoutException e){
                e.printStackTrace();
            }
        }
    }
}
