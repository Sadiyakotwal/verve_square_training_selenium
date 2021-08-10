package Day15.Locators.SimpleformDemopage.Testing;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumSimpleFormPage
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
				objConfigProperties.load(new FileInputStream(System.getProperty("user.dir")+"/src/Day15/Locators/SimpleformDemopage/Testing/configfile/repository.properties"));
	
			} 
			catch (Exception exception) 
			{
				System.out.println("Exception Occured: "+exception.getMessage());
				
			}
		}
		
		
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
		
		public void selectMenuBarOptionAndDropDown(String strMenu,String strDropDownValue) 
		{
			this.selectMenuBarElement(strMenu);
			this.selectParticularDropDown(strDropDownValue);
			
		}
		
		public void verifySimpleInputFormPage() 
		{
			if (driver.findElement(By.xpath("//h3[text()='This would be your first example to start with Selenium.']")).isDisplayed()) 
			{
				System.out.println("Simple Form Demo Page is opened....");
			} 
			else 
			{
				System.out.println("Simple Form Demo Page is not opened!!!!!!!!");

			}	
		}
		
		public void verifySingleInputFieldSection() 
		{
			if (driver.findElement(By.xpath("//div[text()='Single Input Field']")).isDisplayed()) 
			{
				System.out.println("This is single input field section.....");
			} 
			else 
			{
				System.out.println("Wrong section!!!!!!!");

			}	
		}
		
		//To set a message
		public void setSingleInputFieldMessage(String strMessage) 
		{
			driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(strMessage);
			
		}
		
		
		
		public void clickShowMessageButton() 
		{
			driver.findElement(By.xpath("//button[text()='Show Message']")).click();
			
		}
		public void toScrollDownPage() 
		{
			 //to perform Scroll action using  Selenium
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,20)", "");
			
		}
		
		
		public void verifyMessageEnteredInSingleInputField(String strExpectedMessage) 
		{
			String strActualMessage = driver.findElement(By.xpath("//div//label[text()='Your Message: ']/following-sibling::span[@id='display']")).getText();
			if (strExpectedMessage.equals(strActualMessage)) 
			{
				System.out.println("Entered message and actual shown message is same......");
			} 
			else 
			{
				System.out.println("Test failed : expected message != actual message!!!!!");

			}	
		}
		
		
		public void verifyTwoInputFieldsSection() 
		{
			//this.toScrollDownPage();
			if (driver.findElement(By.xpath("//div[text()='Two Input Fields']")).isDisplayed()) 
			{
				System.out.println("This is Two input field section.....");
			} 
			else 
			{
				System.out.println("Wrong section!!!!!!!");

			}	
			
		}
		
		public void setFieldEnterValueAAndEnterValueB(String strLocator,String strLocValue) 
		{
			this.toScrollDownPage();
			By locator = By.xpath("//label[text()='"+strLocator+"']/following-sibling::input");
			driver.findElement(locator).sendKeys(strLocValue);
			
		}
		
		public void clickGetTotalButton() 
		{
			driver.findElement(By.xpath("//button[text()='Get Total']")).click();
			
		}
		
		public String getTotal() 
		{
			String strTotal = driver.findElement(By.xpath("//label[text()=' Total a + b = ']/following-sibling::span[@id='displayvalue']")).getText();
			return strTotal;
		}
		public void verifyGetTotal(String strValue1,String strValue2) 
		{
			int intTotal = Integer.parseInt(strValue1)+Integer.parseInt(strValue2);
			String strExpectedTotal = String.valueOf(intTotal);
			String strActualTotal = this.getTotal();
			if (strExpectedTotal.equals(strActualTotal)) 
			{
				System.out.println("Test passed : Actual total is equal to expected total........");
				
			} 
			else 
			{
				System.out.println("Test Failed :  Actual total is not equal to expected total!!!!!!! ");
			}
			
		}
		
		
		public void tearDown() 
		{
			//driver.close();
		}


		
	
}
