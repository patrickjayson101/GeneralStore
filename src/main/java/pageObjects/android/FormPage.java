package pageObjects.android;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class FormPage extends AndroidActions{
	AndroidDriver driver;
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	public WebElement GenStoreBanner;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/spinnerCountry")
	public WebElement CountrySpinner;
	
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/nameField")
	@AndroidFindBy(id ="com.androidsample.generalstore:id/nameField")
	public WebElement NameField;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/radioMale")
	public WebElement GenderMaleButton;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/radioFemale")
	public WebElement GenderFemaleButton;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement LetsShopButton;
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement CartButton;

	

		
	public void clickOnElement(WebElement ele) {
		ele.click();
	}
	
	public void navigateBack() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	public String getText(WebElement ele) {
		return ele.getText();
	}

	public String getRadioButtonValue(WebElement ele) {
	      return ele.getAttribute("checked");
	  }
	
	public void validateIfCorrectText(String str1, String str2) {
		
		Assert.assertEquals(str1,str2);
	
	}
	public void validateIfDisplayedTrue(WebElement ele) {
		Assert.assertTrue(ele.isDisplayed());
		System.out.println("Element is displayed");
	}
	public void validateIfDisplayedFalse(WebElement ele) {
		Assert.assertFalse(ele.isDisplayed());
		System.out.println("Element is not displayed");
	}
	
	
}
