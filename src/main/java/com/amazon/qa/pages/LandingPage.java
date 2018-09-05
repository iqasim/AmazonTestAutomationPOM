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
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchTextbox;
	
	@FindBy(xpath = "//input[@class='nav-input' and @value='Go']")
	WebElement searchButton;
	
	
	
	
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
	
	public LoginPage navigateToLoginPage()
	{
		Actions action = new Actions(driver);
		action.moveToElement(navArrow).click().perform();
		return new LoginPage();
	}
	
	public void enterSearchCriteria(String searchCriteria)
	{
		searchTextbox.clear();
		searchTextbox.sendKeys(searchCriteria);
	}
	
	public SearchResultsPage clickOnSearchButton()
	{
		searchButton.click();
		return new SearchResultsPage();
	}
	
}
