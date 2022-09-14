package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EquipmentPage extends BasePage {

    private final static By SHOES_BUTTON_LOCATOR = By.xpath("//strong/a[text()='Shoes']");

    public EquipmentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }


    public void clickShoesButton() {
        driver.findElement(SHOES_BUTTON_LOCATOR).click();
    }

}
