package com.Stepdefenitions;

import com.Baseclass.Library;
import com.Pages.AddtToCartPage;
import com.ReusableFuntions.SeleniumReusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartTestCase extends Library {
	AddtToCartPage cp;
	SeleniumReusable se;

	@Given("User hovers the login link")
	public void user_hovers_the_login_link() {
		cp = new AddtToCartPage(driver);
		cp.LoginLink();
	}

	@Given("User clicks on flipkart plus zone")
	public void user_clicks_on_flipkart_plus_zone() throws InterruptedException {
		cp.FlipkartPlusZoe();
		cp.FlipkartPlusZoeResult();
	}

	@When("User hovers over Home&Furniture link")
	public void user_hovers_over_home_furniture_link() {
		cp.HomeFurnitureLink();
	}

	@When("User clicks the Paintings from the dropdown")
	public void user_clicks_the_paintings_from_the_dropdown() {
		cp.Paintings();
	}

	@Then("User should be navigated to Paintings page")
	public void user_should_be_navigated_to_paintings_page() {
		cp.PaintingsResult();
	}

	@When("Scroll down the page and click one particular result")
	public void scroll_down_the_page_and_click_one_particular_result() throws InterruptedException {
		cp.Product();
	}

	@Then("User should be navigated to the Product Detail page")
	public void user_should_be_navigated_to_the_product_detail_page() throws InterruptedException {
		cp.ProductResult();
	}

	@When("User clicks select delivery address")
	public void user_clicks_select_delivery_address() throws InterruptedException {
		cp.DeliveryLocation();
	}

	@When("User enters the pin code in the search field")
	public void user_enters_the_pin_code_in_the_search_field() {
		cp.AddressSearchInput("4301");
	}

	@When("Select an address")
	public void select_an_address() throws InterruptedException {
		cp.AddressSuggestionItem();
	}

	@When("User clicks the confirm button")
	public void user_clicks_the_confirm_button() {
		cp.Confirm();
	}

	@When("User clicks the add to cart button")
	public void user_clicks_the_add_to_cart_button() throws InterruptedException {
		cp.AddToCart();
	}

	@Then("Product should be added to cart successfully")
	public void product_should_be_added_to_cart_successfully() {
		se = new SeleniumReusable(driver);
	}

	@When("User clicks on Cart icon")
	public void user_clicks_on_cart_icon() {
		cp.CartIcon();
	}

	@Then("User should be navigated to Cart page")
	public void user_should_be_navigated_to_cart_page() {
		cp.CartResult();
	}

	@Then("It should displayed the order in the cart")
	public void it_should_displayed_the_order_in_the_cart() throws InterruptedException {
		cp.CartResult();
		se.waits();
		se.screenShot("src/test/resources/Screenshots/SearchResult/success.png");

	}
}
