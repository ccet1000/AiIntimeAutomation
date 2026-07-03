package com.aiintime.tests;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import com.aiintime.base.BaseTest;
import com.aiintime.pages.CaseyChatsPage;
import com.aiintime.pages.CaseyHubsPage;
import com.aiintime.pages.HubCreationPage;
import com.aiintime.pages.LoginPage;
import com.aiintime.utils.ConfigReader;

public class HubCreationTest extends BaseTest {
	
	/*@Test(priority = 1)
	public void verifyHubNameIsMandatory() {
		
		driver.get(ConfigReader.getProperty("url"));
		
		LoginPage login_page = new LoginPage(driver);
		login_page.login(ConfigReader.getProperty("email"),ConfigReader.getProperty("password"));
		
		CaseyChatsPage casey_chats = new CaseyChatsPage(driver);
		casey_chats.clickCaseyHubs();
		
		CaseyHubsPage casey_hubs = new CaseyHubsPage(driver);
		casey_hubs.clickNewHub();
		
		HubCreationPage hubpage = new HubCreationPage(driver);
		hubpage.waitForPageToLoad();
		hubpage.enterDescription(ConfigReader.getProperty("hubDescription"));
		hubpage.clickSave();
	}*/
	
	@Test
	public void verifySuccessfullHubCreation() {
		
		CaseyChatsPage casey_chats = new CaseyChatsPage(driver);
		casey_chats.clickCaseyHubs();
		
		CaseyHubsPage casey_hubs = new CaseyHubsPage(driver);
		casey_hubs.clickNewHub();
		
		HubCreationPage hubpage = new HubCreationPage(driver);
		hubpage.waitForPageToLoad();
		hubpage.enterHubName("Test hub-"+LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM-d")));
		hubpage.selectMembersOnlyAccess();
		hubpage.clickSave();
		
		
	}
}
