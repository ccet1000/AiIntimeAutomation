package com.aiintime.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aiintime.base.BasePage;

public class CaseyChatsPage extends BasePage {

    By searchBoxField = By.xpath("//textarea[@placeholder='Ask me anything']");
    By sendQueryButton = By.xpath("//textarea[@placeholder='Ask me anything']/following::button[1]");
    By responseTimeStamp = By.xpath("//span[contains(@class,'MuiTypography-caption')]");
    By response = By.xpath("(//div[@class='MuiBox-root css-z06a9i']/p)[last()]");
    By caseyHubsOption = By.xpath("//p[text()='Casey Hubs']");

    public CaseyChatsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad() {
        waitForClickable(searchBoxField);
    }

    public void enterQuery(String query) {
        click(searchBoxField);
        type(searchBoxField, query);
    }

    public void clickGenerateQuery() {
        click(sendQueryButton);
    }

    public int getTimeStampCount() {
        return driver.findElements(responseTimeStamp).size();
    }

    public void waitForResponseCompletion(int previousCount) {
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        longWait.until(ExpectedConditions.numberOfElementsToBe(responseTimeStamp, previousCount + 2));
    }

    public String getResponse() {
        return getText(response);
    }

    public void clickCaseyHubs() {
        click(caseyHubsOption);
    }
}