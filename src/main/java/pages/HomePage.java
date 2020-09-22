package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private Driver driver;
    private SelenideElement userProfileIcon = $(byCssSelector(".aui-avatar-inner"));

    public HomePage(Driver driver) {
        this.driver = driver;
    }

    public void isUserProfileIconShown(){
        userProfileIcon.shouldBe(Condition.appear);
    }
}
