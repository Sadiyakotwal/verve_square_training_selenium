package com.Day14.Repository;

public class TestSelenium {

	public static void main(String[] args) 
	{
		String strMenuBar;
		String strDropDownValue;
		Selenium objSelenium = new Selenium();
		objSelenium.initializeWebEnvironment();
		//objSelenium.closePopUp();
		objSelenium.selectParticularDropDownOption(objSelenium.objConfigProperties.getProperty("strMenuBar"),objSelenium.objConfigProperties.getProperty("strDropDownValue"));
	}

}
