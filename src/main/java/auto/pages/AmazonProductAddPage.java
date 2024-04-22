package auto.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class AmazonProductAddPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement serachbox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(xpath = " //span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'Apple iPhone 15, 128GB, Pink - Unlocked (Renewed P')]")
    private WebElement iphoneLink;
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCart;

    @FindBy(xpath = "//span[@id='attachSiNoCoverage-announce']")
    private WebElement noThanksElement;

    public AmazonProductAddPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchboxwithappleProducts(String... appleproduct) {
        serachbox.clear();
        serachbox.sendKeys(appleproduct);
        searchButton.click();
    }

    public void addingIphoneToCart() {
        System.out.println("inside addingIphoneToCard method ......");
        iphoneLink.click();
        addToCart.click();
        noThanksElement.click();
    }
}
