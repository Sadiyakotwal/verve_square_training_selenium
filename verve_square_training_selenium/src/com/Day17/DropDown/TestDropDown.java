package com.Day17.DropDown;

public class TestDropDown 
{
	public static void main(String[] args) 
	{
		DropDown objDropDown = new DropDown();
		objDropDown.initializeWebEnvironment();
		objDropDown.getPageOfParticularDropDown("Input Forms", "Select Dropdown List");
		objDropDown.verifyDropDownDemoPageIsDisplayedOrNOt();
		objDropDown.verifySelectListDemoSectionIsDisplayedOrNot();
		objDropDown.selectSingleDropDown();
		
	}

}
