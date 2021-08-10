package com.Day13.Locators;

public class TestLocators {

	public static void main(String[] args)
	{
		Locators objLocators = new Locators();
		objLocators.initializeWebEnvironment();
		//objLocators.cancelPopUp();
		objLocators.printListOfMenuBar("List Box");
		//objLocators.chooseParticularDropDown("Simple Form Demo");
		objLocators.chooseParticularDropDown("Bootstrap List Box");
		//objLocators.tearDown();
		

	}

}
