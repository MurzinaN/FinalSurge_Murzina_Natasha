package pages.modals;

import elements.InputId;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.NewShoe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.AllureUtils;


@Log4j2
public class AddNewShoeModal extends BaseModal {

    private final static By BRAND_INPUT_LOCATOR = By.xpath("//span[text()='Select Brand...']");
    private final static String BRAND_LOCATOR = "//ul[@class='select2-results']/descendant-or-self::div[@class='select2-result-label' and text()='%s']";
    private final static By SIZE_LOCATOR = By.id("ShoeSize");
    private final static By STARTING_DISTANCE_LOCATOR = By.id("StartDist");
    private final static By STARTING_DISTANCE_TYPE_LOCATOR = By.id("DistType");
    private final static By DISTANCE_ALERT_TYPE_LOCATOR = By.id("DistAlertType");
    private final static By ADD_SHOE_BUTTON_LOCATOR = By.id("saveButton");

    public AddNewShoeModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    @Step("Filling form AddNewShoe")
    public void fillForm(NewShoe inputNewShoe) {
        log.info("Filling form AddNewShoe");
        new InputId(driver, "ShoeName").setValue(inputNewShoe.getShoeName());
        if (inputNewShoe.getBrand() != null) {
            driver.findElement(BRAND_INPUT_LOCATOR).click();
            driver.findElement(By.xpath(String.format(BRAND_LOCATOR, inputNewShoe.getBrand().getName()))).click();
        }
        new InputId(driver, "ShoeModel").setValue(inputNewShoe.getModel());
        new InputId(driver, "ShoeCost").setValue(inputNewShoe.getCost());
        new InputId(driver, "ShoeDate").setValue(inputNewShoe.getDatePurchased());
        if (inputNewShoe.getShoeSize() != null) {
            WebElement dropdownElement = driver.findElement(SIZE_LOCATOR);
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(inputNewShoe.getShoeSize().getName());
        }
        if (inputNewShoe.getStartingDistance() != null) {
            WebElement startingDistance = driver.findElement(STARTING_DISTANCE_LOCATOR);
            startingDistance.clear();
            startingDistance.sendKeys(inputNewShoe.getStartingDistance());
        }

        if (inputNewShoe.getStartingDistanceType() != null) {
            WebElement dropdownElement = driver.findElement(STARTING_DISTANCE_TYPE_LOCATOR);
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(inputNewShoe.getStartingDistanceType().getName());
        }
        new InputId(driver, "DistAlert").setValue(inputNewShoe.getDistanceAlert());
        if (inputNewShoe.getDistanceAlertType() != null) {
            WebElement dropdownElement = driver.findElement(DISTANCE_ALERT_TYPE_LOCATOR);
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(inputNewShoe.getDistanceAlertType().getName());
        }
        new InputId(driver, "ShoeNotes").setValue(inputNewShoe.getNotes());

    }

    @Step("Click 'Add Shoe'")
    public void clickAddShoeButton() {
        log.info("Click 'Add Shoe'");
        AllureUtils.attachScreenshot(driver);
        driver.findElement(ADD_SHOE_BUTTON_LOCATOR).click();
    }
}

