package pages;

import enums.SleepAmount;
import enums.SleepQuality;
import enums.StressAmount;
import enums.WeightType;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.DailyVitals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


@Log4j2
public class DailyVitalsPage extends BasePage {
    private final static String DATE_LOCATOR = "//a[text()='%s/%s/%s']";
    private final static String DATA_LOCATOR = "//a[text()='%s/%s/%s']/parent::td/following-sibling::td";
    private final static String NOTES_LOCATOR = "//a[text()='%s/%s/%s']/parent::td/following-sibling::td/span";
    private final static By DELETE_LOCATOR = By.xpath("//a[@title='Delete']");
    private final static By OK_BUTTON_LOCATOR = By.xpath("//a[@data-handler='1']");
    private final static By PAST_DAYS_LOCATOR = By.id("PastDays");

    public DailyVitalsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
    }

    @Step("Select data display interval: {name}")
    public void selectPastDays(String name) {
        log.info("Select data display interval");
        WebElement dropdownElement = driver.findElement(PAST_DAYS_LOCATOR);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(name);

    }

    @Step("Choise date for input daily vitals")
    public void clickDate(int month, int day, int year) {
        log.info("Choise date for input daily vitals");
        driver.findElement(By.xpath(String.format(DATE_LOCATOR, month, day, year))).click();
    }

    @Step("Filling form DailyVitals with recived data")
    public DailyVitals getDailyVitalsInfo(int month, int day, int year) {
        log.info("Filling form DailyVitals with recived data");
        DailyVitals.DailyVitalsBuilder dailyVitalsBuilder = DailyVitals.builder();
        List<WebElement> allItem = driver.findElements(By.xpath(String.format(DATA_LOCATOR, month, day, year)));
        String steps = allItem.get(0).getText();
        if (steps != "") {
            dailyVitalsBuilder.steps(steps);
        }
        String weightAndType = allItem.get(1).getText();
        if (weightAndType != "") {
            String[] weightAndTypeSplit = weightAndType.split(" ");
            String weight = weightAndTypeSplit[0];
            if (weight != "") {
                dailyVitalsBuilder.weight(weight);
            }
            String weightType = weightAndTypeSplit[1];
            if (weightType != "") {
                dailyVitalsBuilder.weightType(WeightType.fromString(weightType));
            }
        }
        String bodyFat = allItem.get(2).getText().replace("%", "");
        if (bodyFat != "") {
            dailyVitalsBuilder.bodyFat(bodyFat);
        }
        String restingHR = allItem.get(3).getText().replace(" bpm", "");
        if (restingHR != "") {
            dailyVitalsBuilder.restingHR(restingHR);
        }
        String hRVariability = allItem.get(4).getText();
        if (hRVariability != "") {
            dailyVitalsBuilder.hRVariability(hRVariability);
        }
        String caloriesConsumed = allItem.get(5).getText().replace(" kCal", "");
        if (caloriesConsumed != "") {
            dailyVitalsBuilder.caloriesConsumed(caloriesConsumed);
        }
        String water = allItem.get(6).getText().replace("%", "");
        if (water != "") {
            dailyVitalsBuilder.water(water);
        }
        String muscleMassAndType = allItem.get(7).getText();
        if (muscleMassAndType != "") {
            String[] muscleMassAndTypeSplit = muscleMassAndType.split(" ");
            String muscleMass = muscleMassAndTypeSplit[0];
            if (muscleMass != "") {
                dailyVitalsBuilder.muscleMass(muscleMass);
            }
            String muscleMassType = muscleMassAndTypeSplit[1];
            if (muscleMassType != "") {
                dailyVitalsBuilder.muscleMassType(WeightType.fromString(muscleMassType));
            }
        }
        String sleepHours = allItem.get(8).getText().replace(" hrs", "");
        if (sleepHours != "") {
            dailyVitalsBuilder.sleepHours(sleepHours);
        }
        String totalAwakeTime = allItem.get(9).getText().replace(" hrs", "");
        if (totalAwakeTime != "") {
            dailyVitalsBuilder.totalAwakeTime(totalAwakeTime);
        }
        String sleepAmount = allItem.get(10).getText();
        if (sleepAmount != "") {
            dailyVitalsBuilder.sleepAmount(SleepAmount.fromString(sleepAmount));
        }
        String sleepQuality = allItem.get(11).getText();
        if (sleepQuality != "") {
            dailyVitalsBuilder.sleepQuality(SleepQuality.fromString(sleepQuality));
        }
        String stressAmount = allItem.get(12).getText();
        if (stressAmount != "") {
            dailyVitalsBuilder.stressAmount(StressAmount.fromString(stressAmount));
        }
        String bloodPressure = allItem.get(13).getText().replace(" mm Hg", "");
        if (bloodPressure != "") {
            String[] bloodPressureSplit = bloodPressure.split(" / ");
            String systolic = bloodPressureSplit[0];
            if (systolic != "") {
                dailyVitalsBuilder.systolic(systolic);
            }
            String diastolic = bloodPressureSplit[1];
            if (diastolic != "") {
                dailyVitalsBuilder.diastolic(diastolic);
            }
        }
        if (isElementPresentByLocator(By.xpath(String.format(NOTES_LOCATOR, month, day, year)))) {
            String healthNotes = driver.findElement(By.xpath(String.format(NOTES_LOCATOR, month, day, year))).getText();
            if (healthNotes != "") {
                dailyVitalsBuilder.healthNotes(healthNotes);
            }
        }
        return dailyVitalsBuilder.build();
    }

    @Step("Click 'Delete'")
    public void clickDelete() {
        log.info("Click 'Delete'");
        driver.findElement(DELETE_LOCATOR).click();
        WebElement ok = driver.findElement(OK_BUTTON_LOCATOR);
        jsClick(ok);
    }

}
