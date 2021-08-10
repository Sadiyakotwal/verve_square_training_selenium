package com.Day15.Locator.FBPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBAccountDetails 
{
	public WebDriver driver=null;
	public void initializeWebEnvironment() 
	{
		//Set system property
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/externalResource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/r.php");
		System.out.println("URL to be Tested: "+driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();	
		
	}

	public void setFirstName(String strFirstName)
	{
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(strFirstName);
		System.out.println("Set First Name : "+strFirstName);
	}
	public void setLastname(String strLastName)
	{
		driver.findElement(By.xpath("//input[@id='u_0_l_iE']")).sendKeys(strLastName);
		System.out.println("Set Last Name : "+strLastName);
	}
	public void setEmailAddres(String strEmail)
	{
		driver.findElement(By.xpath("//input[@id='u_0_o_HH']")).sendKeys(strEmail);
		System.out.println("Enter Email  : "+strEmail+"_@gmail.com");
	}
	public void setPassword(String strPassowrd)
	{
		System.out.println("Enter Password  :" +strPassowrd);
	}
	public void setDate(String strDate)
	{
		System.out.println("Set Date  : "+strDate);
	}
	public void setMonth(String strMonth)
	{
		System.out.println("Set Month  : "+strMonth);
	}
	public void setYear(String strYear)
	{
		System.out.println("Set Year  : "+strYear);
	}
	public void setGender(String strGender)
	{
		System.out.println("Set Year  : "+strGender);
	}
	public void clickOnSignUpButton(String strSignUp)
	{
		System.out.println("Button : "+strSignUp);
	}
	
}
