package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogoutPage extends BasePage {
    private final static By logoutMessage = By.xpath("//div[contains(@class, 'alert-success')]/strong");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    @Step("Ñhecking the presence of logout message on display")
    public boolean isLogoutMessageDisplayed() {
        return driver.findElement(logoutMessage).isDisplayed();
    }

    public String getLogoutMessageText() {
        return driver.findElement(logoutMessage).getText();
    }
}
