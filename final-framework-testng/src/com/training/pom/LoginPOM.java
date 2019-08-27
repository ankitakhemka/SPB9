package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/div/header/div/div/div[3]/div[3]/nav/ul/li[2]/a/span/span/i")
	private WebElement account;
	
	@FindBy(partialLinkText="LOGIN")
	private WebElement login;
	
	@FindBy(id="input-email")
	private WebElement emailid;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement submitbutton;
	
	 public void sendUserName(String username)
		{
			this.emailid.clear();
			this.emailid.sendKeys(username);
		}
		
		public void sendPassword(String password)
		{
			this.password.clear();
			this.password.sendKeys(password);
		}
		
		
		public void gotologinpage()
		{
			Actions action=new Actions(driver);
			action.moveToElement(this.account).build().perform();
			this.login.click();
			
		}

		public void clickLoginBtn() 
		{
			this.submitbutton.click();
			
		}
}
