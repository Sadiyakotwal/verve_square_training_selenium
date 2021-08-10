package com.Day16.CheckBox;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ModifiedCheckBoxDemo 
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
			objConfigFile.load(new FileInputStream(System.getProperty("user.dir")+"/src/com/Day16/CheckBox/configFile/configFile.properties"));

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
		driver.get(objConfigFile.getProperty("AUT_URL"));
		System.out.println("URL to be Tested: "+objConfigFile.getProperty("AUT_URL"));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
		driver.manage().window().maximize();	
		
	}
	
	//To scroll page
	public void toScrollDownPage(String strYAxisValue) 
	{
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,"+strYAxisValue+")", "");
		
	}
	
	//To wait
	public void implicitlyWait() 
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;

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
	
	//Verify wheteher check box demo page is displayed or not
	public void verifyCheckBoxDemoPageIsDisplayedOrNOt() 
	{
		if (driver.findElement(By.xpath("//h3[text()='This would be a basic example to start with checkboxes using selenium.']")).isDisplayed()) 
		{
			System.out.println("Check Box Demo Page is opened....");
		} 
		else 
		{
			System.out.println("Check Box Demo Page is not opened!!!!!!!!");

		}	
	}
	
	//Verify Single demo Section is displayed or not
	public void verifySingleCheckBoxDemoSectionIsDisplayedOrNot() 
	{
		if (driver.findElement(By.xpath("//div[text()='Single Checkbox Demo']")).isDisplayed()) 
		{
			System.out.println("This is single checkbox demo field section.....");
		} 
		else 
		{
			System.out.println("Wrong section!!!!!!!");

		}	
	}
	
	//Verfiy if single check box is selected or not
	public boolean verifySingleCheckBoxIsSectedOrNot() 
	{
        boolean blnFlag = false;
        blnFlag = driver.findElement(By.xpath("//input[@id='isAgeSelected']")).isSelected();
        return blnFlag;
    }
	
	
	//Select single check box
	public void selectSingleCheckBox() 
	{
		if (verifySingleCheckBoxIsSectedOrNot() == true) 
		{
			System.out.println("Check Box is selected.....");
			
		} 
		else
		{
			System.out.println("Selecting check box.........");
			 driver.findElement(By.xpath("//input[@id='isAgeSelected']")).click();
		}	
	}
	
	
	//Verify Multiple Check Box Section Is displayed or not
	public void verifyMultipleCheckBoxDemoSectionIsDisplayedOrNot() 
	{
		this.toScrollDownPage("250");
		
		if (driver.findElement(By.xpath("//div[text()='Multiple Checkbox Demo']")).isDisplayed()) 
		{
			System.out.println("This is multiple checkbox demo field section.....");
		} 
		else 
		{
			System.out.println("Wrong section!!!!!!!");

		}	
	}
	
	
	public boolean verifyMultipleCheckbox(String strCheckBoxOption) 
	{
		 boolean blnFlag = false;
	     blnFlag = driver.findElement(By.xpath("//label[text()='"+strCheckBoxOption+"']")).isSelected();
	     return blnFlag;		
		
	}
	
	public void selectMultipleCheckBox(String strCheckBoxOption) 
	{
		if (verifyMultipleCheckbox(strCheckBoxOption) == true) 
		{
			System.out.println("Check Box Is Selected..........");
			
		} 
		else 
		{
			driver.findElement(By.xpath("//label[text()='"+strCheckBoxOption+"']")).click();

		}
		
	}


}
