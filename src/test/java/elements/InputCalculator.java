package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;


@Log4j2
public class InputCalculator extends BaseElement {

    private final static String INPUT_CALCULATOR_LOCATOR = "//*[text()='Daily Caloric Needs Calculator']/parent::div/following-sibling::div/descendant::input[@id='%s']";

    public InputCalculator(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        if (Objects.nonNull(value)) {
            WebElement inputElement = driver.findElement(By.xpath(String.format(INPUT_CALCULATOR_LOCATOR, label)));
            log.debug(String.format("Setting %s InputCalculator locator: %s value = %s", label, INPUT_CALCULATOR_LOCATOR, value));
            scrollIntoView(inputElement);
            inputElement.sendKeys(value);
        }
    }
}
