package com.Day16.ActionClass.TooltipMethod;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tooltip 
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
		driver.get(objConfigFile.getProperty("AUT_URL3"));
		System.out.println("URL to be Tested: "+objConfigFile.getProperty("AUT_URL3"));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
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
	
	
	public void verifySeleniumHomePagePageVisibleOrNOt() 
	{
		if (driver.findElement(By.xpath("//strong[text()='BLACK LIVES MATTER']")).isDisplayed()) 
		{
			System.out.println("Selenium official   page is opened......");
			
		} 
		else 
		{
			System.out.println("Wrong page is  opened!!!!");

		}
		
	}
	
	public void captureToolTips(String strExpectedValue) 
	{
		this.toScrollDownPage("100");
		this.implicitlyWait();
		objactions = new Actions(driver);
		WebElement textField = driver.findElement(By.xpath("//input[@id ='gsc-i-id1']")); 
		objactions.moveToElement(textField).build().perform();
		String tooltipTextActualValue = textField.getAttribute("title"); 
		if (tooltipTextActualValue.equalsIgnoreCase(strExpectedValue)) 
		{
			System.out.println("Text is : "+tooltipTextActualValue);
			
		} 
		else 
		{
			System.out.println("Wrong value!!!!!");

		}
		
	}
	
	
}
