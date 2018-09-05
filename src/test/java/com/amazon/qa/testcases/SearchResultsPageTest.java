package com.amazon.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LandingPage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.SearchResultsPage;



public class SearchResultsPageTest extends TestBase {
	
	LandingPage homepage;
	LoginPage loginpage;
	SearchResultsPage searchResultsPage;
	
	public SearchResultsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		init();
		homepage = new LandingPage();
		loginpage = new LoginPage();
		searchResultsPage = new SearchResultsPage();
		homepage.navigateToLoginPage();
		loginpage.login();
		homepage.enterSearchCriteria("Apple iPhone 6 (Gold, 32GB)");
		homepage.clickOnSearchButton();
	}
	
	@Test
	public void testSearchResultsBreadcrumb()
	{
		boolean isDisplayed = searchResultsPage.validateSearchBreadCrumb();
		Assert.assertTrue(isDisplayed);
	}
	
	@Test
	public void testSortResultsByLowToHighPrice()
	{
		searchResultsPage.sortResults("price-asc-rank");
		Assert.assertTrue(searchResultsPage.validateAllRelevantText());
	}
	
	@AfterMethod
	public void teardown()
	{
		closeBrowsers();
	}

}
