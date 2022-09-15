package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class EquipmentPage extends BasePage {

    private final static By SHOES_BUTTON_LOCATOR = By.xpath("//strong/a[text()='Shoes']");

    public EquipmentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    @Step("Click 'Shoes'")
    public void clickShoesButton() {
        log.info("Click 'Shoes'");
        driver.findElement(SHOES_BUTTON_LOCATOR).click();
    }

}
