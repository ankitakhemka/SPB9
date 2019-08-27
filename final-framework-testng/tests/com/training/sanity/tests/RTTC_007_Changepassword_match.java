package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTC_006_Changepassword_match_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class RTTC_007_Changepassword_match extends LoginTests{
	
	private static Properties properties;
	private RTTC_006_Changepassword_match_POM match;
	
	
  @Test(priority=1)
  public void changepassowrd_match() 
  {
	  match=new RTTC_006_Changepassword_match_POM(driver);
	  match.changemypasswordlink();
	  match.sendchangepassword("Training@2019");
	  match.sendconfirmpassword("Learning@2019");
	  match.clickcontinuebtn();
	  String Expected="Password confirmation does not match password!";
	  String Actual=match.errormsg_mismatching_password();
	  System.out.println(Actual);
	  if(Actual.equals(Expected))
	  {
		  System.out.println("got proper error message");
	  }
	  else
	  {
		  System.out.println("Testcase failure");
	  }
	 
  }
 
}
