package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_007changepasswordPOM {

private WebDriver driver; 
	
	public RTTC_007changepasswordPOM(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
	
	
	@FindBy(xpath="//*[contains(text(),'Change your password')]")
	private WebElement changepasswordlink;
	
	@FindBy(id="input-password")
	private WebElement inputpassword;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpassword;

    @FindBy(xpath="//input[@value='Continue']")
    private WebElement continuebtn;
    
    @FindBy(xpath="//*[@id=\"System_nyHsmShk\"]/div")
    private WebElement sucessmsg; 
    
    
   
	
	public void changemypasswordlink()
	{
		this.changepasswordlink.click();
	}
	public void sendchangepassword(String passwd)
	{
		this.inputpassword.clear();
		this.inputpassword.sendKeys(passwd);
	}
	
	public void sendconfirmpassword(String confirm)
	{
		this.confirmpassword.clear();
		this.confirmpassword.sendKeys(confirm);
	}
	
	public void clickcontinuebtn()
	{
		this.continuebtn.click();
	}
	
	public String successmsg()
	{
		String msg=this.sucessmsg.getText();
		return msg;
	}

}
