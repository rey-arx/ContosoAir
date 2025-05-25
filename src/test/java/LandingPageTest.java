import ContosoAir.Operations.LandingPageOperations;
import ContosoAir.Pages.HomePage;
import ContosoAir.Pages.LandingPage;
import ContosoAir.Util.Recommendation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.List;

/**
 * This class contains unit tests for the Landing Page functionalities
 * of the ContosoAir application.
 */
public class LandingPageTest {

    // Reference to LandingPage functionality via interface
    LandingPageOperations contosoAir;

    /**
     * Setup method executed before each test.
     * Initializes the LandingPage object and browser.
     */
    @Before
    public void setUp() {
        contosoAir = new LandingPage();
    }

    /**
     * Teardown method executed after each test.
     * Closes the browser session.
     */
    @After
    public void tearDown() {
        contosoAir.tearDown();
    }

    /**
     * Verifies that the logo on the landing page matches the expected logo file name.
     */
    @Test
    public void testingLogoDetails() {
        String expected = "logo_contoso_air.svg";
        String actual = contosoAir.getLogoDetails();
        Assert.assertEquals(expected, actual);
    }

    /**
     * Verifies the number of recommended destinations shown on the landing page.
     */
    @Test
    public void testRecommendation() {
        int expected = 3; // Expecting 3 destination blocks
        List<Recommendation> recommendations = contosoAir.getRecommendations();
        System.out.println(recommendations.get(0).imageUrl);
        System.out.println(recommendations.get(1).imageUrl);
        System.out.println(recommendations.get(2).imageUrl);
        System.out.println(recommendations.get(0).description);
        System.out.println(recommendations.get(1).description);
        System.out.println(recommendations.get(2).description);
        int actual =  recommendations.size();
        Assert.assertEquals(expected, actual);
    }

    /**
     * Verifies that clicking the login link takes the user to the login section with the correct title.
     */
    @Test
    public void accessingLoginPageIsOk() {
        String expected = "Login";
        String actual = contosoAir.enterLogin();
        Assert.assertEquals(expected, actual);
    }

    /**
     * Verifies that login and navigation to the booking page works,
     * and that the correct heading is shown.
     */
    @Test
    public void accessingBookPageIsOk() {
        String expected = "Book a trip";
        String actual = contosoAir.enterBooking("raihan", "12345678");
        Assert.assertEquals(expected, actual);
    }

}
