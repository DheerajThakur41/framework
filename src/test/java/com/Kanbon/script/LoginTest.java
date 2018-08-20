package com.Kanbon.script;

import org.testng.annotations.Test;
import com.kanbon.generic.BaseLib;
import com.kanbon.generic.ExcelUtilitiesLib;
import com.kanbon.generic.WaitStatementLib;

import co.kanban.pageobject.LoginPagePO;
import co.kanban.pageobject.OdooPagePO;

public class LoginTest extends BaseLib 
{   
	@Test(priority=1)
	public void verifyValidLogin() throws InterruptedException
	{   
		String filepath="./TestData/Template.xlsx";
		String username=ExcelUtilitiesLib.readData(filepath, "Sheet2", 1, 2);
		String password=ExcelUtilitiesLib.readData(filepath, "Sheet2", 1, 3);
		LoginPagePO lp=new LoginPagePO(driver);
		lp.verifyLogin(username, password);		
		WaitStatementLib wsl=new WaitStatementLib();
		wsl.isleep(5);
		OdooPagePO op=new OdooPagePO(driver);
		op.verifyHomeTitle(driver);
	}
	@Test(priority=2)
	public void verifyInvalidLogin()
	{
		String filepath="./TestData/Template.xlsx";
		String username=ExcelUtilitiesLib.readData(filepath, "Sheet2", 2, 2);
		String password=ExcelUtilitiesLib.readData(filepath, "Sheet2", 2, 3);
		LoginPagePO lp=new LoginPagePO(driver);
		lp.verifyLogin(username, password);	
		lp.verifyerrormsg();		
	}

}
