package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

@Log4j2
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

    @Step("Set email: {email}")
    public void setEmail(String email) {
        log.info("Set email");
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Set password: {password}")
    public void setPassword(String password) {
        log.info("Set password");
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Click 'Login' button")
    public void clickLoginButton() {
        log.info("Click 'Login' button");
        driver.findElement(loginButton).click();
    }

    @Step("Ñhecking the presence of error message on display")
    public boolean isErrorMessageForEmailDisplayed() {
        log.info("Checking the presence of error message on display");
        return driver.findElement(errorMessageForEmail).isDisplayed();
    }

    @Step("Ñhecking the presence of error message on display")
    public String getErrorMessageForEmailText() {
        log.info("Checking the presence of error message on display");
        return driver.findElement(errorMessageForEmail).getText();
    }

    @Step("Ñhecking the presence of error message on display")
    public boolean isErrorMessageForFormDisplayed() {
        log.info("Checking the presence of error message on display");
        return driver.findElement(errorMessageForForm).isDisplayed();
    }

    @Step("Getting the text of the error message")
    public String getErrorMessageForFormText() {
        log.info("Getting the text of the error message");
        return driver.findElement(errorMessageForForm).getText();
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    @Step("Entering url")
    public void open() {
        log.info("Entering url");
        driver.get(URL);
    }
}

