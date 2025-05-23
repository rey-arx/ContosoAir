package ContosoAir.Pages;

import ContosoAir.Operations.LandingPageOperations;
import ContosoAir.Utilities.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static ContosoAir.Utilities.WebElementUtil.click;
import static ContosoAir.Utilities.WebElementUtil.sendKeys;

public class LandingPage implements LandingPageOperations {

    private final By loginLink = By.linkText("Login");
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector(".btn");
    private final By BookButton = By.linkText("Book");
    private By logoIdentifier;
    WebDriver driver;

    String url;
    public LandingPage(){
        logoIdentifier = By.xpath("/html/body/navbar/nav/div/div[2]/div[1]/a/img");
        this.driver = new ChromeDriver();
        this.url = "http://localhost:3001/";
        driver.navigate().to("http://localhost:3001/");
        WebElementUtil.initializeDriver(driver);
    }

    @Override
    public String getLogoDetails() {
        WebElementUtil.navigateTo(url,driver);
        WebElement logo = WebElementUtil.findElement(logoIdentifier,driver);
        String[] logoName = logo.getDomAttribute("src").split("/");
        return logoName[2];
    }

    @Override
    public int getRecommendations() {
        WebElementUtil.navigateTo(url,driver);
        List<WebElement> flights = WebElementUtil.findElements(By.cssSelector(".block-cities-list-item"),driver);
        return flights.size();
    }

    /**
     * Performs login with provided username and password.
     */
    @Override
    public void performLoginWithCredentials(String username, String password) {
        WebElementUtil.navigateTo(url,driver);
        click(loginLink, driver);
        sendKeys(usernameInput, username, driver);
        sendKeys(passwordInput, password, driver);
        click(loginButton, driver);
    }


    @Override
    public String enterBooking(String username, String password) {
        WebElementUtil.navigateTo(url,driver);
        performLoginWithCredentials(username,password);
        click(BookButton,driver);
        String heading = WebElementUtil.getText(By.cssSelector(".block-search-form-title"),driver);
        return heading;

    }

    @Override
    public String enterLogin() {
        click(loginLink, driver);
        String heading = WebElementUtil.getText(By.cssSelector(".block-search-form-title"),driver);
        return heading;
   }
    @Override
    public void tearDown() {
        driver.quit();
    }
}
