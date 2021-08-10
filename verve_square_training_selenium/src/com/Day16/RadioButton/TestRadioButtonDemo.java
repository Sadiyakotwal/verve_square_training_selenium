package com.Day16.RadioButton;


public class TestRadioButtonDemo {

	public static void main(String[] args) 
	{
		String strMenuBar;
		String strDropDownValue;
		String strRadioHeaderSection;
		String strGroupHeader;
		RadioButtonDemo objRadioButtonDemo = new RadioButtonDemo();
		objRadioButtonDemo.initializeWebEnvironment();
		objRadioButtonDemo.getPageOfParticularDropDown(objRadioButtonDemo.objConfigFile.getProperty("strMenuBar"), objRadioButtonDemo.objConfigFile.getProperty("strDropDownValue"));
		objRadioButtonDemo.verifyRadioButtonDemoPageIsDisplayedOrNot();
		objRadioButtonDemo.verifyRadioButtonDemoSectionIsDisplayedOrNot("Radio Button Demo");
		objRadioButtonDemo.selectRadioButton("Male");
		objRadioButtonDemo.clickGetCheckedValueBUtton();
		objRadioButtonDemo.VerifyTextAfterButtonClicked("Radio button 'Male' is checked");
		objRadioButtonDemo.verifyGroupRadioButtonSectionIsDisplayedOrNot("Group Radio Buttons Demo");
		objRadioButtonDemo.selectGroupRadioButtonGender("Female");
		objRadioButtonDemo.selectGroupRadioButtonAgeGroup("5 to 15");
		objRadioButtonDemo.clickOnGetValuesButton();
		objRadioButtonDemo.verifyTheTextAfterClickingGetValuesButton();
	}

}
