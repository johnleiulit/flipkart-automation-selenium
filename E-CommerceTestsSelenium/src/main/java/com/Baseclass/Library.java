package com.Baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {
	public static WebDriver driver;
	public static Properties prop;
	protected Logger logger;
	
	
	public void launchApp() throws IOException {
		FileInputStream input = new FileInputStream("src/test/resources/Properties/Config.Property");
		prop=new Properties();
		prop.load(input);
		logger = Logger.getLogger(Library.class.getName());
		PropertyConfigurator.configure("src/test/resources/Properties/log4j.properties");
		
		try {
			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) 
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				logger.info("====== Chrome Browser Launched 1=======");
			}
			else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				logger.info("====== Firefox Browser Launched =======");

			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(prop.getProperty("url"));
			
			logger.info("====== Application Launched =======");

		}
		catch(Exception e)
		{
			System.out.println("Browser didn't launch");
		}
	}
	
	public void tearDown()
	{
		driver.close();
	}
	
}
