package pages.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AllureUtils;

public class UploadDataModal extends BaseModal {
    private final static By IFRAME_LOCATOR = By.id("WorkoutUploadiFrame");
    private final static By INPUT_FILE = By.xpath("//input[@name='FileUpload1']");

    private final static By UPLOAD_FILE_BUTTON = By.xpath("//input[@id='saveButton']");


    public UploadDataModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
    }

    public void inputUploadFile(String fileName) {
        WebElement iframe = driver.findElement(IFRAME_LOCATOR);
        driver.switchTo().frame(iframe);
        driver.findElement(INPUT_FILE).sendKeys(System.getProperty("user.dir") + "/src/test/resources/" + fileName);
        AllureUtils.attachScreenshot(driver);
        driver.findElement(UPLOAD_FILE_BUTTON).click();
        driver.switchTo().defaultContent();
    }
}
