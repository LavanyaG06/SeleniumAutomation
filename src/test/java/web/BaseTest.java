package web;

import auto.utils.*;
import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.safari.*;
import org.testng.annotations.*;

public class BaseTest {
    private static BaseTest INSTANCE;
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

    private BaseTest() {
    }

    public static BaseTest  getInstance() {
        if(INSTANCE == null) INSTANCE = new BaseTest();
        return INSTANCE;
    }

    public void setDriver() {
        String testBrowser = System.getProperty("browser");
        switch (testBrowser) {
            case ("chrome") -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setAcceptInsecureCerts(true);
                threadLocalDriver.set( new ChromeDriver(options));
            }
            case ("safari") -> {
                WebDriverManager.getInstance(SafariDriver.class).setup();
                threadLocalDriver.set(new SafariDriver());
            }
            default -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.setAcceptInsecureCerts(true);
                threadLocalDriver.set( new FirefoxDriver(options));
            }
        }
    }

    public WebDriver getDriver() {
        String url = getFinalurl();
        threadLocalDriver.get().get(url);
        //webDriver.manage().deleteAllCookies();
        threadLocalDriver.get().manage().window().maximize();
        return threadLocalDriver.get();
    }

    protected static String getFinalurl() {
        String webUrl = "https://"+getWebUrl();
        return webUrl;
    }

    private static String getWebUrl() {
        return switch (System.getProperty("env")) {
            case "dev" -> TestwebUrls.dev.getUrl();
            case "test" -> TestwebUrls.test.getUrl();
            default -> TestwebUrls.dev.getUrl();
        };
    }

    @AfterClass
    public void tearDown(){
        if(threadLocalDriver.get() != null) {
            System.out.println("teardown ---->");
            threadLocalDriver.get().quit();
            //threadLocalDriver.remove();
        }
    }
}
