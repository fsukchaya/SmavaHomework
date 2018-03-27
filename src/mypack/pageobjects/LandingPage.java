package mypack.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LandingPage {

    private WebDriver driver;
    private By loanAmount = By.xpath("//*[@id=\"myselect\"]/div/input ");
    private By duration = By.xpath("//*[@id=\"myselect2\"]/div/input ");
    private By nextButton = By.id("forwardButtonskg");
    private By login = By.className("login-popup");

    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getLandingPageTitle()
    {
        final String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public void verifyLandingPageTitle(final String aExpectedLandingPageTitle)
    {
        Assert.assertEquals(getLandingPageTitle(), aExpectedLandingPageTitle);
    }

    public LoginWindowPage openLoginWindow()
    {
        driver.findElement(login).click();
        return new LoginWindowPage(driver);
    }

    public void typeTextInInput(final By aLocator, final String aText)
    {
        final WebElement loanAmountBox = driver.findElement(aLocator);
        if (loanAmountBox.isEnabled())
        {
            loanAmountBox.sendKeys(aText);
            loanAmountBox.sendKeys(Keys.ENTER);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
        }
    }

    public ResultPage openResultPage(final String aLoanAmount, final String aDuration) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        typeTextInInput(loanAmount, aLoanAmount);
        typeTextInInput(duration, aDuration);
        final WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
        next.click();
        return new ResultPage(driver);
    }

}
