package ContosoAir.Pages;

import ContosoAir.Operations.HomePageOperations;
import ContosoAir.Utilities.WebElementUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
/*
Licensed to the Software Freedom Conservancy (SFC) under one
or more contributor license agreements.

Author: Raihan
*/

public class HomePage implements HomePageOperations {

    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = new ChromeDriver();
        WebElementUtil.navigateTo("http://localhost:3001/", driver);
    }

    public HomePage() {
        this.driver = new ChromeDriver();
        WebElementUtil.navigateTo("http://localhost:3001/", driver);
    }

    @Override
    public void navigateToUrl(String url) {
        WebElementUtil.navigateTo(url, driver);
        WebElementUtil.setWindowSize(1296, 688, driver);
    }

    @Override
    public void getLogo() {
        By logoLocator = By.xpath("//img[@class='block-navbar-left-logo']");
        if (!WebElementUtil.isElementDisplayed(logoLocator, driver)) {
            throw new RuntimeException("Logo image is not displayed on the homepage.");
        }
    }

    @Override
    public String getTitle() {
        return WebElementUtil.getText(By.xpath("//span[normalize-space()='Where do youwant to go?']"), driver);
    }

    @Override
    public String subTitle() {
        return WebElementUtil.getText(By.xpath("//h2[normalize-space()='Flight deals']"), driver);
    }

    @Override
    public String getSuggestTitle() {
        return WebElementUtil.getText(By.xpath("//h2[normalize-space()='Recommended for you']"), driver);
    }

    @Override
    public void checkHawaiiImage() {
        By hawaiiImageLocator = By.xpath("/html/body/main/main/div/div/div[1]/ul/li[1]/figure/img[1]");
        if (!WebElementUtil.isElementDisplayed(hawaiiImageLocator, driver)) {
            throw new RuntimeException("Hawaii image is not displayed on the homepage.");
        }
    }

    @Override
    public String checkHawaiiCaption() {
        By captionLocator = By.xpath("//figcaption[normalize-space()='Hawaii']");
        if (!WebElementUtil.isElementDisplayed(captionLocator, driver)) {
            throw new RuntimeException("Hawaii caption is not displayed on the homepage.");
        }
        return WebElementUtil.getText(captionLocator, driver);
    }

    @Override
    public void checkParisImage() {
        By parisImageLocator = By.xpath("/html/body/main/main/div/div/div[1]/ul/li[2]/figure/img[1]");
        if (!WebElementUtil.isElementDisplayed(parisImageLocator, driver)) {
            throw new RuntimeException("Paris image is not displayed on the homepage.");
        }
    }

    @Override
    public String checkParisCaption() {
        By captionLocator = By.xpath("//figcaption[normalize-space()='Paris']");
        if (!WebElementUtil.isElementDisplayed(captionLocator, driver)) {
            throw new RuntimeException("Paris caption is not displayed on the homepage.");
        }
        return WebElementUtil.getText(captionLocator, driver);
    }

    @Override
    public void checkBarcelonaImage() {
        By barcelonaImageLocator = By.xpath("/html/body/main/main/div/div/div[1]/ul/li[3]/figure/img[1]");
        if (!WebElementUtil.isElementDisplayed(barcelonaImageLocator, driver)) {
            throw new RuntimeException("Barcelona image is not displayed on the homepage.");
        }
    }

    @Override
    public String checkBarcelonaCaption() {
        By captionLocator = By.xpath("//figcaption[normalize-space()='Barcelona']");
        if (!WebElementUtil.isElementDisplayed(captionLocator, driver)) {
            throw new RuntimeException("Barcelona caption is not displayed on the homepage.");
        }
        return WebElementUtil.getText(captionLocator, driver);
    }

    @Override
    public void performLogin(String username, String password) {
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Username and password cannot be null or empty");
        }
        WebElementUtil.click(By.linkText("Login"), driver);
        WebElementUtil.sendKeys(By.id("username"), username, driver);
        WebElementUtil.sendKeys(By.id("password"), password, driver);
        WebElementUtil.click(By.cssSelector(".btn"), driver);
    }

    @Override
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
