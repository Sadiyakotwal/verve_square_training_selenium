package com.Day12.BasicsInstallation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailPage
{
	
	//Global variable
	public WebDriver driver = null;
	
	
	public void initializeWebEnvironment() 
	{
		//Set system property
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/externalResource/chromedriver.exe");
		System.out.println("System Path: "+System.getProperty("user.dir")+"/externalResource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
	}
	
	public void tearDown() 
	{
		driver.close();
	}
	

	

}
