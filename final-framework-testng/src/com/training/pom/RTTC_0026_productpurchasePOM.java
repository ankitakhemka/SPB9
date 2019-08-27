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
import org.openqa.selenium.support.ui.Select;

public class RTTC_0026_productpurchasePOM 
{
	private WebDriver driver;

	public RTTC_0026_productpurchasePOM(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

			
	@FindBy(id="input-username")
	private WebElement username;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement submitbutton;
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/a/i")
	private WebElement reportlink;
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[2]/a")
	private WebElement productlink;
	
	@FindBy(xpath="//*[@id=\"button-menu\"]/i")
	private WebElement dashboardicon;
	
	@FindBy(xpath="//*[@id=\"menu-report\"]/ul/li[2]/ul/li[2]/a")
	private WebElement purchaselink;
	
	@FindBy(xpath="//*[@id=\"input-status\"]")
	private WebElement statuslistbox;
	
	@FindBy(xpath="//*[@id=\"button-filter\"]/i")
	private WebElement Filterbutton;
	
	//@FindBy(xpath="//*[text()='Lorem ipsum dolor sit amet'][1]")
	//private Webelement 
	
	
	//Login 
	
	 public void sendUserName(String username)
		{
			
			this.username.sendKeys(username);
		}
		
		public void sendPassword(String password)
		{
			
			this.password.sendKeys(password);
		}
		
		
		public void clickLoginBtn() 
		{
			this.submitbutton.click();
			
		}
		
		public void clickproductfrommenu()
		{
			
			Actions action=new Actions(driver);
			action.moveToElement(this.reportlink).build().perform();
			this.productlink.click();
			this.purchaselink.click();
			Select listbox = new Select(this.statuslistbox);
			listbox.selectByVisibleText("Complete");
			this.Filterbutton.click();
			
			
		}
	public void takescreenshot() throws IOException
	{
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(scrFile, new File("C:/screenshots/removefromcart/"+System.currentTimeMillis()+".png"));
	}
		
}
