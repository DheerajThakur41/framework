package co.kanban.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import junit.framework.Assert;

public class OdooPagePO 
{
	@FindBy(linkText="CRM")
	private WebElement crmlnk;

	public OdooPagePO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void verifyHomeTitle(WebDriver driver)
	{
		String actResult=driver.getTitle();
		String expResult="Odoo";
		Assert.assertEquals(expResult, actResult);
		Reporter.log(" Home Title is verified", true);		  
	}
	public void clickCrm()
	{
		crmlnk.click();
	}


}
