package ContosoAir.Utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementUtil {

    private static final int TIMEOUT = 10;

    public static WebElement findElement(By locator, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException | TimeoutException ex) {
            System.out.println("Element not found: " + locator);
            return null;
        }
    }

    public static void click(By locator, WebDriver driver) {
        WebElement element = findElement(locator, driver);
        if (element != null) {
            element.click();
        }
    }

    public static void sendKeys(By locator, String input, WebDriver driver) {
        WebElement element = findElement(locator, driver);
        if (element != null) {
            element.clear();
            element.sendKeys(input);
        }
    }

    public static String getText(By locator, WebDriver driver) {
        WebElement element = findElement(locator, driver);
        return element != null ? element.getText() : "";
    }
}
