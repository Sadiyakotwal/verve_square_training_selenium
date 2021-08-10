package com.Day17.ActionClass.MouseHover;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction 
{
	 //Global variable
	public WebDriver driver = null;
	public Properties objConfigFile;
	public  Actions objActions ;
	
	//Load properties
	public void loadConfigProperties() 
	{
		try 
		{
			objConfigFile = new Properties();
			objConfigFile.load(new FileInputStream(System.getProperty("user.dir")+"/src/com/Day16/ActionClass/configFile/configFile.properties"));
		} 
		catch (Exception exception) 
		{
			System.out.println("Exception Occured: "+exception.getMessage());
		}
	}

	//Initialized web environment
	public void initializeWebEnvironment() 
	{
		this.loadConfigProperties();
		//Set system property
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/externalResource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(objConfigFile.getProperty("AUT_URL6"));
		System.out.println("URL to be Tested: "+objConfigFile.getProperty("AUT_URL6"));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();	
		
	}
	//To wait
	public void implicitlyWait() 
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	}
		
	public void mouseHoverActionOnMenuList() 
	{
		this.implicitlyWait();
		objActions = new Actions(driver);
		WebElement mainItem2Menu = driver.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"));
		//Move to element main menu list 2
    	objActions.moveToElement(mainItem2Menu).build().perform();
		WebElement subListMenu = driver.findElement(By.xpath("//a[contains(text(),'SUB SUB LIST ')]"));
		//Move to element sub list
    	objActions.moveToElement(subListMenu).build().perform();
    	WebElement subListMenu1 = driver.findElement(By.xpath("//a[contains(text(),'Sub Sub Item 1')]"));
		//Move to element sub list menu 1
    	objActions.moveToElement(subListMenu1).build().perform();
	}
	
	public void mouseHoverWithOffset() 
	{
		objActions = new Actions(driver);
		//Retrieve WebElemnt 'slider' to perform mouse hover 
    	WebElement slider = driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));
    	//Move mouse to x offset 50 in horizontal direction
    	objActions.moveToElement(slider,80,0).perform();
    	slider.click();
    
		
	}

}
