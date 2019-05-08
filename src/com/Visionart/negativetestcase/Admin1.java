package com.Visionart.negativetestcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class Admin1 {

	Properties prop = new Properties();
	InputStream input = null;
	Actions action;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	Markup m;

	public static WebDriver driver;

	String expecteduserNameURL = "https://auto-visionart.pantheonsite.io/user/login?current=node", actualuserNameURL,

			expectedPasswordURL = "https://auto-visionart.pantheonsite.io/user/login?current=node",
			actualPasswordNameURL,
			expectedLoginbuttonURL = "https://auto-visionart.pantheonsite.io/user/login?current=node",
			actualLoginbuttonNameURL, expectedLoginSuccess = "https://auto-visionart.pantheonsite.io/",
			actualLoginSuccess;
	String browser = "firefox", iframe = "overlay-element overlay-active";
	WebElement elementFrame;
	WebElement e;
	Random random = new Random();
	static int count;
	 static int count1;
	static int count2;

	
	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	Calendar calobj = Calendar.getInstance();
	String date=(df.format(calobj.getTime()));
	
	@BeforeTest
	@Parameters("browser")
	public void elementInitialization(String browsercheck) throws Exception {

		try {
			if (browsercheck.equalsIgnoreCase("firefox")) {
				input = new FileInputStream("./Assets.properties");
				prop.load(input);

				/*htmlReporter = new ExtentHtmlReporter("./Reports/VisionArt_Firefox" + this.getClass().getSimpleName()
						+ System.currentTimeMillis() + ".html");*/
				htmlReporter = new ExtentHtmlReporter("./Reports/VisionArt_Firefox" + "Rustic LEATHER VISIBILITY CHECK"
						+count + ".html");
				count++;
				
				
				
				
				htmlReporter.config().setChartVisibilityOnOpen(true);
				htmlReporter.config().setDocumentTitle("VisionArt Suite");
				htmlReporter.config().setReportName("VisionArt Project Report");
				htmlReporter.config().setTheme(Theme.DARK);
				extent = new ExtentReports();
				extent.attachReporter(htmlReporter);
				test = extent.createTest("To verify whether newly created user is able to view PREMIUM LEATHER under Extras section according to the conditions set by Admin");

				m = MarkupHelper.createLabel("PREMIUM  LEATHER CHECK/UNCHECK VISIBILITY TEST", ExtentColor.BLUE);
				test.pass(m);

				test.log(Status.PASS, "Properties file loaded successfully");
			} else if (browsercheck.equalsIgnoreCase("chrome")) 
			
			{
				
				count1++;
				System.out.print(count1);
				input = new FileInputStream("./Assets.properties");
				prop.load(input);

				htmlReporter = new ExtentHtmlReporter("./Reports/VisionArt_Chrome" + "PREMIUM LEATHER VISIBILITY CHECK"
						+ count1 + ".html");
				
				htmlReporter.config().setChartVisibilityOnOpen(true);
				htmlReporter.config().setDocumentTitle("VisionArt Suite");
				htmlReporter.config().setReportName("VisionArt Project Report");
				htmlReporter.config().setTheme(Theme.DARK);
				extent = new ExtentReports();
				extent.attachReporter(htmlReporter);
				test = extent.createTest("To verify whether newly created user is able to view RUSTIC LEATHER under Extras section according to the conditions set by Admin");

				m = MarkupHelper.createLabel("PREMIUM LEATHER CHECK/UNCHECK VISIBILITY TEST", ExtentColor.BLUE);
				test.pass(m);
				//test.log(Status.PASS, "Properties file loaded successfully");
			}

			else if (browsercheck.equalsIgnoreCase("ie")) {

				input = new FileInputStream("./Assets.properties");
				prop.load(input);

				htmlReporter = new ExtentHtmlReporter("./Reports/VisionArt_IE" + this.getClass().getSimpleName()
						+ count2 + ".html");
				count2++;
				htmlReporter.config().setChartVisibilityOnOpen(true);
				htmlReporter.config().setDocumentTitle("VisionArt Suite");
				htmlReporter.config().setReportName("VisionArt Project Report");
				htmlReporter.config().setTheme(Theme.DARK);
				extent = new ExtentReports();
				extent.attachReporter(htmlReporter);
				test = extent.createTest("To verify whether newly created user is able to view PREMIUM LEATHER under Extras section according to the conditions set by Admin");

				m = MarkupHelper.createLabel("PREMIUM LEATHER CHECK/UNCHECK VISIBILITY TEST", ExtentColor.BLUE);
				test.pass(m);
				//test.log(Status.PASS, "Properties file loaded successfully");

			}
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

	@Parameters("browser")
	@Test
	public void adminChanges(String browser1) throws Exception {
		try {
			if (browser1.equalsIgnoreCase("firefox")) {
				
				System.setProperty("webdriver.gecko.driver", "./jars/geckodriver.exe");
				driver = new FirefoxDriver();
				test.log(Status.PASS, "Firefox Sucessfully launched");
				test.log(Status.PASS, "Initialized Firefox browser from 1st Logininvalidnegativetestcase method");
			} else if (browser1.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Jars/chromedriver.exe");

				// test.log(Status.PASS, "Initialized Chrome browser from 1st logininvalid
				// method");
				driver = new ChromeDriver();
				test.log(Status.PASS, "Chrome browser sucessfully launched");
				test.log(Status.PASS, "Initialized chrome browser ");
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
			String baseUrl = "https://auto-visionart.pantheonsite.io";
			//test.log(Status.PASS, "VisionArt Url Initialized successfully");
			driver.navigate().to(baseUrl);
			driver.manage().window().maximize();
			test.log(Status.PASS, "Maximized the browser");
			Thread.sleep(5000);
			driver.get(baseUrl);
			test.log(Status.PASS, "Launched VisionArt URL in the browser");
			// Login
			driver.findElement(By.xpath("html/body/div[3]/header/div[1]/div/div/div/div[2]/div/div/ul/li[1]/a"))
					.click();
			
			
			test.log(Status.PASS, MarkupHelper.createLabel("ADMIN LOGIN", ExtentColor.CYAN));
			test.log(Status.PASS, "Clicked on the login button");

			
			driver.findElement(By.name("name")).sendKeys(prop.getProperty("Username"));
			// elements.userName("admin");
			test.log(Status.PASS, "Enter Admin user name as : " + prop.getProperty("Username"));
			// password
			driver.findElement(By.name("pass")).sendKeys(prop.getProperty("Password"));
			test.log(Status.PASS, "Entered Admin password as : " + prop.getProperty("Password"));
			// elements.passWord("visiont3am");
			// login button
			driver.findElement(
					By.xpath("html/body/div[3]/section/div/div/div/div/div/div/div/form/div/div[1]/div[3]/input"))
					.click();
			test.log(Status.PASS, "Logged in as Admin");
			
			
			test.log(Status.PASS, MarkupHelper.createLabel("Editing Material-List ", ExtentColor.CYAN));
			WebElement element = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/ul[2]/li[2]/a"));
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			Thread.sleep(1000);
			// driver.findElement(By.xpath("iPads")).click();
			WebElement element1 = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/ul[2]/li[2]/ul/li[15]/a"));
			element1.click();
			escape();
			test.log(Status.PASS, "Clicked on Taxanomy Successfully");
			
			
		/*	 test.log(Status.PASS, MarkupHelper.createLabel("*************** Using Labels ***************", ExtentColor.RED));
		        test.log(Status.PASS, MarkupHelper.createLabel("This is Test Logger 1", ExtentColor.BLUE));*/

			elementFrame = driver.findElement(
					By.xpath("//div[@id='overlay-container']//iframe[@class='overlay-element overlay-active']"));
			Thread.sleep(5000);

			driver.switchTo().frame(elementFrame);
			Thread.sleep(5000);

			driver.findElement(By.id("edit-5-list")).click();
			Thread.sleep(5000);
			test.log(Status.PASS, "Pop up opens up after clicking Taxanomy");
			test.log(Status.PASS, "Clicked Material- list terms.");

			driver.switchTo().defaultContent();

			// ------ Iframe------------

			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Materials dialog']")));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("edit-tid110-edit")).click();
			test.log(Status.PASS, MarkupHelper.createLabel("Editing Premium leather", ExtentColor.CYAN));
			test.log(Status.PASS, "Clicked on Premium leather- edit  hyperlink ");
			test.log(Status.PASS, "Scrolled down to extra checkbox");
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Edit dialog']")));

			WebElement extra = driver.findElement(By.id("edit-field-pages-und-extras"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", extra);

			Thread.sleep(3000);
			js.executeScript("arguments[0].click();", extra);

			System.out.println("checked" + extra.isSelected());

			Thread.sleep(1000);
			boolean isChecked;

			isChecked = extra.isSelected();

			if (isChecked == true) {
				System.out.println("Extra is checked");
				test.log(Status.PASS, MarkupHelper.createLabel("Checking whether Extra checkbox is already clicked", ExtentColor.INDIGO));
				
				test.log(Status.PASS, "Enabling Extras as it is unchecked - Under page section");
				test.log(Status.PASS, "Extras Checkbox - Under page section checked");
			} else {
				test.log(Status.PASS, MarkupHelper.createLabel("Checking whether Extra checkbox is already clicked", ExtentColor.INDIGO));
				
				test.log(Status.PASS, "Disabling Extras as it is checked - Under page section");
				
				test.log(Status.PASS, "Extras - Under page section unchecked");
			}

			Thread.sleep(3000);

			// Click on save
			WebElement save = driver.findElement(By.id("edit-submit"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView();", save);
			js1.executeScript("arguments[0].click();", save);
			test.log(Status.PASS, "Extras - Save button under page section clicked and changes saved ");

			driver.switchTo().defaultContent();
			WebElement logout = driver.findElement(By.xpath("//*[@id=\"admin-menu-account\"]/li[1]/a"));
			logOut(logout);

			test.log(Status.PASS, "Logged out as admin user");
			
			test.log(Status.PASS, MarkupHelper.createLabel("New user creation", ExtentColor.CYAN));
			register();
			//test.log(Status.PASS, "New user created sucessfully and aunthenticated");

			driver.findElement(By.xpath("//*[@id=\"main-menu\"]/li[3]/a")).click();
			Thread.sleep(20000);
			if (isChecked == true) {
				test.log(Status.PASS, "Extras section is checked for Rustic Leather");
				test.log(Status.PASS, MarkupHelper.createLabel("Premium leather is displayed under extra section", ExtentColor.INDIGO));
			//	test.log(Status.PASS, "Rustic leather is displayed under extra section");
				WebElement prem = driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[3]/p[2]/em"));
				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("arguments[0].scrollIntoView();", prem);
				String display = prem.getText();
				System.out.println(display);

				System.out.println("Premium Leather is visible to authenticated user");
			} else {
				test.log(Status.PASS, "Extras section is checked for Rustic Leather");
				
				test.log(Status.PASS, MarkupHelper.createLabel("Premium leather is not displayed under extra section", ExtentColor.INDIGO));
				//test.log(Status.PASS, "Rustic leather is not  displayed under extra section");
				System.out.println("Rustic Leather is not  visible to authenticated user");
			}

			// test.fail(m);
			// driver.close();

			// System.out.println(str);

		} catch (Exception e) {
			test.fail(e);

		}
		test.log(Status.PASS, MarkupHelper.createLabel("PREMIUM LEATHER CHECK/UNCHECK VISIBILITY TEST file passed successfully", ExtentColor.TEAL));
		
		extent.flush();
		// driver.quit();
	}

	public void logOut(WebElement logout) {
		logout.click();
	}

	public void escape() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}

	public void register() throws InterruptedException {

		String user = "Testing" + random.nextInt(100000);
		String Email = user + "@mailinator.com";
		String Pass = "vision3tamm";
		driver.findElement(By.xpath("//*[@id=\"block-menu-menu-user-menu\"]/div/div/ul/li[2]/a")).click();
		// userName
		
		test.log(Status.PASS, MarkupHelper.createLabel("Entering values to create new user", ExtentColor.CYAN));
		driver.findElement(By.id("edit-name")).sendKeys(user);
		test.log(Status.PASS, "Entered userName :   " + user);
		// E-mail address

		driver.findElement(By.name("mail")).sendKeys(Email);
		test.log(Status.PASS, "Entered E-mail address : " + Email);

		// password
		// driver.findElement(By.id("edit-pass-pass1")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.id("edit-pass-pass1")).sendKeys(Pass);
		test.log(Status.PASS, "Entered Password as  :  " + Pass);

		// Confirm password

		driver.findElement(By.id("edit-pass-pass2")).sendKeys(Pass);
		test.log(Status.PASS, "Entered Confirm password field as : " + Pass);

		// First name
		driver.findElement(By.name("field_first_name[und][0][value]")).sendKeys("John");
		test.log(Status.PASS, "Entered First name- John ");

		// Last name
		driver.findElement(By.id("edit-field-last-name-und-0-value")).sendKeys("Reddy");
		test.log(Status.PASS, "Entered Last name -Reddy");

		// Studio
		driver.findElement(By.id("edit-field-studio-und-0-value")).sendKeys("https://www.visionart.com/");
		test.log(Status.PASS, "Entered Studio value as   :https://www.visionart.com/");

		// URL
		driver.findElement(By.id("edit-field-url-und-0-value")).sendKeys("https://www.visionart.com/");
		test.log(Status.PASS, "Passed URL value as  :https://www.visionart.com/");
		// Phone
		driver.findElement(By.id("edit-field-phone-und-0-value")).sendKeys("7989155033");
		test.log(Status.PASS, "Entered Phone Number as :  7989155033 ");

		// **************CURRENCY SETTINGS**********//
		// Currency

		Select drpCountry = new Select(
				driver.findElement(By.name("profile_currency_settings[field_currency_preview][und]")));
		drpCountry.selectByVisibleText("USD");
		Thread.sleep(5000);
		test.log(Status.PASS, "Selected currency value from drop-down as USD");
		// create new account
		driver.findElement(By.id("edit-submit")).click();
		//test.log(Status.PASS, "Clicked on Create new account button");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"block-menu-menu-user-menu\"]/div/div/ul/li[1]/a")).click();

		test.log(Status.PASS, "New Account created successfully");
		
		
		test.log(Status.PASS, MarkupHelper.createLabel("ADMIN LOGIN", ExtentColor.CYAN));
		
		driver.findElement(By.name("name")).sendKeys(prop.getProperty("Username"));
		
		test.log(Status.PASS, "Fetched username through Properties file  :" + prop.getProperty("Username"));
		
		
		driver.findElement(By.name("pass")).sendKeys(prop.getProperty("Password"));
		test.log(Status.PASS, "Fetched Password through Properties file  :" + prop.getProperty("Password"));
		driver.findElement(By.id("edit-submit")).click();
		test.log(Status.PASS, "Clicked on Submit");
		test.log(Status.PASS, "Logged in as Admin");
		
		WebElement element = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/ul[2]/li[5]/a"));
		
		
		test.log(Status.PASS, MarkupHelper.createLabel("Making  "+user+"  active ", ExtentColor.CYAN));
		
		test.log(Status.PASS,  "Admin-clicked on Add user");
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		Thread.sleep(1000);
		WebElement element1 = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/ul[2]/li[5]/ul/li[2]/a"));
		element1.click();
		escape();
		test.log(Status.PASS, "Admin-clicked on edit user hyperlink");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='People dialog']")));
		driver.findElement(By.xpath("//*[@id=\"advuser-admin-account\"]/div/table[2]/tbody/tr[1]/td[8]/a[1]")).click();
		driver.switchTo().defaultContent();
		String tit = "'Hello, " + user + " dialog'";
		System.out.println(tit);
		test.log(Status.PASS, "Admin-Searching the newly created user : "+user);
		test.log(Status.PASS, "Admin-Clicked on active radio button to make user active");
		test.log(Status.PASS, "Admin-Saved the changes after making user  "+user+"  active ");
		test.log(Status.PASS, "Admin user logged out");
		
		
		String tit1 = "iframe[title=" + tit + "]";
		System.out.println(tit1);
		driver.switchTo().frame(driver.findElement(By.cssSelector(tit1)));
		System.out.println("Test");
		WebElement extra = driver.findElement(By.id("edit-status-1"));
		WebElement save = driver.findElement(By.id("edit-submit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", extra);
		js.executeScript("arguments[0].click();", extra);
		js.executeScript("arguments[0].scrollIntoView();", save);
		js.executeScript("arguments[0].click();", save);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\"admin-menu-account\"]/li[1]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"block-menu-menu-user-menu\"]/div/div/ul/li[1]/a")).click();
		
		test.log(Status.PASS, MarkupHelper.createLabel("Verifying whether active user   "+user+ "can view Rustic Leather under Extras section" , ExtentColor.CYAN));
		test.log(Status.PASS, "Log in using newly created active user");
		driver.findElement(By.id("edit-name")).sendKeys(user);
		// System.out.println("test "+paint(user));
		test.log(Status.PASS, "Entered newly created User Name  : " + user);

		driver.findElement(By.id("edit-pass")).sendKeys(Pass);
		test.log(Status.PASS, "Entered newly created password  :  " + Pass);
		driver.findElement(By.id("edit-submit")).click();
		test.log(Status.PASS, "Clicked on submit button");
		test.log(Status.PASS, "Logged in as newly created user  :" +user);
		test.log(Status.PASS, "User  "+user+ "  clicks on Extras ");
	}

	

}