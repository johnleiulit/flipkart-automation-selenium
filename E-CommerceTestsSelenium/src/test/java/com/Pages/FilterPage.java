package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Baseclass.Library;
import com.ReusableFuntions.SeleniumReusable;

public class FilterPage extends Library {
	
	SeleniumReusable se;
	public FilterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[1]/div/div[1]/div/section[7]/div[4]/div[1]/select")
	WebElement MinimumAmount;
	
	@FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[1]/div/div[1]/div/section[7]/div[4]/div[3]/select")
	WebElement MaximumAmount;
	
//	@FindBy(xpath="//div[text()='Apple']/preceding-sibling::div")
	@FindBy(xpath="//div[text()='POCO']/preceding-sibling::div")
	WebElement Brand;
	
	@FindBy(xpath="//div[text()='6 GB']/preceding-sibling::div")
	WebElement Ram;
	
	@FindBy(xpath="//div[text()='Battery Capacity']/..")
	WebElement OpenBattery;
	
	@FindBy(xpath="//div[text()='5000 - 5999 mAh']/preceding-sibling::div")
	WebElement BatteryCapacity;
	
	@FindBy(xpath="//*[@id='container']/div/div[3]/div/div[2]/div/div/div/div/a/div[2]/div[1]")
	List<WebElement> EntireResult;
	
	public void MinimumAmount() {
		se = new SeleniumReusable(driver);
		se.DropDown(MinimumAmount, "10000");
	}
	
	public void MaximumAmount() throws InterruptedException {
		se.waits();
		se.DropDown(MaximumAmount, "20000");
		se.waits();
	}
	
	public void Brand() throws InterruptedException {
		se.click(Brand);
		se.waits();
	}
	
	public void Ram() throws InterruptedException {
//		se.ScrollDown(Ram);
		se.click(Ram);
		se.waits();
	}
	
	public void OpenBattery() throws InterruptedException {
		se.click(OpenBattery);
		se.waits();
	}
	
	public void BatteryCapacity() {
		se.click(BatteryCapacity);
	}
	
	public void EntireResult() {
		se.MultipleGettext(EntireResult); 
	}
	
}
