package tests;


import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AthleteWorkoutReportPage;
import pages.HomePage;
import pages.modals.ReportFiltersModal;
import utils.ReportFiltersFactory;
import utils.UpdateActivityType;

public class ReportsAndStatisticsTest extends BaseTest{
    public final static String ITEM_NAVIGATION_MENU = "Workouts";
    public final static String ITEM_WORKOUT_MENU = "Reports & Statistics";
    public final static int EXPECTED_NUMBERS = 3;
    private HomePage homePage;
    private AthleteWorkoutReportPage athleteWorkoutReportPage;
    private ReportFiltersModal reportFiltersModal;

    @BeforeClass(alwaysRun = true)
    public void initialise() {
        homePage = new HomePage(driver);
        athleteWorkoutReportPage = new AthleteWorkoutReportPage(driver);
        reportFiltersModal = new ReportFiltersModal(driver);
    }
    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.login(EMAIL, PASSWORD);
        homePage.clickItemWorkoutsMenu(ITEM_NAVIGATION_MENU, ITEM_WORKOUT_MENU);

    }

    @Test(groups = {"smoke"})
    @Description("Getting a report on training for the selected period")
    public void reportTest(){
        reportFiltersModal.fillForm(ReportFiltersFactory.getReportFilters());
        reportFiltersModal.clickViewReportButton();
        Assert.assertEquals(athleteWorkoutReportPage.countNumberWorkouts(), EXPECTED_NUMBERS, "Numbers of workout in report should be "+EXPECTED_NUMBERS);
        Assert.assertEquals(athleteWorkoutReportPage.checkActivityType(),UpdateActivityType.update(ReportFiltersFactory.getReportFilters().getActivityType().getName(),athleteWorkoutReportPage.countNumberWorkouts()), "Activity type all workouts in report should be: "+ReportFiltersFactory.getReportFilters().getActivityType().getName());
    }
}
