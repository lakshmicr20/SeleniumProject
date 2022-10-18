package com.FinalSelenium.Utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtilities {
	WebDriver driver;

	public GeneralUtilities(WebDriver driver) {
		this.driver = driver;

	}

	public String getTextOfElement(WebElement element) {
		return element.getText();
	}

	public boolean isElementtextMatches(String expectedtext, WebElement element) {
		return element.getText().equals(expectedtext);

	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public String get_AttributeOfElement(String attribute,WebElement element) {
		return element.getAttribute(attribute);

	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	public String get_CurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	public List<String> getTextOfElements(String xpath) 
	 {
		 List<String>text=new ArrayList<String>();
		 List<WebElement>elements=driver.findElements(By.xpath(xpath));
		 for(WebElement web:elements)
		 {
			 text.add(web.getText());
		 }
		 return text;
	 }


	public String getCssSelectorValue(WebElement element,String property) {
		return element.getCssValue(property);
	}
	public String get_TimeStamp()
	{
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm").format(new Date());
		return timeStamp;
	}
	public boolean isAttributeValueMatched(WebElement element,String atbt,String expectedValue) {
		return element.getAttribute(atbt).equals(expectedValue);
		
	}
	public boolean isTextPresent(WebElement element,String expectedText)
	{
		return element.getText().equals(expectedText);
	}

}
