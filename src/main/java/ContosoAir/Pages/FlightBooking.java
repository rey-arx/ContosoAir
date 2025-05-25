/*
Licensed to the Software Freedom Conservancy (SFC) under one
or more contributor license agreements.
*/
package ContosoAir.Pages;

import ContosoAir.Operations.FlightBookingOperation;
import ContosoAir.Utilities.WebElementUtil;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Implements the FlightBookingOperation interface using Selenium WebDriver for flight booking automation.
 */
public class FlightBooking implements FlightBookingOperation {

    private WebDriver driver;

    public FlightBooking() {
        driver = new ChromeDriver();
        WebElementUtil.initializeDriver(driver); // NEW: Delegates window maximize etc.
    }

    @Override
    public void login(String username, String password) {
        WebElementUtil.navigateTo("http://localhost:3001/", driver);
        WebElementUtil.click(By.linkText("Login"), driver);
        WebElementUtil.sendKeys(By.id("username"), username, driver);
        WebElementUtil.sendKeys(By.id("password"), password, driver);
        WebElementUtil.click(By.cssSelector(".btn"), driver);
    }

    @Override
    public void selectFlightDetails(String from, String to, LocalDate departureDate, int numberOfPassengers, LocalDate returnDate) {
        WebElementUtil.click(By.linkText("Book"), driver);

        Select fromDropdown = new Select(WebElementUtil.findElement(By.id("fromCode"), driver));
        fromDropdown.selectByVisibleText(from);

        Select toDropdown = new Select(WebElementUtil.findElement(By.id("toCode"), driver));
        toDropdown.selectByVisibleText(to);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        WebElementUtil.sendKeys(By.id("dpa"), departureDate.format(formatter), driver);
        WebElementUtil.sendKeys(By.id("dpb"), returnDate.format(formatter), driver);

        Select passengersDropdown = new Select(WebElementUtil.findElement(By.id("passengers"), driver));
        passengersDropdown.selectByVisibleText(String.valueOf(numberOfPassengers));
    }

    @Override
    public void bookFlight(String username,String password,String from, String to, LocalDate departure, int noOfPassengers, LocalDate ret ) {
        login(username, password);
        selectFlightDetails(from, to, departure, noOfPassengers, ret);
        WebElementUtil.click(By.cssSelector(".btn-md"), driver);
        WebElementUtil.click(By.cssSelector(".block-flights-results-list-item:nth-child(2) .big-blue-radio"), driver);
        WebElementUtil.click(By.cssSelector(".btn"), driver);
        WebElementUtil.click(By.cssSelector(".btn:nth-child(5)"), driver);
    }

    @Override
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Override
    public String getBookingConfirmationTitle() {
        return WebElementUtil.getText(By.cssSelector(".block-booking-title"), driver);
    }
}
