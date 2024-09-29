package mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest {
	
	//WebDriver driver;

//	@BeforeTest
//	public void setUp() {
//		driver = new ChromeDriver();
//		driver.get("https://naveenautomationlabs.com/"
//				+ "opencart/index.php?route=account/login");
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//	}

	@Test(priority = 1)
	public void titleTest() throws InterruptedException {
		//driver.get("https://naveenautomationlabs.com/"
				//+ "opencart/index.php?route=account/login");
		Assert.assertEquals(driver.getTitle(), "Account Login");
		Thread.sleep(1500);
	}

	@Test(priority = 2)
	public void urlTest() throws InterruptedException {
		Assert.assertTrue(driver.getCurrentUrl().contains("account/login"));
		Thread.sleep(1500);
	}

//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
}
