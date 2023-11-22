package TestCases;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utils.AndroidActions;

public class LaunchApplication extends BaseClass {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite - This runs once before all tests.");
	}
	@Test
	public void launchApp() throws MalformedURLException {
		
		//Check if the app opens and see if welcome banner appears
		String valbanner=FormPage.getText(FormPage.GenStoreBanner);
		FormPage.validateIfCorrectText(valbanner,"General Store");
		test.pass("General Store banner is displayed");
		
		//Check if name field has correct hint
		FormPage.clickOnElement(FormPage.NameField);
		String valname=FormPage.getText(FormPage.NameField);
		FormPage.validateIfCorrectText(valname,"Enter name here");
		test.pass("Name field has correct hint");
		
		
		//Check the default gender
		FormPage.clickOnElement(FormPage.GenderMaleButton);
		String valRadio=FormPage.getRadioButtonValue(FormPage.GenderMaleButton);
		FormPage.validateIfCorrectText(valRadio,"true");
		test.pass("Gender has correct default value");
	
		
		/*//Click to open the country dropdown list
		FormPage.clickOnElement(FormPage.CountrySpinner);
		test.info("Clicking the open the country dropdown list");

		
		//Navigate to the bottom of the list
		test.info("Scroll to the bottom of Country Spinner");
		AndroidActions.scrollToText("Bahrain");
		test.pass("User scrolled to the last entry of Country Spinner");
		AndroidActions.scrollToText("Afghanistan");
		FormPage.clickOnText("Afghanistan");
		test.pass("User scrolled up to the first entry of Country Spinner");*/
		
		
		
		//Test Case 1***********************************************************
		//Enter name
		FormPage.clickOnElement(FormPage.NameField);
		FormPage.NameField.sendKeys("Test User");
		String valname1=FormPage.getText(FormPage.NameField);
		FormPage.validateIfCorrectText(valname1,"Test User");
		test.pass("Name has been entered");
		
		
		//Select gender
		FormPage.clickOnElement(FormPage.GenderFemaleButton);
		String valRadio1=FormPage.getRadioButtonValue(FormPage.GenderFemaleButton);
		FormPage.validateIfCorrectText(valRadio1,"true");
		test.pass("Gender has been entered");
		
		
		//Enter country
		FormPage.clickOnElement(FormPage.CountrySpinner);
		test.info("Clicking the open the country dropdown list");
		AndroidActions.scrollToText("Bahrain");
		test.pass("User scrolled to the country");
		FormPage.clickOnText("Bahrain");
		test.pass("User selected the country");
		
		//Click let's shop button
		test.info("Click Let's Shop button to create account");
		FormPage.LetsShopButton.click();	
		
		//Check if the product page opens and see if cart button appears
		FormPage.validateIfDisplayedTrue(FormPage.CartButton);
	
		
		}
}
