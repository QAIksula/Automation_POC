package com.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Elements {

	// register

	public WebDriver d;

	// **************************register
	// page***************************************

	@FindBy(xpath = ".//*[@id='block-menu-menu-user-menu']/div/div/ul/li[2]/a")
	public WebElement createAccount;

	@FindBy(id="edit-name")
	public WebElement userName;

	@FindBy(xpath = "(//input[@class='form-text required'])[1]")
	public WebElement emailAddress;

	@FindBy(xpath = "//input[@id='edit-pass-pass1']")
	public WebElement passWord;

	@FindBy(xpath = "//input[@id='edit-pass-pass2']")
	public WebElement confirmPassword;

	@FindBy(xpath = "//input[@id='edit-field-first-name-und-0-value']")
	public WebElement firstName;

	@FindBy(xpath = "//input[@id='edit-field-last-name-und-0-value']")
	public WebElement lastName;

	@FindBy(xpath = "//input[@id='edit-field-studio-und-0-value']")
	public WebElement studio;

	@FindBy(xpath = "(//input[@class='form-text required'])[1]")
	public WebElement URL;

	@FindBy(xpath = "//input[@id='edit-field-phone-und-0-value']")
	public WebElement Phone;

	@FindBy(xpath = ".//select[@id='edit-profile-currency-settings-field-currency-preview-und']/option[3]")
	public WebElement currency;

	@FindBy(id = "edit-submit")
	public WebElement elementCreateAccount;

	// ************************login***********************************

	@FindBy(xpath = "//a[text()='Log in']")
	public WebElement Login;

	@FindBy(id = "edit-name")
	public WebElement LoginuserName;

	@FindBy(id = "edit-pass")
	public WebElement LoginpassWord;

	@FindBy(id = "edit-submit")
	public WebElement loginButton;

	// **********************HeaderPages*****************************

	@FindBy(xpath = "//a[text()='The Books']")
	public WebElement theBook;

	@FindBy(xpath = "//a[text()='Getting started']")
	public WebElement gettingStarted;

	@FindBy(xpath = "//a[text()='Extras']")
	public WebElement Extras;

	@FindBy(xpath = "//a[text()='Materials']")
	public WebElement Materials;

	@FindBy(xpath = "//a[text()='The Messenger']")
	public WebElement theMessenger;

	// *********************************************OrderSwatchbook*******************************

	@FindBy(xpath = "html/body/div[4]/header/div[3]/div/div/div/nav/div[1]/ul/li[6]/li[3]/a")
	public WebElement orderSwatchbooks;

	@FindBy(xpath = ".//*[@class='order-swatchbooks']/a")
	public WebElement order;

	@FindBy(xpath = ".//*[@class='swatch-option button-clear']/img)[1]")
	public WebElement clickOnimage;

	@FindBy(xpath = "html/body/div[4]/section/div/div/div/div/div/div/div/div[3]/ul[4]/li[13]/div/div[1]")
	public WebElement subElement;

	@FindBy(xpath = ".//*[@id='rush-checkbox']")
	public WebElement clickOncheckboxRush;

	// Billing information

	@FindBy(id = "edit-customer-profile-billing-commerce-customer-address-und-0-organisation-name")
	public WebElement company;

	@FindBy(id = "edit-customer-profile-billing-commerce-customer-address-und-0-premise")
	public WebElement address2;

	// Shipping information

	@FindBy(xpath = ".//*[@id='edit-customer-profile-shipping-commerce-customer-address-und-0-organisation-name']")
	public WebElement Shippingcompany;

	@FindBy(id = "edit-customer-profile-shipping-commerce-customer-address-und-0-premise")
	public WebElement Shippingaddress;

	@FindBy(id = "edit-commerce-coupon-coupon-code")
	public WebElement coupons;

	@FindBy(id = "edit-continue")
	public WebElement continueTonextStep;

	@FindBy(id = "edit-back")
	public WebElement goBack;

	// ****Review order*******
	@FindBy(id = "edit-commerce-payment-payment-method-authnet-aimcommerce-payment-authnet-aim")
	public WebElement creditCard;

	@FindBy(id = "edit-commerce-payment-payment-details-credit-card-type")
	public WebElement cardType;

	@FindBy(id = "edit-commerce-payment-payment-details-credit-card-number")
	public WebElement cardNumber;

	@FindBy(id="edit-commerce-payment-payment-details-credit-card-code")
	public WebElement securityCode;
	@FindBy(id ="edit-commerce-payment-payment-details-credit-card-type")
	public WebElement reviewOrdercontinueTonextStep;
	
	@FindBy(id ="edit-commerce-payment-payment-details-credit-card-type")
	public WebElement reviewOrderGoback ;
	
	

	// *******************************Orderpage***************************************

	// clickonorder

	@FindBy(xpath = "html/body/div[4]/header/div[3]/div/div/div/nav/div[1]/ul/li[6]/li[3]/a")
	public WebElement clickOnorder;

	@FindBy(name = "event-name")
	public WebElement enterEventname;

	@FindBy(xpath = ".//*[@id='stage01']/li[3]/form/label[1]")
	public WebElement orderingAbook;

	@FindBy(xpath = "html/body/div[4]/section/div/div/div/div/div/div/div/div[3]/ul[1]/li[4]/form/label[1]")
	public WebElement whatTypeofBookwillYoubeOrdering;

	@FindBy(xpath = ".//*[@id='stage01']/li[5]/div[1]/span[1]/a[1]/span/span")
	public WebElement HowmanySpreadsdoesYourdesignHave;

	@FindBy(className = "layout-Horizontal")
	public WebElement whatLayoutisyourDesign;

	@FindBy(xpath = ".//*[@id='stage02']/li[2]/ul/li[1]/ul/ul/li[4]")
	public WebElement SelectAsize;

	@FindBy(xpath = ".//*[@id='stage02']/li[2]/ul/li[2]/ul/li[2]/ul/li[1]/form/label[1]")
	public WebElement coverStyle;

	// constructor

	public Elements(WebDriver driver) {
		d = driver;
		PageFactory.initElements(d, this);
	}

	// ************methods************

	public void clickRegisterMenu() {
		createAccount.click();
	}

	public void userName(String strUser) {
		userName.click();
		userName.sendKeys(strUser);
	}

	public void emailAddress(String strEmail) {
		emailAddress.click();
		emailAddress.sendKeys(strEmail);
	}

	public void passWord(String strpassWord) {
		passWord.click();
		passWord.sendKeys(strpassWord);
	}

	public void confirmPassword(String strConfirmpassword) {
		confirmPassword.click();
		confirmPassword.sendKeys(strConfirmpassword);
	}

	public void firstName(String strFirstName) {
		firstName.click();
		firstName.sendKeys(strFirstName);
	}

	public void lastName(String strlastName) {
		lastName.click();
		lastName.sendKeys(strlastName);
	}

	public void Studio(String strStudio) {
		studio.click();
		studio.sendKeys(strStudio);
	}

	public void URL(String strURL) {
		studio.click();
		studio.sendKeys(strURL);
	}

	public void Phone(String strPhone) {
		Phone.click();
		Phone.sendKeys(strPhone);
	}

	public void Currency(String strCurrency) {
		Select drpCountry = new Select(currency);
		drpCountry.selectByVisibleText(strCurrency);
	}

	public void registerUser() {
		elementCreateAccount.click();
	}

	// ********login********

	public void clickLoginMenu() {
		Login.click();
	}

	public void loginUsername(String strLoginuserName) {
		userName.sendKeys(strLoginuserName);
	}

	public void loginPassword(String strLoginPassword) {
		passWord.sendKeys(strLoginPassword);
	}

	public void Loginbutton() {
		loginButton.click();
	}

	// **********************HeaderPages*****************************

	public void theBook(String strThebook) {
		theBook.sendKeys(strThebook);
	}

	public void gettingStarted(String strGettingStarted) {
		gettingStarted.sendKeys(strGettingStarted);
	}

	public void Extras(String strExtras) {
		Extras.sendKeys(strExtras);
	}

	public void Materials(String strMaterials) {
		Materials.sendKeys(strMaterials);
	}

	public void theMessenger(String strThemessenger) {
		theMessenger.sendKeys(strThemessenger);
	}

	// *********************************************OrderSwatchbook*******************************

	public void orderSwatchbooks(String strOrderswatchbooks) {
		orderSwatchbooks.sendKeys(strOrderswatchbooks);
	}

	public void clickOnimage(String strClickonimage) {
		clickOnimage.sendKeys(strClickonimage);
	}

	public void subElement(String strSubelement) {
		subElement.sendKeys(strSubelement);
	}

	public void clickOncheckboxRush(String strClickOnCheckboxRush) {
		clickOncheckboxRush.sendKeys(strClickOnCheckboxRush);
	}

	public void company(String strCompany) {
		company.sendKeys(strCompany);
	}

	public void address2(String strAddress2) {
		address2.sendKeys(strAddress2);
	}

	public void Shippingcompany(String strShippingcompany) {
		Shippingcompany.sendKeys(strShippingcompany);
	}

	public void Shippingaddress(String strShippingaddress) {
		Shippingaddress.sendKeys(strShippingaddress);
	}

	public void coupons(String strCoupons) {
		coupons.sendKeys(strCoupons);
	}

	public void continueTonextStep(String strContinuetonextStep) {
		continueTonextStep.sendKeys(strContinuetonextStep);
	}

	public void goBack(String strGoback) {
		goBack.sendKeys(strGoback);
	}

	// *******************************Orderpage***************************************

	public void clickOnorder(String strClickonOrder) {
		clickOnorder.sendKeys(strClickonOrder);
	}

	public void enterEventname(String strEntereventName) {
		enterEventname.sendKeys(strEntereventName);
	}

	public void orderingAbook(String strOrderingaBook) {
		orderingAbook.sendKeys(strOrderingaBook);
	}

	public void whatTypeofBookwillYoubeOrdering(String strWhattypeOfbookWillyouBeordering) {
		whatTypeofBookwillYoubeOrdering.sendKeys(strWhattypeOfbookWillyouBeordering);
	}

	public void HowmanySpreadsdoesYourdesignHave(String strHowmanySpreadsdoesYourdesignHave) {
		HowmanySpreadsdoesYourdesignHave.sendKeys(strHowmanySpreadsdoesYourdesignHave);
	}

	public void whatLayoutisyourDesign(String strwhatLayoutisyourDesign) {
		whatLayoutisyourDesign.sendKeys(strwhatLayoutisyourDesign);
	}

	public void SelectAsize(String strSelectAsize) {
		SelectAsize.sendKeys(strSelectAsize);
	}

	public void coverStyle(String strCoverstyle) {
		coverStyle.sendKeys(strCoverstyle);
	}
}
