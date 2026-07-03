package com.aiintime.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aiintime.base.BasePage;

public class CaseyHubsPage extends BasePage {
	
	By activeHubsButton = By.xpath("//button[@aria-label='Active Hubs']");
	By archivedHubsButton = By.xpath("//button[@aria-label='Deactivated Hubs']");
	By deactivatedHubsButton = By.xpath("//button[@aria-label='Deactivated Hubs']");
    By newHubIcon = By.xpath("//button[@aria-label='New hub']");
 
    By vaultOption = By.xpath("//button[@aria-label='Vault']");
    By myHubsButton = By.xpath("//button[@aria-label='My Hubs']");
    
    By currentHub = By.xpath("//h1/following-sibling::div//p");
    
    By archivedHubsSectionTitle = By.xpath("//p[text()='Archived Hubs']");
    
    By hubActionsButton(String hubName) {
        return By.xpath(
            "//div[@role='button'][.//p[@aria-label='" + hubName + "']]//div[contains(@class,'hub-more-icon')]"
        );
    }
    public By getHubActionsButton(String hubName) {
        return By.xpath(
            String.format(
                "//p[normalize-space()='%s']/ancestor::div[2]//div[@role='button'][1]",
                hubName
            )
        );
    }
    
    public CaseyHubsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad() {
        waitForVisibility(newHubIcon);
        waitForVisibility(currentHub);
    }

    public void clickNewHub() {
        click(newHubIcon);
    }

    public void openHub(String hubName) {

        if (isHubSelected(hubName)) {
            return;
        }

        click(By.xpath("//div[@role='button'][.//p[@aria-label='" + hubName + "']]"));
        waitForVisibility(currentHub);
    }
    
    public void openHubActionsButton(String hubName) {
        click(hubActionsButton(hubName));
    } 
    public boolean isHubSelected(String hubName) {
        return getText(currentHub).equals(hubName);
    }
    public void openVault() {
        click(vaultOption);
    }
    
    public void openActiveHubs() {
    	click(activeHubsButton);
    }
    public void openArchivedHubs() {
    	click(archivedHubsButton);
    }
    public void openDeactivatedHubs() {
    	click(deactivatedHubsButton);
    }
    public void openMyhubs() {
    	click(myHubsButton);
    }
    
    public String getArchivedPageTitle() {
        return waitForVisibility(archivedHubsSectionTitle).getText().trim();
    }
    
}