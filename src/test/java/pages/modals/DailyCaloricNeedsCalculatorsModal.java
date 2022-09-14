package pages.modals;

import elements.InputCalculator;
import elements.RadioButtonCalculator;
import lombok.extern.log4j.Log4j2;
import models.DailyCaloricNeedsCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AllureUtils;

@Log4j2
public class DailyCaloricNeedsCalculatorsModal extends OthersCalculatorsModal{
    private final static By TODAYS_CALORIC_NEEDS_TABLE_LOCATOR = By.xpath("//*[text()='Non-Activity Calories']/ancestor::table");
    private static final By CALCULATE_CALORIC_NEEDS_BUTTON = By.id("saveButtonSettings");
    private final static By TODAYS_CALORIC_NEEDS_TABLE_ROWS_LOCATOR = By.xpath("//th[text()='Non-Activity Calories']/ancestor::table/descendant::tbody/tr");
    public DailyCaloricNeedsCalculatorsModal(WebDriver driver) {
        super(driver);
    }
    @Override
    public void waitForPageLoaded() {
    }



    public  void fillForm(DailyCaloricNeedsCalculator inputDailyCaloricNeedsCalculator) {
        log.info("Filling form DailyCaloricNeedsCalculator");
        new InputCalculator(driver, "Weight").setValue(inputDailyCaloricNeedsCalculator.getWeight());
        new RadioButtonCalculator(driver, "WeightType").setValue(inputDailyCaloricNeedsCalculator.getWeightTypeCalculator().getName());
        new InputCalculator(driver, "HeightInchCent").setValue(inputDailyCaloricNeedsCalculator.getHeight());
        new RadioButtonCalculator(driver, "HeightType").setValue(inputDailyCaloricNeedsCalculator.getHeightTypeCalculator().getName());
        new InputCalculator(driver, "Age").setValue(inputDailyCaloricNeedsCalculator.getAge());
        new RadioButtonCalculator(driver, "Gender").setValue(inputDailyCaloricNeedsCalculator.getGenderTypeCalculator().getName());
        new InputCalculator(driver, "RunDist").setValue(inputDailyCaloricNeedsCalculator.getDistance());
        new RadioButtonCalculator(driver, "DistType").setValue(inputDailyCaloricNeedsCalculator.getDistanceTypeCalculator().getName());
        AllureUtils.attachScreenshot(driver);
    }
    public void clickCalculateCaloricNeedsButton() {
        driver.findElement(CALCULATE_CALORIC_NEEDS_BUTTON).click();
    }
    public boolean isTodaysCaloricNeedsTableDisplayed() {
        return driver.findElement(TODAYS_CALORIC_NEEDS_TABLE_LOCATOR).isDisplayed();
    }

    public boolean isTodaysCaloricNeedsTableRowsDisplayed() {
        return !driver.findElements(TODAYS_CALORIC_NEEDS_TABLE_ROWS_LOCATOR).isEmpty();
    }
}
