package mypack.tests;

import mypack.common.TestbaseSetupTest;
import mypack.pageobjects.LandingPage;
import mypack.pageobjects.LoginWindowPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginWindowPageTest extends TestbaseSetupTest
{

    WebDriver driver;
    private LandingPage landingPage;
    private LoginWindowPage loginWindowPage;

    @BeforeClass
    public void setup()
    {
        driver = getDriver();
    }

    @Test
    public void verifyLoginFuntion()
    {
        landingPage = new LandingPage(driver);
        loginWindowPage = landingPage.openLoginWindow();
        loginWindowPage.verifyPageAfterLogin("test@test.com", "1234Abc",
                "2+Sicheres-Einloggen-mit-Zugangsdaten.html",
                "Sicheres Einloggen mit Zugangsdaten - smava.de",
                "Der Zugang für diesen Benutzernamen ist deaktiviert.");
    }

}
