package pages.modals;

import elements.InputCalculator;
import elements.RadioButtonCalculator;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.DailyCaloricNeedsCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    @Step("Filling form DailyCaloricNeedsCalculator")
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

    }
    @Step("Click 'Calculate Caloric Needs'")
    public void clickCalculateCaloricNeedsButton() {
        log.info("Click 'Calculate Caloric Needs'");
        AllureUtils.attachScreenshot(driver);
        driver.findElement(CALCULATE_CALORIC_NEEDS_BUTTON).click();
    }
    @Step("�hecking the presence of table 'Today's Caloric Needs'")
    public boolean isTodaysCaloricNeedsTableDisplayed() {
        log.info("�hecking the presence of table 'Today's Caloric Needs'");
        return driver.findElement(TODAYS_CALORIC_NEEDS_TABLE_LOCATOR).isDisplayed();
    }
    @Step("�hecking the presence of data in table 'Today's Caloric Needs'")
    public boolean isTodaysCaloricNeedsTableRowsDisplayed() {
        log.info("�hecking the presence of data in table 'Today's Caloric Needs'");
        return !driver.findElements(TODAYS_CALORIC_NEEDS_TABLE_ROWS_LOCATOR).isEmpty();
    }
}
