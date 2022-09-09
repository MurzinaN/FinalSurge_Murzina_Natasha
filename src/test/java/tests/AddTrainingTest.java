package tests;

import enums.ActivityType;
import io.qameta.allure.Description;
import models.WorkoutQuick;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.WorkoutDetailsPage;
import pages.modals.UploadDataModal;
import pages.modals.WorkoutQuickAddModal;
import utils.WorkoutQuickFactory;

public class AddTrainingTest extends BaseTest {
    protected final static int MONTH = 8;
    protected final static int YEAR = 2022;
    protected final static int UPLOAD_DAY = 10;
    protected final static int COPY_DAY = 13;
    protected final static int NEW_COPY_DAY = 6;

    protected final static String copyTraining= "MyTraining";
    protected final static String uploadTraining= "OneTraining";
    private CalendarPage calendarPage;
    private WorkoutQuickAddModal workoutQuickAddModal;
    private WorkoutDetailsPage workoutDetailsPage;
    private UploadDataModal uploadDataModal;

    @BeforeClass
    public void initialise() {
        calendarPage = new CalendarPage(driver);
        workoutQuickAddModal = new WorkoutQuickAddModal(driver);
        workoutDetailsPage = new WorkoutDetailsPage(driver);
        uploadDataModal = new UploadDataModal(driver);
    }
    @BeforeMethod()
    public void login() {
        loginPage.login(EMAIL, PASSWORD);
    }

    @Test(groups = {"regression"}, dataProvider = "AddTrainingOnCalendarTestData")
    @Description("Quick add training on calendar")
    public void addTrainingOnCalendarTest(int day, int month, int year, WorkoutQuick newWorkoutQuick) throws InterruptedException {
        calendarPage.addQuickTraining(day, month, year);
        workoutQuickAddModal.fillForm(newWorkoutQuick);
        workoutQuickAddModal.saveButtonClick();
        workoutQuickAddModal.cancelButtonClick();
        calendarPage.openMenuTraining(day, month, year, newWorkoutQuick.getWorkoutName());
        calendarPage.viewButtonClick(newWorkoutQuick.getWorkoutName(), month, day, year);
        Assert.assertEquals(workoutDetailsPage.getWorkoutQuickInfo(), newWorkoutQuick, "Input data should be equals data from workout details form");

    }

    @DataProvider
    public Object[][] AddTrainingOnCalendarTestData() {
        return new Object[][]{
                {1, MONTH, YEAR, WorkoutQuickFactory.getWorkoutQuickAllData()},
                {7, MONTH, YEAR, WorkoutQuickFactory.getWorkoutQuickWithDistance()},
                {12, MONTH, YEAR, WorkoutQuickFactory.getWorkoutQuickWithActivityType()}
        };
    }

    @Test(groups = {"regression"})
    @Description("Copy training on calendar")
    public void copyTrainingOnCalendarTest(){
        calendarPage.openMenuTraining(COPY_DAY, MONTH, YEAR, copyTraining);
        calendarPage.viewButtonClick(copyTraining, MONTH, COPY_DAY, YEAR);
        WorkoutQuick expectedWorkoutQuick = WorkoutQuickFactory.copyWorkoutQuick(workoutDetailsPage.getWorkoutQuickInfo().getWorkoutName(),
                workoutDetailsPage.getWorkoutQuickInfo().getActivityType(),
                workoutDetailsPage.getWorkoutQuickInfo().getWorkoutDescription());
        calendarPage.backToCalendar();
        calendarPage.openMenuTraining(COPY_DAY, MONTH, YEAR, copyTraining);
        calendarPage.copyButtonClick(copyTraining, MONTH, COPY_DAY, YEAR);
        workoutQuickAddModal.inputNewDate(MONTH, NEW_COPY_DAY, YEAR);
        workoutQuickAddModal.saveButtonClick();
        workoutQuickAddModal.cancelButtonClick();
        calendarPage.openMenuTraining(NEW_COPY_DAY, MONTH, YEAR, copyTraining);
        calendarPage.viewButtonClick(copyTraining, MONTH, NEW_COPY_DAY, YEAR);
        Assert.assertEquals(workoutDetailsPage.getWorkoutQuickInfo(), expectedWorkoutQuick);
    }

    @Test(groups = {"regression"})
    @Description("Quick add training on calendar")
    public void uploadTrainingTest() {
        calendarPage.openMenuTraining(UPLOAD_DAY, MONTH, YEAR, uploadTraining);
        calendarPage.upButtonClick(uploadTraining, MONTH, UPLOAD_DAY, YEAR);
        uploadDataModal.inputUploadFile("training.tcx");
        Assert.assertEquals(workoutDetailsPage.getWorkoutQuickInfo(), WorkoutQuickFactory.uploadWorkoutQuick());

    }



}
