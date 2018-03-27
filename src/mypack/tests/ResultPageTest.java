package mypack.tests;

import mypack.common.TestbaseSetupTest;
import mypack.pageobjects.LandingPage;
import mypack.pageobjects.ResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResultPageTest extends TestbaseSetupTest
{
    private WebDriver driver;
    private LandingPage landingPage;
    private ResultPage resultPage;

    @BeforeClass
    public void setup()
    {
        driver = getDriver();
    }

    @Test
    public void verifyResultFuntion() throws InterruptedException {
        landingPage = new LandingPage(driver);
        resultPage = landingPage.openResultPage("2750", "24");
        resultPage.verifyResultPageUrl("/kreditantrag.html");
        resultPage.verifyResultPageTitle("smava Kreditantrag");
        resultPage.waitForPageLoad();
    }
}
