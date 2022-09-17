package tests;

import io.qameta.allure.Description;
import models.DailyVitals;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DailyVitalsPage;
import pages.HomePage;
import pages.modals.DailyVitalsAddModal;
import utils.DailyVitalsFactory;


public class DailyVitalsTest extends BaseTest {
    public final static String ITEM_NAVIGATION_MENU = "Daily Vitals";
    public final static String ERROR_MESSAGE_SLEEP_HOURS = "*Sleep Hours cannot be greater than 24.00.";
    public final static String ERROR_MESSAGE_WATER = "*Water % cannot be greater than 100.00.";
    public final static String ERROR_MESSAGE_BODY_FAT = "*Body Fat % cannot be greater than 99.00.";
    public final static String ERROR_MESSAGE_CALORIES = "*Calories cannot be greater than 20000.";
    protected final static int MONTH = 9;
    protected final static int YEAR = 2022;
    private final static String PAST_DAYS_NAME = "This Month";
    int dailyVitalsDay;
    int dailyVitalsMonth;
    int dailyVitalsYear;
    private HomePage homePage;
    private DailyVitalsPage dailyVitalsPage;
    private DailyVitalsAddModal dailyVitalsAddModal;

    @BeforeClass(alwaysRun = true)
    public void initialise() {
        homePage = new HomePage(driver);
        dailyVitalsPage = new DailyVitalsPage(driver);
        dailyVitalsAddModal = new DailyVitalsAddModal(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.login(EMAIL, PASSWORD);
        homePage.clickItemNavigationMenu(ITEM_NAVIGATION_MENU);
        dailyVitalsPage.selectPastDays(PAST_DAYS_NAME);
    }

    @Test(groups = {"regression", "addDailyVitals"}, dataProvider = "AddDailyVitalsTestData")
    @Description("Add daily vitals in table")
    public void addDailyVitalsTest(int month, int day, int year, DailyVitals newDailyVitals) throws InterruptedException {
        dailyVitalsPage.clickDate(month, day, year);
        dailyVitalsDay = day;
        dailyVitalsMonth = month;
        dailyVitalsYear = year;
        dailyVitalsAddModal.fillForm(newDailyVitals);
        dailyVitalsAddModal.saveButtonClick();
        dailyVitalsAddModal.cancelButtonClick();
        Assert.assertEquals(dailyVitalsPage.getDailyVitalsInfo(month, day, year), newDailyVitals, "Input data should be equals data from workout details form");

    }

    @DataProvider
    public Object[][] AddDailyVitalsTestData() {
        return new Object[][]{
                {MONTH, 10, YEAR, DailyVitalsFactory.getDailyVitalsAllData()},
                {MONTH, 13, YEAR, DailyVitalsFactory.getDailyVitalsSomeData()}
        };
    }

    @Test(groups = {"negative"}, dataProvider = "DailyVitalsWithIncorrectDataTestData")
    @Description("Check error message when entering incorrect data in daily vitals")
    public void DailyVitalsWithIncorrectDataTest(DailyVitals newDailyVitals, String errorMessage) throws InterruptedException {
        dailyVitalsPage.clickDate(MONTH, 20, YEAR);
        dailyVitalsAddModal.fillForm(newDailyVitals);
        dailyVitalsAddModal.saveButtonClick();
        Assert.assertTrue(dailyVitalsAddModal.getErrorMessageText().contains(errorMessage), "Error message should contains: " + errorMessage);

    }

    @DataProvider
    public Object[][] DailyVitalsWithIncorrectDataTestData() {
        return new Object[][]{
                {DailyVitalsFactory.getDailyVitalsSleepHours(), ERROR_MESSAGE_SLEEP_HOURS},
                {DailyVitalsFactory.getDailyVitalsWater(), ERROR_MESSAGE_WATER},
                {DailyVitalsFactory.getDailyVitalsBodyFat(), ERROR_MESSAGE_BODY_FAT},
                {DailyVitalsFactory.getDailyVitalsCalories(), ERROR_MESSAGE_CALORIES}
        };
    }

    @AfterMethod(onlyForGroups = {"addDailyVitals"})
    public void clearDataDailyVitals() {
        dailyVitalsPage.clickDate(dailyVitalsMonth, dailyVitalsDay, dailyVitalsYear);
        dailyVitalsPage.clickDelete();

    }


}

