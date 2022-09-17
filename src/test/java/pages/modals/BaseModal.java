package pages.modals;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utils.AllureUtils;

@Log4j2
public abstract class BaseModal extends BasePage {
    private static final By SAVE_BUTTON = By.id("saveButton");

    public BaseModal(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Save'")
    public void saveButtonClick() {
        log.info("Click 'Save'");
        AllureUtils.attachScreenshot(driver);
        driver.findElement(SAVE_BUTTON).click();
    }
}

