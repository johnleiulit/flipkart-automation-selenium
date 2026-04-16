package com.Pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Baseclass.Library;
import com.ReusableFuntions.SeleniumReusable;
import com.Utilities.Excelutility;

public class SearchExcelPage extends Library{
	SeleniumReusable se;
	String searchKeyword;
	
	public SearchExcelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		se = new SeleniumReusable(driver);
	}
	
	@FindBy(xpath = "//input[@name='q']")
	WebElement SearchText;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div/div")
	WebElement HomePage;
	
	public void SearchWithExcel() throws IOException, InterruptedException {
		Excelutility excel = new Excelutility();

		for (int i = 1; i <= 6; i++) {
			try {
				String searchText = excel.ExcelRead("Testdata", i, 0);
				se.EnterValue(SearchText, searchText);
				SearchText.sendKeys(Keys.ENTER);
				se.waits();
				se.screenShot("src/test/resources/Screenshots/SearchResult/" + searchText + ".png");
				if (HomePage.isDisplayed()) {
					excel.ExcelWrite("Testdata", i, 1, "pass");
				}else {
					excel.ExcelWrite("Testdata", i, 1, "fail");
				}
				se.navigateBack();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}	
	}
	
	
}
