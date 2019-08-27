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
import com.training.pom.RTTC_010_Remove_from_Cart_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_036_returnorder
{
	private WebDriver driver;
	private RTTC_010_Remove_from_Cart_POM  product;
	private String baseUrl;
	private static Properties properties;
//	private ScreenShot screenShot;
	
	@Test(priority=0)
	public void login()
	{
		product.gotologinpage();
		product.sendUserName("khemka.ankita@gmail.com");
		product.sendPassword("Training@2019");
		product.clickLoginBtn();
				
	}
	@Test(priority=1)
	public void add_cart()
	{
		product.homeclick();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500)");
		product.addtocart();
		product.clickcart();
		
	}
	@Test(priority=2)
	  public void remove_cart_Test() 
	  {
		product.removeitem();
		String Expected="Your shopping cart is empty!";
		String Actual=product.emptyCart_message();
		assertEquals(Expected,Actual);
	 
	 }
	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		product = new RTTC_010_Remove_from_Cart_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
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
  