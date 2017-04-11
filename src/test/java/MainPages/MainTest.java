package MainPages;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import Utility.MultiBrowser;

public class MainTest {
		
	WebDriver driver;
	Properties properties;
	
	@Test
	public void initialization() throws Throwable {
		driver=new MultiBrowser(driver).startbrowser();	 
	}
	@Test(dependsOnMethods="initialization")
	public void homepageTesting() throws Exception
	{
		AppDirectHomePage appdirecthomepage	= new AppDirectHomePage(driver);
		appdirecthomepage.checker1();
		appdirecthomepage.LoginLink();			
	}
	
	@Test(dependsOnMethods="homepageTesting") 
	public void loginpageTesting() throws Exception 
	{
		AppDirectLoginPage appdirectloginpage = new AppDirectLoginPage(driver);
		appdirectloginpage.checker2();
		appdirectloginpage.waitVisibilityConditionByXpath();
		appdirectloginpage.Signuplink();
	}
	
	@Test(dependsOnMethods="loginpageTesting")
	public void signuppagetesting() throws Exception 
	{
		AppDirectSignupPage appdirectsignuppage = new AppDirectSignupPage(driver);
		appdirectsignuppage.checker3();
		appdirectsignuppage.finalSignup();
		appdirectsignuppage.SuccessSignupChecker(driver);
	}
	/*@Test(dependsOnMethods="signuppagetesting")
	public void IsSignUpSuccessfullorNot() throws Exception
	{	
		
		new SuccessSignupChecker(driver);

	} */
	
	@AfterClass
	public void termination(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	}