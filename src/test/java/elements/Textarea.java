package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;


@Log4j2
public class Textarea extends BaseElement {
    private final static String TEXTAREA_LOCATOR = "//label[text()='%s']/ancestor::div[@class='formSep']/descendant::textarea";

    public Textarea(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        if (Objects.nonNull(value)) {
            WebElement inputElement = driver.findElement(By.xpath(String.format(TEXTAREA_LOCATOR, label)));
            log.debug(String.format("Setting %s Textarea locator: %s value = %s", label, TEXTAREA_LOCATOR, value));
            scrollIntoView(inputElement);
            inputElement.sendKeys(value);
        }
    }
}
