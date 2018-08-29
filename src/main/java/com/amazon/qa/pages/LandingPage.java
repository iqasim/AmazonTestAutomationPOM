package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.qa.base.TestBase;

public class LandingPage extends TestBase {
	
	@FindBy(xpath="//span[@class='nav-line-1' and contains(text(), 'Hello')]")
	WebElement SignInText;
	

}
