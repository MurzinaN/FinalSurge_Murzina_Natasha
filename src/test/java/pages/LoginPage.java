package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;


public class LoginPage extends BasePage {
    private final static String URL = System.getenv().getOrDefault("URL", PropertyReader.getProperty("finalSurge.url"));
    private final static By emailInput = By.cssSelector("input#login_name");
    private final static By passwordInput = By.cssSelector("input#login_password");
    private final static By loginButton = By.xpath("//button[text()='Login']");
    private final static By errorMessageForEmail = By.xpath("//label[@for='login_name' and @class='error']");
    private final static By errorMessageForForm = By.xpath("//div[contains(@class, 'alert-error')]/strong");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(loginButton);
    }

    @Step("Set email")
    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Ñhecking the presence of error message on display")
    public boolean isErrorMessageForEmailDisplayed() {
        return driver.findElement(errorMessageForEmail).isDisplayed();
    }

    public String getErrorMessageForEmailText() {
        return driver.findElement(errorMessageForEmail).getText();
    }

    @Step("Ñhecking the presence of error message on display")
    public boolean isErrorMessageForFormDisplayed() {
        return driver.findElement(errorMessageForForm).isDisplayed();
    }

    public String getErrorMessageForFormText() {
        return driver.findElement(errorMessageForForm).getText();
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    public void open() {
        driver.get(URL);
    }
}