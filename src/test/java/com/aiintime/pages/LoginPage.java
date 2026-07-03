package com.aiintime.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aiintime.base.BasePage;

public class LoginPage extends BasePage {

    By emailField = By.xpath("//input[@placeholder='Enter Email']");
    By passWord = By.xpath("//input[@placeholder='Enter Password']");
    By submitButton = By.xpath("//button[@type ='submit']");
    By errorMessage = By.xpath("//p[contains(text(),'Wrong email or password')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        waitForVisibility(emailField);
        type(emailField, email);
        type(passWord, password);
        click(submitButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}