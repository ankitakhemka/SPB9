package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RTTC_010_Remove_from_Cart_POM 
{
	private WebDriver driver;

	public RTTC_010_Remove_from_Cart_POM(WebDriver driver) 
	{
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
	@FindBy(xpath="//*[@id=\"menu_url_R28IP\"]/a/span")
	private WebElement home;
	
	@FindBy(xpath="//*[@id=\"BestsellerProducts_Yllc2v2l\"]/div/div[1]/div/div/div[10]/div/div/div[2]/div[1]/a/span/span/img")
	private WebElement imagelink;
	
	@FindBy(id="button-cart")
	private WebElement addtocartbutton;
	
	@FindBy(xpath="//*[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement cartimage;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li/div/div/div[3]/a[1]")
	private WebElement viewcart;
	
	@FindBy(xpath="//*[@class='fa fa-times-circle']")
	private WebElement removelink;
	
	@FindBy(xpath="//*[@class='fa fa-refresh']")
	private WebElement refresh;
	
	@FindBy(xpath="//*[@id=\"System_V2Exp1o9\"]/div[1]/p")
	private WebElement emptycart_message;
	
	@FindBy(xpath="//*[@id=\"BestsellerProducts_Yllc2v2l\"]/div/div[1]/div/div/div[10]/div/div/div[3]/div/div/div[1]/h4/a")
	private WebElement imageclick;
	
	//Login 
	
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
	
		//Add cart
	
	public void clickimage()
	{
		this.imagelink.click();
				
	}
	
	public void homeclick()
	{
		this.home.click();
	}
	
	public void addtocart()
	{
		Actions action=new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"BestsellerProducts_Yllc2v2l\\\"]/div/div[1]/div/div/div[10]/div/div/div[2]/div[1]/a/span/span/img")));
		action.moveToElement(this.imagelink).click().build().perform();
		//this.imageclick.click();
		this.addtocartbutton.click();
	}
	
   public void clickcart()
   {
	   Actions action=new Actions(driver);
	   action.moveToElement(this.cartimage).build().perform();
	   this.viewcart.click();
	   
   }
   
   public void removeitem()
   {
	   this.removelink.click();
	   this.refresh.click();
   }
   
   public String emptyCart_message()
   {
	   String Actual=this.emptycart_message.getText();
	   return Actual;
	   
   }


}
