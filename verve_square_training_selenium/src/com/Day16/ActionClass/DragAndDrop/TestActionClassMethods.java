package com.Day16.ActionClass.DragAndDrop;

public class TestActionClassMethods {

	public static void main(String[] args) 
	{
		ActionClassMethods objActionClassMethods = new ActionClassMethods();
		objActionClassMethods.initializeWebEnvironment();
		objActionClassMethods.verifyDroppablePageVisibleOrNOt();
		objActionClassMethods.dragDropActionPerfom();
		objActionClassMethods.verifyDragOperationPerformedOrNot();
		
		
	}

}
