package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_007changepasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class RTTC_006_Password_change {
	
	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private RTTC_007changepasswordPOM changepassword;
	private static Properties properties;
	private ScreenShot screenShot;
	
	
  @Test
  public void changepassword() 
  {   
	 // LoginTests login=new LoginTests(driver);
	  changepassword.changemypasswordlink();
	  changepassword.sendchangepassword("Training@2019");
	  changepassword.sendconfirmpassword("Training@2019");
	  changepassword.clickcontinuebtn();
	  String Expected="Success: Your password has been successfully updated.";
	  String Actual=changepassword.successmsg();
	  System.out.println(Actual);
	  assertEquals(Expected,Actual);
	  
		//screenShot.captureScreenShot("First");
	  
  }
  @BeforeMethod
  public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		changepassword = new RTTC_007changepasswordPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

  @AfterMethod
  public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

  @BeforeClass
  public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

}
