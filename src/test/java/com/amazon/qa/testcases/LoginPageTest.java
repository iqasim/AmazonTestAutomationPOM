package com.amazon.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
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
	Logger log = Logger.getLogger(LoginPageTest.class.getName());
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		log.info("Calling the init method from the Base Class.");
		init();
		log.info("Creating the LoginPage class instance.");
		lp = new LoginPage();
		log.info("Creating the LandingPage class instance.");
		landPage = new LandingPage();
		log.info("Calling navigateToLoginPage() method of LandingPage class.");
		landPage.navigateToLoginPage();
	}
	
	@Test
	public void testLoginPageTitle()
	{
		log.info("Retrieving the title of the login page.");
		String title = lp.getLoginPageTitle();
		log.info("Validating the Title at run time.");
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
