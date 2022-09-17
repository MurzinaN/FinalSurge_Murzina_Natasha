package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class HomePage extends BasePage {
    private final static By USER_ICON = By.id("LayoutProfilePic");
    private final static By LOGOUT_BUTTON = By.xpath("//a[text()='Logout']");
    private final static By OTHERS_CALCULATORS_BUTTON = By.xpath("//a[@data-reveal-iframe='OtherCalciFrame']");
    private final static String MENU_LOCATOR = "//div[@id='fade-menu']/descendant::a[text()='%s']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }


    @Step("Checking the presence of user icon on display")
    public boolean isUserIconDisplayed() {
        log.info("Checking the presence of user icon on display");
        return driver.findElement(USER_ICON).isDisplayed();
    }

    @Step("Click 'Logout'")
    public void clickLogoutButton() {
        log.info("Click 'Logout'");
        driver.findElement(LOGOUT_BUTTON).click();
    }

    @Step("Click item navigation menu: {item}")
    public void clickItemNavigationMenu(String item) {
        log.info("Click item navigation menu");
        waitForElementClickable(By.xpath(String.format(MENU_LOCATOR, item)));
        driver.findElement(By.xpath(String.format(MENU_LOCATOR, item))).click();
    }

    @Step("Click item Workouts menu: {item}")
    public void clickItemWorkoutsMenu(String item, String subItem) {
        log.info("Click item Workouts menu");
        Actions actions = new Actions(driver);
        WebElement workout = driver.findElement(By.xpath(String.format(MENU_LOCATOR, item)));
        actions.moveToElement(workout).build().perform();
        driver.findElement(By.xpath(String.format(MENU_LOCATOR, subItem))).click();
    }


    @Step("Click 'Others Calculators'")
    public void clickOthersCalculatorsButton() {
        log.info("Click 'Others Calculators'");
        driver.findElement(OTHERS_CALCULATORS_BUTTON).click();
    }

}
