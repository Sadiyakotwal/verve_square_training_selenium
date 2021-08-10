package com.Day17.AllLinksOnPage;

import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AllLinks 
{
	
		//Global variable
		public WebDriver driver = null;
		public Properties objConfigFile;
		public  Actions objActions ;
		public WebElement WebElement;
		public HttpURLConnection httpConnection;
		
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
			driver.get(objConfigFile.getProperty("AUT_URL11"));
			System.out.println("URL to be Tested: "+objConfigFile.getProperty("AUT_URL11"));
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
			driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
			driver.manage().window().maximize();	
			
		}
		
		
		public void getAllLinks() 
		{
		      List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		      System.out.println("Total links on the  Page : " + allLinks.size());
		      System.out.println("Links Available are :");
		      System.out.println("-------------------------");
		      for(int i=0; i<allLinks.size(); i++) 
		      {
		    	  WebElement = allLinks.get(i);
		    	  String urlLink=WebElement.getAttribute("href");		    	 
		    	  verifyAllLink(urlLink); 
		    } 
		}
		
		public void verifyAllLink(String urlLink) 
		{
	        try 
	        {
				httpConnection =(HttpURLConnection)new URL(urlLink).openConnection();
				httpConnection.connect();
				if(httpConnection.getResponseCode()>=400) 
				{	
					System.out.println("Broken Link : "+urlLink);
				}
				else
				{
					System.out.println("Link :\n "+urlLink);
				}
			}
	        catch (Exception Exception) 
	        {
	        	System.out.println("Exception occured!!!!");
			}

	      }
}
