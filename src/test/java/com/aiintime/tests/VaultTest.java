package com.aiintime.tests;

import org.testng.annotations.Test;

import com.aiintime.base.BaseTest;
import com.aiintime.pages.CaseyChatsPage;
import com.aiintime.pages.CaseyHubsPage;
import com.aiintime.pages.LoginPage;
import com.aiintime.pages.VaultPage;
import com.aiintime.utils.ConfigReader;

public class VaultTest extends BaseTest{
	@Test
	public void verifyLocalFileUpload() {
		
		CaseyChatsPage casey_chats = new CaseyChatsPage(driver);
		casey_chats.waitForPageToLoad();
		casey_chats.clickCaseyHubs();
		
		CaseyHubsPage casey_hubs = new CaseyHubsPage(driver);
		casey_hubs.waitForPageToLoad();
		
		casey_hubs.openHub(ConfigReader.getProperty("fileUploadTestHub"));
		casey_hubs.openVault();
		
		VaultPage vault_page = new VaultPage(driver);
		vault_page.waitForPageToLoad();
		vault_page.clickShareToButton();
		vault_page.uploadFiles();
		vault_page.clickUpload();
		vault_page.waitForFileUploadSuccessMessage();
		
		
	}
}
