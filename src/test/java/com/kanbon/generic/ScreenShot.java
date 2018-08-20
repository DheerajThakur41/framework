package com.kanbon.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenShot
{
	public void takeScreenShot(WebDriver driver,String scriptname)
	{
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+scriptname+".png");
		try 
		{
			
		FileUtils.copyFile(src,dest);
		}
		catch (IOException e) 
		{

			e.printStackTrace();
		}
	}
}
