package com.Day18.SimpleFormDemo.TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleFormPageTest extends BaseTest
{
	public SimpleFormPage objSimpleFormPage;
	
	public void initializePageObjectModel() 
	{
		objSimpleFormPage =new SimpleFormPage(this);
		
	}

	@BeforeTest
	public void initializeWebEnvironmentAndSetup()
	{
		this.initializePageObjectModel();
		initializeWebEnvironment();
		
	}
	
	@Test(priority=1)
	public void clickOnMunuBarOptionAndDropDownOption() 
	{
		objSimpleFormPage.selectMenuBarOptionAndDropDown(objConfigProperties.getProperty("strMenuBar"),objConfigProperties.getProperty("strDropDownValue"));
	}
	
	@Test(priority=2)
	public void verifyHomePageOfSimpleInputForm()
	{
		objSimpleFormPage.verifySimpleInputFormPage();
	}
	
	@Test(priority=3)
	public void singleInputFieldForm()
	{
		objSimpleFormPage.verifySingleInputFieldSection();
		objSimpleFormPage.setSingleInputFieldMessage(objConfigProperties.getProperty("strMessage"));
		objSimpleFormPage.clickShowMessageButton();
		objSimpleFormPage.verifyMessageEnteredInSingleInputField(objConfigProperties.getProperty("strMessage"));
	}
	
	@Test(priority=4)
	public void twoInputFieldForm()
	{
		objSimpleFormPage.verifyTwoInputFieldsSection();
		objSimpleFormPage.setFieldEnterValueAAndEnterValueB(objConfigProperties.getProperty("ValueA"),objConfigProperties.getProperty("ValueA1"));
		objSimpleFormPage.setFieldEnterValueAAndEnterValueB(objConfigProperties.getProperty("ValueB"), objConfigProperties.getProperty("ValueB1"));
		objSimpleFormPage.clickGetTotalButton();
		objSimpleFormPage.verifyGetTotal(objConfigProperties.getProperty("ValueA1"),objConfigProperties.getProperty("ValueB1"));
	}
	
	@AfterTest
	public void tearDownWebEnvironment()
	{
		tearDown();
	}
}
