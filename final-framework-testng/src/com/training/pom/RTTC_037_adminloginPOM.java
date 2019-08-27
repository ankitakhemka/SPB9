package com.training.pom;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RTTC_037_adminloginPOM 
{
	private WebDriver driver;
	
	public RTTC_037_adminloginPOM(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-username")
	WebElement usernme;
	
	@FindBy(id="input-password")
	WebElement passwrd;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	WebElement submit;
	
	@FindBy(xpath="//*[@class='alert alert-danger']")
	WebElement errormessage;
	
	public void takescreenshot() throws IOException
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:/screenshots/RTTC_037/"+System.currentTimeMillis()+".png"));
		
	}

	public void sendUserName(String username)
	{
		this.usernme.sendKeys(username);
		
	}

	public void sendPassword(String password)
	{
		this.passwrd.sendKeys(password);
		
	}

	public void clickLoginBtn() 
	{
		this.submit.click();
		
	}
	
	public String errormessagetext()
	{
		String actual=this.errormessage.getText();
		return actual; 
	}

	
}
