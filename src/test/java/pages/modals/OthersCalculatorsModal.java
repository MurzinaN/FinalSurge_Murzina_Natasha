package pages.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OthersCalculatorsModal extends BaseModal{
    protected final static By IFRAME_LOCATOR = By.id("OtherCalciFrame");
    private final static By PACE_CALCULATOR_BUTTON_LOCATOR = By.xpath("//*[text()='Pace Calculator']");
    private final static By CALORIC_NEEDS_BUTTON_LOCATOR = By.xpath("//*[text()='Caloric Needs']");
    public OthersCalculatorsModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
    }

    public void switchToIframe() {
        WebElement iframe = driver.findElement(IFRAME_LOCATOR);
        driver.switchTo().frame(iframe);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void clickCaloricNeedsButton() {
        driver.findElement(CALORIC_NEEDS_BUTTON_LOCATOR).click();
    }
    public void clickPaceCalculatorButton() {
        driver.findElement(PACE_CALCULATOR_BUTTON_LOCATOR).click();
    }
}
