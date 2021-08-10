package com.Day18.SimpleFormDemo.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class SimpleFormPage 
{
	private BaseTest objBaseTest;
	public boolean blnFlag = false;
	public SimpleFormPage(BaseTest  baseTest) 
	{
		this.objBaseTest = baseTest;
	}
	
	public void selectMenuBarElement(String strMenuBar) 
	{
		By MenuList = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"+strMenuBar+"')]");
		System.out.println("Menu Bar Selected : "+strMenuBar);
		objBaseTest.getDriver().findElement(MenuList).click();	
		
	}
	
	public void selectParticularDropDown(String strDropDownValue)
	{
		//Dynamic xpath
		By Drop_Down_Option = By.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='"+strDropDownValue+"']");
		System.out.println("Drop Down Selected : "+strDropDownValue);
		objBaseTest.getDriver().findElement(Drop_Down_Option).click();	
	}
	
	public void selectMenuBarOptionAndDropDown(String strMenu,String strDropDownValue) 
	{
		this.selectMenuBarElement(strMenu);
		this.selectParticularDropDown(strDropDownValue);
		
	}
	
	public void verifySimpleInputFormPage() 
	{
		if (objBaseTest.getDriver().findElement(By.xpath("//h3[text()='This would be your first example to start with Selenium.']")).isDisplayed()) 
		{
			System.out.println("Simple Form Demo Page is opened....");
		} 
		else 
		{
			System.out.println("Simple Form Demo Page is not opened!!!!!!!!");

		}	
	}
	
	public void verifySingleInputFieldSection() 
	{
		if (objBaseTest.getDriver().findElement(By.xpath("//div[text()='Single Input Field']")).isDisplayed()) 
		{
			System.out.println("This is single input field section.....");
		} 
		else 
		{
			System.out.println("Wrong section!!!!!!!");

		}	
	}
	
	//To set a message
	public void setSingleInputFieldMessage(String strMessage) 
	{
		objBaseTest.getDriver().findElement(By.xpath("//input[@id='user-message']")).sendKeys(strMessage);
		
	}
	
	
	
	public void clickShowMessageButton() 
	{
		objBaseTest.getDriver().findElement(By.xpath("//button[text()='Show Message']")).click();
		
	}
	
	
	
	public void verifyMessageEnteredInSingleInputField(String strExpectedMessage) 
	{
		String strActualMessage = objBaseTest.getDriver().findElement(By.xpath("//div//label[text()='Your Message: ']/following-sibling::span[@id='display']")).getText();
		if (strExpectedMessage.equals(strActualMessage)) 
		{
			System.out.println("Entered message and actual shown message is same......");
		} 
		else 
		{
			System.out.println("Test failed : expected message != actual message!!!!!");

		}	
	}
	
	
	public void verifyTwoInputFieldsSection() 
	{
		//this.toScrollDownPage();
		if (objBaseTest.getDriver().findElement(By.xpath("//div[text()='Two Input Fields']")).isDisplayed()) 
		{
			System.out.println("This is Two input field section.....");
		} 
		else 
		{
			System.out.println("Wrong section!!!!!!!");

		}	
		
	}
	
	public void setFieldEnterValueAAndEnterValueB(String strLocator,String strLocValue) 
	{
		
		By locator = By.xpath("//label[text()='"+strLocator+"']/following-sibling::input");
		objBaseTest.getDriver().findElement(locator).sendKeys(strLocValue);
		
	}
	
	public void clickGetTotalButton() 
	{
		objBaseTest.getDriver().findElement(By.xpath("//button[text()='Get Total']")).click();
		
	}
	
	public String getTotal() 
	{
		String strTotal = objBaseTest.getDriver().findElement(By.xpath("//label[text()=' Total a + b = ']/following-sibling::span[@id='displayvalue']")).getText();
		return strTotal;
	}
	public void verifyGetTotal(String strValue1,String strValue2) 
	{
		int intTotal = Integer.parseInt(strValue1)+Integer.parseInt(strValue2);
		String strExpectedTotal = String.valueOf(intTotal);
		String strActualTotal = this.getTotal();
		if (strExpectedTotal.equals(strActualTotal)) 
		{
			System.out.println("Test passed : Actual total is equal to expected total........");
			
		} 
		else 
		{
			System.out.println("Test Failed :  Actual total is not equal to expected total!!!!!!! ");
		}
		
	}
	


}
