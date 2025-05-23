package ContosoAir.Pages;

import ContosoAir.Operations.FlightListingOperation;
import ContosoAir.Utilities.WebElementUtil;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Implements the FlightListingOperation interface using Selenium WebDriver for listing and searching flights.
 */
public class FlightListing implements FlightListingOperation {

    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor to initialize WebDriver and WebDriverWait.
     */
    public FlightListing() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Logs into the flight booking portal.
     */
    @Override
    public void login(String username, String password) {
        driver.get("http://localhost:3001/");
        driver.manage().window().setSize(new Dimension(1296, 688));

        WebElementUtil.click(By.linkText("Login"), driver);
        WebElementUtil.sendKeys(By.id("username"), username, driver);
        WebElementUtil.sendKeys(By.id("password"), password, driver);
        WebElementUtil.click(By.cssSelector(".btn"), driver);
    }

    /**
     * Searches for flights with the provided details.
     */
    @Override
    public void searchFlights(String from, String to, LocalDate departureDate, int passengers, LocalDate returnDate) {
        WebElementUtil.click(By.linkText("Book"), driver);

        // Select "from" location from dropdown
        WebElement fromDropdown = WebElementUtil.findElement(By.id("fromCode"), driver);
        fromDropdown.findElement(By.xpath("//option[. = '" + from + "']")).click();
        waitShort();

        // Select "to" location from dropdown
        WebElement toDropdown = WebElementUtil.findElement(By.id("toCode"), driver);
        toDropdown.findElement(By.xpath("//option[. = '" + to + "']")).click();
        waitShort();

        // Select departure date from calendar
        WebElementUtil.click(By.id("dpa"), driver);
        WebElement depDateCell = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[contains(text(), '" + departureDate.getDayOfMonth() + "')]")));
        depDateCell.click();

        // Select number of passengers
        WebElementUtil.click(By.id("passengers"), driver);
        WebElement passengerDropdown = WebElementUtil.findElement(By.id("passengers"), driver);
        passengerDropdown.findElement(By.xpath("//option[. = '" + passengers + "']")).click();

        // Select return date from calendar
        WebElementUtil.click(By.id("dpb"), driver);
        WebElement retDateCell = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[contains(text(), '" + returnDate.getDayOfMonth() + "')]")));
        retDateCell.click();

        // Click the "Find Flights" button
        WebElementUtil.click(By.xpath("/html/body/main/section/div/div/div[3]/div/form/fieldset/button"), driver);
    }

    /**
     * Returns a list of available flight WebElements after search.
     */
    @Override
    public List<WebElement> listAvailableFlights() {
        List<WebElement> flights = driver.findElements(By.cssSelector(".block-flights-results-list-item"));

        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            System.out.println("Available Flights:");
            flights.forEach(flight -> System.out.println(flight.getText()));
        }

        return flights;
    }

    /**
     * Closes the browser session.
     */
    @Override
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Introduces a short wait (2 seconds).
     */
    private void waitShort() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
