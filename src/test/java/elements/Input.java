package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

@Log4j2
public class Input extends BaseElement {
    private final static String INPUT_LOCATOR = "//label[text()='%s']/following-sibling::input";

    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        if (Objects.nonNull(value)) {
            WebElement inputElement = driver.findElement(By.xpath(String.format(INPUT_LOCATOR, label)));
            log.debug(String.format("Setting %s Input locator: %s value = %s", label, INPUT_LOCATOR, value));
            scrollIntoView(inputElement);
            inputElement.sendKeys(value);
        }
    }
}
