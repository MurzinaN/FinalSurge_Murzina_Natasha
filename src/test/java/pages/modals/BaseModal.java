package pages.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;


public abstract class BaseModal extends BasePage {
    private static final By SAVE_BUTTON = By.id("saveButton");

    public BaseModal(WebDriver driver) {
        super(driver);
    }

    public void saveButtonClick() {
        driver.findElement(SAVE_BUTTON).click();
    }
}
