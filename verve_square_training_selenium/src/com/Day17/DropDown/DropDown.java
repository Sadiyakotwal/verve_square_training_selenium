package com.Day17.DropDown;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown 
{
	//Global variable
		public WebDriver driver = null;
		public Properties objConfigFile;
		
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

		
		//Initialize Web Enviroment
		public void initializeWebEnvironment() 
		{
			this.loadConfigProperties();
			//Set system property
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/externalResource/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(objConfigFile.getProperty("AUT_URL9"));
			System.out.println("URL to be Tested: "+objConfigFile.getProperty("AUT_URL9"));
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
			driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
			driver.manage().window().maximize();	
			
		}
		
		//To select Menu bar element
		public void selectMenuBarElement(String strMenuBar) 
		{
			//Dynamic locator
			By MenuList = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"+strMenuBar+"')]");
			System.out.println("Menu Bar Selected : "+strMenuBar);
			driver.findElement(MenuList).click();	

			
		}
		
		//To select particular drop down from menu bar list
		public void selectParticularDropDownFromMenuBar(String strDropDownValue)
		{
			//Dynamic xpath
			By Drop_Down_Option = By.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='"+strDropDownValue+"']");
			System.out.println("Drop Down Selected : "+strDropDownValue);
			driver.findElement(Drop_Down_Option).click();	
		}
		

		//Directed to the page of drop down selected
		public void getPageOfParticularDropDown(String strMenu,String strDropDownValue) 
		{
			this.selectMenuBarElement(strMenu);
			this.selectParticularDropDownFromMenuBar(strDropDownValue);
			
		}
		
		//Verify wheteher Drop Down demo page is displayed or not
		public void verifyDropDownDemoPageIsDisplayedOrNOt() 
		{
			if (driver.findElement(By.xpath("//h3[text()='This would be your first example on select dropd down list to with Selenium.']")).isDisplayed()) 
			{
				System.out.println("Drop Down Demo Page is opened....");
			} 
			else 
			{
				System.out.println("Drop down Demo Page is not opened!!!!!!!!");

			}	
		}
		
		//Verify Select List Demo Section is displayed or not
		public void verifySelectListDemoSectionIsDisplayedOrNot() 
		{
			if (driver.findElement(By.xpath("//div[text()='Select List Demo']")).isDisplayed()) 
			{
				System.out.println("This is select list demo field section.....");
			} 
			else 
			{
				System.out.println("Wrong section!!!!!!!");

			}	
		}
	
		//Verfiy if single drop down is selected or not is selected or not
		public boolean verifySingleDropDownIsSectedOrNot() 
		{
	        boolean blnFlag = false;
	        blnFlag = driver.findElement(By.xpath("//select[@id='select-demo']")).isSelected();
	        return blnFlag;
	    }
		
		
		//Select single drop down
		public void selectSingleDropDown() 
		{
			if (verifySingleDropDownIsSectedOrNot() == true) 
			{
				System.out.println("Drop down is selected.....");
				
			} 
			else
			{
				System.out.println("Selecting drop down .........");
				Select selectListDemo = new Select(driver.findElement(By.xpath("//select[@id='select-demo']")));  
				selectListDemo.selectByVisibleText("Tuesday");
			}	
		}	
}
