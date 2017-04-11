package PageChecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Exception.FileNotFound;
import MainPages.AppDirectHomePage;
import Utility.Reporterlogtest;

public class HomePageChecker {

	 WebDriver driver;
	 Reporterlogtest log;
	 Properties properties;

	 public HomePageChecker(WebDriver driver) throws IOException {
		 this.driver = driver;
		 this.log=new Reporterlogtest();
		 File file = new File("HomePage.properties");
		 FileInputStream fileInput = new FileInputStream(file);
		 properties = new Properties();
		 properties.load(fileInput);
	 }
	 
	 public AppDirectHomePage checktitle() throws IOException, FileNotFound {
		/* if(!driver.getTitle().equals(properties.getProperty("HomePageTitle")))
		 {
			 log.warning("Matching Error");
			 
		 } 
		 else {
			log.info("HomePage successfully verified");
		 } */
		 log.info("Verify If Appdirect HomePage Title is same required or not");
	     Assert.assertEquals(driver.getTitle(), properties.getProperty("HomePageTitle"));
		 return new AppDirectHomePage(driver); 
		 
	 }
}

