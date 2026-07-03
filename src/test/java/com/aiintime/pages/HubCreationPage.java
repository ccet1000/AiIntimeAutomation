package com.aiintime.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aiintime.base.BasePage;

public class HubCreationPage extends BasePage {

    By hubNameField = By.id("hubName");
    By descriptionField = By.id("hubDescription");
    By tagField = By.id("hubTagInput");

    By personalAccess = By.xpath("//button[@value='Personal']");
    By membersOnlyAccess = By.xpath("//button[@value='MemberOnly']");
    By publicAccess = By.xpath("//button[@value='Public']");

    By saveButton = By.xpath("//button[contains(.,'Save')]");
    By cancelButton = By.xpath("//button[contains(.,'Cancel')]");

    public HubCreationPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad() {
        waitForVisibility(hubNameField);
    }

    public void enterHubName(String hubName) {
        click(hubNameField);
        type(hubNameField, hubName);
    }

    public void enterDescription(String description) {
        click(descriptionField);
        type(descriptionField, description);
    }

    public void enterTag(String tag) {
        click(tagField);
        type(tagField, tag);
    }

    public void selectPersonalAccess() {
        click(personalAccess);
    }

    public void selectMembersOnlyAccess() {
        click(membersOnlyAccess);
    }

    public void selectPublicAccess() {
        click(publicAccess);
    }

    public void clickSave() {
        click(saveButton);
    }

    public void clickCancel() {
        click(cancelButton);
    }
}