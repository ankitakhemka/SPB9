package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RTTC_006_Changepassword_match_POM;
import com.training.pom.RTTC_037_adminloginPOM;
import com.training.pom.RTTC_038_AddCategoryPOM;
import com.training.pom.RTTC_067_productpagePOM;
import com.training.pom.RTTC_069_producterrormsgPOM;
import com.training.pom.AdminloginPOM;
import com.training.pom.LoginPOM;
import com.training.pom.RTTC_0026_productpurchasePOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_069_producterrormsg 
{
	
	private RTTC_069_producterrormsgPOM  prod;
	private  Properties properties;
	public WebDriver driver;
	private AdminloginPOM  login;
	private String baseUrl;
	
  //  public  ScreenShot screenShot;
   // private static Properties properties;
    
    
	@Test(priority=0)
	public void login() 
	{
		
		login.sendUserName("admin");
		login.sendPassword("admin@123");
		login.clickLoginBtn();
		//screenShot = new ScreenShot(driver); 
		//login.takescreenshot();
								
	}
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		login = new AdminloginPOM(driver); 
		baseUrl = properties.getProperty("baseURLadmin");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

     
    @Test(priority=1,dataProvider="excel-inputs1",dataProviderClass = LoginDataProviders.class)
	public void productdetails(String productname, String metatitle, String model, String price, String category)
	{
    	prod = new RTTC_069_producterrormsgPOM (driver); 
    	prod.clickcategory();
    	prod.clickadd();
    	prod.sendproductname(productname);
    	prod.sendmetatile(metatitle);
    	prod.clickdatatab();
    	prod.sendproductmodel(model);
    	prod.sendproductprice(price);
    	prod.clicklinktab();
    	prod.sendproductcategory(category);
    	
    
		
						
	}

	
	
	

}
