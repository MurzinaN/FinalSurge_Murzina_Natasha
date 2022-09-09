package pages.modals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadDataModal extends BaseModal{
    private final static By iframeLocator = By.id("WorkoutUploadiFrame");
    private final static By InputFile = By.xpath("//input[@name='FileUpload1']");

    private final static By uploadFileButton = By.xpath("//input[@id='saveButton']");
    public UploadDataModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
    }

    public void inputUploadFile(String fileName) {
        WebElement iframe = driver.findElement(iframeLocator);
        driver.switchTo().frame(iframe);
        driver.findElement(InputFile).sendKeys(System.getProperty("user.dir") + "/src/main/resources/" + fileName);
        driver.findElement(uploadFileButton).click();
        driver.switchTo().defaultContent();
    }
}
