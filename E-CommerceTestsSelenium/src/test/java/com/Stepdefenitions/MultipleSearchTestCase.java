package com.Stepdefenitions;

import com.Baseclass.Library;
import com.Pages.MultipleSearch;
import com.ReusableFuntions.SeleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultipleSearchTestCase extends Library{
	MultipleSearch ms;
	SeleniumReusable se;
	String searchText;
	
	@Given("Enter the {string} in the search field")
	public void enter_the_in_the_search_field(String searchtext) {
		this.searchText = searchtext;
		ms = new MultipleSearch(driver);
		ms.EnterSearch(searchtext);
	}

	@When("click the search button")
	public void click_the_search_button(){
	    ms.ClickSearch();
	}

	@Then("It should navigate to the next page and display the corresponding page")
	public void it_should_navigate_to_the_next_page_and_display_the_corresponding_page() {
	    se = new SeleniumReusable(driver);
	    se.gettitle();
	    System.out.println("=================================");
	    se.screenShot("src/test/resources/Screenshots/SearchResult/" + searchText + ".png");
	}
}
