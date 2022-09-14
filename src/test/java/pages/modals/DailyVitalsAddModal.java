package pages.modals;

import elements.InputId;
import lombok.extern.log4j.Log4j2;
import models.DailyVitals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class DailyVitalsAddModal extends BaseModal {
    private static final By CANCEL_BUTTON = By.xpath("//a[text()='Cancel']");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class, 'alert-error')]");

    public DailyVitalsAddModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    public void fillForm(DailyVitals inputDailyVitals) {
        log.info("Filling form DailyVitals");
        new InputId(driver, "Steps").setValue(inputDailyVitals.getSteps());
        new InputId(driver, "Calories").setValue(inputDailyVitals.getCaloriesConsumed());
        new InputId(driver, "Weight").setValue(inputDailyVitals.getWeight());
        if (inputDailyVitals.getWeightType() != null) {
            new InputId(driver, "WeightType").setValue(inputDailyVitals.getWeightType().getName());
        }
        new InputId(driver, "BodyFat").setValue(inputDailyVitals.getBodyFat());
        new InputId(driver, "WaterPercent").setValue(inputDailyVitals.getWater());
        new InputId(driver, "MuscleMass").setValue(inputDailyVitals.getMuscleMass());
        if (inputDailyVitals.getMuscleMassType() != null) {
            new InputId(driver, "MuscleMassType").setValue(inputDailyVitals.getMuscleMassType().getName());
        }
        new InputId(driver, "RestHR").setValue(inputDailyVitals.getRestingHR());
        new InputId(driver, "HRVar").setValue(inputDailyVitals.getHRVariability());
        new InputId(driver, "SleepHours").setValue(inputDailyVitals.getSleepHours());
        new InputId(driver, "AwakeTime").setValue(inputDailyVitals.getTotalAwakeTime());
        if (inputDailyVitals.getSleepAmount() != null) {
            new InputId(driver, "SleepAmount").setValue(inputDailyVitals.getSleepAmount().getName());
        }
        if (inputDailyVitals.getSleepQuality() != null) {
            new InputId(driver, "SleepQuality").setValue(inputDailyVitals.getSleepQuality().getName());
        }
        if (inputDailyVitals.getStressAmount() != null) {
            new InputId(driver, "Stress").setValue(inputDailyVitals.getStressAmount().getName());
        }
        new InputId(driver, "Systolic").setValue(inputDailyVitals.getSystolic());
        new InputId(driver, "Diastolic").setValue(inputDailyVitals.getDiastolic());
        new InputId(driver, "HealthNotes").setValue(inputDailyVitals.getHealthNotes());
    }

    public void cancelButtonClick() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public String getErrorMessageText() {
        String text = driver.findElement(ERROR_MESSAGE_LOCATOR).getText();
        return text;
    }

}
