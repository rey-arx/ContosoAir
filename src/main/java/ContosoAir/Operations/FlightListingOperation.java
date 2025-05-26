package ContosoAir.Operations;

import org.openqa.selenium.WebElement;
import java.time.LocalDate;
import java.util.List;

/**
 * Interface that defines the methods for the flight listing functionality,
 * including login, searching for flights, and listing available flights.

 */
public interface FlightListingOperation {

    /**
     * Logs in to the application with the provided username and password.
     *
     * @param username The username to log in.
     * @param password The password to log in.
     */
    void login(String username, String password);

    /**
     * Searches for flights with the specified parameters.
     *
     * @param from           The departure airport (e.g., "New York").
     * @param to             The arrival airport (e.g., "Los Angeles").
     * @param departureDate  The departure date of the flight.
     * @param passengers     The number of passengers for the flight.
     * @param returnDate     The return date of the flight (if applicable).
     */
    void searchFlights(String username, String password, String from, String to, LocalDate departureDate, int passengers, LocalDate returnDate);

    /**
     * Lists all available flights after performing the search.
     *
     * @return A list of WebElements representing available flights.
     */
    List<WebElement> listAvailableFlights();

    /**
     * Closes the WebDriver and shuts down the browser session.
     */
    void close();
}