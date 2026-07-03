package com.aiintime.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aiintime.base.BaseTest;
import com.aiintime.pages.CaseyChatsPage;
import com.aiintime.pages.LoginPage;
import com.aiintime.utils.ConfigReader;

public class CaseyChatsTest extends BaseTest {
	@Test
	public void verifyCaseyChatIsWorking() {
				
		CaseyChatsPage caseychats = new CaseyChatsPage(driver);
		caseychats.waitForPageToLoad();
		caseychats.enterQuery(ConfigReader.getProperty("query"));
		
		int previousCount = caseychats.getTimeStampCount();
		caseychats.clickGenerateQuery();
		
		caseychats.waitForResponseCompletion(previousCount);
		
		String response = caseychats.getResponse();
		System.out.println(response);
		Assert.assertFalse(response.trim().isEmpty(),
		        "Response was not generated");
	}
}
