import ContosoAir.Operations.LandingPageOperations;
import ContosoAir.Pages.HomePage;
import ContosoAir.Pages.LandingPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class LandingPageTest {
    LandingPageOperations contosoAir;

    @Before
    public void setUp() {
        contosoAir = new LandingPage();
    }

    @After
    public void tearDown() {
        contosoAir.tearDown();
    }

    @Test
    public void testingLogoDetails(){
        String expected = "logo_contoso_air.svg";
        String actual = contosoAir.getLogoDetails();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testRecommendation(){
        int expected = 3;
        int actual = contosoAir.getRecommendations();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void enterLogin(){
        String expected = "Login";
        String actual = contosoAir.enterLogin();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void enterBook(){
        String expected = "Book a trip";
        String actual = contosoAir.enterBooking("raihan","12345678");
        Assert.assertEquals(expected,actual);
    }

}
