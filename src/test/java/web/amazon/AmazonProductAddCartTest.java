package web.amazon;

import auto.pages.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import web.*;

public class AmazonProductAddCartTest {
    private static WebDriver driver;
    private AmazonProductAddPage amazonProductAddPage;

    @BeforeClass
    public void setUp() {
        BaseTest.getInstance().setDriver();
        driver = BaseTest.getInstance().getDriver();
        amazonProductAddPage = new AmazonProductAddPage(driver);
    }

    @Test(description = "Adding apple product to card", groups="products")
    public void addAppleProductToCart() {
        amazonProductAddPage.searchboxwithappleProducts("iphone 15");
        amazonProductAddPage.addingIphoneToCart();
    }

    @AfterClass
    public void quitBroswer(){
        BaseTest.getInstance().tearDown();
    }

}
