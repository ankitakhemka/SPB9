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

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_006_Changepassword_match_POM;
import com.training.pom.RTTC_037_adminloginPOM;
import com.training.pom.RTTC_038_AddCategoryPOM;
import com.training.pom.LoginPOM;
import com.training.pom.RTTC_0026_productpurchasePOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_038_AddCategory extends Adminlogin
{
	
	private RTTC_038_AddCategoryPOM category;
	private static Properties properties;
     
    @Test(priority=1)
	public void addcategoryfunc()
	{
    	category = new RTTC_038_AddCategoryPOM(driver); 
		category.clickcategory();
		String name="shoes";
		String descriptionvalue="indian";
		String metatagvalue="abc";
		String metadescrip="def";
		category.newcategory(name,descriptionvalue,metatagvalue,metadescrip);
		category.clicksave();
		String Expected="Success: You have modified categories!\n" + "×";
		String actual=category.sucessmsg();
		assertEquals(Expected, actual);
						
	}

	
	
	

}
