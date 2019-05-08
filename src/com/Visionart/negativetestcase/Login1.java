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

//Invalid login and valid password
public class Login1 {
	Properties prop = new Properties();
	InputStream input = null;

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	Markup m;
	public WebDriver driver;
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

			test = extent.createTest("To verify user is able to login in the portal");

			m = MarkupHelper.createLabel("LOGIN TEST", ExtentColor.BLUE);
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

		if (browser1.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./jars/geckodriver.exe");
			driver = new FirefoxDriver();
			test.log(Status.PASS, "Firefox Sucessfully launched");
			test.log(Status.PASS, "Initialized Firefox browser");
		}

		else if (browser1.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Jars/chromedriver.exe");
			driver = new ChromeDriver();
			test.log(Status.PASS, "Chrome Sucessfully launched");
			test.log(Status.PASS, "Initialized Chrome browser ");
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
		Thread.sleep(5000);

		try {

			test.log(Status.PASS, MarkupHelper.createLabel("Log in the portal ", ExtentColor.CYAN));
			wle = new WebElements(driver);
			wle.clickLogin();

			test.log(Status.PASS, "Clicked on Login button successfully");

			wle.enterFN("pooja11");
			test.log(Status.PASS, "Enter UserName as:  pooja11");
			Thread.sleep(5000);

			wle.enterlpass(prop.getProperty("pw"));
			test.log(Status.PASS, "Fetched Password through Properties file  as  : " + (prop.getProperty("pw")));

			Thread.sleep(5000);

			wle.clicklSub();
			test.log(Status.PASS, "Clicked on submit successfully");

			driver.close();
		} catch (Exception e) {

			e.printStackTrace();
			test.fail(e);

		}
	}

	@AfterTest
	public void finalD() {
		test.log(Status.PASS, MarkupHelper.createLabel("LOGIN TEST file passed successfully", ExtentColor.TEAL));
		extent.flush();
	}

}