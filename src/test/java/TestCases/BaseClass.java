package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pageObjects.android.FormPage;


public class BaseClass {
	AppiumDriverLocalService service;
	FormPage FormPage;
	protected AndroidDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void startServerwithApp() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\data.properties");
		prop.load(fis);
		String ipAddress=prop.getProperty("ipAddress");
		String portNo=prop.getProperty("port");
		String deviceName=prop.getProperty("AndroidDeviceName");
		
		service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\COLLABERA\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAddress).usingPort(Integer.parseInt(portNo)).build();
		service.start();
		UiAutomator2Options options=new UiAutomator2Options();
//		options.setDeviceName(deviceName);
		options.setDeviceName("PatrickPixel7Midterm");
		options.setApp("C:\\Users\\COLLABERA\\eclipse-workspace\\GeneralStore\\src\\main\\resources\\appUsed\\General-Store.apk");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

		FormPage=new FormPage(driver);
	}
	@BeforeClass
	public void configReports() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Android Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Patrick");
		test =extent.createTest("Click on View and scroll to WebView test");
	}
	@BeforeMethod
	public void beforeMethod() {
        System.out.println("Before Method - This tests if it runs before each test method.");
    }
	@AfterClass
	public void closeReport() {
		extent.flush();
	}
	@AfterMethod
	    public void afterMethod() {
	        System.out.println("After Method - This tests if it runs after each test method.");
	    }
	@AfterTest
	public void tearDown() {
		driver.quit();
		service.stop();
	}
	   @AfterSuite
	    public void afterSuite() {
	        System.out.println("After Suite - This tests if it runs once after all tests.");
	    }	
	
	
}
