package com.Day16.ActionClass.Clicks;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickMethods 
{
	//Global variable
		public WebDriver driver = null;
		public Properties objConfigFile;
		public Actions objactions;
		
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
			driver.get(objConfigFile.getProperty("AUT_URL1"));
			System.out.println("URL to be Tested: "+objConfigFile.getProperty("AUT_URL1"));
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
			driver.manage().window().maximize();	
			
		}
		
		
		public void verifyButtonsClickPageVisibleOrNOt() 
		{
			if (driver.findElement(By.xpath("//div[text()='Buttons']")).isDisplayed()) 
			{
				System.out.println("Click methods page is opened......");
				
			} 
			else 
			{
				System.out.println("Wrong page is not opened!!!!");

			}
			
		}
		
		//Double click
		public void doubleClick() 
		{
			objactions = new Actions(driver);
			WebElement btnDoubleClick = driver.findElement(By.xpath("//button[text()='Double Click Me']")); 
			objactions.doubleClick(btnDoubleClick).perform(); 
		}
		
		public void verifyDoubleClick(String strExpectedValueDoubleClick) 
		{
			String strActualValueDoubleclick = driver.findElement(By.xpath("//p[text()='You have done a double click']")).getText();
			if (strActualValueDoubleclick.equals(strExpectedValueDoubleClick)) 
			{
				System.out.println("Double option is clicked........");
			} 
			else 
			{
				System.out.println("Wrong option clicked!!!!");

			}

		}
		//Right click
		public void rightClick() 
		{
			objactions = new Actions(driver);
			WebElement btnRightClick = driver.findElement(By.xpath("//button[text()='Right Click Me']")); 
			objactions.contextClick(btnRightClick).perform();
		}
		
		public void verifyRightClick(String strExpectedValueRightClick) 
		{
			String strActualValueRightClick = driver.findElement(By.xpath("//p[text()='You have done a right click']")).getText();
			if (strActualValueRightClick.equals(strExpectedValueRightClick)) 
			{
				System.out.println("Right Click option is clicked........");
				
			} 
			else 
			{
				System.out.println("Wrong option clicked!!!!");

			}
			
			
		}


}
