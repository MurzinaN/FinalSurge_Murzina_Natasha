package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CalendarPage extends BasePage {
    private final static String DATE_LOCATOR = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']";
    private final static String PLUS_BUTTON_LOCATOR = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']/descendant::i[@class='icon-plus']";
    private final static String QUICK_ADD_LOCATOR = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']/descendant::a[@class='quick-add']";
    private final static String TRAINING_LOCATOR = "//td[@data-day='%s' and @data-month='%s' and @data-year='%s']/descendant::div[@class='fc-event-activity-title' and contains(text(), '%s')]";
    private final static String VIEW_BUTTON_LOCATOR = "//*[@data-title='%s']/ancestor::div[@data-date='%s/%s/%s']/descendant::a[@role='menuitem' and @class='full-view']";

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    public void addQuickTraining(int day, int month, int year) {
        driver.findElement(By.xpath(String.format(DATE_LOCATOR, day, month, year))).click();
        driver.findElement(By.xpath(String.format(PLUS_BUTTON_LOCATOR, day, month, year))).click();
        driver.findElement(By.xpath(String.format(QUICK_ADD_LOCATOR, day, month, year))).click();
    }

    public void openTraining(int day, int month, int year, String name) {
        driver.findElement(By.xpath(String.format(TRAINING_LOCATOR, day, month, year, name))).click();
    }

    public void viewButtonClick(String name, int month, int day, int year) {
        driver.findElement(By.xpath(String.format(VIEW_BUTTON_LOCATOR, name, month, day, year))).click();
    }


}
