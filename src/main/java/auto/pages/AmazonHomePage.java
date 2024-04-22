package auto.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;
import java.util.*;

public class AmazonHomePage {
    public WebDriver driver;
    @FindBy(id="nav-logo-sprites")
    private WebElement amazonLogo;

    @FindBy(xpath="//input[@id='twotabsearchtextbox']")
    private WebElement amazonSearchBar;

    @FindBy(xpath = "//div[@class='nav-line-1-container']")
    private WebElement signIntext;

    @FindAll ({
            @FindBy (xpath = "//div[@id='nav-xshop-container']//a")
    })
    private List<WebElement> homeShopBar;

    @FindBy(xpath = "//div[@id='nav-xshop']")
    private WebElement waitTillelementPresent;

    @FindBy(xpath = "//span[@id = 'nav-cart-count']")
    private WebElement amazonCart;

    @FindBy(tagName = "h2")
    private WebElement headerText;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean validateAmazonLogo() throws InterruptedException {
        return amazonLogo.isDisplayed();
    }

    public boolean validateSignText(){
        return signIntext.isDisplayed();
        //webDriver.navigate().back();
    }

    public void waitMethod(Long timeInSeconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        webDriverWait.until(d -> waitTillelementPresent.isDisplayed());

    }
    public List<WebElement> listOfHomeShopElement() {
        return homeShopBar;
    }

    public void navigateRefreshPage() {
        driver.navigate().refresh();
    }

    public String cartValidation() {
        amazonCart.click();
        return headerText.getText();
    }
}
