package mypack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginWindowPage {

    private WebDriver driver;
    private By email = By.id("signonForm.email");
    private By password = By.id("signonForm.password");
    private By login = By.cssSelector("button.ui.right.labeled.icon.fluid.button");
    private By redError = By.cssSelector("span.red");
    private By error = By.xpath("//*[@id=\"layout-wrapper\"]/div[3]/div[1]/div/div/div[1]/div/ul/li");

    public LoginWindowPage(final WebDriver driver)
    {
        this.driver = driver;
    }

    public void enterEmail(final String aEmail)
    {
        final WebDriverWait wait = new WebDriverWait(driver, 10);
        final WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        if (emailBox.isDisplayed() || emailBox.isEnabled())
        {
            emailBox.click();
            emailBox.sendKeys(aEmail);
        }
    }

    public void enterPassword(final String aPassword)
    {
        final WebDriverWait wait = new WebDriverWait(driver, 10);
        final WebElement passwordBox = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        if (passwordBox.isDisplayed() || passwordBox.isEnabled())
        {
            passwordBox.click();
            passwordBox.sendKeys(aPassword);
        }
    }

    public void clickLoginButton()
    {
        final WebElement loginButton = driver.findElement(login);
        if (loginButton.isEnabled())
        {
            loginButton.click();
        }
    }

    public void verifyPageAfterLogin(final String aEmail, final String aPassword, final String aExpectedUrlText,
                                     final String aExpectedTitle, final String aExpectedError)
    {
        enterEmail(aEmail);
        enterPassword(aPassword);
        clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().contains(aExpectedUrlText));
        Assert.assertEquals(driver.getTitle(), aExpectedTitle);
        Assert.assertEquals(getErrormessage(), aExpectedError);
    }

    public String getErrormessage()
    {
        final WebElement redErrorText = driver.findElement(redError);
        final WebElement errorMessage = driver.findElement(error);
        if (redErrorText.isDisplayed())
        {
            Assert.assertEquals(redErrorText.getText(),"Fehler");
        }
        final String errorMessageText = errorMessage.getText();
        return errorMessageText;
    }
}
