package com.aiintime.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aiintime.base.BasePage;

public class SettingsPage extends BasePage{
	
	By usersPage = By.xpath("//p[text()='Users']");
	
	public SettingsPage(WebDriver driver) {
		super(driver);
	}
	
	public void openUsersPage() {
		click(usersPage);
	}

}
