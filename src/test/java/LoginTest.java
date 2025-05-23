
import ContosoAir.Operations.LoginOperations;

import ContosoAir.Pages.Login;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Scenario class for executing the login test.
 */
public class LoginTest {

    private LoginOperations loginTest;

    /**
     * Initializes the WebDriver and login test setup before each test.
     */
    @Before
    public void setUp() {
        loginTest = new Login();
    }

    /**
     * Test to perform login with valid credentials.
     */
    @Test
    public void performLoginWithCredentials() throws InterruptedException {
        String username = "Raihan";
        String password = "12345678";
        loginTest.performLoginWithCredentials(username, password);
        Thread.sleep(2000);
    }

    /**
     * Test to perform login without providing any credentials.
     */
    @Test
    public void performLoginWithoutCredentials() throws InterruptedException {
        String expected = "Missing Credentials";
        String actual = loginTest.performLoginWithoutCredentials();
        Assert.assertEquals(expected, actual);
        Thread.sleep(2000);
    }

    /**
     * Cleanup method to close browser after each test.
     */
    @After
    public void tearDown() {
        loginTest.tearDown();
    }
}
