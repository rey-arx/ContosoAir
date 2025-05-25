package ContosoAir.Pages;

import ContosoAir.Operations.LandingPageOperations;
import ContosoAir.Util.Recommendation;
import ContosoAir.Utilities.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static ContosoAir.Utilities.WebElementUtil.click;
import static ContosoAir.Utilities.WebElementUtil.sendKeys;

/**
 * Implements the LandingPageOperations interface to handle user interactions
 * with the landing page of the ContosoAir application.
 */
public class LandingPage implements LandingPageOperations {

    // Locators for login and booking elements
    private final By loginLink = By.linkText("Login");
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector(".btn");
    private final By BookButton = By.linkText("Book");
    private By logoIdentifier;

    WebDriver driver;
    String url;

    /**
     * Constructor initializes WebDriver, sets URL, and navigates to the landing page.
     */
    public LandingPage(){
        logoIdentifier = By.xpath("/html/body/navbar/nav/div/div[2]/div[1]/a/img");
        this.driver = new ChromeDriver();
        this.url = "http://localhost:3001/";
//        driver.navigate().to(url);
//        WebElementUtil.navigateTo(url);
        WebElementUtil.initializeDriver(driver); // Maximizes window and prepares browser
    }

    /**
     * Retrieves and returns the logo file name (e.g., "contoso-logo.png").
     *
     * @return String representing the logo's file name
     */
    @Override
    public String getLogoDetails() {
        WebElementUtil.navigateTo(url, driver);
        WebElement logo = WebElementUtil.findElement(logoIdentifier, driver);
        String[] logoName = logo.getDomAttribute("src").split("/");
        return logoName[2]; // Extracts the file name from the src path
    }

    /**
     * Counts the number of recommended flight destinations displayed on the landing page.
     *
     * @return Number of recommendation blocks found
     */
    @Override
    public List<Recommendation> getRecommendations() {
        WebElementUtil.navigateTo(url, driver);
        List<WebElement> rec = WebElementUtil.findElements(By.cssSelector("figure.block-cities-list-item-figure"), driver);
        List<Recommendation> recommendations = new ArrayList<>();
        for(int i=0;i<rec.size();i++){
            recommendations.add(WebElementUtil.getRecommendation(rec.get(i)));
        }
        return recommendations;
    }

    /**
     * Logs in with the provided credentials using the login form.
     *
     * @param username The user's username
     * @param password The user's password
     */
    @Override
    public void performLoginWithCredentials(String username, String password) {
        WebElementUtil.navigateTo(url, driver);
        click(loginLink, driver);
        sendKeys(usernameInput, username, driver);
        sendKeys(passwordInput, password, driver);
        click(loginButton, driver);
    }

    /**
     * Logs in with credentials and proceeds to the booking page, returning the booking heading text.
     *
     * @param username The user's username
     * @param password The user's password
     * @return Heading text on the booking page
     */
    @Override
    public String enterBooking(String username, String password) {
        WebElementUtil.navigateTo(url, driver);
        performLoginWithCredentials(username, password);
        click(BookButton, driver);
        String heading = WebElementUtil.getText(By.cssSelector(".block-search-form-title"), driver);
        return heading;
    }

    /**
     * Navigates to the login page and returns the heading of the resulting page.
     *
     * @return Heading text after clicking Login
     */
    @Override
    public String enterLogin() {
        click(loginLink, driver);
        String heading = WebElementUtil.getText(By.cssSelector(".block-search-form-title"), driver);
        return heading;
    }

    /**
     * Closes the browser and quits the WebDriver session.
     */
    @Override
    public void tearDown() {
        driver.quit();
    }
}
