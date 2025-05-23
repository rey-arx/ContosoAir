/*
Licensed to the Software Freedom Conservancy (SFC) under one
or more contributor license agreements.
*/

import ContosoAir.Pages.HomePage;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;



public class HomePageTest {

    private HomePage homepage;

    @BeforeEach
    public void setUp() {
        homepage = new HomePage();
    }

    @AfterEach
    public void tearDown() {
        homepage.tearDown();
    }

    @Test
    public void testLogoIsDisplayed() {
        homepage.performLogin("Raihan", "Raihan");
        assertDoesNotThrow(() -> homepage.getLogo(), "Logo image is not displayed using Relative XPath.");
    }

    @Test
    public void testGetTitle() {
        homepage.performLogin("Raihan", "Raihan");
        String expected = "Where do you\nwant to go?";
        String actual = homepage.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetSubtitle() {
        homepage.performLogin("Raihan", "Raihan");
        String expected = "Flight deals";
        String actual = homepage.subTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetSuggestedTitle() {
        homepage.performLogin("Raihan", "Raihan");
        String expected = "Recommended for you";
        String actual = homepage.getSuggestTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckHawaiiImage() {
        homepage.performLogin("Raihan", "Raihan");
        assertDoesNotThrow(() -> homepage.checkHawaiiImage(), "Hawaii image is not displayed.");
    }

    @Test
    public void testCheckHawaiiCaption() {
        homepage.performLogin("Raihan", "Raihan");
        String expected = "Hawaii";
        String actual = homepage.checkHawaiiCaption();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckParisImage() {
        homepage.performLogin("Raihan", "Raihan");
        assertDoesNotThrow(() -> homepage.checkParisImage(), "Paris image is not displayed.");
    }

    @Test
    public void testCheckParisCaption() {
        homepage.performLogin("Raihan", "Raihan");
        String expected = "Paris";
        String actual = homepage.checkParisCaption();
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckBarcelonaImage() {
        homepage.performLogin("Raihan", "Raihan");
        assertDoesNotThrow(() -> homepage.checkBarcelonaImage(), "Barcelona image is not displayed.");
    }

    @Test
    public void testCheckBarcelonaCaption() {
        homepage.performLogin("Raihan", "Raihan");
        String expected = "Barcelona";
        String actual = homepage.checkBarcelonaCaption();
        assertEquals(expected, actual);
    }

    @Test
    public void testPerformLogin() {
        homepage.performLogin("Raihan", "Raihan");
        // Additional assertions can be placed here to verify login success
    }
}
