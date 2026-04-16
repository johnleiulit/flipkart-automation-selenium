package com.Stepdefenitions;

import java.io.IOException;

import com.Baseclass.Library;
import com.Pages.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchTestCase extends Library {
	SearchPage sp;

	@Given("Launch the Flipkart Application")
	public void launch_the_flipkart_application() throws IOException {
		launchApp();
	}

	@When("Close the popup")
	public void close_the_popup() {
		sp = new SearchPage(driver);
		sp.handlePopup();
		System.out.println(driver.getTitle());
	}

	@Then("it should navigate to the Home Page")
	public void it_should_navigate_to_the_home_page() {
		sp.HomeScreen();
	}

	@Given("User enter the Text in the Search field")
	public void user_enter_the_text_in_the_search_field() {
//		sp.Search("Mobile");
		sp.Search("Mobile");
	}

	@When("Click the search button")
	public void click_the_search_button() {
		sp.ClickSearch();
	}

	@Then("it Should navigate to the search result page and display relevant details")
	public void it_should_navigate_to_the_search_result_page_and_display_relevant_details() {
		sp.SearchResult();
	}
	
	@Then("Extract the Results and print in console")
	public void extract_the_results_and_print_in_console() {
	    sp.EntireResult();
	    System.out.println("============================");
	}



}
