package mytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageNegativeTest {

	// This class explains about
	// how to write negative tests on
	// a page like Login page form component.
	// It will explain this using
	// DATA DRIVEN approach (meaning, fetch
	// the data from a source) passing the wrong
	// test data using DATAPROVIDER
	
	// We pass the data from different source(DataProvider) to avoid the repetition
	// of the same code again and again for different data.
	
	// Data driven approach is also called TEST PARAMETERIZATION

	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(1000);
	}
	
	@DataProvider
	public Object[][] loginTestData() { // The method under the @Dataprovider annotation must
		                          // return some value either a 2D Object array or
		                          // a 1D object array
		
		return new Object[][] {
			{"test121212@gmail.com","test@12121212"},
			{"naveenanimation20@gmail.com","test@12121212"},
			{"test12121212@.@.gmail.com","test@121212121212121"},
			{" ", " "},
			{"!@!@!@!#", "test12121212"}
		};
		
	} 

	@Test(dataProvider = "loginTestData") // The dataProvider keyword
	// in TestNG tells the method written under @Test that which method
	// written under @DataProvider annotation is supplying the
	// data needed for the test method to utilize.
	public void loginWithWrongDataTest(String userName, String password) throws InterruptedException { // The test method which will consume
		// the data provided by method under @DataProvider and we have
		// to map that data by providing some parameters in the test method.
		// The number of parameters to be written for the test method
		// should be equal to the number columns returned by the Dataprovider method.

		// Fill the login form with invalid data or missing any data
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(userName);
		
		
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(password);

		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		// Capture Validation message text for any invalid/missing data on the login
		// form
		String errMsg = driver.findElement(By.cssSelector("div.alert.alert-danger")).getText();
		System.out.println(errMsg);
		Assert.assertTrue(errMsg.contains("Warning: No match for E-Mail Address and/or Password"));
		
		Thread.sleep(500);
		
		// NOTE:
		// Number of parameters in the test method to capture the values
		// returned by dataprovider will be equal to the number of columns
		// returned by the dataprovider.
		
		// Number of times the test method will iterate and execute using the
		// test data returned by dataprovider will be equal to the number of
		// rows returned by the Dataprovider.
	}

}
