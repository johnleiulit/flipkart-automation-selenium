package com.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Baseclass.Library;
import com.ReusableFuntions.SeleniumReusable;

public class FashionPage extends Library{
	
	SeleniumReusable se;
	public FashionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Fashion']")
	WebElement Fashion;
	
	@FindBy(xpath="//input[@name='q']")
	WebElement SearchText;
	
	@FindBy(xpath="//html[@lang='en']")
	WebElement SearchResult;
	
	@FindBy(xpath="//span[text()='Men']")
	WebElement MenLink;
	
	@FindBy(xpath="//a[text()='Top wear']")
	WebElement Topwear;
	
	@FindBy(xpath="//html[@lang='en']")
	WebElement TopwearResult;
	
	@FindBy(xpath="//div[text()='Price -- High to Low']")
	WebElement PriceHighToLow;
	
	
	public void Fashion() {
		se = new SeleniumReusable(driver);
		se.click(Fashion);
	}
	
	public void SearchText(String text) {
		se.EnterValue(SearchText, text);
	}
	public void ClickSearch() {
		SearchText.sendKeys(Keys.ENTER);
	}
	
	public void SearchResult() {
		System.out.println(SearchResult.isDisplayed());
		System.out.println(driver.getTitle());
	}
	
	public void MenLink() {
		se.mouseHover(MenLink);
	}
	
	public void Topwear() {
		se.click(Topwear);
	}
	
	public void TopwearResult() {
		System.out.println(TopwearResult.isDisplayed());
		System.out.println(driver.getTitle());
	}
	
	public void PriceHighToLow() {
		se.click(PriceHighToLow);
	}
}
