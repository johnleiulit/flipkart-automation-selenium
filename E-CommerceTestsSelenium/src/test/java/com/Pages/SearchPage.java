package com.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Baseclass.Library;
import com.ReusableFuntions.SeleniumReusable;
import com.Utilities.Excelutility;

public class SearchPage extends Library {
	SeleniumReusable se;
	String searchKeyword;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		se = new SeleniumReusable(driver);
	}

	@FindBy(xpath = "//input[@name='q']")
	WebElement SearchText;

	@FindBy(xpath = "//html[@lang='en-IN']")
	WebElement HomePage;

	@FindBy(xpath = "//html[@lang='en']")
	WebElement SearchResult;

	@FindBy(xpath = "/html/body/div[5]/div/span")
	WebElement Popup;

	// Mobile
//	@FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[2]/div/div/div/div/a/div[2]/div[1]")
//	List<WebElement> EntireResult;
//	
//	@FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[2]/div[3]/div/div/div/a/div[3]/div[1]")
//	WebElement ThirdResult;

	// Shoes
	@FindBy(xpath = "//*[@id='container']/div/div[3]/div[1]/div/div/div/div/div/div")
	List<WebElement> EntireResult;

//	public List<WebElement> getEntireResults() {
//	    List<WebElement> EntireResult;
//
//	    if (searchKeyword.equalsIgnoreCase("Mobile")) {
//	        EntireResult = driver.findElements(By.xpath(
//	        	"//*[@id='container']/div/div[3]/div[1]/div[2]/div/div/div/div/a/div[2]/div[1]"
//	        ));
//	    } 
//	    else if (searchKeyword.equalsIgnoreCase("Shoes")) {
//	        EntireResult = driver.findElements(By.xpath(
//	        	"//*[@id='container']/div/div[3]/div[1]/div/div/div/div/div/div"
//	        ));
//	    } 
//	    else {
//	        EntireResult = driver.findElements(By.xpath(
//	            "//div[contains(@class,'_1AtVbE')]"
//	        ));
//	    }
//
//	    return EntireResult;
//	}

	public void handlePopup() {
		se = new SeleniumReusable(driver);
		se.click(Popup);
	}

	public void Search(String text) {
		searchKeyword = text;
		se.EnterValue(SearchText, text);
	}

	public void ClickSearch() {
		SearchText.sendKeys(Keys.ENTER);
	}

	public void HomeScreen() {
		System.out.println(HomePage.isDisplayed());
	}

	public void SearchResult() {
		System.out.println(SearchResult.isDisplayed());
		System.out.println(driver.getTitle());
	}

	public void EntireResult() {
		se.MultipleGettext(EntireResult);
	}

	public void SearchWithExcel() throws IOException, InterruptedException {
		Excelutility excel = new Excelutility();

		for (int i = 0; i <= 5; i++) {
			try {
				String searchText = excel.ExcelRead("Testdata", i, 0);
				se.EnterValue(SearchText, searchText);
				SearchText.sendKeys(Keys.ENTER);
				se.waits();
				se.screenShot("src/test/resources/Screenshots/SearchResult/" + searchText + ".png");
				se.navigateBack();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	
	}
	
}
