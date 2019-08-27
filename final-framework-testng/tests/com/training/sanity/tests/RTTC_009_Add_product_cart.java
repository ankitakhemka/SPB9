package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.pom.RTTC_009_Add_Product_cartPOM;



public class RTTC_009_Add_product_cart extends LoginTests{
	
	private RTTC_009_Add_Product_cartPOM Cart;
	@Test
	  public void changepassowrd_match() 
	  {
		Cart=new RTTC_009_Add_Product_cartPOM(driver);
		  super.LoginTest();
		  Cart.homeclick();
		  Cart.clickcart();
		 
		  
		 
	  }
}
