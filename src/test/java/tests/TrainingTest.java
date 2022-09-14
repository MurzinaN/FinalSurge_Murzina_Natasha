package tests;

import io.qameta.allure.Description;
import models.WorkoutQuick;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalendarPage;
import pages.WorkoutDetailsPage;
import pages.modals.UploadDataModal;
import pages.modals.WorkoutQuickAddModal;
import utils.WorkoutQuickFactory;


public class TrainingTest extends BaseTest{
    protected final static int MONTH = 9;
    protected final static int YEAR = 2022;
    protected final static int UPLOAD_DAY = 10;
    protected final static int COPY_DAY = 13;
    protected final static int NEW_COPY_DAY = 6;
    protected final static String COPY_TRAINING = "MyTraining";
    private CalendarPage calendarPage;
    private WorkoutQuickAddModal workoutQuickAddModal;
    private WorkoutDetailsPage workoutDetailsPage;
    private UploadDataModal uploadDataModal;

    @BeforeClass(alwaysRun = true)
    public void initialise() {
        calendarPage = new CalendarPage(driver);
        workoutQuickAddModal = new WorkoutQuickAddModal(driver);
        workoutDetailsPage = new WorkoutDetailsPage(driver);
        uploadDataModal = new UploadDataModal(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void login() {
        loginPage.login(EMAIL, PASSWORD);
    }

    @Test(groups = {"regression", "copyTraining"})
    @Description("Copy training on calendar")
    public void copyTrainingOnCalendarTest() {
        calendarPage.openMenuTraining(COPY_DAY, MONTH, YEAR, COPY_TRAINING);
        calendarPage.viewButtonClick(COPY_TRAINING, MONTH, COPY_DAY, YEAR);
        WorkoutQuick expectedWorkoutQuick = WorkoutQuickFactory.copyWorkoutQuick(workoutDetailsPage.getWorkoutQuickInfo().getWorkoutName(),
                workoutDetailsPage.getWorkoutQuickInfo().getActivityType(),
                workoutDetailsPage.getWorkoutQuickInfo().getWorkoutDescription());
        calendarPage.backToCalendar();
        calendarPage.openMenuTraining(COPY_DAY, MONTH, YEAR, COPY_TRAINING);
        calendarPage.copyButtonClick(COPY_TRAINING, MONTH, COPY_DAY, YEAR);
        workoutQuickAddModal.inputNewDate(MONTH, NEW_COPY_DAY, YEAR);
        workoutQuickAddModal.saveButtonClick();
        workoutQuickAddModal.cancelButtonClick();
        calendarPage.openMenuTraining(NEW_COPY_DAY, MONTH, YEAR, COPY_TRAINING);
        calendarPage.viewButtonClick(COPY_TRAINING, MONTH, NEW_COPY_DAY, YEAR);
        Assert.assertEquals(workoutDetailsPage.getWorkoutQuickInfo(), expectedWorkoutQuick);
    }

    @Test(groups = {"regression", "uploadTraining"})
    @Description("Quick add training on calendar")
    public void uploadTrainingTest() {
        calendarPage.addQuickTraining(UPLOAD_DAY, MONTH, YEAR);
        workoutQuickAddModal.fillForm(WorkoutQuickFactory.beforeUploadWorkoutQuick());
        workoutQuickAddModal.saveButtonClick();
        workoutQuickAddModal.cancelButtonClick();
        calendarPage.openMenuTraining(UPLOAD_DAY, MONTH, YEAR, WorkoutQuickFactory.beforeUploadWorkoutQuick().getWorkoutName());
        calendarPage.upButtonClick(WorkoutQuickFactory.beforeUploadWorkoutQuick().getWorkoutName(), MONTH, UPLOAD_DAY, YEAR);
        uploadDataModal.inputUploadFile("training.tcx");
        Assert.assertEquals(workoutDetailsPage.getWorkoutQuickInfo(), WorkoutQuickFactory.uploadWorkoutQuick());
    }

    @AfterMethod(onlyForGroups = {"copyTraining"}, alwaysRun = true)
    public void clearDataCopyTraining() {
        calendarPage.backToCalendar();
        calendarPage.openMenuTraining(NEW_COPY_DAY, MONTH, YEAR, COPY_TRAINING);
        calendarPage.deleteButtonClick(COPY_TRAINING, MONTH, NEW_COPY_DAY, YEAR);
    }

    @AfterMethod(onlyForGroups = {"uploadTraining"}, alwaysRun = true)
    public void clearDataUploadTraining() {
        calendarPage.backToCalendar();
        calendarPage.openMenuTraining(UPLOAD_DAY, MONTH, YEAR, WorkoutQuickFactory.beforeUploadWorkoutQuick().getWorkoutName());
        calendarPage.deleteButtonClick(WorkoutQuickFactory.beforeUploadWorkoutQuick().getWorkoutName(), MONTH, UPLOAD_DAY, YEAR);
    }


}
