package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EquipmentPage;
import pages.HomePage;
import pages.ShoesPage;
import pages.modals.AddNewShoeModal;
import utils.NewShoeFactory;


public class NewShoeTest extends BaseTest{
    public final static String ITEM_NAVIGATION_MENU = "Gear & Routes";
    private HomePage homePage;
    private EquipmentPage equipmentPage;
    private AddNewShoeModal addNewShoeModal;
    private ShoesPage shoesPage;

    @BeforeClass
    public void initialise() {
        homePage = new HomePage(driver);
        equipmentPage = new EquipmentPage(driver);
        addNewShoeModal = new AddNewShoeModal(driver);
        shoesPage = new ShoesPage(driver);
    }
    @BeforeMethod()
    public void login() {
        loginPage.login(EMAIL, PASSWORD);
    }

    @Test(groups = {"regression"})
    @Description("Add daily vitals in table")
    public void addNewShoeTest(){
        homePage.clickItemNavigationMenu(ITEM_NAVIGATION_MENU);
        equipmentPage.clickShoesButton();
        addNewShoeModal.fillForm(NewShoeFactory.getNewShoe());
        addNewShoeModal.clickAddShoeButtonButton();
        Assert.assertEquals(shoesPage.getNewShoeInfo(NewShoeFactory.getNewShoe().getShoeName()), NewShoeFactory.getNewShoe());
    }
    @AfterMethod
    public void clearDataNewShoe() {
    shoesPage.clickDelete(NewShoeFactory.getNewShoe().getShoeName());
    }
}
