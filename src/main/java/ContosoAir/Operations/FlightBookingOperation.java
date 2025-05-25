package ContosoAir.Operations;

/*
Licensed to the Software Freedom Conservancy (SFC) under one
or more contributor license agreements.

Author: Raihan
*/


import java.time.LocalDate;

/**
 * Defines the contract for a flight booking system,
 * including methods for login, flight selection, booking,
 * and retrieving booking details.
 */
public interface FlightBookingOperation {

    /**
     * Logs in the user with the provided username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    void login(String username, String password);

    /**
     * Selects the flight details based on departure and return locations, dates, and number of passengers.
     *
     * @param from                Departure location.
     * @param to                  Destination location.
     * @param departureDate       Date of departure.
     * @param numberOfPassengers  Number of passengers.
     * @param returnDate          Return date (if applicable).
     */
    void selectFlightDetails(String from, String to, LocalDate departureDate, int numberOfPassengers, LocalDate returnDate);

    /**
     * Books the selected flight.
     */
    void bookFlight(String username,String password,String from, String to, LocalDate departure, int noOfPassengers, LocalDate ret );

    /**
     * Closes the current flight booking session.
     */
    void close();

    /**
     * Retrieves the title of the booking confirmation page.
     *
     * @return The title of the booking confirmation page.
     */
    String getBookingConfirmationTitle();


}
