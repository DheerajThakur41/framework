package co.kanban.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import junit.framework.Assert;

public class LoginPagePO 
{   
	
	@FindBy(id="login")
	private WebElement untxtbx;
	@FindBy(id="password")
	private WebElement pwdtxtbx;
	@FindBy(css="button[type='submit']")
	private WebElement loginbtn;
	@FindBy(xpath="//p[contains(text(),'Wrong login/password')]")
	private WebElement errormsg;

	public LoginPagePO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	public void verifyLogin(String username,String password)
	{
		untxtbx.sendKeys(username);
		pwdtxtbx.sendKeys(password);
		loginbtn.click(); 
	}
	public void verifyerrormsg()
	{
		String actmsg=errormsg.getText();
		String expmsg="Wrong login/password";
		Assert.assertEquals(expmsg, actmsg);
	}
}
