package com.amazon.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LandingPage extends TestBase {
	

	
	@FindBy(xpath = "//span[@class='nav-icon nav-arrow']//parent::span[contains(text(), 'Your')]")
	WebElement navArrow;
	
	@FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//child::span[@class='nav-action-inner']")
	WebElement SignInButton;
	
	public LandingPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String getLandingPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickNavArrow()
	{
		navArrow.click();
	}
	
	public LoginPage clickSignInButton()
	{
		Actions action = new Actions(driver);
		action.moveToElement(navArrow).click().perform();
		return new LoginPage();
	}
	
}
