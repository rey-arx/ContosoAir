
import ContosoAir.Operations.FlightListingOperation;
import ContosoAir.Pages.FlightListing;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for FlightListing functionality: login, search, and result verification.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FlightListingTest {

    private FlightListingOperation flightListing;

    @BeforeAll
    public void setUp() {
        flightListing = new FlightListing(); // WebDriver is initialized inside
    }

    @AfterAll
    public void tearDown() {
        flightListing.close(); // Clean up the browser session
    }

    @Test
    public void testFlightSearchWithLogin() {
        // Arrange
        String username = "testuser";
        String password = "1y78fsdfngdfi783423w5767678df";
        String from = "Anchorage ANC";
        String to = "Abakan ABA";
        LocalDate departureDate = LocalDate.of(2024, 12, 20);
        int passengers = 1;
        LocalDate returnDate = LocalDate.of(2024, 12, 25);

        // Act
        flightListing.searchFlights(username,password,from, to, departureDate, passengers, returnDate);

        // Assert
        assertDoesNotThrow(() -> flightListing.listAvailableFlights(),
                "Flight listing failed or no flights are available");
    }

    @Test
    public void testFlightListingsAreNotEmpty() {
        // Arrange
        String username = "testuser";
        String password = "1y78fsdfngdfi783423w";
        String from = "Anchorage ANC";
        String to = "Abakan ABA";
        LocalDate departureDate = LocalDate.of(2024, 12, 20);
        int passengers = 1;
        LocalDate returnDate = LocalDate.of(2024, 12, 25);

        // Act
        flightListing.searchFlights(username,password,from, to, departureDate, passengers, returnDate);

        // Assert
        List<WebElement> listings = flightListing.listAvailableFlights();
        assertFalse(listings.isEmpty(), "No flight listings were found!");
    }
}
