/*
Licensed to the Software Freedom Conservancy (SFC) under one
or more contributor license agreements. See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.
*/

import ContosoAir.Operations.FlightBookingOperation;
import ContosoAir.Pages.FlightBooking;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FlightBookingTest {

    private FlightBookingOperation flightBooking;

    @BeforeEach
    public void setUp() {
        flightBooking = new FlightBooking();
    }

    @Test
    @Order(1)
    public void testValidLoginAndBookingFlight() {
        //Arrange
        String username = "Raihan1";
        String password = "sdhajklsdhqwo84739043-467873@";
        String from = "Seisia ABM";
        String to = "Egg Harbor City ACY";
        LocalDate departure = LocalDate.of(2024, 12, 20);
        LocalDate ret = LocalDate.of(2024, 12, 25);

        //Act
        flightBooking.bookFlight(username, password,from, to, departure, 1, ret);

        //Assert
        String expected = "Flight booked!";
        String actual = flightBooking.getBookingConfirmationTitle();
        assertEquals(expected, actual, "The booking title does not match the expected description.");
    }

    @Test
    @Order(2)
    public void testSinglePassengerBooking() {
        //Arrange
        String username = "Raihan1";
        String password = "nnsuiseuia9876a!!@";
        String from = "Seisia ABM";
        String to = "Egg Harbor City ACY";
        LocalDate departure = LocalDate.of(2024, 12, 20);
        LocalDate ret = LocalDate.of(2024, 12, 25);

        //Act
        flightBooking.bookFlight(username, password,from, to, departure, 1, ret);

        //Assert
        String expected = "Flight booked!";
        String actual = flightBooking.getBookingConfirmationTitle();
        assertEquals(expected, actual);
    }

    @Test
    @Order(3)
    public void testMultiplePassengersBooking() {
        //Arrange
        String username = "randommonkey";
        String password = "asdfghjsj8967623!@v";
        String from = "Seisia ABM";
        String to = "Egg Harbor City ACY";
        LocalDate departure = LocalDate.of(2024, 12, 20);
        LocalDate ret = LocalDate.of(2024, 12, 25);

        //Act
        flightBooking.bookFlight(username, password,from, to, departure, 3, ret);

        //Assert
        assertEquals("Flight booked!", flightBooking.getBookingConfirmationTitle());
    }


    @AfterEach
    public void tearDown() {
        flightBooking.close();
    }
}
