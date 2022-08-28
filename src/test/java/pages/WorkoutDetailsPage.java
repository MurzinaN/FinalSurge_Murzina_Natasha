package pages;

import enums.*;
import lombok.extern.log4j.Log4j2;
import models.WorkoutQuick;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class WorkoutDetailsPage extends BasePage {
    private final static By WORKOUT_NAME_LOCATOR = By.xpath("//div[@class='formSep']/descendant::div[contains(@style, 'clear:')]");
    private final static By TIME_LOCATOR = By.xpath("//div[contains(@style, 'float:')]/small[@class='muted']");
    private final static By ACTIVITY_TYPE_LOCATOR = By.className("activityTypeName");
    private final static By DESCRIPTION_LOCATOR = By.xpath("//small[text()='Workout Description:']/ancestor::p");
    private final static By STATISTIC_LOCATOR = By.xpath("//small[text()='Workout Statistics:']/following-sibling::span[contains(@class, 'label-info')]");
    private final static By PACE_LOCATOR = By.xpath("//small[text()='Workout Statistics:']/following-sibling::span[contains(@class, 'label-info')]/following-sibling::span[contains(@class, 'label')]");
    private final static By HOW_I_FELT_LOCATOR = By.xpath("//small[text()='How I Felt:']/following-sibling::span[contains(@class, 'label')]");
    private final static By PERCEIVED_EFFORT_LOCATOR = By.xpath("//small[text()='Perceived Effort']/parent::div[@class='formSep']");
    private final static By POST_WORKOUT_LOCATOR = By.xpath("//h4[text()='Post Workout Notes & Results']");
    private final static By POST_WORKOUT_NOTES_LOCATOR = By.xpath("//h4[text()='Post Workout Notes & Results']/ancestor::div[@data-label='notes-edit']/descendant::div[@class='formSep']");

    public WorkoutDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    public WorkoutQuick getWorkoutQuickInfo() {
        log.info("Filling form WorkoutQuick with recived data");
        WorkoutQuick.WorkoutQuickBuilder workoutQuickBuilder = WorkoutQuick.builder();
        if (isElementPresent(WORKOUT_NAME_LOCATOR) == true) {
            String workoutName = driver.findElement(WORKOUT_NAME_LOCATOR).getText();
            workoutQuickBuilder.workoutName(workoutName);
        }
        if (isElementPresent(TIME_LOCATOR) == true) {
            String time = driver.findElement(TIME_LOCATOR).getText();
            if (time.contains(":")) {
                String[] timeSplit = time.split("- ");
                String timeOfDay = "0" + timeSplit[1];
                workoutQuickBuilder.timeOfDay(TimeOfDay.fromString(timeOfDay));
            }
        }
        if (isElementPresent(ACTIVITY_TYPE_LOCATOR) == true) {
            String activityTypeName = driver.findElement(ACTIVITY_TYPE_LOCATOR).getText();
            if (activityTypeName.contains("-")) {
                String activityType = activityTypeName.replace(" - ", ": ");
                activityType = "    -" + activityType;
                workoutQuickBuilder.activityType(ActivityType.fromString(activityType));

            } else {
                workoutQuickBuilder.activityType(ActivityType.fromString(activityTypeName));
            }
        }
        if (isElementPresent(DESCRIPTION_LOCATOR) == true) {
            String workoutDescription = driver.findElement(DESCRIPTION_LOCATOR).getText();
            workoutDescription = workoutDescription.replace("Workout Description:\n", "");
            workoutQuickBuilder.workoutDescription(workoutDescription);
        }
        if (isElementPresent(STATISTIC_LOCATOR) == true) {
            String statistic = driver.findElement(STATISTIC_LOCATOR).getText();
            statistic = statistic.replace(" ~ ", " ");
            String[] workoutStatistic = statistic.split(" ");
            workoutQuickBuilder.distance(workoutStatistic[0]);
            workoutQuickBuilder.distanceType(DistanceType.fromString(workoutStatistic[1]));
            workoutQuickBuilder.duration("0" + workoutStatistic[2]);
        }
        if (isElementPresent(PACE_LOCATOR) == true) {
            String pace = driver.findElement(PACE_LOCATOR).getText();
            String[] paceType = pace.split(" ");
            workoutQuickBuilder.paceType(PaceType.fromString(paceType[1]));
        }
        if (isElementPresent(HOW_I_FELT_LOCATOR) == true) {
            String howIFelt = driver.findElement(HOW_I_FELT_LOCATOR).getText();
            workoutQuickBuilder.howIFelt(HowIFelt.fromString(howIFelt));
        }
        if (isElementPresent(PERCEIVED_EFFORT_LOCATOR) == true) {
            String perceivedEffortText = driver.findElement(PERCEIVED_EFFORT_LOCATOR).getText();
            String[] perceivedEffortSplit = perceivedEffortText.split("  ");
            String perceivedEffort = perceivedEffortSplit[1].replace(" Perceived Effort ", "");
            workoutQuickBuilder.perceivedEffort(PerceivedEffort.fromString(perceivedEffort));
        }
        if (isElementPresent(POST_WORKOUT_LOCATOR) == true) {
            driver.findElement(POST_WORKOUT_LOCATOR).click();
            String postWorkoutNotesResults = driver.findElement(POST_WORKOUT_NOTES_LOCATOR).getText();
            workoutQuickBuilder.postWorkoutNotes_Results(postWorkoutNotesResults);
        }
        return workoutQuickBuilder.build();
    }

}