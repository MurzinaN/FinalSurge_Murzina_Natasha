package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


@Log4j2
public class AthleteWorkoutReportPage extends BasePage {
    private final static By ITEMS_TABLE_LOCATOR = By.xpath("//th[text()='Activity']/ancestor::table/tbody/tr");
    private final static By ACTIVITIES_TYPES_NAMES_LOCATOR = By.xpath("//th[text()='Activity']/ancestor::table/tbody/tr/td[2]/a");

    public AthleteWorkoutReportPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    @Step("Count the number of workouts")
    public int countNumberWorkouts() {
        log.info("Count the number of workouts");
        List<WebElement> workouts = driver.findElements(ITEMS_TABLE_LOCATOR);
        int number = workouts.size();
        return number;
    }

    @Step("Ñheck if the ActivityType match")
    public List<String> checkActivityType() {
        log.info("Ñheck if the ActivityType match");
        List<WebElement> activities = driver.findElements(ACTIVITIES_TYPES_NAMES_LOCATOR);
        List<String> types = activities.stream().map(WebElement::getText).toList();
        return types;
    }

}


