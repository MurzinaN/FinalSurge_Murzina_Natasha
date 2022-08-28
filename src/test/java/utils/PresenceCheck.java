package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class PresenceCheck {
    protected static WebDriver driver;

    public PresenceCheck(WebDriver driver) {
        PresenceCheck.driver = driver;
    }

    public static boolean isElementPresent(By by) {
        boolean isPresent = true;
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            isPresent = false;
        }
        return isPresent;
    }
}
