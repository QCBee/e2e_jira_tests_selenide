package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class ForgotLoginPage {
    private Driver driver;
    private SelenideElement forgotLoginForm = $(byId("forgot-login"));

    public ForgotLoginPage(Driver driver) {
        this.driver = driver;
    }

    public boolean isForgotLoginFormShown(){
        return forgotLoginForm.shouldBe(Condition.visible).isDisplayed();
    }

}
