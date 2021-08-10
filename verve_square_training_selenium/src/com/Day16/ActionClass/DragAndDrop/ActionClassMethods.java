package com.Day16.ActionClass.DragAndDrop;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;



public class ActionClassMethods 
{
	 //Global variable
	public WebDriver driver = null;
	public Properties objConfigFile;
	public  Actions objActions ;
	
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

	public void initializeWebEnvironment() 
	{
		this.loadConfigProperties();
		//Set system property
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/externalResource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(objConfigFile.getProperty("AUT_URL"));
		System.out.println("URL to be Tested: "+objConfigFile.getProperty("AUT_URL"));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();	
		
	}
	
	public void verifyDroppablePageVisibleOrNOt() 
	{
		if (driver.findElement(By.xpath("//div[text()='Droppable']")).isDisplayed()) 
		{
			System.out.println("Droppable page is opened......");
			
		} 
		else 
		{
			System.out.println("Droppable page is not opened!!!!");

		}
		
	}
	
	public void dragDropActionPerfom() 
	{
		objActions = new Actions(driver);
		WebElement Drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement Drop = driver.findElement(By.id("droppable"));
		objActions.dragAndDrop(Drag, Drop).build().perform();	
		
	}

	public void verifyDragOperationPerformedOrNot() 
	{
		if (driver.findElement(By.xpath("//p[text()='Dropped!']")).isDisplayed())
		{
			System.out.println("Element Dropped to target.....");
			
		} 
		else 
		{
			System.out.println("Element is not dropped!!!!");


		}
		
	}

}
