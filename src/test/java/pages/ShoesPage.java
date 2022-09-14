package pages;

import enums.Brand;
import enums.DistanceTypeShoes;
import enums.ShoeSize;
import lombok.extern.log4j.Log4j2;
import models.NewShoe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yaml.snakeyaml.scanner.Scanner;

import java.util.List;


@Log4j2
public class ShoesPage extends BasePage{
    private final static String NAME_LOCATOR = "//a[text()='%s']/ancestor::strong/parent::td";
    private final static String DATA_LOCATOR = "//a[text()='%s']/ancestor::strong/parent::td/descendant::span/strong[contains(text(),'%s')]/parent::span";
    private final static String DISTANCE_ALERT_LOCATOR = "//a[text()='%s']/ancestor::strong/parent::td/descendant::span[contains(text(),'Alert')]";
    private final static String STARTING_DISTANCE_LOCATOR = "//a[text()='%s']/ancestor::tr/descendant::td[@style]/span[contains(text(),'mi')]";
    private final static String SHOE_NAME_LOCATOR = "//a[text()='%s']";
    private final static By DELETE_LOCATOR = By.xpath("//a[@id='del-shoe']");
    private final static By OK_BUTTON_LOCATOR = By.xpath("//a[@data-handler='1']");
    public ShoesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {

    }

    public NewShoe getNewShoeInfo(String shoeName) {
        log.info("Filling form NewShoe with recived data");
        NewShoe.NewShoeBuilder newShoeBuilder = NewShoe.builder();
        String text = driver.findElement(By.xpath(String.format(NAME_LOCATOR, shoeName))).getText();
        String[] textSplit = text.split("\n");
        String textReplace = textSplit[0].replace(shoeName+" ", "");
        textReplace = textReplace.replace("(", "");
        textReplace = textReplace.replace(")", "");

        newShoeBuilder.shoeName(shoeName);
        newShoeBuilder.brandAndModel(textReplace);
        newShoeBuilder.notes(textSplit[2]);
        if (isElementPresentByLocator(By.xpath(String.format(DATA_LOCATOR, shoeName, "Purchased")))) {
            String datePurchasedText = driver.findElement(By.xpath(String.format(DATA_LOCATOR, shoeName, "Purchased"))).getText();
            String datePurchased = datePurchasedText.replace("Purchased: ", "");
            newShoeBuilder.datePurchased(datePurchased);
        }
        if (isElementPresentByLocator(By.xpath(String.format(DATA_LOCATOR, shoeName, "Cost")))) {
            String costText = driver.findElement(By.xpath(String.format(DATA_LOCATOR, shoeName, "Cost"))).getText();
            String cost = costText.replace("Cost: $", "");
            newShoeBuilder.cost(cost);
        }
        if (isElementPresentByLocator(By.xpath(String.format(DATA_LOCATOR, shoeName, "Size")))) {
            String sizeText = driver.findElement(By.xpath(String.format(DATA_LOCATOR, shoeName, "Size"))).getText();
            String size = sizeText.replace("Size: ", "");
            newShoeBuilder.shoeSize(ShoeSize.fromString(size));
        }
        if (isElementPresentByLocator(By.xpath(String.format(DISTANCE_ALERT_LOCATOR, shoeName)))) {
            String distanceAlertText = driver.findElement(By.xpath(String.format(DISTANCE_ALERT_LOCATOR, shoeName))).getText();
            String distanceAlert = distanceAlertText.replace("Alert at: ", "");
            String[] distanceAlertAndType = distanceAlert.split(" ");
            newShoeBuilder.distanceAlert(distanceAlertAndType[0]);
            newShoeBuilder.distanceAlertType(DistanceTypeShoes.fromString(distanceAlertAndType[1]));
        }
        if (isElementPresentByLocator(By.xpath(String.format(STARTING_DISTANCE_LOCATOR, shoeName)))) {
            String startingDistanceText = driver.findElement(By.xpath(String.format(STARTING_DISTANCE_LOCATOR, shoeName))).getText();
            String startingDistance = startingDistanceText.replace(" mi", "");
            newShoeBuilder.startingDistance(startingDistance);
        }
        return newShoeBuilder.build();
    }
    public void clickDelete(String shoeName){
        driver.findElement(By.xpath(String.format(SHOE_NAME_LOCATOR, shoeName))).click();
        driver.findElement(DELETE_LOCATOR).click();
        WebElement ok = driver.findElement(OK_BUTTON_LOCATOR);
        jsClick(ok);
    }

}
