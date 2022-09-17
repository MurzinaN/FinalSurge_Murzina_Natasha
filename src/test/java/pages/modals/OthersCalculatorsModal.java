package pages.modals;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class OthersCalculatorsModal extends BaseModal {
    protected final static By IFRAME_LOCATOR = By.id("OtherCalciFrame");
    private final static By PACE_CALCULATOR_BUTTON_LOCATOR = By.xpath("//*[text()='Pace Calculator']");
    private final static By CALORIC_NEEDS_BUTTON_LOCATOR = By.xpath("//*[text()='Caloric Needs']");

    public OthersCalculatorsModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
    }

    @Step("Switch to Iframe")
    public void switchToIframe() {
        log.info("Switch to Iframe");
        WebElement iframe = driver.findElement(IFRAME_LOCATOR);
        driver.switchTo().frame(iframe);
    }

    @Step("Switch from Iframe")
    public void switchToDefaultContent() {
        log.info("Switch fromIframe");
        driver.switchTo().defaultContent();
    }

    @Step("Click button 'Caloric Needs'")
    public void clickCaloricNeedsButton() {
        log.info("Click button 'Caloric Needs'");
        driver.findElement(CALORIC_NEEDS_BUTTON_LOCATOR).click();
    }

    @Step("Click button 'Pace Calculator'")
    public void clickPaceCalculatorButton() {
        log.info("Click button 'Pace Calculator'");
        driver.findElement(PACE_CALCULATOR_BUTTON_LOCATOR).click();
    }
}
