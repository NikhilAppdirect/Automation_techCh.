package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class MultiBrowser {

		WebDriver driver;
		Properties properties;
		
		public MultiBrowser(WebDriver driver) throws IOException {
			this.driver=driver;
			File file = new File("Setup.properties");
			FileInputStream fileInput = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInput);
			return;
		}
		public WebDriver startbrowser(){
			String browserName=properties.getProperty("browser");
			if(browserName.equals("Chrome"))
			{	
				System.setProperty("webdriver.chrome.driver", "/Users/nikhil.gupta/Downloads/chromedriver/");
				driver =  new ChromeDriver();
			}
			else if(browserName.equals("firefox"))
			{	
				System.setProperty("webdriver.gecko.driver","geckodriver");
				driver = new FirefoxDriver();
			}
			else if(browserName.equals("Safari"))
			{
				driver = new SafariDriver();
			}
			driver.navigate().to(properties.getProperty("url"));
			return driver;
		}
		
		
}
