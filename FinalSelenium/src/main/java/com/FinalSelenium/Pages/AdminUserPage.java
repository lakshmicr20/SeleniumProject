package com.FinalSelenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FinalSelenium.Utilities.ExcelUtility;
import com.FinalSelenium.Utilities.GeneralUtilities;
import com.FinalSelenium.Utilities.PageUtilities;
public class AdminUserPage {
	WebDriver driver;
	GeneralUtilities utility;
	PageUtilities pageutility;
	ExcelUtility excel=new ExcelUtility();
	
	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement adminUsersButton;
	@FindBy(xpath = "(//i[@class='fas fa-edit'])[1]")
	private WebElement newButton;
	@FindBy(id="username")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeOption;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;
	@FindBy(xpath="(//i[@class='fas fa-edit'])[10]")
	private WebElement editButton;
	@FindBy(xpath="//button[@name='Update']")
	private WebElement updateButton;
	@FindBy (xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement updateSuccessAlert;
	

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAdminUser() {
		adminUsersButton.click();
	}

	public void clickNewButton() {
		newButton.click();
	}

	public void clearAllFields() {
		usernameField.clear();
		passwordField.clear();
	}

	public void enterUserName(String UserName) {
		usernameField.sendKeys(UserName+utility.get_TimeStamp());
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickUpdateButton() {
       updateButton.click();
	}

	public void selectUserType(String userType) {
		pageutility = new PageUtilities(driver);
		if (userType.equalsIgnoreCase("staff")) {
			pageutility.select_selectByVisibleText(userTypeOption, "Staff");
		} else if (userType.equals("Admin")) {
			pageutility.select_selectByVisibleText(userTypeOption, "Admin");
		} else if (userType.equals("Partner")) {
			pageutility.select_selectByVisibleText(userTypeOption, "Partner");
		} else if (userType.equals("Delivery Boy")) {
			pageutility.select_selectByVisibleText(userTypeOption, "Delivery Boy");
		}

	}

	public String createNewAdminUser(String excelFile, String excelSheet) {
		utility = new GeneralUtilities(driver);
		pageutility = new PageUtilities(driver);
		excel.setExcelFile(excelFile, excelSheet);
		String userName = excel.getCellData(0, 0);
		String password = excel.getCellData(0, 1);
		String userType = excel.getCellData(0, 2);
		clickAdminUser();
		clickNewButton();
		enterUserName(userName);
		enterPassword(password);
		selectUserType(userType);
		saveButton.click();
		return utility.getTextOfElement(successAlert);

	}
	public String updateUserprofile(String excelFile, String excelSheet) {
		utility = new GeneralUtilities(driver);
		pageutility = new PageUtilities(driver);
		excel.setExcelFile(excelFile, excelSheet);
		String userName = excel.getCellData(1, 0);
		clickAdminUser();
		pageutility.scrollAndclick(editButton);
		usernameField.clear();
		enterUserName(userName);
		clickUpdateButton();
		return utility.getTextOfElement(updateSuccessAlert);
	}

}
