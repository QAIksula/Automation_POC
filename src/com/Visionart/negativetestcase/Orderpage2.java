package com.Visionart.negativetestcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
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

public class Orderpage2 {
	Properties prop = new Properties();
	InputStream input = null;
	Actions action;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	Markup m;
	WebElements wle;
	public static WebDriver driver;

	/*private String expecteduserNameURL = "https://auto-visionart.pantheonsite.io/user/login?current=node", expectedPasswordURL = "https://auto-visionart.pantheonsite.io/user/login?current=node",
			actualPasswordNameURL,
			expectedLoginbuttonURL = "https://auto-visionart.pantheonsite.io/user/login?current=node",
			actualLoginbuttonNameURL, expectedLoginSuccess = "https://auto-visionart.pantheonsite.io/",
			actualLoginSuccess;*/
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
			test = extent.createTest("To verify whether user is able to place an order");

			m = MarkupHelper.createLabel("ORDER PAGE TEST", ExtentColor.BLUE);
			test.pass(m);
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

		if (browser1.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./jars/geckodriver.exe");
			driver = new FirefoxDriver();
			test.log(Status.PASS, "Firefox Sucessfully launched");
			test.log(Status.PASS, "Initialized Firefox browser from 1st Logininvalidnegativetestcase method");
		}
		
		else if (browser1.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Jars/chromedriver.exe");
			driver = new ChromeDriver();
			test.log(Status.PASS, "Chrome Sucessfully launched");
			test.log(Status.PASS, "Initialized Chrome browser from 1st Logininvalidnegativetestcase method");
		} 
		
		else if (browser1.equalsIgnoreCase("ie")) 
		{
            System.setProperty("webdriver.ie.driver", "./jars/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			test.log(Status.PASS, "Internet Explorer Sucessfully launched");
			test.log(Status.PASS, "Initialized Internet browser");
		}
			
		else 
		{
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String baseUrl = "https://auto-visionart.pantheonsite.io/";
		test.log(Status.PASS, "URL Initialized successfully");
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		test.log(Status.PASS, "Maximized the browser");
		Thread.sleep(5000);
		
		
		
		try {
			wle=new WebElements(driver); 
			
			// ********login********//
			
			test.log(Status.PASS, MarkupHelper.createLabel("Log in the portal ", ExtentColor.CYAN));
			wle.clickPlogin();
			test.log(Status.PASS, "Clicked on login successfully");
			
			// UserName
			wle.clickOPname(prop.getProperty("user"));
			test.log(Status.PASS, "Fetched Username through Properties file  : "+prop.getProperty("user"));

			driver.getCurrentUrl();
			// PasswordName
			wle.clickOPpass(prop.getProperty("pw"));
			test.log(Status.PASS, "Fetched Password through Properties file  : "+prop.getProperty("pw"));

			Thread.sleep(5000);

			// *****************LoginbuttonName*******************//
			wle.clickOPsub();
			test.log(Status.PASS, "Clicked login button successfully");
			
			// ****************Order**********

			wle.clickOPorder();
			test.log( Status.PASS,"Clicked on Orders successfully");
				
			// click on books
			wle.clickOBooks();
			test.log( Status.PASS,"Clicked on Books successfully");
			// enter event-name
			
			wle.clickOEvent("Test event");
			test.log(Status.PASS, "Entered event name as: Test event");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			// Will you be ordering a book?
			
			
			Thread.sleep(3000);
			
			
			wle.clickYes();
			Thread.sleep(3000);
			wle.clickRadio();
			test.log(Status.PASS, "What type of book will you be ordering");
			test.log(Status.PASS, "Clicked on Yes radio button successfully");
			
			wle.clickRadioSpread();
			test.log(Status.PASS, "How many spreads does your design have");
			test.log(Status.PASS, "Clicked on Yes radio button successfully");
			
			Thread.sleep(10000);
			
			/*try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}*/
			
			
			// What layout is your design?
		

			wle.enterLayout();
			test.log(Status.PASS, "Horizontal layout selected successfully");
		    Thread.sleep(3000);
	
			// *******Select a size**************
			wle.clickOPSize();
			test.log(Status.PASS, "Size selected as : 10x8 ");
			Thread.sleep(3000);
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		
			// *********************COVER STYLE***********
			// **********FULL********
	       
			
			wle.clickOPCat1();
			
	        wle.clickOPCat2();
	        test.log(Status.PASS, "Clicked on premium leather successfully");	
		
			wle.hover();
			 test.log(Status.PASS, "Selected premium leather as :  ");	
		    Thread.sleep(3000);
		   
					
					
			Thread.sleep(3000);
			//ENDSHEETs
			wle.clickOPEndsheet();
			
			wle.clickOPEndCol();
		    test.log(Status.PASS, "Gray color selected ");	
			
			// ****************Select debossing options*******
			
			//select show option 
			wle.clickOPShow();
			test.log(Status.PASS,"Clicked on Show options");
			System.out.println("test");
			//Add a stamp to the book
			wle.clickOPStamp();
			test.log(Status.PASS, "");
			
			
			//remove
			wle.clickOPRemove();
			test.log(Status.PASS, "");
			
			driver.switchTo().activeElement();
			Thread.sleep(3000);
			wle.clickOPButton();
			
			
			
			
			
			
			
			
			//close
			wle.clickOPClose();
			test.log(Status.PASS,"Pop up closed successfully");
			
			Thread.sleep(3000);
			
		
			// process to
			wle.clickOPSubm();
			test.log(Status.PASS,"Clicked on submit buttton successfully");

		
			
			// **************Billing information*************

			test.log(Status.PASS, MarkupHelper.createLabel("Entering Billing information for checkout ", ExtentColor.CYAN));
		    wle.selectCompany("iksula");
		    test.log(Status.PASS, " Entered Company as :  iksula");
			Thread.sleep(3000);
			 
			wle.selectBAdd2("Test Address");
			test.log(Status.PASS, "Enter Address as :  Test Address ");
			Thread.sleep(3000);

			// Company (***update dynamic change values id'location path 26/7/2018)
			/*wle.selectShipInfo("iksula");
			test.log(Status.PASS, "Entered Shipping information-Company  : iksula");
			Thread.sleep(3000);

			// Address 2 (***update id'location path 26/7/2018)
			wle.selectShipInfo1("Test");
			test.log(Status.PASS, " Entered Shipping information-Address2 as :Test ");
			Thread.sleep(3000);
*/
			// COUPONS
			wle.selectCoupon("Test Coupon");
			test.log(Status.PASS, "Shipping information-COUPONS :Test Coupon");
			Thread.sleep(3000);
			

			// continue to next step
			driver.findElement(By.id("edit-continue")).click();
			test.log(Status.PASS, "Shipping information-continue to next step");
			Thread.sleep(3000);

			// continue to next step
			wle.selectContinue();
			test.log(Status.PASS, "Shipping information-continue to next step");
			Thread.sleep(3000);
			

			// **********************Review order********************************** //
			// payment

			// Credit card
			
			test.log(Status.PASS, MarkupHelper.createLabel("Selecting Payment Type ", ExtentColor.CYAN));
			wle.selectCredit();
			test.log(Status.PASS, "Clicked Review order -Creditcard radio button successfully ");
			Thread.sleep(3000);

			// Card type
			wle.selectCardType();
			test.log(Status.PASS, "Selected Review order -Card type successfully ");
			Thread.sleep(3000);
			
			// Card number
			wle.selectCardNum("457812364512");
			test.log(Status.PASS, "Review order -Entered the Card number as  : 457812364512");
			Thread.sleep(3000);
			// Security code
			wle.selectSecurityCode("563");
			test.log(Status.PASS, "Entered the Security code as : 563");
			// continue to next step
			Thread.sleep(3000);

			// Go Back
			wle.goBack();
			Thread.sleep(3000);
			test.log(Status.PASS, "Clicked on Go Back successfully. ");
			// driver.close();
			
			
		wle.cancelOrder1();
			// driver.close();
		} catch (Exception e) {
			String str = e.getMessage();
			test.fail(""+str.toString());
			// driver.quit();

		}
		//test.log(Status.PASS, MarkupHelper.createLabel("ORDER PAGE TEST passed successfully", ExtentColor.TEAL));
		//extent.flush();

	}

	
	@AfterTest
	public void finalD()
	{
		test.log(Status.PASS, MarkupHelper.createLabel("ORDER PAGE TEST passed successfully", ExtentColor.TEAL));
		extent.flush();
		
	}



}
