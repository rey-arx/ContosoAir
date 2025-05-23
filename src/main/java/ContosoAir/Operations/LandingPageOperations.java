package ContosoAir.Operations;

public interface LandingPageOperations {
    public String getLogoDetails();
    public int getRecommendations();
    void performLoginWithCredentials(String username, String password);
    public String enterBooking(String username, String password);
    public String enterLogin();
    public void tearDown();
}
