//package com.TestRunner;
//
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features="src/test/resources/Features/SearchFunctionality.feature", glue= {"com/Stepdefenitions"},
//				 plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, tags="@tc005"
//)
//
//public class runner {
//
//}

package com.TestRunner;

//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/SearchFunctionality.feature", glue= {"com/Stepdefenitions", "com.Hooks"},
				 plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, tags="@tc006"
)

public class runner extends AbstractTestNGCucumberTests {

}

