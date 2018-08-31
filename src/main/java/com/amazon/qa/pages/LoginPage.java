package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//input[@id='ap_email']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueButton;
	
	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement password;	

	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement loginButton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterUserName()
	{
		username.clear();
		username.sendKeys(prop.getProperty("username"));
	}
	
	public void clickContinueButton()
	{
		continueButton.click();
	}
	
	public void enterPassword()
	{
		password.clear();
		password.sendKeys(prop.getProperty("password"));
	}
	
	
	public LandingPage clickLoginButton()
	{
		loginButton.click();
		return new LandingPage();
	}
	
	public LandingPage login()
	{
		username.clear();
		username.sendKeys(prop.getProperty("username"));
		continueButton.click();
		password.clear();
		password.sendKeys(prop.getProperty("password"));
		loginButton.click();
		return new LandingPage();
	}
	

}
