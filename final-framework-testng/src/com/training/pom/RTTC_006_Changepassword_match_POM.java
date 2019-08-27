package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_006_Changepassword_match_POM {
	private WebDriver driver;

	public RTTC_006_Changepassword_match_POM(WebDriver driver) 
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
    
    @FindBy(xpath="//*[@id=\"System_mY98YHaM\"]/form/fieldset/div[2]/div/div")
    private WebElement errormsg; 
    
    public void changemypasswordlink()
	{
		this.changepasswordlink.click();
	}
	public void sendchangepassword(String passwd)
	{
		this.inputpassword.clear();
		this.inputpassword.sendKeys(passwd);
	}
	

	public void sendconfirmpassword(String confirm) {
		this.confirmpassword.clear();
		this.confirmpassword.sendKeys(confirm);
		
	}
	public void clickcontinuebtn()
	{
		this.continuebtn.click();
	}
	
	
	public String errormsg_mismatching_password()
	{
		String msg;
		msg=this.errormsg.getText();
		return msg;
	}
	

	

}
