package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class SearchResultsPage extends TestBase {
	
	@FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
	WebElement searchBreadCrumb;
	
	@FindBy(xpath = "//select[@id='sort']")
	WebElement sortByDrpdwn;
	
	@FindBy(xpath = "//span[@id='quartsPagelet']")
	WebElement allRelevantText; 
		
	public SearchResultsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateSearchBreadCrumb()
	{
		return searchBreadCrumb.isDisplayed();
	}
	
	public void sortResults(String sortCriteria)
	{
		Select select = new Select(sortByDrpdwn);
		select.selectByValue(sortCriteria);
	}
	
	public boolean validateAllRelevantText()
	{
		return allRelevantText.isDisplayed();
	}

}
