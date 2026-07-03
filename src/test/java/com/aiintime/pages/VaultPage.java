package com.aiintime.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aiintime.base.BasePage;
import com.aiintime.utils.FileUtils;

public class VaultPage extends BasePage {

	By customizeTheViewOption = By.xpath("//div[@aria-label='Customize the view']");
    By shareToCaseyButton = By.xpath("//p[text()='Share to Casey']");
    By selectFilesOption = By.xpath("//span[text()=' Select Files']");
    By fileInput = By.xpath("//input[@type='file']");
    By uploadButton = By.xpath("//button[text()=' Upload']");
    By fileUploadedSuccessMessage = By.xpath("//div[@id='notistack-snackbar' and normalize-space()='Files uploaded successfully']");
    
    
    public VaultPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPageToLoad() {
        waitForVisibility(shareToCaseyButton);
    }

    public void clickShareToButton() {
        click(shareToCaseyButton);
    }

    public void clickSelectFilesOption() {
        click(selectFilesOption);
    }

    public void uploadFiles() {

        String files =
        		FileUtils.getFilePath("sql.txt") + "\n" +
                FileUtils.getFilePath("Captain america.pdf") + "\n" +
                FileUtils.getFilePath("Introduction to cloud computing.docx") + "\n" +
                FileUtils.getFilePath("Guardians_of_galaxy_holiday_special.mp3") + "\n" +
                FileUtils.getFilePath("Introduction to Cybersecurity Attacks.pptx") + "\n" +
                FileUtils.getFilePath("What You Know That AI Doesn’t  Priyanka Vergadia  TED.mp4") + "\n" +
                FileUtils.getFilePath("User_details.xls");

        driver.findElement(fileInput).sendKeys(files);
    }

    public void clickUpload() {
        click(uploadButton);
    }
    
    public void waitForFileUploadSuccessMessage() {
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofMinutes(5));

        longWait.until(
            ExpectedConditions.visibilityOfElementLocated(fileUploadedSuccessMessage)
        );
    }
}