package mypack.tests;

import mypack.common.TestbaseSetupTest;
import mypack.pageobjects.LandingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LandingPageTest extends TestbaseSetupTest {

    WebDriver driver;
    private LandingPage landingPage;

    @BeforeClass
    public void setup()
    {
        driver = getDriver();
    }

    @Test
    public void verifyLandingPage()
    {
        landingPage = new LandingPage(driver);
        landingPage.verifyLandingPageTitle("SMAVA - Das Online-Vergleichsportal für Kredite | SMAVA");
    }
}
