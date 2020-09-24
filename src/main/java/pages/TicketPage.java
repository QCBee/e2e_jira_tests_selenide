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

    //Activity section
    private SelenideElement activityLabel = $(byId("activitymodule_heading"));
    private SelenideElement allTabNotSelected = $(byXpath("//*[@id='all-tabpanel'][contains(text(),'All')]"));
    private SelenideElement commentTab = $(byId("comment-tabpanel"));
    private SelenideElement addCommentFooterButton = $(byId("footer-comment-button"));
    private SelenideElement workLogTabNotSelected = $(byXpath("//*[@id='worklog-tabpanel'][contains(text(),'Work Log')]"));
    private SelenideElement historyTabNotSelected = $(byXpath("//*[@id='changehistory-tabpanel'][contains(text(),'History')]"));
    private SelenideElement activityTabNotSelected = $(byXpath("//*[@id='activity-stream-issue-tab'][contains(text(),'Activity')]"));
    private SelenideElement jigitTabNotSelected = $(byXpath("//*[@id ='jigit-tab-panel'][contains(text(),'Jigit')]"));

    //Locators for comment section
    private SelenideElement commentInput = $(byId("comment"));
    private SelenideElement addCommentButtonEnabled = $(byId("issue-comment-add-submit"));
    private SelenideElement addCommentButtonDisabled = $(byXpath("//*[@id='issue-comment-add-submit' and @disabled = 'disabled']"));
    private SelenideElement cancelAddCommentButton = $(byId("issue-comment-add-cancel"));
    private SelenideElement logsIssueArea = $(byId("issue_actions_container"));
    private SelenideElement addedCommentValue = $(byXpath("//*[contains(text(),'I am a test comment')]"));
    private SelenideElement textMode = $(byXpath("//*[@data-mode='source']//child::a"));
    private SelenideElement anyNotAddedCommentsArea = $(byXpath("//*[contains(text(),'There are no comments yet on this issue.')]"));
    private SelenideElement deleteIcon = $(byXpath("//*[@title='Delete']"));
    private SelenideElement updateIssueNotification = $(byXpath("//*[contains(text(),'WEBINAR-12303 has been updated.')]"));

    public void openTicketPage(String pageUrl){
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

    public boolean isDetailsLabelShown(){
        return detailsLabel.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isTypeIssueFieldShown(){
        return typeIssueField.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isPriorityIssueFieldShown(){
        return priorityIssueField.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isLabelsIssueFieldShown(){
        return labelsIssueField.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isStatusIssueFieldShown(){
        return statusIssueField.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isResolutionIssueFieldShown(){
        return resolutionIssueField.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isDescriptionAreaShown(){
        return descriptionArea.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isDescriptionLabelShown(){
        return descriptionLabel.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isAttachmentLabelShown(){
        return attachmentLabel.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isMoreButtonForAttachmentSectionShown(){
        return moreButtonAttachmentSection.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isAttachmentAreaShown(){
        return attachmentArea.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isBrowseButtonShownOnAttachmentArea(){
        return browseLinkOnAttachmentArea.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isActivitySectionShown(){
        return activityLabel.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isAllTabNotSelectedShown(){
        return allTabNotSelected.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isAddCommentFooterButtonEnabled(){
        return addCommentFooterButton.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isWorkLogTabNotSelectedShown(){
        return workLogTabNotSelected.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isHistoryTabNotSelectedShown(){
        return historyTabNotSelected.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isActivityTabNotSelectedShown(){
        return activityTabNotSelected.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isJigitTabNotSelectedShown(){
        return jigitTabNotSelected.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isCommentTabSelected(){
        return commentTab.shouldBe(Condition.visible).isDisplayed();
    }

    public boolean isAnyCommentNotAdded(){
        return anyNotAddedCommentsArea.should(Condition.visible).isDisplayed();
    }

    public void clickAddCommentFooterButton(){
        addCommentFooterButton.click();
    }

    public boolean isAddCommentAreaShown(){
        return commentInput.should(Condition.visible).isDisplayed();
    }

    public boolean isAddCommentFooterButtonDisabled(){
        return addCommentFooterButton.shouldNot(Condition.visible).isDisplayed();
    }

    public boolean isAddCommentButtonDisabled(){
        return addCommentButtonDisabled.should(Condition.visible).isDisplayed();
    }

    public boolean isCancelButtonEnabled(){
        return cancelAddCommentButton.should(Condition.visible).isDisplayed();
    }

    public void selectTextModeForComment(){
        textMode.click();
    }

    public boolean isTextModeForCommentSelected(){
        return textMode.should(Condition.enabled).isSelected();
    }

    public void enterComment(String commentValue){
        commentInput.setValue(commentValue);
    }

    public boolean isAddCommentButtonEnabled(){
        return addCommentButtonEnabled.should(Condition.enabled).isDisplayed();
    }

    public void clickAddCommentButton(){
        addCommentButtonEnabled.click();
    }

    public boolean isLogIssueAreaShown(){
        return logsIssueArea.should(Condition.visible).isDisplayed();
    }

    public boolean isAddedCommentShown(){
        return addedCommentValue.should(Condition.visible).isDisplayed();
    }

    public void clickDeleteCommentIcon(){
        deleteIcon.click();
    }

    public boolean isUpdateIssueNotificationShown(){
        return updateIssueNotification.should(Condition.visible).isDisplayed();
    }

    public boolean isDeleteIconShown(){
        return deleteIcon.should(Condition.visible).isDisplayed();
    }

    public boolean isUpdateIssueNotificationNotShown(){
        return updateIssueNotification.shouldNot(Condition.visible).isDisplayed();
    }

    public void navigateToTicketPage(String ticketUrl){
        open(ticketUrl);
    }




}
