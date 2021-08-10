package com.Day16.ActionClass.Clicks;

public class TestClickMethods {

	public static void main(String[] args) 
	{
		ClickMethods objClickMethods = new ClickMethods();
		objClickMethods.initializeWebEnvironment();
		objClickMethods.verifyButtonsClickPageVisibleOrNOt();
		objClickMethods.doubleClick();
		objClickMethods.verifyDoubleClick("You have done a double click");
		objClickMethods.rightClick();
		objClickMethods.verifyRightClick("You have done a right click");
		

	}

}
