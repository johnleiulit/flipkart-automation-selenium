package com.Stepdefenitions;

import com.Baseclass.Library;
import com.Pages.FashionPage;
import com.ReusableFuntions.SeleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FashionTestCase extends Library {
	FashionPage fp;
	SeleniumReusable se;

	@Given("User to move the Fashion Link")
	public void user_to_move_the_fashion_link() {
		fp = new FashionPage(driver);
		fp.Fashion();
	}

	@When("enter the Text in the Search field")
	public void enter_the_text_in_the_search_field() {
		fp.SearchText("T Shirts");
	}

	@When("Click the Search button")
	public void click_the_search_button() {
		fp.ClickSearch();
	}

	@Then("It should navigate to the search result page")
	public void it_should_navigate_to_the_search_result_page() {
		fp.SearchResult();
	}

	@When("Cursor to move Men Link")
	public void cursor_to_move_men_link() {
		fp.MenLink();
	}

	@When("Click top wear arrow")
	public void click_top_wear_arrow() {
		se = new SeleniumReusable(driver);
		System.out.println("Before clicking the Price High to Low");
		se.gettitle();
		fp.Topwear();
	}

	@When("Click price high to low link")
	public void click_price_high_to_low_link() {
		fp.PriceHighToLow();
	}

	@Then("It should display the relevant details and get title")
	public void it_should_display_the_relevant_details_and_get_title() {
		System.out.println("After clicking the price to low link");
		se.gettitle();
	}

}
