package com.amazon.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.amazon.qa.utilities.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver eventFiringListener;
	
	public static void init() throws IOException
	{
		prop = new Properties();
		fis = new FileInputStream(new File(System.getProperty("user.dir")+"//src//main//java//com//amazon//qa//config//config.properties"));
		prop.load(fis);
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//Creating object of EventFiringWebDriver 
		eventFiringListener = new EventFiringWebDriver(driver);
		//Creating object of WebEventListener TestUtil
		eventListener = new WebEventListener();
		//Register the WebEventListener TestUtil
		eventFiringListener.register(eventListener);
		//Assign event firing listener to driver
		driver = eventFiringListener;
			
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	public static void closeBrowsers()
	{
		driver.quit();
	}

}
