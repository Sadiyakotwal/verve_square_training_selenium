package com.Day14.Repository;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium
{
		//Global variable
		public WebDriver driver = null;
		public Properties objConfigProperties;

		public void initializeWebEnvironment() 
		{
			this.loadConfigProperties();
			//Set system property
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/externalResource/chromedriver.exe");
			//System.out.println("System Path: "+System.getProperty("user.dir")+"/externalResource/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(objConfigProperties.getProperty("AUT_URL"));
			System.out.println("URL to be Tested: "+objConfigProperties.getProperty("AUT_URL"));
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
			driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
			driver.manage().window().maximize();	
			
		}
		
		public void loadConfigProperties() 
		{
			
			try 
			{
				objConfigProperties = new Properties();
				objConfigProperties.load(new FileInputStream(System.getProperty("user.dir")+"/src/configFile/objectRepository.properties"));
	
			} 
			catch (Exception exception) 
			{
				System.out.println("Exception Occured: "+exception.getMessage());
				
			}
		}
		
		/*public boolean unexpectedPopUpDisplay() 
		{
			boolean blnflag = false;
			try 
			{
				blnflag = driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).isDisplayed();
				return blnflag;
				
			} 
			catch (Exception exception) 
			{
				System.out.println("Exception Occured: "+exception.getMessage());
				return blnflag;
				
			}	
		}*/
		
		/*public void closePopUp() 
		{
			if(this.unexpectedPopUpDisplay())
			{
				 driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
			}
			
		}*/
		
		public void selectMenuBarElement(String strMenuBar) 
		{
			By MenuList = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"+strMenuBar+"')]");
			System.out.println("Menu Bar Selected : "+strMenuBar);
			driver.findElement(MenuList).click();	

			
		}
		
		public void selectParticularDropDown(String strDropDownValue)
		{
			//Dynamic xpath
			By Drop_Down_Option = By.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='"+strDropDownValue+"']");
			System.out.println("Drop Down Selected : "+strDropDownValue);
			driver.findElement(Drop_Down_Option).click();	
		}
		
		public void selectParticularDropDownOption(String strMenu,String strDropDownValue) 
		{
			this.selectMenuBarElement(strMenu);
			this.selectParticularDropDown(strDropDownValue);
			
		}
		
		public void verifyHomePageOfSimpleFormDemo() 
		{
			By Header = By.xpath("//h3[text()='This would be your first example to start with Selenium.']");
			String strHeader= driver.findElement(Header).getText();
			System.out.println("Header of Page is: "+strHeader);

		}
		
		public void formFillingDemo() 
		{
			driver.findElement(By.xpath(objConfigProperties.getProperty("Enter_Msg"))).sendKeys(objConfigProperties.getProperty("Message_Is"));
			driver.findElement(By.xpath(objConfigProperties.getProperty("Button_Show_Msg"))).click();
			driver.findElement(By.xpath(objConfigProperties.getProperty("Value_a"))).sendKeys(objConfigProperties.getProperty("Value_Is"));
			driver.findElement(By.xpath(objConfigProperties.getProperty("Value_b"))).sendKeys(objConfigProperties.getProperty("Value_Is2"));
			driver.findElement(By.xpath(objConfigProperties.getProperty("Button_get_total"))).click();

		}
		
		public void tearDown() 
		{
			//driver.close();
		}


		
	
}
