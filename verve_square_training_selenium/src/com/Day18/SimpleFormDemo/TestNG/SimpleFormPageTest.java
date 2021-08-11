package com.Day18.SimpleFormDemo.TestNG;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleFormPageTest extends BaseTest
{
	public SimpleFormPage objSimpleFormPage;
	
	public void initializePageObjectModel() 
	{
		objSimpleFormPage =new SimpleFormPage(this);
		
	}

	@BeforeClass
	public void initializeWebEnvironmentAndSetup()
	{
		this.initializePageObjectModel();
		initializeWebEnvironment();
		
	}
	
	@Test(priority=1)
	public void verifySimpleFormDemoHomePage() 
	{
		objSimpleFormPage.managePopUP();
		objSimpleFormPage.selectMenuBarOptionAndDropDown(objConfigProperties.getProperty("strMenuBar"),objConfigProperties.getProperty("strDropDownValue"));
		objSimpleFormPage.verifySimpleInputFormPage(objConfigProperties.getProperty("strHeaderExpected"));

		
	}
	
	@Test(priority=3)
	public void singleInputFieldForm()
	{
		objSimpleFormPage.verifySingleInputFieldSection(objConfigProperties.getProperty("strSingleFieldHeader"));
		objSimpleFormPage.setSingleInputFieldMessage(objConfigProperties.getProperty("strMessage"));
		objSimpleFormPage.clickShowMessageButton();
		objSimpleFormPage.verifyMessageEnteredInSingleInputField(objConfigProperties.getProperty("strExpectedMessage"));
	}
	
	@Test(priority=4)
	public void twoInputFieldForm()
	{
		objSimpleFormPage.verifyTwoInputFieldsSection(objConfigProperties.getProperty("strTwoInputFieldHeader"));
		objSimpleFormPage.setFieldEnterValueAAndEnterValueB(objConfigProperties.getProperty("ValueA"),objConfigProperties.getProperty("ValueA1"));
		objSimpleFormPage.setFieldEnterValueAAndEnterValueB(objConfigProperties.getProperty("ValueB"), objConfigProperties.getProperty("ValueB1"));
		objSimpleFormPage.clickGetTotalButton();
		objSimpleFormPage.verifyGetTotal(objConfigProperties.getProperty("ValueA1"),objConfigProperties.getProperty("ValueB1"));
	}
	
	@AfterClass
	public void tearDownWebEnvironment()
	{
		tearDown();
	}
}
