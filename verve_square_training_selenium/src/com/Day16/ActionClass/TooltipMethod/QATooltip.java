package com.Day16.ActionClass.TooltipMethod;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class QATooltip 
{
	//Global variable
		public WebDriver driver = null;
		public Properties objConfigFile;
		public Actions objactions ;
		
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
			driver.get(objConfigFile.getProperty("AUT_URL10"));
			System.out.println("URL to be Tested: "+objConfigFile.getProperty("AUT_URL10"));
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
			driver.manage().window().maximize();	
			
		}
		
		public void captureToolTips(String strExpectedValue) 
		{
			
			objactions = new Actions(driver);
			WebElement textField = driver.findElement(By.xpath("//button[@id='toolTipButton']")); 
			objactions.moveToElement(textField).build().perform();
			String tooltipTextActualValue = textField.getAttribute("innerHTML"); 
			System.out.println(tooltipTextActualValue);
		}
}
