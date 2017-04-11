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
import PageChecker.SignupChecker;
import Utility.Reporterlogtest;

public class AppDirectSignupPage {
	
	WebDriver driver;
	Reporterlogtest log;
	Properties properties;
	WebElement signup_text;
	WebElement signup_submit;
	static Logger Log;
	WebDriverWait wait;
	
	public AppDirectSignupPage(WebDriver driver) throws IOException 
	{
		this.driver=driver;
		this.log=new Reporterlogtest();
		File file = new File("SignupPage.properties");
		FileInputStream fileInput = new FileInputStream(file);
		properties = new Properties();
		properties.load(fileInput);
	}
	
	 public SignupChecker checker3() throws IOException 
	 {
		 return new SignupChecker(this.driver);
	 }
	 private String randomEmail() {
	        String s = "";
	        double d;
	        for (int i = 1; i <= 4; i++) {
	            d = Math.random() * 10;
	            s = s + ((int)d);     
	        }
			return "NikhilTech" + s + "@appdirect.com";	    
	 } 
	 public AppDirectSignupPage finalSignup() throws IOException {
		
		 signup_text=driver.findElement(By.name(properties.getProperty("SignupPageText")));
		 signup_text.sendKeys(randomEmail());
		 driver.findElement(By.id(properties.getProperty("SignupPageSubmit"))).click(); 
		 return new AppDirectSignupPage(driver);
	 }
	 public void SuccessSignupChecker(WebDriver driver) throws IOException
	 {
		 wait = new WebDriverWait(driver, 20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".signupConfirmationPanel"))); 
	        System.out.println(driver.toString());
		 if(driver.findElement(By.cssSelector(".signupConfirmationPanel")).isDisplayed())
		 {
			// System.out.println("Signup successfully Executed...Check your mail for Further processor");
			 log.info("Signup successfully Executed...Check your mail for Further processor");
		 } 
		 else {
			 log.warning("Given Email is already Exists");
		 }
	    }
	 }

