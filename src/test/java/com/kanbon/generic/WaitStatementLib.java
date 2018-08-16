package com.kanbon.generic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib
{
	public void isleep(int sec)
	{
		try
		{
			Thread.sleep(1000*sec);
		} 
		catch (InterruptedException e)
		{

			e.printStackTrace();
		}
	}
	public  void iwaitForsec(WebDriver driver, int sec, WebElement ele)
	{
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	} 
	public void ewaitForvisible(WebDriver driver, int sec, WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.visibilityOf(ele));
	} 
	public void eWaitforrefresh(WebDriver driver, int sec, WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));

	}
}
