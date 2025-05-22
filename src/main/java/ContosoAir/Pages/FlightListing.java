package ContosoAir.Pages;

import ContosoAir.Operations.FlightListingOperation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Class for performing flight listing functionalities, including login and searching for available flights.
 *
 * Author: Ajay
 */
public class FlightListing implements FlightListingOperation {

    private WebDriver driver;
    private WebDriverWait wait;

    public FlightListing() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Override
    public void login(String username, String password) {
        driver.get("http://localhost:3001/");
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1296, 688));

        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector(".btn")).click();
    }

    @Override
    public void searchFlights(String from, String to, LocalDate departureDate, int passengers, LocalDate returnDate) {
        driver.findElement(By.linkText("Book")).click();

        // Departure airport
        WebElement fromDropdown = driver.findElement(By.id("fromCode"));
        fromDropdown.findElement(By.xpath("//option[. = '" + from + "']")).click();
        waitShort();

        // Arrival airport
        WebElement toDropdown = driver.findElement(By.id("toCode"));
        toDropdown.findElement(By.xpath("//option[. = '" + to + "']")).click();
        waitShort();

        // Departure date
        driver.findElement(By.id("dpa")).click();
        WebElement depDateCell = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[contains(text(), '" + departureDate.getDayOfMonth() + "')]")));
        depDateCell.click();

        // Passengers
        driver.findElement(By.id("passengers")).click();
        WebElement passengersDropdown = driver.findElement(By.id("passengers"));
        passengersDropdown.findElement(By.xpath("//option[. = '" + passengers + "']")).click();

        // Return date
        driver.findElement(By.id("dpb")).click();
        WebElement retDateCell = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[contains(text(), '" + returnDate.getDayOfMonth() + "')]")));
        retDateCell.click();

        // Click Find Flights
        driver.findElement(By.xpath("/html/body/main/section/div/div/div[3]/div/form/fieldset/button")).click();
    }

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

    @Override
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void waitShort() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}