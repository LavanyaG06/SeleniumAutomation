package web.amazon;

import auto.pages.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;
import web.*;

import java.util.*;

public class AmazonHomePageTest {
    private static WebDriver driver;
    private AmazonHomePage amazonHomePage;

    @BeforeClass
    public void setUp() {
        BaseTest.getInstance().setDriver();
        driver = BaseTest.getInstance().getDriver();
        amazonHomePage = new AmazonHomePage(driver);
    }

    @Test(description = "Homepage sanity test", priority = 1)
    public void amazonLogoTest() throws InterruptedException {
        amazonHomePage.waitMethod(5L);
        boolean b = amazonHomePage.validateAmazonLogo();
        Assert.assertTrue(b, "true");
        boolean signInElemnet =  amazonHomePage.validateSignText();
        Assert.assertTrue(signInElemnet, "true");
    }

    @Test(description = "Homebar links test", priority = 2)
    public void amazonHomeBarLinks() {
        amazonHomePage.navigateRefreshPage();
        amazonHomePage.waitMethod(5L);
        List<WebElement> homeBarLinks = amazonHomePage.listOfHomeShopElement();

        Assert.assertTrue(homeBarLinks.size() != 0);
        for(WebElement link : homeBarLinks) {
            System.out.println(link.getText().trim());
        }
    }

    @Test(description = "cart validation", priority = 3)
    public void amazonCartTest() {
        String validationText = amazonHomePage.cartValidation();
        Assert.assertTrue(validationText.contains("Your Amazon Cart is empty"));
    }

    @AfterClass
    public void quitBroswer(){
        BaseTest.getInstance().tearDown();
    }

}
