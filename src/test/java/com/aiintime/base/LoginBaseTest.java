package com.aiintime.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aiintime.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginBaseTest {

    protected static WebDriver driver;

    @BeforeSuite
    public void setupSuite() {

        String browser = ConfigReader.getProperty("browser");

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Unsupported Browser : " + browser);
        }

        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setup() {
        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterSuite
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}