 package com.openCart.testCases;


import org.testng.annotations.Test;

import com.openCart.pageObjects.AccountRegistrationPage;
import com.openCart.pageObjects.HomePage;
import com.openCart.testBase.BaseClass;

import org.testng.Assert;

public class TC_001_AccountRegistrationTest extends BaseClass{

	@Test(groups= {"Master","Regression"})
	void test_account_Registration()
	{
		logger.debug("Application logs..........."); // to get the client server communication,have to change to <root level= debug> in log4j2 file
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		
		try 
		{	
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link");
			Thread.sleep(2000);
			hp.clickRegister();
			logger.info("Clicked on Register Link");
			 
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			logger.info("Providing customer data");
			regpage.setFirstName("abc");  //we can call randomeString() here as well to pass the data dynamically 
			logger.info("Entered FirstName");
			regpage.setLastName("xyz");
			logger.info("Entered LastName");
			regpage.setEmail(randomeString()+"@gmail.com");
			logger.info("Entered Email");
		//	regpage.setTelephone(randomeNumber());
			Thread.sleep(2000);
			String password=randomeAlphaNumeric();
			regpage.setPassword(password);
			logger.info("Entered Password");
		//	regpage.setConfirmPassword(password);
			Thread.sleep(2000);
			
			regpage.setPrivacyPolicy();
			logger.info("Clicked on SetPrivacyPolicy checkbox");
			Thread.sleep(2000);
			regpage.clickContinue();
			logger.info("Clicked on Continue");
			
			String confmsg=regpage.getConfirmationMsg();
			logger.info("Validating expected message");
			Assert.assertEquals(confmsg, "Your Account Has Been Created!","Not getting expected message");
			
		}catch(Exception e) 
			{
				logger.error("test failed");
				Assert.fail();
			}
		
		logger.info("*** Finished TC_001_AccountRegistrationTest ***");
		
	}
	
}
