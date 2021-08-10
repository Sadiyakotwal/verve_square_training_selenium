package com.Day16.CheckBox;

public class TestModified {

	public static void main(String[] args) 

	{
		String strMenuBar;
		String strDropDownValue;
		ModifiedCheckBoxDemo objModifiedCheckBoxDemo = new ModifiedCheckBoxDemo();
		objModifiedCheckBoxDemo.initializeWebEnvironment();
		objModifiedCheckBoxDemo.getPageOfParticularDropDown(objModifiedCheckBoxDemo.objConfigFile.getProperty("strMenuBar"), objModifiedCheckBoxDemo.objConfigFile.getProperty("strDropDownValue"));
		objModifiedCheckBoxDemo.verifyCheckBoxDemoPageIsDisplayedOrNOt();
		objModifiedCheckBoxDemo.verifySingleCheckBoxDemoSectionIsDisplayedOrNot();
		objModifiedCheckBoxDemo.selectSingleCheckBox();
		objModifiedCheckBoxDemo.verifyMultipleCheckBoxDemoSectionIsDisplayedOrNot();
		objModifiedCheckBoxDemo.selectMultipleCheckBox("Option 4");
		objModifiedCheckBoxDemo.selectMultipleCheckBox("Option 2");

	}

}