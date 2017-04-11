package PageChecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import MainPages.AppDirectLoginPage;
import Utility.Reporterlogtest;

public class LoginPageChecker {


	 WebDriver driver;
	 Reporterlogtest log;
	 Properties properties;

	 public LoginPageChecker(WebDriver driver) throws IOException {
		 this.driver = driver;
		 this.log=new Reporterlogtest();
		 File file = new File("LoginPage.properties");
		 FileInputStream fileInput = new FileInputStream(file);
		 properties = new Properties();
		 properties.load(fileInput);
	 }
	 
	 public AppDirectLoginPage checktitle() throws IOException {
		/* if(!driver.getTitle().equals(properties.getProperty("LoginPageTitle")))
		 {
			 log.warning("Matching Error");
		 } 
		 else {
			  log.info("LoginPage successfully verified");
		 } */
		 log.info("Verify If Appdirect LogInPage Title is same as required or not");
	     Assert.assertEquals(driver.getTitle(), properties.getProperty("LoginPageTitle"));
		 return new AppDirectLoginPage(driver);
	 }
}

