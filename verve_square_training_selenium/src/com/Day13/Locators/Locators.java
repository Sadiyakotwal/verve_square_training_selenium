package com.Day13.Locators;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators 
{
	//Global variable
	public WebDriver driver = null;
	public void initializeWebEnvironment() 
	{
		//Set system property
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/externalResource/chromedriver.exe");
		System.out.println("System Path: "+System.getProperty("user.dir")+"/externalResource/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		System.out.println("URL to be Tested: ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
		
		
	}
	
	
	
	public void printListOfMenuBar(String strMenu) 
	{
		By MenuList = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown']");
		List<WebElement> list = driver.findElements(MenuList);
		System.out.println("Drop Down: ");
		System.out.println("--------------------");
		for (WebElement webElement : list) 
		{
			System.out.println(webElement.getText());
			String strActualValue = webElement.getText();
			if(strActualValue.equals(strMenu))
			{
				webElement.click();	
				break;
			}
			
		}	
	}
	
	public void chooseParticularDropDown(String strDropDownName) 
	{
		By particularDropDown = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown open']/ul[@class='dropdown-menu']");
		List<WebElement> list1 = driver.findElements(particularDropDown);
		System.out.println("\nParticular Drop Down:");
		System.out.println("--------------------------------");
		for (WebElement webElement1 : list1) 
		{
			System.out.println(webElement1.getText());
			String strActualValue1 = webElement1.getText();
			if(strActualValue1.equals(strDropDownName))
			{
				webElement1.click();	
				break;
			}
		}
		
	}
	
	
	
	public void tearDown() 
	{
		//driver.close();
	}

}
