package com.openCart.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openCart.pageObjects.HomePage;
import com.openCart.pageObjects.LoginPage;
import com.openCart.pageObjects.MyAccountPage;
import com.openCart.testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"Master","Sanity"})
	public void test_Login()
	{
		logger.info("Starting TC_002_LoginTest");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link");		
			hp.clickLogin();
			logger.info("Clicked on Login Link");	
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(rb.getString("email")); // valid email, get it from properties file
			logger.info("Entered email");
			lp.setPassword(rb.getString("password")); // valid password, get it from properties file
			logger.info("Entered password");
			lp.clickLogin();
			logger.info("Clicked on Login Button");	
			
			MyAccountPage macc=new MyAccountPage(driver);
			
			boolean targetpage=macc.isMyAccountPageExists();
						
			Assert.assertEquals(targetpage, true);
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info(" Finished TC_002_LoginTest");
		
	}
	
	
}


