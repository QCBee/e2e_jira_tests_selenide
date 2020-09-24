package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class DeleteCommentPage {
    private Driver driver;

    public DeleteCommentPage(Driver driver) {
        this.driver = driver;
    }

    //List of locators
    private SelenideElement deletePopUp = $(byId("delete-comment-dialog"));
    private SelenideElement deleteButton = $(byId("comment-delete-submit"));
    private SelenideElement cancelButton = $(byId("comment-delete-cancel"));

    public void clickDeleteButton(){
        deleteButton.click();
    }

    public boolean isDeletePopUpShown(){
        return deletePopUp.should(Condition.visible).isDisplayed();
    }

    public boolean isDeleteButtonShown(){
        return deleteButton.should(Condition.visible).isDisplayed();
    }

    public boolean isDeletePopUpClosed(){
        return deletePopUp.shouldNot(Condition.visible).isDisplayed();
    }
}
