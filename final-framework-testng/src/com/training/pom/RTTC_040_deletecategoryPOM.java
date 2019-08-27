package com.training.pom;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class RTTC_040_deletecategoryPOM 
{
	private WebDriver driver;
	
	public RTTC_040_deletecategoryPOM(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@class='fa fa-tags fw']")
	private WebElement Catalogue;
	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[1]/a")
	private WebElement category;
	
	@FindBy(xpath="//*[@class='fa fa-trash-o']")
	private WebElement delete;
	
	@FindBy(xpath="//*[@class='alert alert-success']")
	private WebElement sucessmsg;
	
	
	public void clickcategory()
	{
		Actions action=new Actions(driver);
		action.moveToElement(this.Catalogue).build().perform();
		this.category.click();
	}
	
	public void deletecategoryfunc()
	{   
		 List<WebElement> oCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		 int iSize = oCheckBox.size();
		 System.out.println(iSize);
		 for(int i=0; i < iSize ; i++ )
		 {
		// String sValue = oCheckBox.get(i).getAttribute("value");
		// if (sValue.contentEquals("593")||sValue.contentEquals("576")||sValue.contentEquals("577"))
		if(i<=1)
			 {
		 oCheckBox.get(i).click();
		 System.out.println("done");
		 }
		 }
		 this.delete.click();
		 driver.switchTo().alert().accept();
	}
		 
	public String successmessage()
	{
		String value=this.sucessmsg.getText();
		return value;
	}
		 
	
	/*WebElement element=driver.findElement(By.xpath("//input[@value='red'"));
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);		
	
	List<WebElement> checklist=driver.findElement(By.xpath("//input[@type='checkbox']"));
	System.out.println(checklist.size());
	for(int i=0;i<checklist.size();i++)
	{
		if(checklist.get(i).getAttribute("value"))
		{
			checklist.get(i).click();
			break;
		}
	}*/
	
	
}
