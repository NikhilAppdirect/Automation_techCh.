package MainPages;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;
import PageChecker.LoginPageChecker;
import Utility.Reporterlogtest;

public class AppDirectLoginPage {

	
	WebDriver driver;
	Reporterlogtest log;
	Properties properties;
	WebElement signup_button;
	static Logger Log;
	 WebDriverWait wait;
	 
	public AppDirectLoginPage(WebDriver driver) throws IOException 
	{
		this.driver=driver;
		this.log=new Reporterlogtest();
		File file = new File("LoginPage.properties");
		FileInputStream fileInput = new FileInputStream(file);
		properties = new Properties();
		properties.load(fileInput);
	}
	 public LoginPageChecker checker2() throws IOException 
	 {
		 return new LoginPageChecker(this.driver);
	 }
	
	 public AppDirectLoginPage waitVisibilityConditionByXpath() throws IOException{
	        wait = new WebDriverWait(driver, 20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("LoginPageSignUpButton"))));
	       return new AppDirectLoginPage(driver); 
	    }
	 public AppDirectLoginPage Signuplink() throws IOException {
		 driver.findElement(By.xpath(properties.getProperty("LoginPageSignUpButton"))).click();
		// Log.info("Clicking on the Signup Button");
		 return new AppDirectLoginPage(driver);
	 }
	
}
