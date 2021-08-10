package com.Day16.RadioButton;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonDemo 
{
		 //Global variable
		public WebDriver driver = null;
		public Properties objConfigFile;
		
		public void loadConfigProperties() 
		{
			
			try 
			{
				objConfigFile = new Properties();
				objConfigFile.load(new FileInputStream(System.getProperty("user.dir")+"/src/com/Day16/RadioButton/configFile/configFile.properties"));
	
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
			driver.findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
			driver.manage().window().maximize();	
			
		}
		
		public void toScrollDownPage(String strYAxisValue) 
		{
			 
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,"+strYAxisValue+")", "");
			
		}
		
		
		public void selectMenuBarElement(String strMenuBar) 
		{
			By MenuList = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"+strMenuBar+"')]");
			System.out.println("Menu Bar Selected : "+strMenuBar);
			driver.findElement(MenuList).click();	
		}
		
		public void selectParticularDropDownFromMenuBar(String strDropDownValue)
		{
			//Dynamic xpath
			By Drop_Down_Option = By.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='"+strDropDownValue+"']");
			System.out.println("Drop Down Selected : "+strDropDownValue);
			driver.findElement(Drop_Down_Option).click();	
		}
		
		public void getPageOfParticularDropDown(String strMenu,String strDropDownValue) 
		{
			this.selectMenuBarElement(strMenu);
			this.selectParticularDropDownFromMenuBar(strDropDownValue);
			
		}
		public void verifyRadioButtonDemoPageIsDisplayedOrNot() 
		{
			if (driver.findElement(By.xpath("//h3[text()='This is again simple example to start working with radio buttons using Selenium.']")).isDisplayed()) 
			{
				System.out.println("Radio Button Demo Page is opened....");
			} 
			else 
			{
				System.out.println("Radio Button Demo Page is not opened!!!!!!!!");

			}	
		}
		
		
		public void verifyRadioButtonDemoSectionIsDisplayedOrNot(String strSectionHeader) 
		{
			By getSectionHeader = By.xpath("//div//div[text()='"+strSectionHeader+"']");
			String strHeader = driver.findElement(getSectionHeader).getText();
			if (strHeader.equals(strSectionHeader)) 
			{
				System.out.println("This is "+strSectionHeader+" section");
			} 
			else 
			{
				System.out.println("Wrong section!!!!!");

			}
			
		}
		
		public boolean verifyRadioButtonIsSelectedOrNot(String strGender) 
		{
			boolean blnFlag = false;
	        blnFlag = driver.findElement(By.xpath("//label[text()='"+strGender+"']/input[@name='optradio']")).isSelected();
	        return blnFlag;
			
		}
		
		public void selectRadioButton(String strGender) 
		{
			if (verifyRadioButtonIsSelectedOrNot(strGender) == true) 
			{
				System.out.println("Radio Button is selected.....");
				
			} 
			else
			{
				System.out.println("Selecting radio button.........");
				 driver.findElement(By.xpath("//label[text()='"+strGender+"']/input[@name='optradio']")).click();
			}	
		}
		
		
		public void clickGetCheckedValueBUtton() 
		{
			driver.findElement(By.xpath("//button[text()='Get Checked value']")).click();
		}
		
		public void VerifyTextAfterButtonClicked(String strExpectedValue) 
		{
			By locator =  By.xpath("//p[@class='radiobutton']");
			String strAcualValue = driver.findElement(locator).getText();
			if (strAcualValue.equals(strExpectedValue)) 
			{
				System.out.println("Test Passed.... : "+strAcualValue);
			} 
			else 
			{
				System.out.println("Test Failed!!!!");

			}
		}
		
		
		public void verifyGroupRadioButtonSectionIsDisplayedOrNot(String strSectionHeader) 
		{
			By getSectionHeader = By.xpath("//div//div[text()='"+strSectionHeader+"']");
			String strHeader = driver.findElement(getSectionHeader).getText();
			if (strHeader.equals(strSectionHeader)) 
			{
				System.out.println("This is "+strSectionHeader+" section");
			} 
			else 
			{
				System.out.println("Wrong section!!!!!");

			}
			
		}
		
		public boolean verifyGroupRadioButtonGenderIsSelectedOrNot(String strGender) 
		{
			boolean blnFlag = false;
	        blnFlag = driver.findElement(By.xpath("//label[text()='"+strGender+"']/input[@name='gender']")).isSelected();
	        return blnFlag;
			
		}
		
		public void selectGroupRadioButtonGender(String strGender) 
		{
			if (verifyGroupRadioButtonGenderIsSelectedOrNot(strGender) == true) 
			{
				System.out.println("Radio Button is selected.....");
				
			} 
			else
			{
				System.out.println("Selecting radio button.........");
				 driver.findElement(By.xpath("//label[text()='"+strGender+"']/input[@name='gender']")).click();
			}	
		}
		
		public boolean verifyGroupRadioButtonAgeGroupIsSelectedOrNot(String strAgeGroup) 
		{
			boolean blnFlag = false;
	        blnFlag = driver.findElement(By.xpath("//label[text()='"+strAgeGroup+"']")).isSelected();
	        return blnFlag;
			
		}
		
		public void selectGroupRadioButtonAgeGroup(String strAgeGroup) 
		{
			if (verifyGroupRadioButtonAgeGroupIsSelectedOrNot(strAgeGroup) == true) 
			{
				System.out.println("Radio Button is selected.....");
				
			} 
			else
			{
				System.out.println("Selecting radio button.........");
				 driver.findElement(By.xpath("//label[text()='"+strAgeGroup+"']")).click();
			}	
		}
		
		public void clickOnGetValuesButton() 
		{
			driver.findElement(By.xpath("//button[text()='Get values']")).click();
			
		}
		
		
		public void verifyTheTextAfterClickingGetValuesButton() 
		{
			this.toScrollDownPage("250");
			By locator =  By.xpath("//p[@class='groupradiobutton']");
			boolean strAcualValue = driver.findElement(locator).isDisplayed();
			if (strAcualValue == true) 
			{
				System.out.println("Test Passed.... : "+strAcualValue);
				String strActualValue = driver.findElement(locator).getText();
				System.out.println("Actual Text is:\n"+strActualValue);

			} 
			else 
			{
				System.out.println("Test Failed!!!!");

			}
			
			
		}

}
