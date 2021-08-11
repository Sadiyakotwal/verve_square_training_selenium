package com.Day18.SimpleFormDemo.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class SimpleFormPage 
{
	private BaseTest objBaseTest;
	public boolean blnFlag = false;
	public SimpleFormPage(BaseTest  baseTest) 
	{
		this.objBaseTest = baseTest;
	}
	
	public void managePopUP() 
	{
		objBaseTest.getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		objBaseTest.getDriver().findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
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
	
	public void verifySimpleInputFormPage(String strHeaderExpected) 
	{
		By simpleInputFormPageHeader = By.xpath("//h3[text()='This would be your first example to start with Selenium.']");
		String strActualHeader = objBaseTest.getDriver().findElement(simpleInputFormPageHeader).getText();
		Assert.assertTrue(strActualHeader.equals(strHeaderExpected));
		System.out.println("This is simple Input form page....");
	}
	
	public void verifySingleInputFieldSection(String strSingleFieldHeader) 
	{
		By singleInputFieldHeader = By.xpath("//div[text()='Single Input Field']");
		String strActualText = objBaseTest.getDriver().findElement(singleInputFieldHeader).getText();
		Assert.assertTrue(strActualText.equals(strSingleFieldHeader));
		System.out.println("This is single input field section.....");

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
		By singleInputFieldText = By.xpath("//div//label[text()='Your Message: ']/following-sibling::span[@id='display']");
		String strActualText = objBaseTest.getDriver().findElement(singleInputFieldText).getText();
		Assert.assertTrue(strActualText.equals(strExpectedMessage));
		System.out.println("Entered message and actual shown message is same......");

	}
	
	
	public void verifyTwoInputFieldsSection(String strTwoInputFieldHeader) 
	{
		By twoInputFieldHeader = By.xpath("//div[text()='Two Input Fields']");
		String strActualText = objBaseTest.getDriver().findElement(twoInputFieldHeader).getText();
		Assert.assertTrue(strActualText.equals(strTwoInputFieldHeader));
		System.out.println("This is Two input field section.....");
		
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
		Assert.assertTrue(strActualTotal.equals(strExpectedTotal));
		System.out.println("Test passed : Actual total is equal to expected total........");
	}
	


}
