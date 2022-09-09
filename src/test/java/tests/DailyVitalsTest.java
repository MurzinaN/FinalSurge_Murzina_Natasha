package tests;

import io.qameta.allure.Description;
import models.DailyVitals;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DailyVitalsPage;
import pages.HomePage;
import pages.modals.DailyVitalsAddModal;
import utils.DailyVitalsFactory;



public class DailyVitalsTest extends BaseTest {
    public final static String ITEM_NAVIGATION_MENU = "Daily Vitals";
    protected final static int DAY = 2;
    protected final static int MONTH = 9;
    protected final static int YEAR = 2022;
    public final static String ERROR_MESSAGE_SLEEP_HOURS = "*Sleep Hours cannot be greater than 24.00.";
    public final static String ERROR_MESSAGE_WATER = "*Water % cannot be greater than 100.00.";
    public final static String ERROR_MESSAGE_BODY_FAT = "*Body Fat % cannot be greater than 99.00.";
    public final static String ERROR_MESSAGE_CALORIES = "*Calories cannot be greater than 20000.";
    private HomePage homePage;
    private DailyVitalsPage dailyVitalsPage;
    private DailyVitalsAddModal dailyVitalsAddModal;

    @BeforeClass
    public void initialise() {
        homePage = new HomePage(driver);
        dailyVitalsPage = new DailyVitalsPage(driver);
        dailyVitalsAddModal = new DailyVitalsAddModal(driver);
    }
    @BeforeMethod()
    public void login() {
        loginPage.login(EMAIL, PASSWORD);
    }

    @Test(groups = {"regression"}, dataProvider = "AddDailyVitalsTestData")
    @Description("Add daily vitals in table")
    public void addDailyVitalsTest(int month, int day, int year, DailyVitals newDailyVitals) throws InterruptedException{
        homePage.clickItemNavigationMenu(ITEM_NAVIGATION_MENU);
        dailyVitalsPage.clickDate(month, day, year);
        dailyVitalsAddModal.fillForm(newDailyVitals);
        dailyVitalsAddModal.saveButtonClick();
        dailyVitalsAddModal.cancelButtonClick();
        Assert.assertEquals(dailyVitalsPage.getDailyVitalsInfo(month, day, year), newDailyVitals);

    }

    @DataProvider
    public Object[][] AddDailyVitalsTestData() {
        return new Object[][]{
                { MONTH, 1, YEAR, DailyVitalsFactory.getDailyVitalsAllData()},
                { MONTH, 2, YEAR, DailyVitalsFactory.getDailyVitalsSomeData()}
        };
    }

    @Test(groups = {"negative"}, dataProvider = "DailyVitalsWithIncorrectDataTestData")
    @Description("Check error message when entering incorrect data in daily vitals")
    public void DailyVitalsWithIncorrectDataTest(DailyVitals newDailyVitals, String errorMessage) throws InterruptedException{
        homePage.clickItemNavigationMenu(ITEM_NAVIGATION_MENU);
        dailyVitalsPage.clickDate(MONTH, 1, YEAR);
        dailyVitalsAddModal.fillForm(newDailyVitals);
        dailyVitalsAddModal.saveButtonClick();
        Assert.assertTrue(dailyVitalsAddModal.getErrorMessageText().contains(errorMessage));

    }

    @DataProvider
    public Object[][] DailyVitalsWithIncorrectDataTestData() {
        return new Object[][]{
                { DailyVitalsFactory.getDailyVitalsSleepHours(), ERROR_MESSAGE_SLEEP_HOURS},
                { DailyVitalsFactory.getDailyVitalsWater(), ERROR_MESSAGE_WATER},
                { DailyVitalsFactory.getDailyVitalsBodyFat(), ERROR_MESSAGE_BODY_FAT},
                { DailyVitalsFactory.getDailyVitalsCalories(), ERROR_MESSAGE_CALORIES}
        };
    }


}
