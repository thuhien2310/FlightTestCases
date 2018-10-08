package newpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.TimeUtils;

public class BaseTest 
{
 
	WebDriver driver;
	public static final String myURL = "https://www.tripi.vn";
   
	@BeforeMethod
	public void beforeTest() throws Exception 
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize() ;
		driver.get(myURL);
		TimeUtils.sleep(5);	
	}

	@AfterMethod
	public void afterTest() 
	{
		driver.quit();
	}	
}


