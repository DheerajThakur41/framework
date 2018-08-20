package co.kanban.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PipeLineOdooPagePO 
{
	
	
//	textBx (//input[contains(@id,'o_field_input')])[2]
//	//label[text()='Customer']/../..//input[contains(@id,'o_field_input')]
//	//label[text()='Customer']/../following-sibling::td//input[contains(@id,'o_field_input')]
	@FindBy(xpath="//button[contains(text(),'Create')]")
	private WebElement createbtn;
	@FindBy(name="name")
	private WebElement opporTitle;
	public PipeLineOdooPagePO(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickCreatebtn()
	{
		createbtn.click();
	}
	public void createOpport(String oprtitile,String customer,String exprev)
	{
		opporTitle.sendKeys(oprtitile);
	}

}
