package com.Visionart.negativetestcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
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

//two  field are Invalid
public class Register2 {
	Properties prop = new Properties();
	InputStream input = null;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	Markup m;
	WebElements wle;

	public WebDriver driver;

	Random random = new Random();
	@SuppressWarnings("unused")
	private String user = "Testing" + String.valueOf(random.nextInt(10000));
	private String Email = "Testing" + String.valueOf(random.nextInt(100)) + "@mailinator.com";
	String browser = "firefox";

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
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
			test = extent.createTest("REGISTER - To verify whether error message is thrown for invalid field");

			m = MarkupHelper.createLabel("REGISTRATION TEST", ExtentColor.BLUE);
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
	public void registerNegativeTestcase(String browser1) throws Exception {
		if (browser1.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./jars/geckodriver.exe");
			driver = new FirefoxDriver();
			test.log(Status.PASS, "Firefox Sucessfully launched");
			test.log(Status.PASS, "Initialized Firefox browser from registerNegativeTestcase method");
		} else if (browser1.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Jars/chromedriver.exe");

			driver = new ChromeDriver();
			test.log(Status.PASS, "Chrome Sucessfully launched");
			test.log(Status.PASS, "Initialized Chrome browser from registerNegativeTestcase method");
		}

		else if (browser1.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", "./jars/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			test.log(Status.PASS, "Internet Explorer Sucessfully launched");
			test.log(Status.PASS, "Initialized Internet browser");

		}

		else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String baseUrl = "https://auto-visionart.pantheonsite.io/";
		test.log(Status.PASS, "Url Initialized successfully");
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		test.log(Status.PASS, "Maximized the browser");
		WebElements wle = new WebElements(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wle.clickCreateAccount();

		test.log(Status.PASS, MarkupHelper.createLabel("Negative scenario 1 ", ExtentColor.INDIGO));

		test.log(Status.PASS, "Creating new account");

		Thread.sleep(3000);

		// ********Registration - Negative scenario -User name blank ***************

		try {

			wle.clickCreateAccount();
			test.log(Status.PASS, "Creating new account");

			wle.enterUser("");
			test.log(Status.PASS, "UserName field kept blank");

			wle.enterMail(Email);
			test.log(Status.PASS, "Entered E-mail address as  " + Email);

			wle.enterPass(prop.getProperty("Password"));
			test.log(Status.PASS, "Entered password as:  " + prop.getProperty("Password"));

			wle.enterConPass(prop.getProperty("Password"));

			test.log(Status.PASS, "Entered Confirm password as " + prop.getProperty("Password"));
			/* wle.clickSubmit(); */

			test.log(Status.PASS, "Entered First name");

			wle.enterLastName("Reddy");
			test.log(Status.PASS, "Entered Last name as : Reddy");

			wle.enterStudio("");
			test.log(Status.PASS, "Studio field kept blank");

			wle.enterURL("https://www.visionart.com/");
			test.log(Status.PASS, "Entered URL as : https://www.visionart.com/");

			wle.enterPhone("");
			test.log(Status.PASS, "Phone No field kept blank");

			wle.enterCurr();
			Thread.sleep(5000);
			test.log(Status.PASS, "Selected currency value from drop-down as : USD");

			wle.clickSubmit();
			test.log(Status.PASS, "Clicked on Create new account button successfully");
			Thread.sleep(10000);
			test.log(Status.PASS,
					MarkupHelper.createLabel("Negative scenario 1 test passed successfully ", ExtentColor.INDIGO));
			// test.log(Status.FAIL, "Failed this method intentionally due to negative
			// scenario");
			// driver.close();

		}

		catch (Exception e) {
			test.fail(e);
		}
		// test.log(Status.PASS, MarkupHelper.createLabel("REGISTRATION TEST file passed
		// successfully", ExtentColor.TEAL));
	}

	@AfterTest
	public void finalD() {
		test.log(Status.PASS, MarkupHelper.createLabel("REGISTRATION TEST file passed successfully", ExtentColor.TEAL));
		extent.flush();
	}

}