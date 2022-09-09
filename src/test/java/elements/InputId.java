package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class InputId extends BaseElement{
    private final static String INPUT_ID_LOCATOR = "%s";
    public InputId(WebDriver driver, String label) {
        super(driver, label);
    }
    public void setValue(String value) {
        if (Objects.nonNull(value)) {
            WebElement inputElement = driver.findElement(By.id(String.format(INPUT_ID_LOCATOR, label)));
            log.debug(String.format("Setting %s InputId locator: value = %s", label, value));
            scrollIntoView(inputElement);
            inputElement.sendKeys(value);
        }
    }
}
