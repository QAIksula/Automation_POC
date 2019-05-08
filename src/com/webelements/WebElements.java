package com.webelements;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class WebElements {
	public WebDriver d;

	Actions action;

	// *******REGISTER**********

	@FindBy(xpath = "//*[@id=\"block-menu-menu-user-menu\"]/div/div/ul/li[2]/a")
	public WebElement createAccount;

	public void clickCreateAccount() {
		createAccount.click();
	}

	@FindBy(id = "edit-name")
	public WebElement username;

	public void enterUser(String username1) {
		username.sendKeys(username1);
	}

	@FindBy(name = "mail")
	public WebElement mail;

	public void enterMail(String mail1) {
		mail.sendKeys(mail1);
	}

	@FindBy(id = "edit-pass-pass1")
	public WebElement pass;

	public void enterPass(String pass1) {
		pass.sendKeys(pass1);
	}

	@FindBy(id = "edit-pass-pass2")
	public WebElement conpass;

	public void enterConPass(String pass2) {
		conpass.sendKeys(pass2);
	}

	@FindBy(id = "edit-submit")
	public WebElement submit;

	public void clickSubmit() {
		submit.click();
	}

	@FindBy(name = "field_first_name[und][0][value]")
	public WebElement firtName;

	public void enterFirstName(String fn) {
		firtName.sendKeys(fn);
	}

	@FindBy(id = "edit-field-last-name-und-0-value")
	public WebElement lastName;

	public void enterLastName(String ln) {
		lastName.sendKeys(ln);
	}

	@FindBy(id = "edit-field-studio-und-0-value")
	public WebElement studio;

	public void enterStudio(String st) {
		lastName.sendKeys(st);
	}

	@FindBy(id = "edit-field-phone-und-0-value")
	public WebElement phone;

	public void enterPhone(String ph) {
		phone.sendKeys(ph);
	}

	@FindBy(id = "edit-field-url-und-0-value")
	public WebElement url;

	public void enterURL(String url1) {
		lastName.sendKeys(url1);
	}

	@FindBy(name = "profile_currency_settings[field_currency_preview][und]")
	public WebElement currency;

	public void enterCurr() {

		Select drpCountry = new Select(currency);
		drpCountry.selectByVisibleText("USD");

	}

	// *************************Login********************************

	// @FindBy(xpath = "//li[@class='first leaf']")

	@FindBy(xpath = "html/body/div[3]/header/div[1]/div/div/div/div[2]/div/div/ul/li[1]/a")
	public WebElement login;

	public void clickLogin() {
		login.click();
	}

	@FindBy(id = "edit-name")
	public WebElement userLName;

	public void enterFN(String fName) {
		userLName.sendKeys(fName);
	}

	@FindBy(id = "edit-pass")
	public WebElement lPass;

	public void enterlpass(String lp) {
		lPass.sendKeys(lp);
	}

	@FindBy(id = "edit-submit")
	public WebElement Lsub;

	public void clicklSub() {
		Lsub.click();
	}

	@FindBy(xpath = "//*[@id=\"block-menu-menu-user-menu\"]/div/div/ul/li[2]/a")
	public WebElement LOut;

	public void clickLout() {
		LOut.click();
	}

	// **********************My Account*****************************

	@FindBy(xpath = "html/body/div[3]/header/div[1]/div/div/div/div[2]/div/div/ul/li[1]/a")
	WebElement maLogin;

	public void clickmaLogin() {
		maLogin.click();
	}

	@FindBy(name = "name")
	WebElement maName;

	public void enterMName(String mname) {
		maName.sendKeys(mname);
	}

	@FindBy(name = "pass")
	WebElement maPass;

	public void enterMNPass(String mpass) {
		maPass.sendKeys(mpass);
	}

	@FindBy(id = "edit-submit")
	WebElement maSub;

	public void clickmaSub() {
		maSub.click();
	}

	@FindBy(id = "edit-commerce-customer-address-und-0-first-name")
	WebElement maFN;

	public void entermaFN(String mafn) {
		maFN.sendKeys(mafn);
	}

	@FindBy(id = "edit-commerce-customer-address-und-0-last-name")
	WebElement maLN;

	public void entermaLN(String maln) {
		maLN.sendKeys(maln);
	}

	@FindBy(id = "edit-commerce-customer-address-und-0-organisation-name")
	WebElement maCO;

	public void entermaCO(String maco) {
		maCO.sendKeys(maco);
	}

	@FindBy(id = "edit-commerce-customer-address-und-0-thoroughfare")
	WebElement maAD;

	public void entermaAD(String maad) {
		maAD.sendKeys(maad);
	}

	@FindBy(id = "edit-commerce-customer-address-und-0-premise")
	WebElement maAD1;

	public void entermaAD1(String maad1) {
		maAD1.sendKeys(maad1);
	}

	@FindBy(id = "edit-commerce-customer-address-und-0-locality")
	WebElement maAD2;

	public void entermaAD2(String maad2) {
		maAD2.sendKeys(maad2);
	}

	@FindBy(id = "edit-commerce-customer-address-und-0-administrative-area")
	WebElement country;

	public void setmaCountry() {
		Select Country = new Select(country);
		Country.selectByVisibleText("Iowa");
	}

	@FindBy(id = "edit-commerce-customer-address-und-0-postal-code")
	WebElement pincode;

	public void entermaPC(String pc) {
		pincode.sendKeys(pc);
	}

	@FindBy(id = "edit-submit")
	WebElement masubm;

	public void clickmaSubm() {
		masubm.click();
	}

	@FindBy(xpath = "//li[@class='first leaf']")
	WebElement subclick;

	public void subclick() {
		subclick.click();
	}

	@FindBy(linkText = "Address Book")
	WebElement addBook;

	public void clickAddBook() {
		addBook.click();
	}

	@FindBy(linkText = "Add an address")
	WebElement addAdd;

	public void clickaddAdd() {
		addAdd.click();
	}

	@FindBy(xpath = "//ul[@class='tabs primary clearfix']//a[@href='/users/sai']")
	WebElement maAcc;

	public void clickMA() {
		maAcc.click();
	}

	@FindBy(linkText = "Update email/password")
	WebElement updateEmail;

	public void clickUpdateEmail() {
		updateEmail.click();
	}

	@FindBy(id = "edit-field-studio-und-0-value")
	WebElement updateStudio;

	public void updateStudioField(String updatestudio) {
		updateStudio.sendKeys(updatestudio);
	}

	@FindBy(id = "edit-picture-upload")
	WebElement uploadPic;

	public void uploadPic(String uploadpic) {
		updateStudio.sendKeys(uploadpic);
	}

	@FindBy(id = "edit-submit")
	WebElement clickMaSubmit;

	public void clickMASubmit() {
		clickMaSubmit.click();
	}

	@FindBy(id = "edit-picture-delete")
	WebElement clickDelete;

	public void clickDel() {
		clickDelete.click();
	}
	// **********************OrderOtherProduct*****************************

	@FindBy(xpath = "html/body/div[3]/header/div[1]/div/div/div/div[2]/div/div/ul/li[1]/a")
	WebElement oLogin;

	public void clickOlog() {
		oLogin.click();
	}

	@FindBy(id = "edit-name")
	WebElement oName;

	public void enterOName(String oname) {
		oName.sendKeys(oname);
	}

	@FindBy(id = "edit-pass")
	WebElement oPass;

	public void enterOPass(String opass) {
		oPass.sendKeys(opass);
	}

	@FindBy(id = "edit-submit")
	WebElement oSub;

	public void enterOSub() {
		oSub.click();
	}

	@FindBy(xpath = "//li[@class='menu-5270 last']//a[@class='menu-right']")
	WebElement oOrder;

	public void clickOorder() {
		oOrder.click();
	}

	@FindBy(xpath = "//div[@class='order_col order-others']//h4")
	WebElement oOtherOrder;

	public void clickOtherorder() {
		oOtherOrder.click();
	}

	@FindBy(className = "add-folio")
	WebElement oFolio;

	public void clickFolio() {
		oFolio.click();
	}

	@FindBy(xpath = "//li[@size='5x7']")
	WebElement oSize;

	public void clickOSize() {
		oSize.click();
	}

	@FindBy(xpath = "//div[@class='picker zone02']")
	WebElement oCover;

	public void clickOCover() {
		oCover.click();
	}

	@FindBy(xpath = "//div[@class='swatch-menu']//label[@for='premium-leather']")
	public WebElement oCategory1;

	public void selCat1() {

		oCategory1.click();

	}

	@FindBy(xpath = "//section[@class='swatch-selection option-box open zone02']//li[@class='premium-leather']")
	public WebElement oCategory2;

	public void selCat2() {

		oCategory2.click();

	}

	@FindBy(xpath = "//label[@class='include-print-options-yes']")
	public WebElement oPrint;

	public void clickPrint() {

		oPrint.click();

	}

	@FindBy(xpath = "//div[@class='imprint-options-button button button-clear']")
	public WebElement oDeboss;

	public void clickDeboss() {

		oDeboss.click();

	}

	@FindBy(xpath = "//div[@class='add-stamp-button button button-clear']")
	public WebElement oStamp;

	public void clickStamp() {

		oStamp.click();

	}

	@FindBy(xpath = "//div[@class='select-wrapper']//option[@value='IM-B-6x2']")
	public WebElement oRemove;

	public void clickRemove() {

		oRemove.click();

	}

	@FindBy(xpath = "//div[@class='emboss-picker']//div[@currentmaterial='Choose Color']")
	public WebElement oChoose;

	public void clickChoose() {

		oChoose.click();

	}

	@FindBy(xpath = "/html/body/div[3]/section/div/div/div/div/div/div/div/div[3]/ul[2]/li[2]/ul/li[2]/ul/li[2]/ul/li[3]/section/div[5]/ul/li[1]/div[2]/ul/li[11]/span[2]")
	public WebElement color;

	public void clickColor() {
		color.click();
	}

	@FindBy(xpath = "//div[@class='emboss-picker']//div[@class='material-name button-clear']")
	public WebElement oBlind;

	public void clickBlind() {
		oBlind.click();

	}

	@FindBy(xpath = "/html/body/div[3]/section/div/div/div/div/a[2]")
	public WebElement cancelorder;

	public void cancelOrder() {
		cancelorder.click();
	}

	@FindBy(xpath = ".//*[@id='va-submit-order']")
	public WebElement oSubmit;

	public void clickOSub() {
		oSubmit.click();

	}

	@FindBy(xpath = "//*[@id=\"region-content\"]/div/a[2]")
	public WebElement canorder;

	public void canOrder() {
		canorder.click();
	}

	// ***************Orderpage2************

	@FindBy(xpath = "html/body/div[3]/header/div[1]/div/div/div/div[2]/div/div/ul/li[1]/a")
	public WebElement pLogin;

	public void clickPlogin() {
		pLogin.click();

	}

	@FindBy(id = "edit-name")
	public WebElement opName;

	public void clickOPname(String OPName) {
		opName.sendKeys(OPName);

	}

	@FindBy(id = "edit-pass")
	public WebElement oppass;

	public void clickOPpass(String OPpass) {
		oppass.sendKeys(OPpass);

	}

	@FindBy(id = "edit-submit")
	public WebElement opsub;

	public void clickOPsub() {
		opsub.click();

	}

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[6]/li[3]/a")
	public WebElement opOrder;

	public void clickOPorder() {
		opOrder.click();

	}

	@FindBy(xpath = "//*[@id=\"build-form\"]/div[1]/div[1]/h4")
	public WebElement opBook;

	public void clickOBooks() {
		opBook.click();

	}

	@FindBy(name = "event-name")
	public WebElement opEvent;

	public void clickOEvent(String opevent) {
		opEvent.sendKeys(opevent);

	}

	@FindBy(xpath = "//li[@size='10x8']")
	public WebElement opSize;

	public void clickOPSize() {
		opSize.click();

	}

	@FindBy(xpath = "//div[@class='picker zone02 full']")
	public WebElement opCat1;

	public void clickOPCat1() {
		opCat1.click();

	}

	@FindBy(xpath = "//*[@id=\"accordion\"]/li[86]/img")
	WebElement hovver;

	public void hover() throws Exception {
		Actions actionRustic = new Actions(d);
		actionRustic.moveToElement(hovver);
		Thread.sleep(3000);
		actionRustic.click(hovver);
		Thread.sleep(3000);
		actionRustic.release(hovver);
		Thread.sleep(3000);
		actionRustic.build().perform();
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//label[@for='premium-leather']")
	public WebElement opCat2;

	public void clickOPCat2() {
		opCat2.click();

	}

	@FindBy(xpath = "//*[@id=\"stage02\"]/li[2]/ul/li[2]/ul/li[2]/ul/li[2]/div/div")
	public WebElement opendsheet;

	public void clickOPEndsheet() {
		opendsheet.click();

	}

	@FindBy(xpath = "//*[@id=\"stage02\"]/li[2]/ul/li[2]/ul/li[2]/ul/li[2]/div/ul/li[1]/img")
	public WebElement opendcolor;

	public void clickOPEndCol() {
		opendcolor.click();

	}

	@FindBy(xpath = "//*[@id=\"stage02\"]/li[2]/ul/li[2]/ul/li[2]/ul/li[4]/div")
	public WebElement openshow;

	public void clickOPShow() {
		openshow.click();

	}

	@FindBy(xpath = "//*[@id=\"stage02\"]/li[2]/ul/li[2]/ul/li[2]/ul/li[4]/section/div[5]/ul/li/div")
	public WebElement openstamp;

	public void clickOPStamp() {

		System.out.println("Open stamp");
		openstamp.click();

	}

	@FindBy(xpath = "//*[@id=\"stage02\"]/li[2]/ul/li[2]/ul/li[2]/ul/li[4]/section/div[5]/ul/li[1]/div[2]/div")
	public WebElement openremove;

	public void clickOPRemove() {
		openremove.click();
		System.out.println("Open remove");
	}

	@FindBy(xpath = "//*[@id=\"stage02\"]/li[2]/ul/li[2]/ul/li[2]/ul/li[4]/section/div[5]/ul/li[1]/div[2]/ul/li[3]/span[2]")
	public WebElement opButton;

	public void clickOPButton() {
		System.out.println("Color selection");
		opButton.click();

	}

	@FindBy(xpath = "//*[@id=\"stage02\"]/li[2]/ul/li[2]/ul/li[2]/ul/li[4]/section/div[2]")
	public WebElement opClose;

	public void clickOPClose() {

		System.out.println("close");
		opClose.click();

	}

	@FindBy(id = "va-submit-order")
	public WebElement opSubm;

	public void clickOPSubm() {
		opSubm.click();

	}

	@FindBy(xpath = "//*[@id=\"stage01\"]/li[4]/form/label[1]")
	WebElement orderYes;

	public void clickYes() {
		orderYes.click();
	}

	@FindBy(xpath = "//*[@id=\"stage01\"]/li[5]/form/label[1]")
	WebElement ordertype;

	public void clickRadio() {
		/*
		 * action = new Actions(d);
		 * action.moveToElement(orderYes).click(orderYes).build().perform();
		 */
		ordertype.click();

	}

	@FindBy(xpath = "//*[@id=\"stage01\"]/li[6]/div[1]/span[1]/input")
	WebElement spreadSheet;

	public void clickRadioSpread() throws Exception {
		spreadSheet.click();
		spreadSheet.sendKeys("10" + Keys.ENTER);
		Thread.sleep(3000);
		spreadSheet.click();

	}

	@FindBy(xpath = "//*[@id=\"format-picker\"]/ul/li[2]/div/span")
	WebElement Layout;

	public void enterLayout() throws Exception {

		/*
		 * WebDriverWait wait = new WebDriverWait(d, 80); WebElement element =
		 * wait.until(ExpectedConditions.visibilityOf(Layout));
		 */
		System.out.println("testtttt");
		Thread.sleep(10000);
		Layout.click();
	}

	@FindBy(id = "edit-back")
	WebElement editback;

	public void goBack() {
		editback.click();
	}

	@FindBy(xpath = "//*[@id=\"region-content\"]/div/a[2]")
	WebElement cancelOrder;

	public void cancelOrder1() {
		cancelOrder.click();
	}
	// *****************Order Swatchbook**********************************

	@FindBy(xpath = "html/body/div[3]/header/div[1]/div/div/div/div[2]/div/div/ul/li[1]/a")
	public WebElement osLogin;

	public void clickOSLog() {
		osLogin.click();

	}

	@FindBy(name = "name")
	WebElement osUser;

	public void setOsUser(String osuser) {
		osUser.sendKeys(osuser);
	}

	@FindBy(id = "edit-pass")
	WebElement osPass;

	public void setOsPass(String ospass) {
		osPass.sendKeys(ospass);
	}

	@FindBy(id = "edit-submit")
	WebElement osSub;

	public void clickOsSub() {
		osSub.click();
	}

	@FindBy(xpath = "//li[@class='menu-5270 last']//a[@class='menu-right']")
	WebElement osOrder;

	public void clickOsOrder() {
		osOrder.click();
	}

	@FindBy(xpath = "//div[@class='order_col order-others']")
	WebElement osOtherOrder;

	public void clickOSOtherOrder() {
		osOtherOrder.click();
	}

	@FindBy(xpath = "//li[@class='add-swatchbook']")
	WebElement osSwatch;

	public void clickOSSwatch() {
		osSwatch.click();
	}

	@FindBy(xpath = "//*[@id=\"stage02\"]/li[2]/ul/li[2]/ul/li[10]/img")
	WebElement osImg;

	public void clickOSImg() {

		Actions action = new Actions(d);

		action.sendKeys(Keys.PAGE_DOWN);
		action.moveToElement((WebElement) osImg).build().perform();
		osImg.click();

	}

	@FindBy(xpath = "//*[@id=\"va-submit-order\"]")
	WebElement osSubmit;

	public void clickOSSubmit() {
		osSubmit.click();
	}

	@FindBy(name = "value")
	WebElement swatchqty;

	public void enterQty(String qty) {
		swatchqty.clear();
		swatchqty.sendKeys(qty);
	}

	// ******************Billing***********************
	@FindBy(id = "edit-customer-profile-billing-commerce-customer-address-und-0-organisation-name")
	WebElement bCompany;

	public void selectCompany(String bcompany) {
		bCompany.sendKeys(bcompany);
	}

	@FindBy(id = "edit-customer-profile-billing-commerce-customer-address-und-0-premise")
	WebElement bAdd2;

	public void selectBAdd2(String badd2) {
		bAdd2.sendKeys(badd2);
	}

	@FindBy(id = ".//*[@id='edit-customer-profile-shipping-commerce-customer-address-und-0-organisation-name']")
	WebElement bShipInfo;

	public void selectShipInfo(String shipinfo) {
		bShipInfo.sendKeys(shipinfo);
	}

	@FindBy(id = "edit-customer-profile-shipping-commerce-customer-address-und-0-premise")
	WebElement bShipInfo1;

	public void selectShipInfo1(String shipinfo1) {
		bShipInfo1.sendKeys(shipinfo1);
	}

	@FindBy(xpath = "//*[@id=\"edit-commerce-coupon-coupon-code\"]")
	WebElement bCoupon;

	public void selectCoupon(String bcoupon) {

		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].scrollIntoView();", bCoupon);
		bCoupon.sendKeys(bcoupon);

	}

	@FindBy(id = "edit-continue")
	WebElement bContinue;

	public void selectContinue() {
		bContinue.click();
	}

	@FindBy(id = "edit-commerce-shipping-shipping-service-20-us-2nd-day")
	WebElement shipservice;

	public void clickshipSer() {
		shipservice.click();
	}

	@FindBy(id = "edit-commerce-payment-payment-method-authnet-aimcommerce-payment-authnet-aim")
	WebElement bCredit;

	public void selectCredit() {
		bCredit.click();
	}

	@FindBy(id = "edit-commerce-payment-payment-details-credit-card-type")
	WebElement bCardType;

	public void selectCardType() {
		Select cardtype = new Select(bCardType);
		cardtype.selectByVisibleText("Visa");
	}

	@FindBy(id = "edit-commerce-payment-payment-details-credit-card-number")
	WebElement bCardNum;

	public void selectCardNum(String cardno) {
		bCardNum.sendKeys(cardno);
	}

	@FindBy(id = "edit-commerce-payment-payment-details-credit-card-code")
	WebElement bSecCode;

	public void selectSecurityCode(String bsec) {
		bSecCode.sendKeys(bsec);
	}

	// ***************Admin1************************

	@FindBy(xpath = "html/body/div[3]/header/div[1]/div/div/div/div[2]/div/div/ul/li[1]/a")
	WebElement AdLogin;

	public void adLog() {
		AdLogin.click();
	}

	@FindBy(name = "name")
	WebElement AdName;

	public void enterAdminNAme(String adname) {
		AdName.sendKeys(adname);
	}

	@FindBy(name = "pass")
	WebElement AdPass;

	public void enterAdminPass(String adpass) {
		AdPass.sendKeys(adpass);
	}

	@FindBy(xpath = "html/body/div[3]/section/div/div/div/div/div/div/div/form/div/div[1]/div[3]/input")
	WebElement AdSub;

	public void clickAdSub() {
		AdSub.click();
	}

	@FindBy(xpath = "/html/body/div[5]/div/div/div/ul[2]/li[2]/a")
	WebElement AdStr;

	public void clickAdStr() {
		AdStr.click();
		Actions action = new Actions(d);
		action.moveToElement(AdStr).build().perform();
	}

	@FindBy(xpath = "/html/body/div[5]/div/div/div/ul[2]/li[2]/ul/li[15]/a")
	WebElement AdTax;

	public void clickAdTax() {
		AdTax.click();
	}

	@FindBy(id = "edit-5-list")
	WebElement AdMat;

	public void clickAdMat() {
		AdMat.click();
	}

	@FindBy(id = "edit-tid110-edit")
	WebElement ADPrem;

	public void clickADPrem() {
		ADPrem.click();
	}

	@FindBy(xpath = "//*[@id=\\\"admin-menu-account\\\"]/li[1]/a")
	WebElement AdLog;

	public void clickAdLog() {
		AdLog.click();
	}

	@FindBy(xpath = "//*[@id=\\\"main-menu\\\"]/li[3]/a")
	WebElement AdExtra;

	public void clickAdExtra() {
		AdExtra.click();
	}

	@FindBy(xpath = "//*[@id=\\\"block-menu-menu-user-menu\\\"]/div/div/ul/li[2]/a")
	WebElement AdCreateAcc;

	public void clickCreateacc() {
		AdCreateAcc.click();
	}

	@FindBy(id = "edit-name")
	WebElement AD1Name;

	public void clickAd1Name(String ad1name) {
		AD1Name.sendKeys(ad1name);
	}

	public void setvalue(String x) {
		AD1Name.sendKeys(x);
	}

	// *******************Common Method********************
	public void scrollDown() {
		for (int i = 0; i < 1; i++) {
			Actions action = new Actions(d);
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
		}
	}

	public void scrollToElement(WebElement webElement) {
		Actions action = new Actions(d);

		action.sendKeys(Keys.PAGE_DOWN);
		action.moveToElement((WebElement) webElement).build().perform();

	}

	public void scrollDown(WebElement webElement) {
		Actions action = new Actions(d);

		action.sendKeys(Keys.ARROW_DOWN);
		action.moveToElement((WebElement) webElement).build().perform();

	}

	public void arrowDownElement(WebElement choosecolor) {
		Actions action = new Actions(d);

		action.sendKeys(Keys.ARROW_DOWN);
		action.moveToElement((WebElement) choosecolor).build().perform();
	}

	public void arrowUPElement(WebElement webElement) {
		Actions action = new Actions(d);

		action.sendKeys(Keys.ARROW_UP);
		action.moveToElement((WebElement) webElement).build().perform();

	}

	public void pageDown(WebElement element) {
		for (int i = 0; i < 5; i++) {
			Actions action = new Actions(d);

			action.sendKeys(Keys.PAGE_DOWN);
			action.moveToElement(element);
			if (element.isDisplayed()) {
				action.click(element).build().perform();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else
				System.out.println("Element is not visible Page Down");
		}
	}

	public void actionUp(WebElement element) {
		Actions action = new Actions(d);

		for (int i = 0; i < 2; i++) {
			action.sendKeys(Keys.PAGE_UP);
			action.moveToElement(element);
			if (element.isDisplayed()) {
				action.click(element).build().perform();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else
				System.out.println("Element is not visible Page Up");
		}
	}

	public String randomUser() {
		Random random = new Random();
		user = "Testing" + random.nextInt(100000);
		return user;
	}

	String user;

	public String randomEmail() {
		String Email = user + "@mailinator.com";
		return Email;
	}

	public String randomPW() {
		String password = user + 123;
		return password;
	}

	public void escape() {
		Actions action = new Actions(d);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}

	public WebElements(WebDriver driver) {
		d = driver;
		PageFactory.initElements(d, this);
	}

}
