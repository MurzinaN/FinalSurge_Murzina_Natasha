package tests;


import io.qameta.allure.Description;
import models.WorkoutQuick;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CalendarPage;
import pages.WorkoutDetailsPage;
import pages.modals.WorkoutQuickAddModal;
import utils.WorkoutQuickFactory;

public class AddTrainingTest extends BaseTest {
    protected final static int MONTH = 9;
    protected final static int YEAR = 2022;
    String trainingName;
    int trainingDay;
    int trainingMonth;
    int trainingYear;
    private CalendarPage calendarPage;
    private WorkoutQuickAddModal workoutQuickAddModal;
    private WorkoutDetailsPage workoutDetailsPage;

    @BeforeClass(alwaysRun = true)
    public void initialise() {
        calendarPage = new CalendarPage(driver);
        workoutQuickAddModal = new WorkoutQuickAddModal(driver);
        workoutDetailsPage = new WorkoutDetailsPage(driver);
    }


    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.login(EMAIL, PASSWORD);
    }

    @Test(groups = {"smoke"}, dataProvider = "AddTrainingOnCalendarTestData")
    @Description("Quick add training on Calendar")
    public void addTrainingOnCalendarTest(int day, int month, int year, WorkoutQuick newWorkoutQuick) throws InterruptedException {
        calendarPage.addQuickTraining(day, month, year);
        workoutQuickAddModal.fillForm(newWorkoutQuick);
        workoutQuickAddModal.saveButtonClick();
        workoutQuickAddModal.cancelButtonClick();
        calendarPage.openMenuTraining(day, month, year, newWorkoutQuick.getWorkoutName());
        calendarPage.viewButtonClick(newWorkoutQuick.getWorkoutName(), month, day, year);
        trainingName = workoutDetailsPage.getWorkoutQuickInfo().getWorkoutName();
        trainingDay = day;
        trainingMonth = month;
        trainingYear =year;
        Assert.assertEquals(workoutDetailsPage.getWorkoutQuickInfo(), newWorkoutQuick, "Input data should be equals data from workout details form");

    }

    @DataProvider
    public Object[][] AddTrainingOnCalendarTestData() {
        return new Object[][]{
                {1, MONTH, YEAR, WorkoutQuickFactory.getWorkoutQuickAllData()},
                {8, MONTH, YEAR, WorkoutQuickFactory.getWorkoutQuickWithDistance()},
                {25, MONTH, YEAR, WorkoutQuickFactory.getWorkoutQuickWithActivityType()}
        };
    }


    @AfterMethod(alwaysRun = true)
    public void clearDataAddTraining() {
        calendarPage.backToCalendar();
            calendarPage.openMenuTraining(trainingDay, trainingMonth, trainingYear, trainingName);
            calendarPage.deleteButtonClick(trainingName, trainingMonth, trainingDay, trainingYear);


    }

}
