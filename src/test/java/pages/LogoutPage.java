package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LogoutPage extends BasePage {
    private final static By LOGOUT_MESSAGE = By.xpath("//div[contains(@class, 'alert-success')]/strong");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    @Step("Checking the presence of logout message on display")
    public boolean isLogoutMessageDisplayed() {
        log.info("Checking the presence of logout message on display");
        return driver.findElement(LOGOUT_MESSAGE).isDisplayed();
    }

    @Step("Getting the text of the error message")
    public String getLogoutMessageText() {
        log.info("Getting the text of the error message");
        return driver.findElement(LOGOUT_MESSAGE).getText();
    }
}



