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

public class RTTC_068_addproductPOM 
{
	private WebDriver driver;
	
	public RTTC_068_addproductPOM(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@class='fa fa-tags fw']")
	private WebElement Catalogue;
	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[2]/a")
	private WebElement product;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement addbutton;
	
	@FindBy(id="input-name1")
	private WebElement productname;
	
	@FindBy(id="input-meta-title1")
	private WebElement metatitle;
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[2]/a")
	private WebElement data;
	
	@FindBy(id="input-model")
	private WebElement model;
	
	@FindBy(id="input-price")
	private WebElement price;
	
	@FindBy(xpath="//*[@id='form-product']/ul/li[3]/a")
	private WebElement links;
	
	@FindBy(xpath="input-category")
	private WebElement category;
	
	public void clickcategory()
	{
		Actions action=new Actions(driver);
		action.moveToElement(this.Catalogue).build().perform();
		this.product.click();
	}
	
	public void clickdatatab()
	{
		this.data.click();
		
	}
	
	public void clicklinktab()
	{
		this.links.click();
	}
	
	public void sendproductname(String value) {
		
		this.productname.sendKeys(value);
	}

	public void sendproductmodel(String value) {
		this.model.sendKeys(value);
	}


	public void sendmetatile(String value) {
		
		this.metatitle.sendKeys(value);
	}


	public void sendproductprice(String value) {
	 this.price.sendKeys(value);
		
	}


	public void sendproductcategory(String value) {
		
	Select cat=new Select(this.category);
	cat.selectByValue(value);
		
	}


	public void clickadd() {
		
		this.addbutton.click();
	}


	
	
	
	
	
		
	
	
	
	
}
