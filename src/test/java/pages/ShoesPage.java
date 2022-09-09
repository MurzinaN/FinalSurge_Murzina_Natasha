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
        String brand;
        String model;
        if (textReplace.contains("New Balance") || textReplace.contains("Newton Running") || textReplace.contains("Pearl Izumi") ||
                textReplace.contains("UK Gear") || textReplace.contains("Under Armour") || textReplace.contains("Vibram FiveFingers")){
            String[] brandAndModel = textReplace.split(" ", 3);
            brand = brandAndModel[0]+" "+brandAndModel[1];
            model = brandAndModel[2];
        }else {
            if (textReplace.contains("Hoka One One")){
                String[] brandAndModel = textReplace.split(" ", 4);
                brand = brandAndModel[0]+" "+brandAndModel[1]+" "+brandAndModel[2];
                model = brandAndModel[3];
            }else {
                String[] brandAndModel = textReplace.split(" ", 2);
                brand = brandAndModel[0];
                model = brandAndModel[1];
            }
        }
        newShoeBuilder.shoeName(shoeName);
        newShoeBuilder.brand(Brand.fromString(brand));
        newShoeBuilder.model(model);
        newShoeBuilder.notes(textSplit[2]);
        if (isElementPresentByLocator(By.xpath(String.format(DATA_LOCATOR, shoeName, "Purchased"))) == true) {
            String datePurchasedText = driver.findElement(By.xpath(String.format(DATA_LOCATOR, shoeName, "Purchased"))).getText();
            String datePurchased = datePurchasedText.replace("Purchased: ", "");
            newShoeBuilder.datePurchased(datePurchased);
        }
        if (isElementPresentByLocator(By.xpath(String.format(DATA_LOCATOR, shoeName, "Cost"))) == true) {
            String costText = driver.findElement(By.xpath(String.format(DATA_LOCATOR, shoeName, "Cost"))).getText();
            String cost = costText.replace("Cost: $", "");
            newShoeBuilder.cost(cost);
        }
        if (isElementPresentByLocator(By.xpath(String.format(DATA_LOCATOR, shoeName, "Size"))) == true) {
            String sizeText = driver.findElement(By.xpath(String.format(DATA_LOCATOR, shoeName, "Size"))).getText();
            String size = sizeText.replace("Size: ", "");
            newShoeBuilder.shoeSize(ShoeSize.fromString(size));
        }
        if (isElementPresentByLocator(By.xpath(String.format(DISTANCE_ALERT_LOCATOR, shoeName))) == true) {
            String distanceAlertText = driver.findElement(By.xpath(String.format(DISTANCE_ALERT_LOCATOR, shoeName))).getText();
            String distanceAlert = distanceAlertText.replace("Alert at: ", "");
            String[] distanceAlertAndType = distanceAlert.split(" ");
            newShoeBuilder.distanceAlert(distanceAlertAndType[0]);
            newShoeBuilder.distanceAlertType(DistanceTypeShoes.fromString(distanceAlertAndType[1]));
        }
        if (isElementPresentByLocator(By.xpath(String.format(STARTING_DISTANCE_LOCATOR, shoeName))) == true) {
            String startingDistanceText = driver.findElement(By.xpath(String.format(STARTING_DISTANCE_LOCATOR, shoeName))).getText();
            String startingDistance = startingDistanceText.replace(" mi", "");
            newShoeBuilder.startingDistance(startingDistance);
        }
        return newShoeBuilder.build();
    }
    public void get(String shoeName1){
        String text = driver.findElement(By.xpath(String.format(NAME_LOCATOR, shoeName1))).getText();
        String[] textSplit = text.split("\n");
        String textReplace = textSplit[0].replace(shoeName1+" ", "");
        textReplace = textReplace.replace("(", "");
        textReplace = textReplace.replace(")", "");
        String brand;
        String model;
        if (textReplace.contains("New Balance") || textReplace.contains("Newton Running") || textReplace.contains("Pearl Izumi") ||
                textReplace.contains("UK Gear") || textReplace.contains("Under Armour") || textReplace.contains("Vibram FiveFingers")){
            String[] brandAndModel = textReplace.split(" ", 3);
          brand = brandAndModel[0]+" "+brandAndModel[1];
          model = brandAndModel[2];
        }else {
            if (textReplace.contains("Hoka One One")){
                String[] brandAndModel = textReplace.split(" ", 4);
                brand = brandAndModel[0]+" "+brandAndModel[1]+" "+brandAndModel[2];
                model = brandAndModel[3];
            }else {
                String[] brandAndModel = textReplace.split(" ", 2);
                brand = brandAndModel[0];
                model = brandAndModel[1];
            }
        }
        System.out.println(brand);
        System.out.println(model);
        /*System.out.println(textSplit[0]);
        System.out.println(textSplit[1]);
        System.out.println(textSplit[2]);*/

    }
}
