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

public class RTTC_038_AddCategoryPOM 
{
	private WebDriver driver;
	
	public RTTC_038_AddCategoryPOM(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@class='fa fa-tags fw']")
	private WebElement Catalogue;
	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[1]/a")
	private WebElement category;
	
	@FindBy(xpath="//*[@class='btn btn-primary']")
	private WebElement addbutton;
	
	@FindBy(id="input-name1")
	private WebElement categoryname;
	
	@FindBy(xpath="//*[@class='note-editable panel-body']")
	private WebElement description;
	
	@FindBy(id="input-meta-title1")
	private WebElement metatag;
	
	@FindBy(id="input-meta-description1")
	private WebElement Metadescription;
	
	@FindBy(xpath="//*[@href='#tab-data']")
	private WebElement datatab;
	
	@FindBy(xpath="//*[@class='fa fa-save']")
	private WebElement savebutton;
	
	@FindBy(xpath="//*[@class='alert alert-success']")
	private WebElement sucessmessage;
	
		
	public void clickcategory()
	{
		Actions action=new Actions(driver);
		action.moveToElement(this.Catalogue).build().perform();
		this.category.click();
	}
	
	public void newcategory(String name,String descriptionvalue,String metatagvalue,String metadescrip) 
	{
		this.addbutton.click();
		this.categoryname.sendKeys(name);
		this.description.sendKeys(descriptionvalue);
		this.metatag.sendKeys(metatagvalue);
		this.Metadescription.sendKeys(metadescrip);
		this.datatab.click();
		
	}
	
	public void clicksave()
	{
		this.savebutton.click();
	}

	public String sucessmsg() {
		String msg=this.sucessmessage.getText();
		return msg;
	}
	
	
	
	
	
	
	
}
