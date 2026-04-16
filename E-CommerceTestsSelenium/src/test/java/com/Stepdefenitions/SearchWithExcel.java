package com.Stepdefenitions;

import java.io.IOException;

import com.Baseclass.Library;
import com.Pages.SearchExcelPage;
import com.Pages.SearchPage;
import com.ReusableFuntions.SeleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchWithExcel extends Library{
	
	SearchExcelPage sp;
	SeleniumReusable se;
	@Given("User enters search text in the search field")
	public void user_enters_search_text_in_the_search_field() throws IOException, InterruptedException {
		sp = new SearchExcelPage(driver);
		sp.SearchWithExcel();
		
		
	}

	@When("User clicks seach icon")
	public void user_clicks_seach_icon() {
		se = new SeleniumReusable(driver);
		se.screenShot("src/test/resources/Screenshots/ExcelSearchResult/excelsearch.png");
	}

	@Then("It should display the relevant result")
	public void it_should_display_the_relevant_result() {
	   se.gettitle();
	}
}
