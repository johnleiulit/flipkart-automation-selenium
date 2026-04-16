package com.Hooks;

import java.io.IOException;

import com.Baseclass.Library;
import com.ReusableFuntions.SeleniumReusable;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks extends Library{
	SeleniumReusable se;
	public static Scenario scenario;
	@Before
	public void test(Scenario Cucumberscenario) throws IOException {
		scenario=Cucumberscenario;
//		launchApp();
	}
	
	@After
	public void cleanup(Scenario scenario) throws InterruptedException {
		se = new SeleniumReusable(driver);
		se.attachScreenShot(scenario);
		if (driver != null) {
			se.waits();
            driver.quit();
            System.out.println("Browser closed");
        }
	}
}
