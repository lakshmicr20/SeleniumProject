package com.FinalSelenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FinalSelenium.Utilities.ExcelUtility;
import com.FinalSelenium.Utilities.GeneralUtilities;
import com.FinalSelenium.Utilities.PageUtilities;

public class LoginPage {
	WebDriver driver;
	ExcelUtility excel = new ExcelUtility();
	GeneralUtilities utility;
	PageUtilities pageutility;
	
	@FindBy(xpath = "//input[@name='username']")
	@CacheLookup
	private WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	private WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	@CacheLookup
	private WebElement signinButton;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	private WebElement profileImage;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement invalidAlertMessage;
	@FindBy (xpath="//i[@class='ace-icon fa fa-power-off']")
	private WebElement logoutButton;
	@FindBy (xpath="//p[@class='login-box-msg']")
	private WebElement loginInMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String UserName) {
		usernameField.clear();
		usernameField.sendKeys(UserName);
	}

	public void enterPassWord(String passWord) {
		passwordField.clear();
		passwordField.sendKeys(passWord);
	}

	public void clickOnLoginButton() {
		signinButton.click();
	}

	public void login(String userName, String password) {

		enterUserName(userName);
		enterPassWord(password);
		clickOnLoginButton();
	}
	public void clickOnLogoutButton()
	{
		logoutButton.click();
	}

	public void login() {
		utility = new GeneralUtilities(driver);
		excel.setExcelFile("LoginData", "ValidLoginCredentials");
		String userName = excel.getCellData(1, 0);
		String password = excel.getCellData(1, 1);
		enterUserName(userName);
		enterPassWord(password);
		clickOnLoginButton();
		
	}

	public String getInvalidLoginErrorMessage() {
		
		utility = new GeneralUtilities(driver);
		excel.setExcelFile("LoginData", "InvalidLoginCredentials");
		String userName = excel.getCellData(0, 0);
		String password = excel.getCellData(0, 1);
		login(userName, password);
		System.out.println(utility.getTextOfElement(invalidAlertMessage));
		return utility.getTextOfElement(invalidAlertMessage);
	}

	public boolean getLoginStatus() {
		utility = new GeneralUtilities(driver);
		return utility.isElementDisplayed(profileImage);

	}
	
	
	public String getLoginInMessage()
	{
		utility = new GeneralUtilities(driver);
		pageutility=new PageUtilities(driver);
		pageutility.Click(logoutButton);
		return utility.getTextOfElement(loginInMessage);
	}


}
