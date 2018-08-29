package com.amazon.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.amazon.qa.base.TestBase;

public class LandingPage extends TestBase {
	
	@FindBy(xpath="//a[@class='nav-a nav-a-2' and @data-nav-role='signin']")
	WebElement SignInText;
	
	@FindBy(xpath="//span[@class='nav-action-inner' and contains(text(), 'Sign')]")
	WebElement SignInButton;
	
	
	public String getLandingPageTitle()
	{
		return driver.getTitle();
	}
	
	public LoginPage clickSignInText()
	{
		SignInText.click();
		return new LoginPage();
	}
	
	public LoginPage clickSignInButton()
	{
		/*Actions action = new Actions(driver);
		action.moveToElement(SignInButton).click().build().perform();*/
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", SignInButton);
		
		return new LoginPage();
	}
	
}
