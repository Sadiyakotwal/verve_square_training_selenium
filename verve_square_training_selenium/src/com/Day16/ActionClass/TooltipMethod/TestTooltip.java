package com.Day16.ActionClass.TooltipMethod;



public class TestTooltip 
{
	public static void main(String[] args)
	{
		Tooltip objTooltip = new Tooltip();
		objTooltip.initializeWebEnvironment();
		objTooltip.verifySeleniumHomePagePageVisibleOrNOt();
		//objTooltip.verifyToolTipPageVisibleOrNOt();
		//objTooltip.captureAndVerifyToolTips("We ask for your age only for statistical purposes.");
		objTooltip.captureToolTips("search");
	}

}
