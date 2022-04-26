package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public  void verifyThatSigningUpPageDisplay() {
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        String expectedMessage = "Signing up is easy!";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        Assert.assertEquals("Not navigate to Register page", expectedMessage, actualMessage);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully() {
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        sendTextToElement(By.xpath("//input[@id='customer.firstName']"),"Sanket12");
        sendTextToElement(By.xpath("//input[@id='customer.lastName']"),"desai1");
        sendTextToElement(By.xpath("//input[@id='customer.address.street']"),"2,Mayfield");
        sendTextToElement(By.xpath("//input[@id='customer.address.city']"),"Harrow");
        sendTextToElement(By.xpath("//input[@id='customer.address.state']"),"Essex");
        sendTextToElement(By.xpath("//input[@id='customer.address.zipCode']"),"AB1 2CD");
        sendTextToElement(By.xpath("//input[@id='customer.phoneNumber']"),"12378945691");
        sendTextToElement(By.xpath("//input[@id='customer.ssn']"),"123456789");
        sendTextToElement(By.xpath("//input[@id='customer.username']"),"san1234");
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"Prime1234");
        sendTextToElement(By.xpath("//input[@id='repeatedPassword']"),"Prime1234");
        clickOnElement(By.xpath("//input[@value='Register']"));
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        String actualMessage = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        Assert.assertEquals("Registration page is not displayed", expectedMessage, actualMessage);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
    //  @After


    // public void tearDown() {
    //   closeBro
}

