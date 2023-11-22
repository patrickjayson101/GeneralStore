package TestCases;

import java.net.MalformedURLException;
import org.testng.annotations.Test;
import TestCases.BaseClass;
import utils.AndroidActions;

public class CreateAccount extends BaseClass {
	 @Test
	 public void launchApp() throws MalformedURLException {

			//Enter name
			FormPage.clickOnElement(FormPage.NameField);
			FormPage.enterText("Test User");
			String valname=FormPage.getText(FormPage.NameField);
			FormPage.validateIfCorrectText(valname,"Test User");
			test.pass("Name has been entered");
			
			
			//Select gender
			FormPage.clickOnElement(FormPage.GenderFemaleButton);
			String valRadio=FormPage.getRadioButtonValue(FormPage.GenderFemaleButton);
			FormPage.validateIfCorrectText(valRadio,"true");
			test.pass("Gender has been entered");
			
			
			//Enter country
			test.info("Scroll to the country");
			AndroidActions.scrollToText("Philippines");
			test.pass("User scrolled to the country");
			FormPage.clickOnText("Philippines");
			test.pass("User selected the country");
			
			//Click let's shop button
			test.info("Click Let's Shop button to create account");
			FormPage.clickOnElement(FormPage.LetsShopButton);
		}
	}