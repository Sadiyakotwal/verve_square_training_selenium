package com.Day17.ActionClass.KepadOperations;

public class TestKeyPad {

	public static void main(String[] args) 
	{
		KeyPadAction objKeyPadAction = new KeyPadAction();
		objKeyPadAction.initializeWebEnvironment();
		objKeyPadAction.verifyTextFields("text");
		objKeyPadAction.verifyTextFields("email");
		objKeyPadAction.sendKeysAction();
		objKeyPadAction.verifyTextFields("email");
		objKeyPadAction.copyPasteAction();
		objKeyPadAction.sendAllCapitalLetters();

	}

}
