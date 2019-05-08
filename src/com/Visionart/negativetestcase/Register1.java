package com.Visionart.negativetestcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
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
public class Register1 {
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
	@SuppressWarnings("unused")
	private final String email = "Testing" + String.valueOf(random.nextInt(100)) + "@mailinator.com";
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
			test = extent.createTest("REGISTER - To verify user can successfully register/create an account");

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
			System.out.println("Browser is not correct");
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

		test.log(Status.PASS, MarkupHelper.createLabel("REGISTRATION TEST ", ExtentColor.INDIGO));

		test.log(Status.PASS, "Creating new account");

		Thread.sleep(3000);

		// ********Registration - Negative scenario -User name blank ***************

		try {

			String user = "Testing" + random.nextInt(100000);
			String email = user + "@mailinator.com";
			String pass = "vision3tamm";
			wle.clickCreateAccount();
			// userName

			test.log(Status.PASS, MarkupHelper.createLabel("Entering values to create new user", ExtentColor.CYAN));
			wle.clickAd1Name(user);
			test.log(Status.PASS, "Entered userName :   " + user);
			Thread.sleep(3000);
			// E-mail address

			driver.findElement(By.name("mail")).sendKeys(email);
			test.log(Status.PASS, "Entered E-mail address : " + email);
			Thread.sleep(3000);

			// password
			// driver.findElement(By.id("edit-pass-pass1")).sendKeys(prop.getProperty("Password"));
			driver.findElement(By.id("edit-pass-pass1")).sendKeys(pass);
			test.log(Status.PASS, "Entered Password as  :  " + pass);
			Thread.sleep(3000);

			// Confirm password

			driver.findElement(By.id("edit-pass-pass2")).sendKeys(pass);
			test.log(Status.PASS, "Entered Confirm password field as : " + pass);
			Thread.sleep(3000);

			// First name
			driver.findElement(By.name("field_first_name[und][0][value]")).sendKeys("John");
			test.log(Status.PASS, "Entered First name- John ");
			Thread.sleep(3000);

			// Last name
			driver.findElement(By.id("edit-field-last-name-und-0-value")).sendKeys("Reddy");
			test.log(Status.PASS, "Entered Last name -Reddy");
			Thread.sleep(3000);

			// Studio
			driver.findElement(By.id("edit-field-studio-und-0-value")).sendKeys("https://www.visionart.com/");
			test.log(Status.PASS, "Entered Studio value as   :https://www.visionart.com/");
			Thread.sleep(3000);

			// URL
			driver.findElement(By.id("edit-field-url-und-0-value")).sendKeys("https://www.visionart.com/");
			test.log(Status.PASS, "Passed URL value as  :https://www.visionart.com/");
			Thread.sleep(3000);
			// Phone
			driver.findElement(By.id("edit-field-phone-und-0-value")).sendKeys("7989155033");
			test.log(Status.PASS, "Entered Phone Number as :  7989155033 ");
			Thread.sleep(3000);

			// **************CURRENCY SETTINGS**********//
			// Currency

			Select drpCountry = new Select(
					driver.findElement(By.name("profile_currency_settings[field_currency_preview][und]")));
			drpCountry.selectByVisibleText("USD");
			Thread.sleep(5000);
			test.log(Status.PASS, "Selected currency value from drop-down as USD");
			Thread.sleep(3000);
			// create new account
			driver.findElement(By.id("edit-submit")).click();
			// test.log(Status.PASS, "Clicked on Create new account button");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@id=\"block-menu-menu-user-menu\"]/div/div/ul/li[1]/a")).click();

			test.log(Status.PASS, "New Account created successfully");

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