package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private Driver driver;
    private SelenideElement dashboard = $(byId("dashboard-content"));

    public HomePage(Driver driver) {
        this.driver = driver;
    }

    public boolean isDashboardShown(){
        return dashboard.shouldBe(Condition.visible).isDisplayed();
    }
}
