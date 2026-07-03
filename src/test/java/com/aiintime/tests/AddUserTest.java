package com.aiintime.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aiintime.base.BaseTest;
import com.aiintime.components.SidebarComponent;
import com.aiintime.pages.AddUserPage;
import com.aiintime.pages.LoginPage;
import com.aiintime.pages.SettingsPage;
import com.aiintime.pages.UsersPage;
import com.aiintime.utils.ConfigReader;
import com.aiintime.utils.TestDataUtil;

public class AddUserTest extends BaseTest{
	@Test
	public void createUserWithMandatoryFields() {
		
		SidebarComponent sidebarComponent = new SidebarComponent(driver);
		sidebarComponent.openSettings();
		
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.openUsersPage();
		
		UsersPage usersPage = new UsersPage(driver);
		usersPage.clickAddButton();
		
		AddUserPage addUserPage = new AddUserPage(driver);
		addUserPage.waitForPageToLoad();
		addUserPage.enterDisplayName(ConfigReader.getProperty("displayName"));
		String email = TestDataUtil.getUniqueEmail();
		addUserPage.enterEmail(email);
		String[] roles = ConfigReader.getProperty("role").split(",");

		for (String role : roles) {

		    switch (role.trim().toLowerCase()) {

		        case "global administrator":
		            addUserPage.selectGlobalAdministrator();
		            break;

		        case "account administrator":
		            addUserPage.selectAccountAdministrator();
		            break;

		        case "user":
		            addUserPage.selectUser();
		            break;

		        case "guest":
		            addUserPage.selectGuest();
		            break;

		        default:
		            throw new IllegalArgumentException("Invalid role: " + role);
		    }
		}	
		addUserPage.clickCreate();
		Assert.assertEquals(
			    addUserPage.getSuccessMessage(),
			    "New user account information added successfully."
			);
	}
	
}
