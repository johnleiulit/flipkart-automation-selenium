package com.Stepdefenitions;

import com.Baseclass.Library;
import com.Pages.TitlePricePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TitlePriceTestCase extends Library{
	TitlePricePage tp;
	@Given("User enters the search text in the search filed")
	public void user_enters_the_search_text_in_the_search_filed() {
		tp = new TitlePricePage(driver);
		tp.SearchField("Laptop");
	}

	@When("User clicks the search icon")
	public void user_clicks_the_search_icon() {
	    tp.ClickSearch();
	}

	@Then("It should display the search result and get title and price")
	public void it_should_display_the_search_result_and_get_title_and_price() {
	    tp.GetEntireTitlePrice();
	}
}
