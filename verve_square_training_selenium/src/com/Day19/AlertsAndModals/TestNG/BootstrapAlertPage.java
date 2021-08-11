package com.Day19.AlertsAndModals.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BootstrapAlertPage 
{
	public BaseTest objBaseTest;
	public boolean blnFlag = false;
	public BootstrapAlertPage(BaseTest BaseTest) 
	{
		this.objBaseTest = BaseTest;
	}
	
	//Close popup
	public void closePopup() throws InterruptedException 
	{
	        Thread.sleep(5000);
	        objBaseTest.getDriver().findElement(By.xpath("//a[@id='at-cv-lightbox-close']")).click();
	  }
	
	
	//To scroll
		public void toScrollDownPage(String strYAxisValue) 
		{
			 
			 JavascriptExecutor js = (JavascriptExecutor) objBaseTest.getDriver();
			 js.executeScript("window.scrollBy(0,"+strYAxisValue+")", "");
			
		}
	
	//Select menubar option
	public void selectMenuBarElement(String strMenuBar) 
	{
		By MenuList = By.xpath("//div[@id='navbar-brand-centered']//li[@class='dropdown']/a[@data-toggle='dropdown'][contains(.,'"+strMenuBar+"')]");
		System.out.println("Menu Bar Selected : "+strMenuBar);
		objBaseTest.getDriver().findElement(MenuList).click();	
		
	}
	
	//Select drop down option
	public void selectParticularDropDown(String strDropDownValue)
	{
		//Dynamic xpath
		By Drop_Down_Option = By.xpath("//div[@id='navbar-brand-centered']//ul/li/a[text()='"+strDropDownValue+"']");
		System.out.println("Drop Down Selected : "+strDropDownValue);
		objBaseTest.getDriver().findElement(Drop_Down_Option).click();	
	}
	
	//Select menubar and drop down option
	public void selectMenuBarOptionAndDropDown(String strMenu,String strDropDownValue) 
	{
		this.selectMenuBarElement(strMenu);
		this.selectParticularDropDown(strDropDownValue);
		
	}
	
	//Verify the home page of bootstrap Alert message
	public void verifyBootStrapAlertMessagesPageIsDisplayedOrNot(String strHeaderExpected) 
	{
		By bootStrapAlertPageHeader = By.xpath("//h2[text()='Bootstrap Alert messages']");
		String strActualHeader = objBaseTest.getDriver().findElement(bootStrapAlertPageHeader).getText();
		Assert.assertTrue(strActualHeader.equals(strHeaderExpected));
		System.out.println("This is BootStrap Alert page....\n");
	}
	
	//Select particular button
	public void selectBootstrapAlertButtonOption(String strButtonsOption ) 
	{
		//Dynamic xpath for All Buttons of bootstrap alert message
		By BootstrapAlertButtonOptions = By.xpath("//button[@id='"+strButtonsOption+"']");
		String strButtonName = objBaseTest.getDriver().findElement(BootstrapAlertButtonOptions).getText();
		System.out.println("Bootstrap Button Selected is :"+strButtonName);
		System.out.println("------------------------------------------------------");
		objBaseTest.getDriver().findElement(BootstrapAlertButtonOptions).click();
	}

	//Select autocloseable success message button
	public void clickOnAutocloseableMessageButton(String strAutocloseableButton) 
	{
		this.selectBootstrapAlertButtonOption(strAutocloseableButton);	
	}
	
	//Get the text message of autocloseable success messsage button
	public String getAutocloseableMsg() 
	{
		return objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-success alert-autocloseable-success']")).getText();
		
	}
	
	//verify the autocloseable message
	public void verifyAutocloseableSuccessMsgIsDisplayedOrNot(String strExpAutocloseableSuccessMsg) 
	{
		String strActualMessage = this.getAutocloseableMsg();
		System.out.println("Actual Message :"+strActualMessage);
		System.out.println("Expected Message :"+strExpAutocloseableSuccessMsg);
		Assert.assertTrue(strExpAutocloseableSuccessMsg.equals(strActualMessage));
		System.out.println("Test Passed....\n");
	}
	
	//Click on normal success button
	public void clickOnNormalSuccessMessageButton(String strNormalSuccessButton) 
	{
		this.selectBootstrapAlertButtonOption(strNormalSuccessButton);	
	}
	
	//Get normal succes message
	public String getNormalSuccessMsg() 
	{
		return objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-success alert-normal-success']")).getText();
	}
	
	//Verify normal success message
	public void verifyNormalSuccessMessageIsDisplayedOrNot(String strExpNormalSuccessMsg) 
	{
		String strActualMessage = this.getNormalSuccessMsg();
		String strActualText = strActualMessage.replace("×"," ").trim();
		System.out.println("Actual Message :"+strActualText);
		System.out.println("Expected Message :"+strExpNormalSuccessMsg);
		Assert.assertTrue(strExpNormalSuccessMsg.trim().equals(strActualText));
		System.out.println("Test Passed....\n");
	}
	
	//Click on autocloseable warning message button
	public void clickOnAutocloseableWarningMessageButton(String strAutocloseableWarningButton) 
	{
		this.selectBootstrapAlertButtonOption(strAutocloseableWarningButton);	
	}
		
	//Get autocloseable warning message
	public String getAutocloseableWarningMsg() 
	{
		return objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-warning alert-autocloseable-warning']")).getText();
	}
		
	//Verify normal success message
	public void verifyAutocloseableWarningMessageIsDisplayedOrNot(String strExpAutocloseableWarningMsg) 
	{
		String strActualMessage = this.getAutocloseableWarningMsg();
		System.out.println("Actual Message :"+strActualMessage);
		System.out.println("Expected Message :"+strExpAutocloseableWarningMsg);
		Assert.assertTrue(strExpAutocloseableWarningMsg.equals(strActualMessage));
		System.out.println("Test Passed....\n");
	}
	
	//Click on normal warning message button
	public void clickOnNormalWarningMessageButton(String strNormalWarningButton) 
	{
		this.selectBootstrapAlertButtonOption(strNormalWarningButton);	
	}
	
	//Get normal warning message
	public String getNormalWarningMsg() 
	{
		return objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-warning alert-normal-warning']")).getText();
	}
	
	//Verify normal warning message
	public void verifyNormalWarningMessageIsDisplayedOrNot(String strExpNormalWarningMsg) 
	{
			String strActualMessage = this.getNormalWarningMsg();
			String strActualText = strActualMessage.replace("×"," ").trim();
			System.out.println("Actual Message :"+strActualText);
			System.out.println("Expected Message :"+strExpNormalWarningMsg);
			Assert.assertTrue(strExpNormalWarningMsg.trim().equals(strActualText));
			System.out.println("Test Passed....\n");
	}
	
	//Select autocloseable danger  message button
	public void clickOnAutocloseableDangerMessageButton(String strAutocloseableDangerButton) 
	{
		this.selectBootstrapAlertButtonOption(strAutocloseableDangerButton);	
	}
	
	//Get the text message of autocloseable danger messsage button
	public String getAutocloseabledangerMsg() 
	{
		return objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-danger alert-autocloseable-danger']")).getText();	
	}
		
	//verify the autocloseable danger message
	public void verifyAutocloseableDangerMsgIsDisplayedOrNot(String strExpAutocloseableDangerMsg) 
	{
		String strActualMessage = this.getAutocloseableMsg();
		System.out.println("Actual Message :"+strActualMessage);
		System.out.println("Expected Message :"+strExpAutocloseableDangerMsg);
		Assert.assertTrue(strExpAutocloseableDangerMsg.equals(strActualMessage));
		System.out.println("Test Passed....\n");
	}
	
	//Click on normal danger message button
	public void clickOnNormalDangerMessageButton(String strNormalDangerButton) 
	{
		this.selectBootstrapAlertButtonOption(strNormalDangerButton);	
	}
	
	//Get normal danger message
	public String getNormalDangerMsg() 
	{
		return objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-danger alert-normal-danger']")).getText();
	}
	
	//Verify normal warning message
	public void verifyNormalDangerMessageIsDisplayedOrNot(String strExpNormalDangerMsg) 
	{
				String strActualMessage = this.getNormalDangerMsg();
				String strActualText = strActualMessage.replace("×"," ").trim();
				System.out.println("Actual Message :"+strActualText);
				System.out.println("Expected Message :"+strExpNormalDangerMsg);
				Assert.assertTrue(strExpNormalDangerMsg.trim().equals(strActualText));
				System.out.println("Test Passed....\n");
	}
	
	//Select autocloseable info message button
	public void clickOnAutocloseableInfoMessageButton(String strAutocloseableInfoButton) 
	{
		this.selectBootstrapAlertButtonOption(strAutocloseableInfoButton);	
	}
	
	//Get the text message of autocloseable info messsage button
	public String getAutocloseableInfoMsg() 
	{
		return objBaseTest.getDriver().findElement(By.xpath("//div[@class='alert alert-info alert-autocloseable-info']")).getText();
			
	}
	
	//verify the autocloseable  info message
	public void verifyAutocloseableInfoMsgIsDisplayedOrNot(String strExpAutocloseableInfoMsg) 
		{
			String strActualMessage = this.getAutocloseableInfoMsg();
			System.out.println("Actual Message :"+strActualMessage);
			System.out.println("Expected Message :"+strExpAutocloseableInfoMsg);
			Assert.assertTrue(strExpAutocloseableInfoMsg.equals(strActualMessage));
			System.out.println("Test Passed....\n");
		}
}
