package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final static By userIcon = By.id("LayoutProfilePic");
    private final static By logoutButton = By.xpath("//a[text()='Logout']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    @Step("Ñhecking the presence of user icon on display")
    public boolean isUserIconDisplayed() {
        return driver.findElement(userIcon).isDisplayed();
    }

    @Step("Click button 'Logout'")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
