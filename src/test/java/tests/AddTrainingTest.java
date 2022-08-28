package tests;

import io.qameta.allure.Description;
import models.WorkoutQuick;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.WorkoutDetailsPage;
import pages.modals.WorkoutQuickAddModal;
import utils.WorkoutQuickFactory;

public class AddTrainingTest extends BaseTest {
    protected final static int DAY = 11;
    protected final static int MONTH = 8;
    protected final static int YEAR = 2022;
    private CalendarPage calendarPage;
    private WorkoutQuickAddModal workoutQuickAddModal;
    private WorkoutDetailsPage workoutDetailsPage;

    @BeforeClass
    public void initialise() {
        calendarPage = new CalendarPage(driver);
        workoutQuickAddModal = new WorkoutQuickAddModal(driver);
        workoutDetailsPage = new WorkoutDetailsPage(driver);
    }

    @Test(groups = {"regression"}, dataProvider = "AddTrainingOnCalendarTestData")
    @Description("Quick add training on calendar")
    public void addTrainingOnCalendarTest(int day, int month, int year, WorkoutQuick newWorkoutQuick) throws InterruptedException {
        loginPage.login(EMAIL, PASSWORD);
        calendarPage.addQuickTraining(day, month, year);
        workoutQuickAddModal.fillForm(newWorkoutQuick);
        workoutQuickAddModal.saveButtonClick();
        workoutQuickAddModal.cancelButtonClick();
        calendarPage.openTraining(day, month, year, newWorkoutQuick.getWorkoutName());
        calendarPage.viewButtonClick(newWorkoutQuick.getWorkoutName(), month, day, year);
        workoutDetailsPage.getWorkoutQuickInfo();
        Assert.assertEquals(workoutDetailsPage.getWorkoutQuickInfo(), newWorkoutQuick, "Input data should be equals data from workout details form");
        homePage.clickLogoutButton();
    }

    @DataProvider
    public Object[][] AddTrainingOnCalendarTestData() {
        return new Object[][]{
                {1, MONTH, YEAR, WorkoutQuickFactory.getWorkoutQuickAllData()},
                {7, MONTH, YEAR, WorkoutQuickFactory.getWorkoutQuickWithDistance()},
                {12, MONTH, YEAR, WorkoutQuickFactory.getWorkoutQuickWithActivityType()}
        };
    }

}
