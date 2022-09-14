package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage {
    private final static By userIcon = By.id("LayoutProfilePic");
    private final static By logoutButton = By.xpath("//a[text()='Logout']");
    private final static By othersCalculatorsButton = By.xpath("//a[@data-reveal-iframe='OtherCalciFrame']");
    private final static String MENU_LOCATOR = "//div[@id='fade-menu']/descendant::a[text()='%s']";

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

    @Step("Click item navigation menu: {item}")
    public void clickItemNavigationMenu(String item) {
        driver.findElement(By.xpath(String.format(MENU_LOCATOR, item))).click();
    }

    @Step("Click button 'Others Calculators'")
    public void clickOthersCalculatorsButton() {
        driver.findElement(othersCalculatorsButton).click();
    }

}
