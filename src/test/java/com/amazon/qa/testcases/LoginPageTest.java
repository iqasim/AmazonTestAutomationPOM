package com.amazon.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LandingPage;
import com.amazon.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage lp;
	LandingPage landPage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		init();
		lp = new LoginPage();
		landPage = new LandingPage();
		landPage.navigateToLoginPage();
	}
	
	@Test
	public void testLoginPageTitle()
	{
		String title = lp.getLoginPageTitle();
		Assert.assertEquals(title, "Amazon Sign In");
	}
	
	@Test
	public void testLogin()
	{
		lp.enterUserName();
		lp.clickContinueButton();
		lp.enterPassword();
		lp.clickLoginButton();
		Assert.assertEquals(landPage.getLandingPageTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		closeBrowsers();
	}

}
