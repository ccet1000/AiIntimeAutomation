package com.aiintime.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aiintime.base.BaseTest;
import com.aiintime.components.HubActionsComponent;
import com.aiintime.pages.CaseyChatsPage;
import com.aiintime.pages.CaseyHubsPage;
import com.aiintime.utils.ConfigReader;

public class HubActionsTest extends BaseTest{
	
	String hubName = ConfigReader.getProperty("hubOperationsTestHub");	
	
	@Test
	public void verifyOpenInNewTabWorks() {
		CaseyChatsPage caseyChatsPage = new CaseyChatsPage(driver);
		caseyChatsPage.clickCaseyHubs();
		
		CaseyHubsPage caseyHubsPage = new CaseyHubsPage(driver);
		caseyHubsPage.waitForPageToLoad();
		caseyHubsPage.openHub(hubName);
		caseyHubsPage.openHubActionsButton(hubName);
		String parentWindow = driver.getWindowHandle();
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = currentUrl;
		
		HubActionsComponent hubActionsComponent = new HubActionsComponent(driver);
		hubActionsComponent.clickOpenInNewTab();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));	
		
		for (String window : driver.getWindowHandles()) {
		    if (!window.equals(parentWindow)) {
		        driver.switchTo().window(window);
		        break;
		    }
		}
		Assert.assertEquals(driver.getWindowHandles().size(), 2);
		Assert.assertEquals(currentUrl, expectedUrl);
		Assert.assertTrue(caseyHubsPage.isHubSelected(hubName));
		
		driver.close();
		driver.switchTo().window(parentWindow);
	}

	@Test
	public void verifyPinHubWorks() {
		CaseyChatsPage caseyChatsPage = new CaseyChatsPage(driver);
		caseyChatsPage.clickCaseyHubs();
		
		CaseyHubsPage caseyHubsPage = new CaseyHubsPage(driver);
		caseyHubsPage.waitForPageToLoad();
		caseyHubsPage.openHub(ConfigReader.getProperty("hubOperationsTestHub"));
		caseyHubsPage.openHubActionsButton(hubName);
		
		HubActionsComponent hubActionsComponent = new HubActionsComponent(driver);
		hubActionsComponent.clickPinHub();
		
		Assert.assertTrue(
			    hubActionsComponent.getHubActionMessage()
			        .contains("Hub pinned successfully")
			);
		
	}

	@Test
	public void verifyUnpinHubWorks() {
		CaseyChatsPage caseyChatsPage = new CaseyChatsPage(driver);
		caseyChatsPage.clickCaseyHubs();
		
		CaseyHubsPage caseyHubsPage = new CaseyHubsPage(driver);
		caseyHubsPage.waitForPageToLoad();
		caseyHubsPage.openHub(hubName);
		caseyHubsPage.openHubActionsButton(hubName);
		
		HubActionsComponent hubActionsComponent = new HubActionsComponent(driver);
		hubActionsComponent.clickUnpinHub();
		
		Assert.assertTrue(
			    hubActionsComponent.getHubActionMessage()
			        .contains("Hub unpinned successfully")
			);

	}

	/*@Test
	public void verifyArchiveHubWorks() {
		CaseyChatsPage caseyChatsPage = new CaseyChatsPage(driver);
		caseyChatsPage.clickCaseyHubs();
		
		CaseyHubsPage caseyHubsPage = new CaseyHubsPage(driver);
		caseyHubsPage.waitForPageToLoad();
		caseyHubsPage.openHub(hubName);
		caseyHubsPage.openHubActionsButton(hubName);
		
		HubActionsComponent hubActionsComponent = new HubActionsComponent(driver);
		hubActionsComponent.clickArchiveHub();
		
		Assert.assertTrue(
			    hubActionsComponent.getHubActionMessage()
			        .contains("Hub archived successfully")
			);
		
		caseyHubsPage.openArchivedHubs();
		Assert.assertTrue(
			    caseyHubsPage.getArchivedPageTitle()
			        .contains("Archived Hubs"),
			    "Not navigated to Archived Hubs page"
			);
		
		
	}

	/*@Test
	public void verifyLeaveHubWorks() {
		CaseyChatsPage caseyChatsPage = new CaseyChatsPage(driver);
		caseyChatsPage.clickCaseyHubs();
		
		CaseyHubsPage caseyHubsPage = new CaseyHubsPage(driver);
		caseyHubsPage.waitForPageToLoad();
		
		caseyHubsPage.openHubActionsButton(ConfigReader.getProperty("hubOperationsTestHub"));
	}

	@Test
	public void verifyDeactivateHubWorks() {
		CaseyChatsPage caseyChatsPage = new CaseyChatsPage(driver);
		caseyChatsPage.clickCaseyHubs();
		
		CaseyHubsPage caseyHubsPage = new CaseyHubsPage(driver);
		caseyHubsPage.waitForPageToLoad();
		caseyHubsPage.openHubActionsButton(ConfigReader.getProperty("hubOperationsTestHub"));
		
		HubActionsComponent hubActionsComponent = new HubActionsComponent(driver);
		
	}
	
*/	

}
