package mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest {
	// WebDriver driver;

//	@BeforeTest
//	public void setUp() {
//		driver = new ChromeDriver();
//		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//	}

	@Test(priority = 1)
	public void titleTest() throws InterruptedException {
		//driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		Assert.assertTrue(driver.getTitle().contains("OrangeHRM"));
		Thread.sleep(1500);
	}

	@Test(priority = 2)
	public void urlTest() throws InterruptedException {
		Assert.assertTrue(driver.getCurrentUrl().contains("30-day-free-trial"));
		Thread.sleep(1500);
	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
	
	// Now, what if we need to run OrangeHRMTest, OpenCartTest, GoogleTest
	// all at once? To acheive this we will create a runner file
	// called testNG.xml where we could configure all these test
	// classes and then run the runner file which in turn executes
	// all these test classes in a Bundle or Batch
}
