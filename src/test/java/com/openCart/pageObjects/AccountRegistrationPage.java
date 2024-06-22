package com.openCart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	
	@FindBy(name="firstname")
	WebElement txtFirstname;
	
	@FindBy(name="lastname")
	WebElement txtLastname;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtTelephone;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//*[@id=\"form-register\"]/div/div/div/input") //input[@name='agree']   //input[@type='checkbox']
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//action methods
	
	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy() {
		boolean isDisplayed = chkdPolicy.isDisplayed();

		// performing click operation if element is enabled
		if (isDisplayed== true) {
		System.out.println(isDisplayed);
		chkdPolicy.click();
		}
	}
	
	public void clickContinue() {
		btnContinue.click();    //sol1
	}
	
	/* Diff. ways to perform click on a button
	 
	 	//sol2
	 	 btnContinue.submit();
	 	 
	 	 //sol3
	 	 Actions act = new Actions(driver);
	 	 act.moveToElement(btnContinue).click().perform();    from MOUSE
	 	 
	 	  //sol4
	 	   JavascriptExecutor js= (JavascriptExecutor)driver;
	 	   js.executeScript("arguments[0].click();", btnContinue);
	 	   
	 	   //sol5
	 	   btnContinue.sendKeys(keys.RETURN);     from KEYBOARD
	 	   
	 	   //sol6
	 	   WebDriverWait mywait= new WebDriverWait(driver; Duration.ofSeconds(10));
	 	   mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	 	  
	 */	
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}catch(Exception e){
			return (e.getMessage());
		}
	}
	
}
