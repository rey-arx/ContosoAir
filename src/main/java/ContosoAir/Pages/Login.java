package ContosoAir.Pages;

import ContosoAir.Operations.LoginOperations;
import ContosoAir.Utilities.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static ContosoAir.Utilities.WebElementUtil.*;
//import static utilities.WebElementUtil.*;

/**
 * Class implementing the LoginOperations interface to perform login automation.
 */
public class Login  implements LoginOperations {

    // Locators for elements used in login functionality
    private final By loginLink = By.linkText("Login");
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector(".btn");
    private final By alertMessage = By.cssSelector(".alert > span");

    /**
     * Constructor initializes the driver and opens the base URL.
     */
    private WebDriver driver;
    private String url = "http://localhost:3001/";
    public Login() {
        this.driver = new ChromeDriver();
        driver.navigate().to("http://localhost:3001/");
    }

    /**
     * Overloaded constructor that accepts a custom WebDriver.
     */
    public Login(WebDriver driver) {
        this.driver = new ChromeDriver();
        driver.navigate().to("http://localhost:3001/");
    }

    /**
     * Navigates to the specified URL and sets the browser window size.
     */
    @Override
    public void navigateToUrl() {
        WebElementUtil.navigateTo(url, driver);
        WebElementUtil.setWindowSize(1296, 688, driver);
    }

    /**
     * Performs login with provided username and password.
     */
    @Override
    public void performLoginWithCredentials(String username, String password) {
        navigateToUrl();
        click(loginLink, driver);
        sendKeys(usernameInput, username, driver);
        sendKeys(passwordInput, password, driver);
        click(loginButton, driver);
    }

    /**
     * Attempts to perform login without providing any credentials.
     */
    @Override
    public String performLoginWithoutCredentials() {
        navigateToUrl();
        click(loginLink, driver);
        click(loginButton, driver);
        String alert = getText(alertMessage, driver);
        System.out.println("Alert Message Displayed: " + alert);
        return alert;
    }

    /**
     * Tears down the test environment by quitting the browser.
     */
    @Override
    public void tearDown() {
        driver.quit();
    }
}