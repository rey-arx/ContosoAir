package ContosoAir.Operations;

import ContosoAir.Util.Recommendation;

import java.util.List;

/**
 * Interface defining operations that can be performed on the Landing Page.
 * This promotes abstraction and supports multiple implementations for the landing page logic.
 */
public interface LandingPageOperations {

    /**
     * Fetches the details of the logo (such as alt text or title).
     *
     * @return String containing logo information.
     */
    public String getLogoDetails();

    /**
     * Returns the number of recommended destinations or items displayed on the page.
     *
     * @return integer count of recommendations.
     */
    public List<Recommendation> getRecommendations();

    /**
     * Performs login using provided credentials.
     *
     * @param username The username to login with.
     * @param password The password to login with.
     */
    void performLoginWithCredentials(String username, String password);

    /**
     * Attempts to make a booking by logging in with the given credentials.
     *
     * @param username The username for booking.
     * @param password The password for booking.
     * @return A status message or confirmation related to the booking.
     */
    public String enterBooking(String username, String password);

    /**
     * Handles the login process and returns any resulting message or status.
     *
     * @return A string message indicating login result (e.g., success or error).
     */
    public String enterLogin();

    /**
     * Cleanly shuts down the browser session and quits the WebDriver.
     */
    public void tearDown();
}
