package auto.factory;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.safari.*;

public class DriverFactory {
    public WebDriver webDriver;
    public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public WebDriver initDriver(String browser) {
        System.out.println("Test execution browser :"+browser);
        switch (browser) {
            case("chrome"):
                WebDriverManager.chromedriver().setup();
                threadLocalDriver.set(new ChromeDriver());
            case("firefox"):
                WebDriverManager.firefoxdriver().setup();
                threadLocalDriver.set(new FirefoxDriver());
            case("safari"):
                threadLocalDriver.set(new SafariDriver());
            default:
                WebDriverManager.chromedriver().setup();
                threadLocalDriver.set(new ChromeDriver());
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

}
