package com.kanbon.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseLib 
{   
	public WebDriver driver;
	@BeforeMethod
	@Parameters({"Browser","Url"})
	public void setUp(String browser,String url)
	{   
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver","./exefiles/InternetExplorerDriver");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	@AfterMethod
	public void teardown(ITestResult result)
	{
		String scriptname=result.getMethod().getMethodName();
		if(result.isSuccess())
		{
			Reporter.log(scriptname+": is Sucessfully Passed", true);
		}
		else
		{
			ScreenShot sc=new ScreenShot();
			sc.takeScreenShot(driver, scriptname);

		}
		driver.close();
	}
}
