package ContosoAir.Utilities;

import ContosoAir.Util.Recommendation;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Utility class for common WebDriver operations.
 */
public class WebElementUtil {

    private static final int TIMEOUT = 10;

    /**
     * Navigates to a URL and maximizes the browser window.
     */
    public static void navigateTo(String url, WebDriver driver) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    /**
     * Ensures browser setup like window sizing (can be extended).
     */
    public static void initializeDriver(WebDriver driver) {
        driver.manage().window().maximize();
    }

    /**
     * Finds an element with explicit wait.
     */
    public static WebElement findElement(By locator, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException | TimeoutException ex) {
            System.out.println("Element not found: " + locator);
            return null;
        }
    }
    public static List<WebElement> findElements(By locator, WebDriver driver) {
        try {
            return  driver.findElements(locator);
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
//            return (List<WebElement>) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException | TimeoutException ex) {
            System.out.println("Element not found: " + locator);
            return null;
        }
    }

    /**
     * Clicks on the element located by the given selector.
     */
    public static void click(By locator, WebDriver driver) {
        WebElement element = findElement(locator, driver);
        if (element != null) {
            element.click();
        }
    }

    /**
     * Sends input text to the element located by the given selector.
     */
    public static void sendKeys(By locator, String input, WebDriver driver) {
        WebElement element = findElement(locator, driver);
        if (element != null) {
            element.clear();
            element.sendKeys(input);
        }
    }

    /**
     * Gets text content from the element located by the given selector.
     */
    public static String getText(By locator, WebDriver driver) {
        WebElement element = findElement(locator, driver);
        return element != null ? element.getText() : "";
    }
    /**
     * Checks if the desired element is displayed .
     */
    public static boolean isElementDisplayed(By locator, WebDriver driver) {
        WebElement element = findElement(locator, driver);
        return element != null && element.isDisplayed();
    }
    /**
     * Sets Window size to the required width and height .
     */
    public static void setWindowSize(int width, int height, WebDriver driver) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

}
