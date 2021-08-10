package Day15.Locators.SimpleformDemopage.Testing;

public class TestSeleniumSimpleFormPage {

	public static void main(String[] args) 
	{
		String strMenuBar;
		String strDropDownValue;
		String strMessage;
		SeleniumSimpleFormPage objSeleniumSimpleFormPage = new SeleniumSimpleFormPage();
		objSeleniumSimpleFormPage.initializeWebEnvironment();
		objSeleniumSimpleFormPage.selectMenuBarOptionAndDropDown(objSeleniumSimpleFormPage.objConfigProperties.getProperty("strMenuBar"),objSeleniumSimpleFormPage.objConfigProperties.getProperty("strDropDownValue"));
		objSeleniumSimpleFormPage.verifySimpleInputFormPage();
		objSeleniumSimpleFormPage.verifySingleInputFieldSection();
		objSeleniumSimpleFormPage.setSingleInputFieldMessage(objSeleniumSimpleFormPage.objConfigProperties.getProperty("strMessage"));
		objSeleniumSimpleFormPage.toScrollDownPage();
		objSeleniumSimpleFormPage.clickShowMessageButton();
		objSeleniumSimpleFormPage.verifyMessageEnteredInSingleInputField(objSeleniumSimpleFormPage.objConfigProperties.getProperty("strMessage"));
		objSeleniumSimpleFormPage.verifyTwoInputFieldsSection();
		objSeleniumSimpleFormPage.setFieldEnterValueAAndEnterValueB("Enter a", "10");
		objSeleniumSimpleFormPage.setFieldEnterValueAAndEnterValueB("Enter b", "10");
		objSeleniumSimpleFormPage.clickGetTotalButton();
		objSeleniumSimpleFormPage.verifyGetTotal("10", "10");
	
	
	}

}
