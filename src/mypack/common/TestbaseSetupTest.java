package mypack.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestbaseSetupTest {

    protected WebDriver driver;
    final String geckoDriver = "/Users/fsukchaya/Projects/geckoDriver_v17/geckodriver";
    final String chromeDriver = "/Users/fsukchaya/Projects/chromedriver";

    protected WebDriver getDriver()
    {
        return driver;
    }

    private WebDriver setDriver(final String aBrowser, final String aUrl)
    {
        if (aBrowser.matches("iexplorer")) {
            driver = new InternetExplorerDriver();
            //driver.get(aUrl);
        } else if (aBrowser.matches("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromeDriver);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(aUrl);
        } else {
            System.setProperty("webdriver.gecko.driver", geckoDriver);
            final FirefoxProfile fp = new FirefoxProfile();
            fp.setPreference("browser.download.folderList", 2);
            fp.setPreference("browser.download.manager.showWhenStarting", false);
            fp.setPreference("browser.download.manager.focusWhenStarting", false);
            fp.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel,application/xls,text/csv,text/plain");
            fp.setAcceptUntrustedCertificates(true);
            fp.setAssumeUntrustedCertificateIssuer(true);
            driver = new FirefoxDriver(fp);
            driver.manage().window().maximize();
            //driver.get(aUrl);
        }
        return driver;
    }

    @BeforeClass
    @Parameters({"aBrowser","aUrl"})
    public void initializeTestBaseSetup(final String aBrowser, final String aUrl) {
        try {
            setDriver(aBrowser, aUrl);

        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }

}
