package com.aiintime.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aiintime.base.BasePage;

public class UserProfileFooter extends BasePage{

	public UserProfileFooter(WebDriver driver) {
		super(driver);	
	}
	
	By userMenu = By.xpath("//div[contains(@class,'MuiAvatar-root')]");
	
	public void openUserMenu() {
		click(userMenu);
	}
	
}
