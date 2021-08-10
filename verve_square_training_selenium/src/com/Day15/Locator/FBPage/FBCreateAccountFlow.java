package com.Day15.Locator.FBPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBCreateAccountFlow 
{
	//public WebDriver driver;
	private FBAccountDetails objFBAccountDetails;
	private FBHomePage objFBHomePage;
	private HashtableUtilityFB objHashtableUtilityFB;
	String strTestData = "";

	public FBCreateAccountFlow() {

		objFBAccountDetails = new FBAccountDetails();
		objFBHomePage = new FBHomePage();
		objHashtableUtilityFB = new HashtableUtilityFB();

	}
	public void initializeWebEnvironmentFlow() 
	{
		objFBAccountDetails.initializeWebEnvironment();
		
	}
	
	/*public void verifyFacebookSignUpPage() 
	{
		if (driver.findElement(By.xpath("//div[text()='Create a new account']")).isDisplayed()) 
		{
			System.out.println("This is Sign in Page of Facebook.......");
			
		} 
		else 
		{
			System.out.println("This is Sign in Page of Facebook.......");
		}
		
	}*/
	
	
	public void doSignUp() {

		strTestData = objHashtableUtilityFB.createAccountTestData().get("FirstName")+objHashtableUtilityFB.getRandomFirstName(4);
		if (!strTestData.equals("")) {
			objFBAccountDetails.setFirstName(strTestData);

		}

		strTestData = objHashtableUtilityFB.createAccountTestData().get("LastName")+objHashtableUtilityFB.getRandomLirstName(4);
		if (!strTestData.equals("")) {
			objFBAccountDetails.setLastname(strTestData);
		}

		strTestData = objHashtableUtilityFB.createAccountTestData().get("EmailAddress")+objHashtableUtilityFB.getRandomEmail();
		if (!strTestData.equals("")) {
			objFBAccountDetails.setEmailAddres(strTestData);
		}

		strTestData = objHashtableUtilityFB.createAccountTestData().get("Password")+objHashtableUtilityFB.getRandomPassword(5);
		if (!strTestData.equals("")) {
			objFBAccountDetails.setPassword(strTestData);
		}

		strTestData = objHashtableUtilityFB.createAccountTestData().get("Date")+objHashtableUtilityFB.getRandomDate();
		if (!strTestData.equals("")) {
			objFBAccountDetails.setDate(strTestData);
		}
		
		strTestData = objHashtableUtilityFB.createAccountTestData().get("Month")+objHashtableUtilityFB.getRandomMonth();
		if (!strTestData.equals("")) {
			objFBAccountDetails.setMonth(strTestData);
		}
		
		strTestData = objHashtableUtilityFB.createAccountTestData().get("Month")+objHashtableUtilityFB.getRandomMonth();
		if (!strTestData.equals("")) {
			objFBAccountDetails.setYear(strTestData);
		}
		strTestData = objHashtableUtilityFB.createAccountTestData().get("Gender");
		if (!strTestData.equals("")) {
			objFBAccountDetails.setGender(strTestData);
		}

		objFBAccountDetails.clickOnSignUpButton(objHashtableUtilityFB.createAccountTestData().get("Sign-Up"));	}
	
	public void verifyHomePageIsVisible() 
	{
		String strExpectedData = objFBHomePage.getLogoutText();

		strTestData = objHashtableUtilityFB.createAccountTestData().get("Logout Text Visible");
		if (strExpectedData.equals(strTestData)) 
		{
			
			System.out.println("LogOut Button is visible");
			System.out.println("Test Passed");

		} else {
			System.out.println("LogOut Button is not visible");

			System.out.println("Test failed");
		}
	}

}
