package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_006_Changepassword_match_POM;
import com.training.pom.LoginPOM;
import com.training.pom.RTTC_0026_productpurchasePOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_026_Productpurchasedetail
{
	private WebDriver driver;
	private RTTC_0026_productpurchasePOM  product;
	private String baseUrl;
	
    public  ScreenShot screenShot;
    private static Properties properties;
    
    
	
	@Test(priority=0)
	public void login() throws IOException
	{
		
		product.sendUserName("admin");
		product.sendPassword("admin@123");
		product.clickLoginBtn();
		screenShot = new ScreenShot(driver); 
		product.takescreenshot();
						
	}
	@Test(priority=1)
	public void selectproductfrom_report()
	{
		product.clickproductfrommenu();
		
	}
	
	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		product = new RTTC_0026_productpurchasePOM(driver); 
		baseUrl = properties.getProperty("baseURLadmin");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
 