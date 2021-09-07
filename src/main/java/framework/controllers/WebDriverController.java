package framework.controllers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverController {

    private WebDriver driver;

    //private static ThreadLocal<WebDriver> threadLocaldriver = new ThreadLocal<>();

    private static String browserType;

    private String chromedriverpath = System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe";

    public WebDriver getDriver() {

        if(driver==null)
            driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {

        browserType = FileReaderController.getInstance().getPropertiesReader().getBrowserType();

        switch(browserType) {

            case "CHROME" :
                WebDriverManager.chromedriver().setup();
                //System.setProperty("webdriver.chrome.driver", chromedriverpath);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                break;

            case "FIREFOX" :
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--ignore-certificate-errors");
                firefoxOptions.addArguments("disable-infobars");
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                break;
        }

        return driver;
    }

    public void quitDriver() {

        driver.close();
        driver.quit();
    }
}
