package com.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Baseclass.Library;
import com.ReusableFuntions.SeleniumReusable;

public class MultipleSearch extends Library{
	SeleniumReusable se;
	public MultipleSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='q']")
	WebElement SearchField;
	
	public void EnterSearch(String text) {
		se = new SeleniumReusable(driver);
		se.EnterValue(SearchField, text);
	}
	
	public void ClickSearch() {
		SearchField.sendKeys(Keys.ENTER);

	}
}
