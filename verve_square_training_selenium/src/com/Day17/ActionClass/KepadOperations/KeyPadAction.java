package com.Day17.ActionClass.KepadOperations;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyPadAction 
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
			driver.get(objConfigFile.getProperty("AUT_URL4"));
			System.out.println("URL to be Tested: "+objConfigFile.getProperty("AUT_URL4"));
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
			driver.manage().window().maximize();	
			
		}
		
		public String verifyIfAllTextFieldIsEmptyOrNot(String strTextFieldType) 
		{
	        WebElement textPresentOrNot = driver.findElement(By.xpath("//input[@type='"+strTextFieldType+"']"));
	        String strActualText = textPresentOrNot.getAttribute("value");
	        return strActualText;
		}
		
		public void verifyTextFields(String strTextFieldType) 
		{
			if (verifyIfAllTextFieldIsEmptyOrNot(strTextFieldType).isEmpty()) 
			{
				System.out.println("Text field "+strTextFieldType+" is empty....");
			} 
			else 
			{
				System.out.println("Text field "+strTextFieldType+" is not empty!!!!!");

			}
		}
		
		public void sendKeysAction() 
		{
			driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("ABC_");
			driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("xyz_jsdh_@gmail.com");
			driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("Solapur");
		}
		
		public void copyPasteAction() 
		{
			//field is selected
			objActions = new Actions(driver);
			objActions.keyDown(Keys.CONTROL).sendKeys("a");
	        objActions.keyUp(Keys.CONTROL).build().perform();
	        
	        //field is copied
	        objActions.keyDown(Keys.CONTROL).sendKeys("c");
	        objActions.keyUp(Keys.CONTROL).build().perform();
	        
	        //Go to permanent address field
	        objActions.sendKeys(Keys.TAB);
	        objActions.build().perform();
	        
	        //Paste the current address in permanent field
	        objActions.keyDown(Keys.CONTROL).sendKeys("v");
	        objActions.keyUp(Keys.CONTROL).build().perform();   
	       
		}
		
		public void sendAllCapitalLetters() 
		{
			objActions = new Actions(driver);
			WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
			fullName.clear();
			Action capitalLetters = objActions.keyDown(fullName, Keys.SHIFT).sendKeys(fullName, "i am sadiya").keyUp(fullName, Keys.SHIFT).build();
		   //In capital letters
		   capitalLetters.perform();
			
		}

}
