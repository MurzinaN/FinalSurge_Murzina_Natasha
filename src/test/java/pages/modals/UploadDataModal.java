package pages.modals;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.AllureUtils;

@Log4j2
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

    @Step("Upload file with data in training from Training Calendar")
    public void inputUploadFile(String fileName) {
        log.info("\"Upload file with data in training from Training Calendar\"");
        WebElement iframe = driver.findElement(IFRAME_LOCATOR);
        driver.switchTo().frame(iframe);
        driver.findElement(INPUT_FILE).sendKeys(System.getProperty("user.dir") + "/src/test/resources/" + fileName);
        driver.findElement(UPLOAD_FILE_BUTTON).click();
        AllureUtils.attachScreenshot(driver);
        driver.switchTo().defaultContent();
    }
}
