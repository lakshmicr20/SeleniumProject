package com.FinalSelenium.Utilities;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtilities

{
	public WebDriver driver;
	Select select;
	Actions actions;
	public PageUtilities(WebDriver driver)
	{
		this.driver=driver;
	}
	public void implicityWait()
	{ 
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public WebElement waitForElementTobeVisible(WebElement elementToBeLoaded, int Time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Time);
		WebElement element=wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
		return element;
	}
	public WebElement waitForElementTobeClickable(WebElement elementToBeLoaded, int Time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Time);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(elementToBeLoaded));
		return element;
	}
	public Alert waitForAlert(int Time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Time);
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}
	public void hitenter(WebElement element)
	{
		element.sendKeys(Keys.ENTER);
	}
	public void sendTestUsingMouseActions(WebElement element, String text)
	{
		Actions action=new Actions(driver);
		action.sendKeys(element,text).build().perform();		
	}
    
    public String catchAlert()
    {
    	Alert obj=driver.switchTo().alert();
    	String s=obj.getText();
    	obj.dismiss();
    	return s;
    }
    public void scroll(WebElement element)
    {
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
	public void clearTextField(WebElement element)
	{
		element.clear();
	}
	public void select_selectByIndex(WebElement element,int index)
	{
		select=new Select(element);
		select.selectByIndex(index);
	}
	public void select_selectByVisibleText(WebElement element,String text)
	{
		select=new Select(element);
		select.selectByVisibleText(text);
	}
	public void select_selectByValue(WebElement element,String value)
	{
		select=new Select(element);
		select.selectByValue(value);
	}
	public void select_selectAllOptions(WebElement element,String value)
	{
		select=new Select(element);
		select.getAllSelectedOptions();
	}
	
	public void moveToElement(WebElement element)
	{
		actions=new Actions(driver);
		actions.moveToElement(element);
		actions.build().perform();
		
	}
	public void rightClick(WebElement element)
	{
		actions=new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	public void doubleclick(WebElement element)
	{
		actions=new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	public void DragandDrop(WebElement source, WebElement target) {
		actions = new Actions(driver);
		actions.dragAndDrop(source, target);
	}
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	public String getAlertText()
	{
		return driver.switchTo().alert().getText();
		
	}
	public void dismissAlert()
	{
		driver.switchTo().alert().dismiss();
	}
	public void switch_To_Frame_by_Name(String name) {
		driver.switchTo().frame(name);
	}
	public void fileUpload(WebElement element, String path) {

		element.sendKeys(path);
	}
	public boolean isElementPresent(String xpath)
	{
		try {
			WebElement element=driver.findElement(By.xpath(xpath));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void scroll_By(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}
	public void scroll_into_View(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void Click(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	public void pageRefresh()
	{
		driver.navigate().refresh();
	}
	public boolean checkClickstatus(WebElement element) {
		try {
		element.click();
		return false;

		} catch (Exception e) {

		return true;
		}

		}

		public void scrollAndclick(WebElement element) {
		int x = 0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		while(checkClickstatus(element))
		{
		js.executeScript("window.scrollBy(0," + x + ")");
		x=x+50;
		}
		}

}
