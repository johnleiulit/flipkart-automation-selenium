package com.ReusableFuntions;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Baseclass.Library;

import io.cucumber.java.Scenario;

public class SeleniumReusable extends Library {

	Actions act;

	public SeleniumReusable(WebDriver driver) {
		this.driver = driver;
	}

	public void EnterValue(WebElement element, String text) {
		try {
			element.sendKeys(text);
			logger.info("====== Entered Value =======");

		} catch (Exception e) {
			System.out.println("No such element Exception");
		}
	}

	public void click(WebElement element) {
		try {
			element.click();
			logger.info("====== Clicked Button =======");

		} catch (Exception e) {
			System.out.print("No such element Exception");
		}
	}

	public void gettitle() {
		try {
			System.out.println(driver.getTitle());
		} catch (Exception e) {
			System.out.println("Couldn't get the Title");
		}
	}

//	public void MultipleGettext(List<WebElement> element) {
//		List<WebElement> text = element;
//		System.out.println(text.size());
//
//		for (WebElement textcount : text) {
//			String Totallist = textcount.getText();
//			System.out.println("==================");
//			System.out.println(Totallist);
//		}
//
//	}
	public void MultipleGettext(List<WebElement> element) {
		List<WebElement> text = element;
		System.out.println(text.size());

		for (WebElement textcount : text) {
			String Totallist = textcount.getText();
			System.out.println("==================");
			System.out.println(Totallist);
		}

	}

	public void GetValue(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public void DropDown(WebElement element, String text) {
		Select drp = new Select(element);
		drp.selectByValue(text);
	}

	public void ScrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void ScrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}

	public void waits() throws InterruptedException {
		Thread.sleep(2000);
	}

	public void mouseHover(WebElement element) {
		act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void moveElement(WebElement element) {
		act.moveToElement(element).click().build().perform();
	}

	public void screenShot(String path) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(source, new File(path));
		} catch (Exception e) {
			System.out.println("Couldn't take screenshot");
		}
	}

	public void windowHandling(WebElement element) {
		String ParrentWindow = driver.getWindowHandle();
		element.click();
		System.out.println(ParrentWindow);

		Set<String> allwindow = driver.getWindowHandles();
		System.out.println(allwindow.size());

		for (String Childwindow : allwindow) {
			driver.switchTo().window(Childwindow);
			System.out.println(Childwindow);
		}
	}

	public void clickWithRetry(WebElement element, int maxRetries) throws InterruptedException {
		int attempts = 0;
		while (attempts < maxRetries) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
				Thread.sleep(1000);
				js.executeScript("arguments[0].click();", element);
				return;
			} catch (StaleElementReferenceException e) {
				attempts++;
				System.out.println("Stale element, retry " + attempts);
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Click failed: " + e.getMessage());
				break;
			}
		}
	}

	public void attachScreenShot(Scenario CucumberScenario) {
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		CucumberScenario.attach(screenshot, "image/png", "FlipkartAutomation");
	}
	
	public void close() {
		driver.close();
		System.out.println("Browser closed");
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}

}
