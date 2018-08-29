package com.amazon.qa.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LandingPage;

public class LandingPageTest extends TestBase {

	@BeforeMethod
	public void setUp() throws IOException
	{
		init();
	}
	
	
	@Test
	public void testNavigationToLoginPage()
	{
		LandingPage lp = new LandingPage();
		lp.clickSignInText();
		//lp.clickSignInButton();
		
	}
	
}
