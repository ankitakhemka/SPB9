package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_006_Changepassword_match_POM;
import com.training.pom.RTTC_037_adminloginPOM;
import com.training.pom.RTTC_038_AddCategoryPOM;
import com.training.pom.RTTC_039_EditcategoryPOM;
import com.training.pom.RTTC_040_deletecategoryPOM;
import com.training.pom.LoginPOM;
import com.training.pom.RTTC_0026_productpurchasePOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_040_deletecategory extends Adminlogin
{
	
	private RTTC_040_deletecategoryPOM deletecategory;
	private static Properties properties;
     
    @Test(priority=1)
	public void deletecategoryfunc()
	{
    	deletecategory = new RTTC_040_deletecategoryPOM(driver); 
		deletecategory.clickcategory();
		deletecategory.deletecategoryfunc();
		String Actual=deletecategory.successmessage();
		String Expected="Success: You have modified categories!\n" + "×";
		Assert.assertEquals(Actual, Expected);
		
					
	}

	
	
	

}