package com.Pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Baseclass.Library;
import com.ReusableFuntions.SeleniumReusable;

public class TitlePricePage extends Library{
	SeleniumReusable se;
	public TitlePricePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='q']")
	WebElement SearchField;
	
	@FindBy(xpath="//div[@class='RG5Slk']")
	List<WebElement> Title;
	
	@FindBy(xpath="//div[@class='hZ3P6w DeU9vF']")
	List<WebElement> Price;
	
	public void SearchField(String text) {
		se = new SeleniumReusable(driver);
		se.EnterValue(SearchField, text);
	}
	
	public void ClickSearch() {
		SearchField.sendKeys(Keys.ENTER);
	}
	
//	public void GetEntireTitlePrice() {
//		se.MultipleGettext(Title);
//		se.MultipleGettext(Price);
//	}
	
	public void GetEntireTitlePrice() {

	    int size = Math.min(Title.size(), Price.size());

	    for (int i = 0; i < size; i++) {
	        String titleText = Title.get(i).getText();
	        String priceText = Price.get(i).getText();

	        System.out.println((i + 1) + ". " + titleText + " \n" + priceText);
	        System.out.println("==============================");
	    }
	}
	
	
}
