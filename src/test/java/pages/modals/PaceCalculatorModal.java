package pages.modals;

import elements.InputId;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.PaceCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.AllureUtils;

@Log4j2
public class PaceCalculatorModal extends OthersCalculatorsModal{
    private static final By DISTANCE_TYPE_LOCATOR = By.id("DistType");
    private static final By CALCULATE_PACES_BUTTON_LOCATOR = By.id("saveButtonSettings");
    private final static By PACE_CHART_TABLE_LOCATOR = By.xpath("//h4[text()='Pace Chart']");
    private final static By PACE_SPLITS_TABLE_LOCATOR = By.xpath("//h4[text()='Pace Splits']");
    private final static By PACE_CHART_TABLE_ROWS_LOCATOR = By.xpath("//h4[text()='Pace Chart']/parent::div/following-sibling::div/descendant::tbody/tr");
    private final static By PACE_SPLITS_TABLE_ROWS_LOCATOR = By.xpath("//h4[text()='Pace Splits']/parent::div/following-sibling::div/descendant::tbody/tr");
    public PaceCalculatorModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
    }
    @Step("Filling form PaceCalculator")
    public  void fillForm(PaceCalculator inputPaceCalculator) {
        log.info("Filling form PaceCalculator");
        new InputId(driver, "RunDist").setValue(inputPaceCalculator.getDistance());
        if (inputPaceCalculator.getDistanceTypePaceCalculator() != null) {
            WebElement dropdownElement = driver.findElement(DISTANCE_TYPE_LOCATOR);
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(inputPaceCalculator.getDistanceTypePaceCalculator().getName());
        }
        new InputId(driver, "TimeHH").setValue(inputPaceCalculator.getHours());
        new InputId(driver, "TimeMM").setValue(inputPaceCalculator.getMinutes());
        new InputId(driver, "TimeSS").setValue(inputPaceCalculator.getSeconds());
        AllureUtils.attachScreenshot(driver);
    }

    @Step("Click 'Calculate Paces'")
    public void clickCalculatePacesButton() {
        log.info("Click 'Calculate Paces'");
        AllureUtils.attachScreenshot(driver);
        driver.findElement(CALCULATE_PACES_BUTTON_LOCATOR).click();
    }
    @Step("Ñhecking the presence of table 'Pace Chart'")
    public boolean isPaceChartTableDisplayed() {
        log.info("Ñhecking the presence of table 'Pace Chart'");
        return driver.findElement(PACE_CHART_TABLE_LOCATOR).isDisplayed();
    }
    @Step("Ñhecking the presence of table 'Pace Splits'")
    public boolean isPaceSplitsTableDisplayed() {
        log.info("Ñhecking the presence of table 'Pace Splits'");
        return driver.findElement(PACE_SPLITS_TABLE_LOCATOR).isDisplayed();
    }
    @Step("Ñhecking the presence of data in table 'Pace Chart'")
    public boolean isPaceChartTableRowsDisplayed() {
        log.info("Ñhecking the presence of data in table 'Pace Chart'");
        return !driver.findElements(PACE_CHART_TABLE_ROWS_LOCATOR).isEmpty();
    }
    @Step("Ñhecking the presence of data in table 'Pace Splits'")
    public boolean isPaceSplitsTableRowsDisplayed() {
        log.info("Ñhecking the presence of data in table 'Pace Splits'");
        return !driver.findElements(PACE_SPLITS_TABLE_ROWS_LOCATOR).isEmpty();
    }
}
