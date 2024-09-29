package mytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTesting {

	// AAA (Arrange - Act - Assert)
	// In the below test case design pattern a different Browser instance will
	// be opening before running each test. Hence, there will be 3 browser
	// instances opened in total and all the tests will
	// be running in their own browser instance. Because @BeforeMethod and @AfterMethod
	// run before and after each @Test is executed respectively.
	
	// This pattern ensures the AAA rule is followed i.e., each test
	// has it's own browser and validation check. It
	// is also recommended to follow this approach (opening
	// and closing browser after every test) in real-time.
	
	// It is also recommended to keep your tests as independent 
	// as possible from each other so that they behave
	// as individual units, show-casing unit tests.

	WebDriver driver;

	@BeforeMethod
	
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test(priority = 1)
	public void googleTitleTest() {
		Assert.assertEquals(driver.getTitle(), "Google");
	}

	@Test(priority = 2)
	public void googleURLTest() {
		Assert.assertTrue(driver.getCurrentUrl().contains("google"));
	}

	@Test(priority = 3)
	public void googleSearchTest() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.name("q")).submit();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getTitle().contains("selenium"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	// ADVANTAGES OF USING BEFOREMETHOD
	// AND AFTERMETHOD IN PLACE OF
	// BEFORETEST AND AFTERTEST
	
	// 1. Let's say you have 100 tests to execute and at test no. 4 your
	// application stops responding or a blank white page is getting displayed.
	// Now if you are using @BeforeTest and @AfterTest in your scripts
	// the rest of the test cases after test no. 4 will not be executed at all
	// because the browser will be opened and closed only once using @BeforeTest
	// and @AfterTest and all the tests will be running in the same browser.
	// In this case the test execution coverage will be only 4 out of 100 (4%).
	// Whereas if you are using @BeforeMethod and @AfterMethod in your scripts
	// and you have the same problem at test no. 4 then the test cases post
	// test no. 5 will have a chance to at least execute in a fresh browser because
	// the browser will be opened and closed after each test using @BeforeMethod
	// and @AfterMethod. In this if all tests are executed post
	// test no. 4 then only one test will not be executed and
	// execution coverage will be 99 out of 100 (99%).

	// So, for the applications which are more complex and using
	// a lot of browser cache in the form of filling some forms etc
	// and it is not that stable then go with @BeforeMethod and @AfterMethod
	// approach.
	
	// Also if you have a full fledged regression test suite 
	// or a lot of test cases ( like more than a few hundred tests)
	// to execute then using @BeforeMethod and @AfterMethod
	// is beneficial.

	// ADVANTAGES OF USING BEFORETEST
	// AND AFTERTEST IN PLACE OF
	// BEFOREMETHOD AND AFTERMETHOD
	
	// If you have a few tests or a partial regression suite or 
	// or sanity tests to run then using BeforeTest and AfterTest 
	// is beneficial as it takes less time than BeforeMethod
	// and AfterMethod
	
	
	

}
