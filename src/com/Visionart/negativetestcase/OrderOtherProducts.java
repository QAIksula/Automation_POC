package com.Visionart.negativetestcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.webelements.WebElements;

public class OrderOtherProducts {
	
	Properties prop = new Properties();
	InputStream input = null;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	Markup m;
	WebElements wle;
	public static WebDriver driver;

	String expecteduserNameURL = "https://auto-visionart.pantheonsite.io/user/login?current=node", actualuserNameURL,

			expectedPasswordURL = "https://auto-visionart.pantheonsite.io/user/login?current=node",
			actualPasswordNameURL,
			expectedLoginbuttonURL = "https://auto-visionart.pantheonsite.io/user/login?current=node",
			actualLoginbuttonNameURL, expectedLoginSuccess = "https://auto-visionart.pantheonsite.io/",
			actualLoginSuccess;
	String browser = "firefox";
   
	
	
	@BeforeTest
	public void elementInitialization() throws Exception {

		try {
			input = new FileInputStream("./Assets.properties");
			prop.load(input);

			htmlReporter = new ExtentHtmlReporter(
					"./Reports/VisionArt_" + this.getClass().getSimpleName() + System.currentTimeMillis() + ".html");
			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setDocumentTitle("VisionArt Suite");
			htmlReporter.config().setReportName("VisionArt Project Report");
			htmlReporter.config().setTheme(Theme.DARK);
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			test = extent.createTest("To verify user is able to order other products");

			m = MarkupHelper.createLabel("ORDER OTHER PRODUCT TEST", ExtentColor.BLUE);
			//test.pass(m);
			test.log(Status.PASS, "Properties file loaded successfully");

		} catch (IOException e) {
			e.printStackTrace();
		}
		if (input != null) {
			try {
				input.close();
			} catch (Exception e) {
				System.out.println("Properties method caught - " + e.getMessage());
			}
		}
	}	
				
	@Test	
		
	@Parameters("browser")
	public void invalidLogin(String browser1) throws Exception {

		if (browser1.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./jars/geckodriver.exe");
			driver = new FirefoxDriver();
			test.log(Status.PASS, "Firefox Sucessfully launched");
			test.log(Status.PASS, "Initialized Firefox browser from 1st Logininvalidnegativetestcase method");
		} else if (browser1.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Jars/chromedriver.exe");

			
			driver = new ChromeDriver();
			test.log(Status.PASS, "Chrome Sucessfully launched");
			test.log(Status.PASS, "Initialized Chrome browser from 1st Logininvalidnegativetestcase method");
		} 
		
		
		else if (browser1.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", "./jars/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			test.log(Status.PASS, "Internet Explorer Sucessfully launched");
			test.log(Status.PASS, "Initialized Internet browser");
			//test.log(Status.PASS, "Properties file loaded successfully");

		}
		
		else
		{
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String baseUrl = "https://auto-visionart.pantheonsite.io/";
		test.log(Status.PASS, "Url Initialized successfully");
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		test.log(Status.PASS, "Maximized the browser");
		
		test.log(Status.PASS, MarkupHelper.createLabel("Log in the portal ", ExtentColor.CYAN));
		Thread.sleep(5000);
		try {
			 wle=new WebElements(driver);
			// click on login
			wle.clickOlog();
			test.log(Status.PASS, "Clicked on login button successfully");
			
		
		
	    // UserName
	    wle.enterOName(prop.getProperty("user"));
	    test.log(Status.PASS, "Fetched Username through Properties file as : "+prop.getProperty("user"));

	    actualuserNameURL = driver.getCurrentUrl();
	   // PasswordName
	    
	   wle.enterOPass(prop.getProperty("pw"));
	   test.log(Status.PASS, "Fetched Password through Properties file : "+prop.getProperty("pw"));

	   Thread.sleep(5000);
	   //*****************LoginbuttonName******************
		wle.enterOSub();
		test.log(Status.PASS, "Cicked on submit button successfully");
		test.pass(m);
		test.log(Status.PASS, "Passed this method intentionally due to positive scenario");
		
		
		// ****************Order**********
		test.log(Status.PASS, MarkupHelper.createLabel("Ordering other products ", ExtentColor.CYAN));
		wle.clickOorder();
		test.log(Status.PASS, "Clicked on Orders successfully.");	
		// click on other products
		wle.clickOtherorder();
		test.log(Status.PASS, "Clicked on other Products successfully ");

		// clickon ADD-Folio
		wle.clickFolio();
		test.log(Status.PASS, "Clicked on other Add Folio successfully ");
		
		// Select a size
		wle.clickOSize();
		test.log(Status.PASS, "Size selected as : 5*7");
		//selectasize.click();
	  
		//scrollToElement(selectasize);
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		
		
		
		// SELECT A COVER OPTION and click
		wle.clickOCover();
		test.log(Status.PASS, "Selected cover option ");
		//Select a category and swatch
		wle.selCat1();
		// click on premium Leather
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		wle.selCat2();
		test.log(Status.PASS, "Selected premium leather successfully ");
		
		Thread.sleep(3000);
		// INCLUDE PRINTS
		wle.clickPrint();
		test.log(Status.PASS, "Clicked Print successfully ");
		// DEBOSSING
		wle.clickDeboss();
		test.log(Status.PASS, "Clicked Debossing successfully");
		// ADD A STAMP TO THIS BOOK
		
		//**** click on add stamp*****
		
		wle.clickStamp();
		 
		// xpath changed
		test.log(Status.PASS, "Clicked  ADD A STAMP TO THIS BOOK successfully");
		
		
		
		
		//remove
		wle.clickRemove();
		test.log(Status.PASS, "Clicked on remove successfully");
		System.out.println("test1");
		// Choose color
		driver.switchTo().activeElement();
		Thread.sleep(3000);
	     wle.clickChoose();
	     test.log(Status.PASS, " Clicked on choose color successfully");
	     
	     wle.clickColor();
	     test.log(Status.PASS, " Color clicked successfully");
	     Thread.sleep(3000);
		//Blind
		wle.clickBlind();
		test.log(Status.PASS, "Clicked on blind successfully ");
		
		Thread.sleep(3000);
		
		//Proceed to checkout
		wle.clickOSub();
		test.log(Status.PASS, "Clicked on submit button successfully");
			
		Thread.sleep(3000);

		// **************Billing information*************
		test.log(Status.PASS, MarkupHelper.createLabel("Entering Billing Information for checkout ", ExtentColor.CYAN));
		// Addresses on
		Thread.sleep(2000);
	
		// Company
		wle.selectCompany("iksula");
        test.log(Status.PASS, " Entered Company as :  iksula");
        Thread.sleep(3000);
        
        
        
		wle.selectBAdd2("Test Address");
		test.log(Status.PASS, "Enter Address as :  Test Address ");
		Thread.sleep(3000);

		/*// Company (***update dynamic change values id'location path 26/7/2018)
		wle.selectShipInfo("iksula");
		test.log(Status.PASS, "Entered Shipping information-Company  : iksula");

		// Address 2
		wle.selectShipInfo1("Test"); 
		test.log(Status.PASS, " Entered Shipping information-Address2 as : Test ");*/
		
		// COUPONS
		wle.selectCoupon("Test Coupon");
		test.log(Status.PASS, "Shipping information-COUPONS : Test Coupon");
		Thread.sleep(3000);
		
		// continue to next step
		wle.selectContinue();
		test.log(Status.PASS, "Clicked on continue successfully.");

		Thread.sleep(3000);
		// continue to next step
		wle.clickshipSer();
		test.log(Status.PASS, "");
		Thread.sleep(3000);
		wle.selectContinue();
		test.log(Status.PASS, "SHIPPING SERVICE -Continue to next step");
		// go back
		// driver.findElement(By.className("checkout-back form-submit")).click();

		// **********************Review order********************************** //
		// payment

		// Credit card
		
		test.log(Status.PASS, MarkupHelper.createLabel("Selecting Payment Type", ExtentColor.CYAN));
        wle.selectCredit();	
		test.log(Status.PASS, "Clicked Review order -Creditcard radio button successfully ");
		Thread.sleep(3000);

		// Card type
		wle.selectCardType();
		test.log(Status.PASS, "Selected Review order -Card type successfully ");
		Thread.sleep(3000);

		// Card number
		wle.selectCardNum("457812364512");
		test.log(Status.PASS, "Review order -Entered Card number as  : 457812364512");
		Thread.sleep(3000);

		// Security code
		wle.selectSecurityCode("563");
		test.log(Status.PASS, "Entered the Security code as : 563");
		Thread.sleep(3000);

		// continue to next step
		wle.selectContinue();
		Thread.sleep(3000);
		
       wle.cancelOrder();
       Thread.sleep(3000);
		
		
		
		
	} catch (Exception e) {
		test.fail(e);
	// driver.quit();

	}
	
	
		//test.log(Status.PASS, MarkupHelper.createLabel("ORDER OTHER PRODUCT TEST passed successfully", ExtentColor.TEAL));
	//extent.flush();

}
	
	
	@AfterTest
	public void finalD()
	{
		test.log(Status.PASS, MarkupHelper.createLabel("ORDER OTHER PRODUCT TEST passed successfully", ExtentColor.TEAL));
		extent.flush();
		
	}

	

}
