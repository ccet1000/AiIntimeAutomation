package com.aiintime.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aiintime.base.BasePage;

public class UsersPage extends BasePage{
	
	By searchUsersField = By.xpath("//input[@placeholder='Search Users']");
	By addButton = By.xpath("//button[@aria-label='Add']");
	By pageTitle = By.xpath("//p[text()='Users']/following::p[text()='Users']");
	
	WebDriver driver;
	public UsersPage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForPageLoad() {
		waitForVisibility(pageTitle);
	}
	
	public void clickAddButton() {
		click(addButton);
	}
	public void SearchUsers(String email) {
		type(searchUsersField,email);
	}
}
