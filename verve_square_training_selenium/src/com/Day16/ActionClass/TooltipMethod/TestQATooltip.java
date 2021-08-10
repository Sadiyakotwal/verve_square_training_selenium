package com.Day16.ActionClass.TooltipMethod;

public class TestQATooltip 
{
	public static void main(String[] args) 
	{
		QATooltip objQATooltip =new QATooltip();
		objQATooltip.initializeWebEnvironment();
		objQATooltip.captureToolTips("You hovered over the button");
		
	}
}
