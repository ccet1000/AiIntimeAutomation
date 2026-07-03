package com.aiintime.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aiintime.components.UserProfileFooter;
import com.aiintime.components.UserMenuComponent;
import com.aiintime.pages.CaseyChatsPage;
import com.aiintime.pages.LoginPage;
import com.aiintime.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

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

        // ALWAYS START FROM LOGIN PAGE
        driver.get(ConfigReader.getProperty("url"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );

        new CaseyChatsPage(driver).waitForPageToLoad();
    }

    @BeforeMethod
    public void setup() {

        // Ensure user is always in application
        driver.get(ConfigReader.getProperty("homePageUrl"));

        // If session expired → re-login
        if (driver.getCurrentUrl().contains("login")) {

            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(
                    ConfigReader.getProperty("email"),
                    ConfigReader.getProperty("password")
            );

            new CaseyChatsPage(driver).waitForPageToLoad();
        }
    }

    @AfterSuite
    public void tearDown() {

        try {
            if (driver != null &&
                !driver.findElements(By.xpath("//div[contains(@class,'MuiAvatar-root')]")).isEmpty()) {

                UserProfileFooter footer = new UserProfileFooter(driver);
                footer.openUserMenu();

                UserMenuComponent userMenu = new UserMenuComponent(driver);
                userMenu.clickLogoutOption();
            }

        } catch (Exception e) {
            System.out.println("Logout skipped: " + e.getMessage());
        }

        if (driver != null) {
            driver.quit();
        }
    }
}