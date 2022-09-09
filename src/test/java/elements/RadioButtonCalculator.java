package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Objects;
@Log4j2
public class RadioButtonCalculator extends BaseElement{
    private final static String RADIO_BUTTON_LOCATOR = "//*[text()='Daily Caloric Needs Calculator']/parent::div/following-sibling::div/descendant::input[@name='%s' and @value='%s']";

    public RadioButtonCalculator(WebDriver driver, String label) {
        super(driver, label);
    }

    public void setValue(String value) {
        if (Objects.nonNull(value)) {
            WebElement radioButtonElement = driver.findElement(By.xpath(String.format(RADIO_BUTTON_LOCATOR, label, value)));
            log.debug(String.format("Select option: %s in %s RadioButtonCalculator locator: %s",value, label, RADIO_BUTTON_LOCATOR));
            scrollIntoView(radioButtonElement);
            jsClick(radioButtonElement);
        }
    }

}
