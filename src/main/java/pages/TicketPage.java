package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TicketPage {
    private Driver driver;

    public TicketPage(Driver driver) {
        this.driver = driver;
    }

    //List of used locators
    private SelenideElement projectAvatar = $(byId("project-avatar"));

    //Buttons on Command Bar
    private SelenideElement editButtonOnCommandBar = $(byId("edit-issue"));
    private SelenideElement commentButtonOnCommandBar = $(byId("comment-issue"));
    private SelenideElement assignButtonOnCommandBar = $(byId("assign-issue"));
    private SelenideElement moreDropDownButtonOnCommandBar = $(byId("opsbar-operations_more"));
    private SelenideElement backlogButtonOnCommandBar = $(byXpath("//*[contains(text(),'Backlog')][@class='trigger-label']"));
    private SelenideElement selectedForDevelopmentButtonOnCommandBar = $(byXpath("//*[contains(text(),'Selected for Development')][@class='trigger-label']"));
    private SelenideElement workflowButtonOnCommandBar = $(byId("opsbar-transitions_more"));
    private SelenideElement shareButtonOnCommandBar = $(byId("jira-share-trigger"));
    private SelenideElement exportButtonOnCommandBar = $(byId("viewissue-export"));

    //Details section
    private SelenideElement detailsLabel = $(byId("details-module_heading"));
    private SelenideElement typeIssueField = $(byId("type-val"));
    private SelenideElement priorityIssueField = $(byId("priority-val"));
    private SelenideElement labelsIssueField = $(byId("wrap-labels"));
    private SelenideElement statusIssueField = $(byId("status-val"));
    private SelenideElement resolutionIssueField = $(byId("resolution-val"));

    //Description section
    private SelenideElement descriptionArea = $(byId("description-val"));
    private SelenideElement descriptionLabel = $(byId("descriptionmodule_heading"));

    //Attachment section
    private SelenideElement attachmentLabel = $(byId("attachmentmodule_heading"));
    private SelenideElement attachmentArea = $(byXpath("//*[contains(text(),' Drop files to attach, or ')]"));
    private SelenideElement browseLinkOnAttachmentArea = $(byXpath("//*[@type='button'][contains(text(),' browse')]"));
    private SelenideElement moreButtonAttachmentSection = $(byXpath("//*[@title = 'Options']"));

    public void openTicletPage(String pageUrl){
        open(pageUrl);
    }

    public boolean isProjectAvatarIconShown(){
        return projectAvatar.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isEditButtonOnCommandBarShown(){
        return editButtonOnCommandBar.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isCommentButtonOnCommandBarShown(){
        return commentButtonOnCommandBar.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isAssignButtonOnCommandBarShown(){
        return assignButtonOnCommandBar.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isMoreDropDownButtonOnCommandBarShown(){
        return moreDropDownButtonOnCommandBar.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isBacklogButtonOnCommandBarShown(){
        return backlogButtonOnCommandBar.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isSelectedForDevelopmentButtonShown(){
        return selectedForDevelopmentButtonOnCommandBar.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isWorkflowButtonOnCommandBarShown(){
        return workflowButtonOnCommandBar.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isShareButtonOncommandBarShown(){
        return shareButtonOnCommandBar.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isExportButtonOnCommandBarShown(){
        return exportButtonOnCommandBar.shouldBe(Condition.visible).isDisplayed();
    }






}
