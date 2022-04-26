package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.xpath("//input[@name='username']"),"san1234");
        sendTextToElement(By.xpath("//input[@name='password']"),"Prime1234");
        clickOnElement(By.xpath("//input[@class='button']"));
        String expectedMessage = "Accounts Overview";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
        Assert.assertEquals("Accounts Overview is not displayed", expectedMessage, actualMessage);
    }
    @Test
    public void verifyTheErrorMessage() {
       sendTextToElement(By.xpath("//input[@name='username']"),"san1");
        sendTextToElement(By.xpath("//input[@name='password']"),"Prime12");
        clickOnElement(By.xpath("//input[@class='button']"));
        String expectedMessage = "The username and password could not be verified.";
        String actualMessage = getTextFromElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
        Assert.assertEquals("Accounts Overview is displayed", expectedMessage, actualMessage);
    }
    @Test
    public void userShouldLogOutSuccessfully() {
        sendTextToElement(By.xpath("//input[@name='username']"),"san1234");
        sendTextToElement(By.xpath("//input[@name='password']"),"Prime1234");
        clickOnElement(By.xpath("//input[@class='button']"));
        driver.manage().deleteAllCookies();
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        String expectedMessage = "Customer Login";
        String actualMessage2 = getTextFromElement(By.cssSelector("div[id='leftPanel'] h2"));
        Assert.assertEquals("Customer Login is not displayed", expectedMessage, actualMessage2);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}


