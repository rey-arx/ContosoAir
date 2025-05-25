package ContosoAir.Operations;

public interface LoginOperations {

    /**
     * Navigates to the specified URL.
     */
    void navigateToUrl();

    /**
     * Performs login with the provided username and password.
     *
     * @param username The username for login.
     * @param password The password for login.
     */
    void performLoginWithCredentials(String username, String password);

    /**
     * Attempts to perform login without providing any credentials.
     */
    String performLoginWithoutCredentials();

    /**
     * Closes the WebDriver session and cleans up resources.
     */
    void tearDown();
}