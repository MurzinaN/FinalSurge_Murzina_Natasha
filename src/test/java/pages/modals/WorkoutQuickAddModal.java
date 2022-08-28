package pages.modals;

import elements.Input;
import elements.InputDiv;
import elements.Textarea;
import lombok.extern.log4j.Log4j2;
import models.WorkoutQuick;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


@Log4j2
public class WorkoutQuickAddModal extends BaseModal {
    private static final By ACTIVITY_TYPE = By.xpath("//label[text()='Activity Type']/following-sibling::select");
    private static final By DISTANCE_TYPE = By.xpath("//select[@id='DistType']");
    private static final By PACE_TYPE = By.xpath("//select[@id='PaceType']");
    private static final By HOW_I_FELT = By.xpath("//label[text()='How I Felt']/ancestor::div[@class='span6']/descendant::select");
    private static final By PERCEIVED_EFFORT = By.xpath("//label[text()='Perceived Effort']/ancestor::div[@class='span6']/descendant::select");
    private static final By SAVE_BUTTON = By.id("saveButton");
    private static final By CANCEL_BUTTON = By.id("CancelClose");

    public WorkoutQuickAddModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    public void fillForm(WorkoutQuick inputWorkoutQuick) {
        log.info("Filling form WorkoutQuick");
        if (inputWorkoutQuick.getTimeOfDay() != null) {
            new InputDiv(driver, "Time of Day").setValue(inputWorkoutQuick.getTimeOfDay().getName());
        }
        if (inputWorkoutQuick.getActivityType() != null) {
            WebElement dropdownElement = driver.findElement(ACTIVITY_TYPE);
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(inputWorkoutQuick.getActivityType().getName());
        }
        new Input(driver, "Workout Name").setValue(inputWorkoutQuick.getWorkoutName());
        new Textarea(driver, "Workout Description").setValue(inputWorkoutQuick.getWorkoutDescription());
        new InputDiv(driver, "Distance").setValue(inputWorkoutQuick.getDistance());
        if (inputWorkoutQuick.getDistanceType() != null) {
            WebElement dropdownElement = driver.findElement(DISTANCE_TYPE);
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(inputWorkoutQuick.getDistanceType().getName());
        }
        new InputDiv(driver, "Duration").setValue(inputWorkoutQuick.getDuration());
        if (inputWorkoutQuick.getPaceType() != null) {
            WebElement dropdownElement = driver.findElement(PACE_TYPE);
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(inputWorkoutQuick.getPaceType().getName());
        }
        if (inputWorkoutQuick.getHowIFelt() != null) {
            WebElement dropdownElement = driver.findElement(HOW_I_FELT);
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(inputWorkoutQuick.getHowIFelt().getName());
        }
        if (inputWorkoutQuick.getPerceivedEffort() != null) {
            WebElement dropdownElement = driver.findElement(PERCEIVED_EFFORT);
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(inputWorkoutQuick.getPerceivedEffort().getName());
        }

        new Textarea(driver, "Post Workout Notes/Results").setValue(inputWorkoutQuick.getPostWorkoutNotes_Results());
    }

    public void saveButtonClick() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public void cancelButtonClick() {
        driver.findElement(CANCEL_BUTTON).click();
    }
}