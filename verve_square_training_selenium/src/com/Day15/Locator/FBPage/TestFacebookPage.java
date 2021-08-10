package com.Day15.Locator.FBPage;

public class TestFacebookPage {

	public static void main(String[] args) 
	{
		FBCreateAccountFlow objFBCreateAccountFlow = new FBCreateAccountFlow();
		//objFBCreateAccountFlow.verifyFacebookSignUpPage();
		objFBCreateAccountFlow.initializeWebEnvironmentFlow();
		objFBCreateAccountFlow.doSignUp();
		objFBCreateAccountFlow.verifyHomePageIsVisible();
		

	}

}