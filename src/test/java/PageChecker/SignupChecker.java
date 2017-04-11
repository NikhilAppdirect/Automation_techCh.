package PageChecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import MainPages.AppDirectSignupPage;
import Utility.Reporterlogtest;

public class SignupChecker {


	 WebDriver driver;
	 Reporterlogtest log;
	 Properties properties;

	 public SignupChecker(WebDriver driver) throws IOException {
		 this.driver = driver;
		 this.log=new Reporterlogtest();
		 File file = new File("SignupPage.properties");
		 FileInputStream fileInput = new FileInputStream(file);
		 properties = new Properties();
		 properties.load(fileInput);
	 }
	 
	public AppDirectSignupPage checktitle() throws IOException {
		/* if(!driver.getTitle().equals(properties.getProperty("SignupPageTitle")))
		 {
			 log.warning("Matching Error");
		 } 
		 else {
			 log.info("SignupPage successfully verified");
		 } */
		 log.info("Verify If Appdirect SignUpPage Title is same as required or not");
	     Assert.assertEquals(driver.getTitle(), properties.getProperty("SignupPageTitle"));
		 return new AppDirectSignupPage(driver);
	 }
}
