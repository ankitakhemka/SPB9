package com.training.pom;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.training.sanity.tests.LoginTests;

public class RTTC_009_Add_Product_cartPOM {
	
	private WebDriver driver;

	public RTTC_009_Add_Product_cartPOM(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath="//*[@id=\"menu_url_R28IP\"]/a/span")
	private WebElement home;
	
	@FindBy(xpath="//*[@id=\"BestsellerProducts_Yllc2v2l\"]/div/div[1]/div/div/div[10]/div/div/div[2]/div[1]/a/span/span/img")
	private WebElement imagelink;
	
	@FindBy(id="button-cart")
	private WebElement addtocart;
	
	@FindBy(xpath="//*[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement cartimage;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li/div/div/div[3]/a[1]")
	private WebElement viewcart;
	
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
		this.addtocart.click();
	}
	
   public void clickcart()
   {
	   Actions action=new Actions(driver);
	   action.moveToElement(this.cartimage).build().perform();
	   this.viewcart.click();
	   
   }

}
