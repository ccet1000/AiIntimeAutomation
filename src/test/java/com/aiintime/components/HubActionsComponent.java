package com.aiintime.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aiintime.base.BasePage;

public class HubActionsComponent extends BasePage{

	public HubActionsComponent(WebDriver driver) {
		super(driver);
	}
	
	By openInNewTabMenuItem = By.xpath("//span[text()='Open in new tab']");
	By pinHubMenuItem = By.xpath("//span[text()='Pin hub']");
	By unpinHubMenuItem = By.xpath("//span[text()='Unpin hub']");
	By archiveHubMenuItem = By.xpath("//span[text()='Archive hub']");
	By leaveHubMenuItem = By.xpath("//span[text()='Leave hub']");
	By deactivateHubMenuItem = By.xpath("//span[text()='Deactivated hub']");
	By hubActionMessage = By.id("notistack-snackbar");
	
	//Confirmation popup items
	By archiveHubPopupTitle = By.xpath("//p[text()='Archive Hub']");
	By confirmArchiveButton = By.xpath("//button[text()='Archive']");
	By confirmDeactivateButton = By.xpath("//button[text()='Deactivate']");
	
	
	
	
	
	public void clickOpenInNewTab() {
		click(openInNewTabMenuItem);
	}
	public void clickPinHub() {
		click(pinHubMenuItem);
	}
	public String getHubActionMessage() {
	    return waitForVisibility(hubActionMessage).getText().trim();
	}
	public void clickUnpinHub() {
		click(unpinHubMenuItem);
	}
	public void clickArchiveHub() {
	    click(archiveHubMenuItem);
	}

	public void clickLeaveHub() {
	    click(leaveHubMenuItem);
	}

	public void clickDeactivateHub() {
	    click(deactivateHubMenuItem);
	}
	

}
