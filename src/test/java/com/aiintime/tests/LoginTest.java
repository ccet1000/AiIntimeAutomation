package com.aiintime.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aiintime.base.BaseTest;
import com.aiintime.pages.CaseyChatsPage;
import com.aiintime.pages.LoginPage;
import com.aiintime.utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );

        CaseyChatsPage home = new CaseyChatsPage(driver);
        home.waitForPageToLoad();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("admin"),
                "User not redirected correctly"
        );
    }

    @Test
    public void incorrect_password() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("incorrect_password")
        );

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Wrong email or password"
        );
    }
}