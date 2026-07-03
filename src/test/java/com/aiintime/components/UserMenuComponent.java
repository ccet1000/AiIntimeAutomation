package com.aiintime.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aiintime.base.BasePage;

public class UserMenuComponent extends BasePage{

	public UserMenuComponent(WebDriver driver) {
		super(driver);
	}
	
	By logoutOption = By.xpath("//p[text()='Logout']");
	
	public void clickLogoutOption() {
		click(logoutOption);
	}
}
