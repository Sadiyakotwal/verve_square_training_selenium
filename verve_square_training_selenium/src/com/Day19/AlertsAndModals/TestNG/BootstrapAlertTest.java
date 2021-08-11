package com.Day19.AlertsAndModals.TestNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BootstrapAlertTest extends BaseTest
{
	public BootstrapAlertPage objBootstrapAlertPage;
	
	public void initializePageObjectModel() 
	{
		objBootstrapAlertPage = new BootstrapAlertPage(this);
		
	}

	@BeforeClass
	public void initializeWebEnvironmentAndSetup()
	{
		this.initializePageObjectModel();
		initializeWebEnvironment();
		
	}
	@Test(priority=1)
	public void TC_ID_01_verifyBootstrapAlertHomePage() throws InterruptedException 
	{
		objBootstrapAlertPage.closePopup();
		objBootstrapAlertPage.selectMenuBarOptionAndDropDown(objConfigProperties.getProperty("strMenuBar"),objConfigProperties.getProperty("strDropDownValue"));
		objBootstrapAlertPage.verifyBootStrapAlertMessagesPageIsDisplayedOrNot(objConfigProperties.getProperty("strHeaderExpected"));
	}
	
	@Test(priority=2)
	public void TC_ID_02_verifyAutocloseableableSuccessMessage() 
	{
		objBootstrapAlertPage.clickOnAutocloseableMessageButton(objConfigProperties.getProperty("strAutocloseableButton"));
		objBootstrapAlertPage.verifyAutocloseableSuccessMsgIsDisplayedOrNot(objConfigProperties.getProperty("strExpAutocloseableSuccessMsg"));
	}
	
	@Test(priority=3)
	public void TC_ID_03_verifyNormalSuccessMessage() 
	{
		objBootstrapAlertPage.clickOnNormalSuccessMessageButton(objConfigProperties.getProperty("strNormalSuccessButton"));
		objBootstrapAlertPage.verifyNormalSuccessMessageIsDisplayedOrNot(objConfigProperties.getProperty("strExpNormalSuccessMsg"));
	}
	

	@Test(priority=4)
	public void TC_ID_04_verifyAutoCloseableWarningMessage() 
	{
		objBootstrapAlertPage.clickOnAutocloseableWarningMessageButton(objConfigProperties.getProperty("strAutocloseableWarningButton"));
		objBootstrapAlertPage.verifyAutocloseableWarningMessageIsDisplayedOrNot(objConfigProperties.getProperty("strExpAutocloseableWarningMsg"));
	}
	
	@Test(priority=5)
	public void TC_ID_05_verifyNormalWarningMessage() 
	{
		objBootstrapAlertPage.clickOnNormalWarningMessageButton(objConfigProperties.getProperty("strNormalWarningButton"));
		objBootstrapAlertPage.verifyNormalWarningMessageIsDisplayedOrNot(objConfigProperties.getProperty("strExpNormalWarningMsg"));
	}
	
	@Test(priority=6)
	public void TC_ID_06_verifyAutoCloseabledangerMessage() 
	{
		objBootstrapAlertPage.clickOnAutocloseableDangerMessageButton(objConfigProperties.getProperty("strAutocloseableDangerButton"));
		objBootstrapAlertPage.verifyAutocloseableDangerMsgIsDisplayedOrNot(objConfigProperties.getProperty("strExpAutocloseableDangerMsg"));
	}
	
	@Test(priority=7)
	public void TC_ID_07_verifyNormaDangerMessage() 
	{
		objBootstrapAlertPage.clickOnNormalDangerMessageButton(objConfigProperties.getProperty("strNormalDangerButton"));
		objBootstrapAlertPage.verifyNormalDangerMessageIsDisplayedOrNot(objConfigProperties.getProperty("strExpNormalDangerMsg"));
	}
	
	@Test(priority=8)
	public void TC_ID_08_verifyAutoCloseableInfoMessage() 
	{
		objBootstrapAlertPage.clickOnAutocloseableInfoMessageButton(objConfigProperties.getProperty("strAutocloseableInfoButton"));
		objBootstrapAlertPage.verifyAutocloseableInfoMsgIsDisplayedOrNot(objConfigProperties.getProperty("strExpAutocloseableInfoMsg"));
	}
}
