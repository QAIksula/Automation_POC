package com.Visionart.negativetestcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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

public class MyAccount {
	Properties prop = new Properties();
	InputStream input = null;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	Markup m;

	public static WebDriver driver = null;
	WebElements wle;
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
			test = extent.createTest("To verify whether user is able to add/update Myaccount fields");

			m = MarkupHelper.createLabel("MY ACCOUNT TEST", ExtentColor.BLUE);
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
	public void order(final String browser1) throws Exception {
		try {
			if (browser1.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./jars/geckodriver.exe");
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability("marionette", false);
				FirefoxOptions fopt = new FirefoxOptions(dc);
				driver = new FirefoxDriver(fopt);

				test.log(Status.PASS, "Firefox Sucessfully launched");
				test.log(Status.PASS, "Initialized Firefox browser from OrderSwatchbook method");
			} else if (browser1.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver", "./Jars/chromedriver.exe");
				driver = new ChromeDriver();
				test.log(Status.PASS, "Chrome Sucessfully launched");

			}

			else if (browser1.equalsIgnoreCase("ie")) {

				System.setProperty("webdriver.ie.driver", "./jars/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				test.log(Status.PASS, "Internet Explorer Sucessfully launched");
				test.log(Status.PASS, "Initialized Internet browser");
			}

			else {
				// If no browser passed throw exception
				System.out.println("Browser is not correct");
			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String baseUrl = "https://auto-visionart.pantheonsite.io";
			test.log(Status.PASS, "Url Initialized successfully");
			driver.navigate().to(baseUrl);
			driver.manage().window().maximize();
			test.log(Status.PASS, "Maximized the browser");
			Thread.sleep(5000);
			driver.get(baseUrl);
			wle = new WebElements(driver);
			test.log(Status.PASS, MarkupHelper.createLabel("Log in the portal ", ExtentColor.CYAN));

			// ********Login***************

			wle.clickmaLogin();
			test.log(Status.PASS, "Clicked on Login successfully");

			wle.enterMName("sai");
			test.log(Status.PASS, "Entered User Name as : Sai");

			wle.enterMNPass("saireddy481@!");
			test.log(Status.PASS, "Entered password as : saireddy481@!");

			wle.clickmaSub();
			test.log(Status.PASS, "Clicked on submit successfully");

			wle.subclick();

			// ************Updating Address***********
			test.log(Status.PASS, MarkupHelper.createLabel("Updating Address", ExtentColor.CYAN));
			wle.clickAddBook();
			test.log(Status.PASS, "Clicked on Address Book successfully");

			Thread.sleep(3000);

			wle.clickaddAdd();
			test.log(Status.PASS, "Clicked on Add a address successfully");

			// first name
			wle.entermaFN("Sai");
			test.log(Status.PASS, "Entered First Name as : Sai");

			// last name
			wle.entermaLN("Reddy");
			test.log(Status.PASS, "Entered Last Name as : Reddy");

			// company
			wle.entermaCO("iksula");
			test.log(Status.PASS, "Entered Company Name as : iksula");

			// Address 1
			wle.entermaAD("test");
			test.log(Status.PASS, "Entered Address first line as : test");

			// Address 2
			wle.entermaAD1("test1");
			test.log(Status.PASS, "Entered Address first line as : test1");

			wle.entermaAD2("Mumbai");
			test.log(Status.PASS, "Entered city line as : Mumbai");

			// state
			wle.setmaCountry();
			test.log(Status.PASS, "Selected country as : IOWA");

			// pincode
			wle.entermaPC("400058");
			test.log(Status.PASS, "Entered pincode as : 400058");

			// save profile

			wle.clickmaSubm();
			test.log(Status.PASS, "Clicked on submit successfully");

			// **************************Update email/password*****************
			// myaccount

			test.log(Status.PASS, MarkupHelper.createLabel("Updating email/password ", ExtentColor.CYAN));
			wle.clickMA();
			test.log(Status.PASS, "Clicked on My Account successfully ");

			// driver.quit();
			wle.clickUpdateEmail();
			test.log(Status.PASS, "Clicked on Update Email successfully ");

			wle.updateStudioField("VisionArt");
			test.log(Status.PASS, "Updated studio field as : VisionArt");

			Thread.sleep(3000);
			wle.scrollDown();

			// Upload picture
			/*
			 * wle.uploadPic("C:\\Users\\user.N420\\Desktop\\new\\notres.png");
			 * test.log(Status.PASS, "Picture uploaded successfully");
			 */
			Thread.sleep(3000);

			String myWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(myWindowHandle);

			wle.clickMASubmit();
			Thread.sleep(3000);

			wle.scrollDown();
			Thread.sleep(3000);

			/*
			 * wle.clickDel(); test.log(Status.PASS, "Deleted picture successfully");
			 */

			// save
			wle.clickMASubmit();
			test.log(Status.PASS, "Clicked on save successfully");
			Thread.sleep(4000);
			wle.scrollDown();

			// test.log(Status.PASS, MarkupHelper.createLabel("MYACCOUNT TEST file passed
			// successfully", ExtentColor.TEAL));

			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
			test.fail(e);
		}

	}

	@AfterTest
	public void finalD() {
		test.log(Status.PASS, MarkupHelper.createLabel("MYACCOUNT TEST file passed successfully", ExtentColor.TEAL));
		extent.flush();
	}

}
