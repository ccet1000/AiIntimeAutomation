package com.aiintime.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aiintime.base.BasePage;
import com.aiintime.utils.TestDataUtil;

public class AddUserPage extends BasePage {

    By displayNameField = By.id("displayName");
    By firstNameField = By.id("firstName");
    By lastNameField = By.id("lastName");
    By emailField = By.id("username");
    By createButton = By.xpath("//div[text()='Create']");
    By cancelButton = By.xpath("//button[text()='Cancel']");
    By successMessage = By.xpath("//div[@id='notistack-snackbar' and contains(text(),'New user account information added successfully.')]");

    // Roles
    By globalAdministratorCheckbox = By.xpath("//span[text()='Global Administrator']/preceding-sibling::span");
    By accountAdministratorCheckbox = By.xpath("//span[text()='Account Administrator']/preceding-sibling::span");
    By userCheckbox = By.xpath("//span[text()='User']/preceding-sibling::span");
    By guestCheckbox = By.xpath("//span[text()='Guest']/preceding-sibling::span");

    public AddUserPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad() {
        waitForVisibility(displayNameField);
        waitForVisibility(createButton);
    }
    public void enterDisplayName(String displayName) {
        type(displayNameField, displayName);
    }

    public void enterFirstName(String firstName) {
        type(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        type(lastNameField, lastName);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void selectGlobalAdministrator() {
        click(globalAdministratorCheckbox);
    }

    public void selectAccountAdministrator() {
        click(accountAdministratorCheckbox);
    }

    public void selectUser() {
        click(userCheckbox);
    }

    public void selectGuest() {
        click(guestCheckbox);
    }

    public void clickCreate() {
        click(createButton);
    }

    public void clickCancel() {
        click(cancelButton);
    }
    public String getSuccessMessage() {
        return waitForVisibility(successMessage).getText();
    }
    
}