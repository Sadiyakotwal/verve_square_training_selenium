package com.Day18.TEstNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations 
{
	@BeforeSuite
	public void taskToBePerformed() 
	{
		System.out.println("Before Suite:");
		System.out.println("Task to be performed: Want to login in the Amazon Website......\n");
	}
	
	
	
	@BeforeTest
	public void initializeWebEnvironment() 
	{
		System.out.println("Before Test: ");
		System.out.println("System Path:   /externalResource/chromedriver.exe...");
		System.out.println("Get URL : https://www.amazon.in/ap/signin \n");
	}
	

	@BeforeClass
	public void verifyAmazonLoginPageIsDisplayedOrNot() 
	{
		System.out.println("Before class:");
		System.out.println("Maximizing the window....\n");
		
	}
	
	@BeforeMethod
	public void maximizeWindow() 
	{
		System.out.println("Before method:");
		System.out.println("Login Page : 'amazon.in'\n");	
	}
	
	@Test
	public void signInToAmazonWithUsernameAndPassword() 
	{
		System.out.println("Test : 1");
		System.out.println("Enter email address :sadiyakotwal@gmail.com");
		System.out.println("Enter password :abcxyz_123\n");
	}
	
	@Test
	public void clickOnLogout() 
	{
		System.out.println("Test : 2");
		System.out.println("Logout Action are performed");
	}
	
	
	@AfterClass
	public void verifyAmazonHomePageIsDisplayedOrNot() 
	{
		System.out.println("After Class: ");
		System.out.println("Home Page : 'Logout Text is visble....'\n");
		
	}
	
	@AfterTest
	public void tearDown() 
	{
		System.out.println("After Test: ");
		System.out.println("Close the Website !!!!!\n");	
	}

	@AfterSuite
	public void taskFinished() 
	{
		System.out.println("After suite:");
		System.out.println("Task completed: Successfull logged in.........");	
		System.out.println("Test report genrated.........");
	}
	
	
}