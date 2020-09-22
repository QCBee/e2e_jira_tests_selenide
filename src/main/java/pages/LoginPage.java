package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Driver;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private Driver driver;
    private SelenideElement userNameInput = $(byId("login-form-username"));
    private SelenideElement userPassInput = $(byId("login-form-password"));
    private SelenideElement loginButton = $(byId("login"));

    public LoginPage(Driver driver) {
        this.driver = driver;
    }

    public void openLoginPage(String loginUrl){
        open(loginUrl);
    }

    public void enterUserName(String userName){
        userNameInput.setValue(userName);
    }

    public void enterUserPass(String userPass){
        userPassInput.setValue(userPass);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
