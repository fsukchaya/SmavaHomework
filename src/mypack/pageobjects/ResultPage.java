package mypack.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ResultPage {

    private WebDriver driver;

    public ResultPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getResultPageUrl()
    {
        return driver.getCurrentUrl();
    }

    public void verifyResultPageUrl(final String aExpectedUrlText)
    {
        Assert.assertTrue(getResultPageUrl().contains(aExpectedUrlText));
    }

    public String getResultPageTitle()
    {
        return driver.getTitle();
    }

    public void verifyResultPageTitle(final String aExpectedResulltPageTitle)
    {
        Assert.assertEquals(getResultPageTitle(), aExpectedResulltPageTitle);
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, 20).until(
                (WebDriver driver) -> {
                    final JavascriptExecutor js = (JavascriptExecutor)driver;
                    return (Boolean)js.executeScript("return document.readyState === 'complete'");
                });
    }

}
