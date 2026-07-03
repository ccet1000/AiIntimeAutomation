package com.aiintime.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aiintime.base.BasePage;

public class SidebarComponent extends BasePage{
	
	By settingsIcon = By.xpath("//button[@aria-label='Settings']");
	
	
	public SidebarComponent(WebDriver driver) {
		super(driver);	
	}
	public void openSettings() {
		click(settingsIcon);
	}

}
