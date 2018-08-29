package com.amazon.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LandingPage;

public class LandingPageTest extends TestBase {
	
	LandingPage lp = new LandingPage();

	@BeforeMethod
	public void setUp() throws IOException
	{
		init();
	}
	
	@AfterMethod
	public void tearDown()
	{
		closeBrowsers();
	}
	
	@Test
	public void LandingPageTitleTest()
	{
		System.out.println(lp.getLandingPageTitle());
	}
	
	@Test
	public void testNavigationToLoginPage()
	{
		lp.clickSignInButton();
	}
	
	
	
	
}


