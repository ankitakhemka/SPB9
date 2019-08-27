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
import com.training.pom.RTTC_039_EditcategoryPOM;
import com.training.pom.LoginPOM;
import com.training.pom.RTTC_0026_productpurchasePOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_039_Editcategory extends Adminlogin
{
	
	private RTTC_039_EditcategoryPOM editcategory;
	private static Properties properties;
     
    @Test(priority=1)
	public void addcategoryfunc()
	{
    	editcategory = new RTTC_039_EditcategoryPOM(driver); 
		editcategory.clickcategory();
		String name="shoes";
		String descriptionvalue="indian";
		String metatagvalue="abc";
		String metadescrip="def";
		editcategory.newcategory(name,descriptionvalue,metatagvalue,metadescrip);
		editcategory.clicksave();
		editcategory.clickedit();
		editcategory.editmetatag("heels");
		editcategory.saveedit();
		String Actual=editcategory.successmessage();
		String Expected="Success: You have modified categories!\n" + "×";
		Assert.assertEquals(Actual, Expected);
					
	}

	
	
	

}