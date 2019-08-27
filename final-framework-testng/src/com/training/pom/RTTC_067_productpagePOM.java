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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RTTC_067_productpagePOM 
{
	private WebDriver driver;
	
	public RTTC_067_productpagePOM(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@class='fa fa-tags fw']")
	private WebElement Catalogue;
	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[2]/a")
	private WebElement product;
	
	@FindBy(id="input-name")
	private WebElement Productname;
	
	@FindBy(id="input-price")
	private WebElement Productprice;
	
	@FindBy(id="input-status")
	private WebElement Productstatus;
	
	@FindBy(id="input-model")
	private WebElement Productmodel;
	
	@FindBy(id="input-quantity")
	private WebElement Productquantity;
	
	@FindBy(id="input-image")
	private WebElement Productimage;
	
	@FindBy(id="button-filter")
	private WebElement filter;
	
	public void clickcategory()
	{
		Actions action=new Actions(driver);
		action.moveToElement(this.Catalogue).build().perform();
		this.product.click();
	}
	
	
	public void sendproductname(String value)
	{
		this.Productname.sendKeys(value);
	}
	
	public void sendproductprice(String value)
	{
		this.Productprice.sendKeys(value);
	}
	
	public void sendproductstatus(String value)
	{
		
		Select listbox = new Select(this.Productstatus);
		listbox.selectByVisibleText(value);
	}
	
	public void sendproductmodel(String value)
	{
		this.Productmodel.sendKeys(value);
	}
	
	public void sendproductquantity(String value)
	{
		this.Productquantity.sendKeys(value);
	}
	
	public void sendproductimage(String value)
	{
		Select listbox = new Select(this.Productimage);
		listbox.selectByVisibleText(value);
	}
	
	public void clickfilter()
	{
		this.filter.click();
	}
	
	
	
	
	
		
	
	
	
	
}
