package com.amazon.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LandingPage;
import com.amazon.qa.pages.LoginPage;

public class LandingPageTest extends TestBase {
	
	LandingPage lp;
	LoginPage logPage;
	
	public LandingPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException
	{
		init();
		lp = new LandingPage();
	}
	
	@Test
	public void testLandingPageTitle()
	{
		String title = lp.getLandingPageTitle();
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	@Test
	public void testNavigationToLoginPage()
	{
		logPage = lp.clickSignInButton();
	}
	
	@AfterMethod
	public void tearDown()
	{
		closeBrowsers();
	}	
	
}


