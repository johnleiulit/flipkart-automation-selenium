package com.Stepdefenitions;

import com.Baseclass.Library;
import com.Pages.FilterPage;
import com.ReusableFuntions.SeleniumReusable;

import io.cucumber.java.en.Then;

public class FilterTestCase extends Library{
	FilterPage fp;
	SeleniumReusable se;
	
	@Then("Select Minimum and Maximum Amount")
	public void select_minimum_and_maximum_amount() throws InterruptedException {
		fp = new FilterPage(driver);
		se = new SeleniumReusable(driver);
		fp.MinimumAmount();
		fp.MaximumAmount();
	}

	@Then("Select the Brand")
	public void select_the_brand() throws InterruptedException {
	   fp.Brand();
	}

	@Then("Select the Ram")
	public void select_the_ram() throws InterruptedException {
		fp.Ram();
	}

	@Then("Select the Batterry Capacity")
	public void select_the_batterry_capacity() throws InterruptedException {
		fp.OpenBattery();
		fp.BatteryCapacity();
	}

	@Then("It should display the Relevent result")
	public void it_should_display_the_relevent_result() throws InterruptedException {
		se.waits();
		fp.EntireResult();
	}

}
