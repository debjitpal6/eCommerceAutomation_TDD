package com.openCart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//span[text()='My Account']")  //*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/a/span
	WebElement lnkMyaccount;
	
	@FindBy(linkText = "Register") ///html/body/nav/div/div[2]/ul/li[2]/div/ul/li[1]/a
	WebElement lnkRegister;
	
	@FindBy(linkText = "Login")
	WebElement lnkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
	WebElement txtSearchbox;
	
	@FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
	WebElement btnSearch;
	
	//Action methods
	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
	
	public void enterProductName(String pName)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pName);
	}
	
	public void clickSearch()  //For Search Product Test
	{
		btnSearch.click();
	}
	
}
