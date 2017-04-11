package MainPages;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import Exception.FileNotFound;
import PageChecker.HomePageChecker;
import Utility.Reporterlogtest;


public class AppDirectHomePage 
{	
	
	WebDriver driver;
	Reporterlogtest log;
	Properties properties = new Properties();;
	WebElement login;
	static Logger Log;
	
	public AppDirectHomePage(WebDriver driver) throws IOException, FileNotFound 
	{
		this.driver=driver;
		this.log=new Reporterlogtest();
		
		FileInputStream fileInput = new FileInputStream(new File("HomePage.properties"));
		
		properties.load(fileInput);
		
	}
	 public HomePageChecker checker1() throws IOException 
	 {
		 return new HomePageChecker(this.driver);
	 }
	
	 
	 
	public AppDirectLoginPage LoginLink() throws IOException {
		
		 driver.findElement(By.cssSelector(".login")).click();
		 
		 return new AppDirectLoginPage(driver);
	 }
		
}
