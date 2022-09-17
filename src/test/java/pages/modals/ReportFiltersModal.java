package pages.modals;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Report;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class ReportFiltersModal extends BaseModal {
    private final static By DATE_LOCATOR = By.id("WorkoutDate");
    private final static By DATE_END_LOCATOR = By.id("WorkoutDateEnd");
    private final static By ACTIVITY_TYPE_LOCATOR = By.id("ActivityType");
    private final static By VIEW_REPORT_BUTTON_LOCATOR = By.xpath("//input[@value='View Report']");

    public ReportFiltersModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    @Step("Filling form ReportModel")
    public void fillForm(Report inputReport) {
        log.info("Filling form ReportModel");
        if (inputReport.getDate() != null) {
            WebElement reportDate = driver.findElement(DATE_LOCATOR);
            reportDate.clear();
            reportDate.sendKeys(inputReport.getDate());
        }
        if (inputReport.getDateEnd() != null) {
            WebElement reportDateEnd = driver.findElement(DATE_END_LOCATOR);
            reportDateEnd.clear();
            reportDateEnd.sendKeys(inputReport.getDateEnd());
        }
        if (inputReport.getActivityType() != null) {
            WebElement dropdownElement = driver.findElement(ACTIVITY_TYPE_LOCATOR);
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(inputReport.getActivityType().getName());
        }
    }

    @Step("Click 'View Report'")
    public void clickViewReportButton() {
        log.info("Click 'View Report'");
        driver.findElement(VIEW_REPORT_BUTTON_LOCATOR).click();
    }

}
