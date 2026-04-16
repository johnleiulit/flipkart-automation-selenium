package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Baseclass.Library;
import com.ReusableFuntions.SeleniumReusable;

public class AddtToCartPage extends Library{
	SeleniumReusable se;
	public AddtToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Login']")
	WebElement LoginLink;
	
	@FindBy(xpath="//div[text()='Flipkart Plus Zone']")
	WebElement FlipkartPlusZoe;
	
	@FindBy(xpath="//html[@lang='en']")
	WebElement FlipkartPlusZoeResult;
	
	@FindBy(xpath="//span[text()='Home & Furniture']")
	WebElement HomeFurnitureLink;
	
	@FindBy(xpath="//a[text()='Paintings']")
	WebElement Paintings;
	
	@FindBy(xpath="//html[@lang='en']")
	WebElement PaintingsResult;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[4]/div/div[1]/div/a[1]/div[1]/div")
	WebElement Product;
	
	@FindBy(xpath="(//div[contains(@class,'CTTtEa')])[5]")
	WebElement ProductResult;
	
	@FindBy(xpath="//div[text()='Location not set']")
	WebElement DeliveryLocation;
	
	@FindBy(xpath="//input[@placeholder=\"Search by area, street name, pin code\"]")
	WebElement AddressSearchInput;
	
	@FindBy(xpath="//*[@id=\"msite-bottomsheet\"]/div/div/div/div/div/div[3]/div[1]/div/div")
	WebElement AddressSuggestionItem;
	
	@FindBy(xpath="//div[text()='Confirm']")
	WebElement Confirm;
	
	@FindBy(xpath="//div[text()='Add to cart']")
	WebElement AddToCart;
	
	@FindBy(xpath="//a[@title=\"Cart\"]")
	WebElement CartIcon;
	
	@FindBy(xpath="//html[@lang='en-IN']")
	WebElement CartResult;
	
	public void LoginLink() {
		se = new SeleniumReusable(driver);
		se.mouseHover(LoginLink);
	}
	
	public void FlipkartPlusZoe () {
		se.click(FlipkartPlusZoe);
	}
	
	public void FlipkartPlusZoeResult() throws InterruptedException {
		System.out.println(FlipkartPlusZoeResult.isDisplayed());
		System.out.println(driver.getTitle());
		se.waits();
	}
	
	public void HomeFurnitureLink() {
		se.mouseHover(HomeFurnitureLink);
	}
	
	public void Paintings() {
		se.click(Paintings);
	}
	
	public void PaintingsResult() {
		System.out.println(PaintingsResult.isDisplayed());
		System.out.println(driver.getTitle());
	}
	
	public void Product() throws InterruptedException {
		se.ScrollDown(Product);
		se.windowHandling(Product);
		se.waits();
	}
	
	public void ProductResult() throws InterruptedException {
		System.out.println("Title: " + driver.getTitle());
	    System.out.println("URL: " + driver.getCurrentUrl());
	    se.waits();
	}
	
	public void DeliveryLocation() {
		se.ScrollDown(DeliveryLocation);
		se.click(DeliveryLocation);
	}
	
	public void AddressSearchInput(String text) {
		se.EnterValue(AddressSearchInput, text);
	}
	
	public void AddressSuggestionItem() throws InterruptedException {
	    se.waits();
	    se.click(AddressSuggestionItem);
	  
	}
	
	public void Confirm() {
		se.click(Confirm);
	}
	public void AddToCart() throws InterruptedException {
		se.clickWithRetry(AddToCart, 3);
		se.waits();
	}

	public void CartIcon() {
		se.click(CartIcon);
	}
	
	public void CartResult() {
		System.out.println(CartResult.isDisplayed());
		System.out.println(driver.getTitle());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
