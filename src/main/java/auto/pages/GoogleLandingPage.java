package auto.pages;

import org.openqa.selenium.*;

import java.util.*;

public class GoogleLandingPage {
    private static WebElement element=null;

    public static WebElement google_landing_page_email(WebDriver driver) {
        List<WebElement> elements = driver.findElements(By.className("gb_I gb_J"));
        for (WebElement element : elements) {
            System.out.println("List of element: "+element);
        }
        return elements.get(0);
    }

    public static WebElement google_GmailtextBox_search(WebDriver driver) {
        return driver.findElement(By.linkText("Gmail"));
    }

    public static WebElement google_searchbox(WebDriver driver) {
        return driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
    }

}
