package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.modals.DailyCaloricNeedsCalculatorsModal;
import pages.modals.OthersCalculatorsModal;
import pages.modals.PaceCalculatorModal;
import utils.DailyCaloricNeedsCalculatorFactory;
import utils.PaceCalculatorFactory;

public class CalculatorTest extends BaseTest {

    private HomePage homePage;
    private DailyCaloricNeedsCalculatorsModal dailyCaloricNeedsCalculatorModal;
    private OthersCalculatorsModal othersCalculatorsModal;
    private PaceCalculatorModal paceCalculatorModal;

    @BeforeClass
    public void initialise() {
        homePage = new HomePage(driver);
        dailyCaloricNeedsCalculatorModal = new DailyCaloricNeedsCalculatorsModal(driver);
        othersCalculatorsModal = new OthersCalculatorsModal(driver);
        paceCalculatorModal = new PaceCalculatorModal(driver);
    }

    @BeforeMethod()
    public void start() {
        loginPage.login(EMAIL, PASSWORD);
        homePage.clickOthersCalculatorsButton();
        othersCalculatorsModal.switchToIframe();
    }

    @AfterMethod()
    public void finish() {
        othersCalculatorsModal.switchToDefaultContent();
    }



    @Test(groups = {"regression"})
    @Description("Calculation daily caloric needs.")
    public void dailyCaloricNeedsCalculatorTest() {
        othersCalculatorsModal.clickCaloricNeedsButton();
        dailyCaloricNeedsCalculatorModal.fillForm(DailyCaloricNeedsCalculatorFactory.getDailyCaloricNeedsCalculator());
        dailyCaloricNeedsCalculatorModal.clickCalculateCaloricNeedsButton();
        Assert.assertTrue(dailyCaloricNeedsCalculatorModal.isTodaysCaloricNeedsTableDisplayed());
        Assert.assertTrue(dailyCaloricNeedsCalculatorModal.isTodaysCaloricNeedsTableRowsDisplayed());
    }

    @Test(groups = {"regression"})
    @Description("Calculate pace.")
    public void paceCalculatorTest() {
        othersCalculatorsModal.clickPaceCalculatorButton();
        paceCalculatorModal.fillForm(PaceCalculatorFactory.getPaceCalculator());
        paceCalculatorModal.clickCalculatePacesButton();
        Assert.assertTrue(paceCalculatorModal.isPaceChartTableDisplayed());
        Assert.assertTrue(paceCalculatorModal.isPaceSplitsTableDisplayed());
        Assert.assertTrue(paceCalculatorModal.isPaceChartTableRowsDisplayed());
        Assert.assertTrue(paceCalculatorModal.isPaceSplitsTableRowsDisplayed());
    }
}
