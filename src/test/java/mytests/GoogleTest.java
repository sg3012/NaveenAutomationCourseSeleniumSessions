package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{
	
	// This class shows how to write
	// test cases / scripts using TestNG
	// framework in real-time use case
	
	// When writing tests using testNG please make sure
	// that the tests are as much independent as possible
	// and there should not be more than one validation / assertion
	// in a test. Because if we have more than one assertion
	// in a test than if one assertion for a step is failed
	// then the remaining steps will not be executed
	// as exception will be thrown, even when further steps
	// are working fine.
	
	// So, it is recommended to always follow AAA (Arrange - Act - Assert)
	// while writing the tests. Meaning, adhere to
	// the practice of 1 TEST 1 ASSERT/VALIDATION
	// in most of the test cases
	
	// In the below test case design pattern the Browser will only be
	// opened once before running all the tests and all the tests will
	// be running in the same browser instance afterwards. Because @BeforeTest and @AfterTest
	// run only once before and after all the tests are executed respectively.
	
	// The test classes will not initialize the driver variable.
	// Its value will come from BaseTest.java or Base class
	// using Inheritance.
	
	// Below test cases explain 
	// Launch a browser and enter any URL (Preconditions)
	// Do some user actions after opening URL
	
	//WebDriver driver;
	
	
	//@BeforeTest
	// This method defines the pre-conditions
	// which you want to fulfill like browser should
	// be opened, the desired URL should be opened etc.
	// We generally name this method as setUp in
	// most of the real-time frameworks and it will be
	// available in most real-time frameworks
//	public void setUp() {
//		driver = new ChromeDriver();
//		driver.get("https://www.google.com");
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		
//		// Now this setup and teardown methods
//		// are written in every test class we create.
//		// So, tomorrow if we have 20 test classes
//		// then we have to unnecessary write this repeated code
//		// in every test class. 
//		// To improve this and write the code block for both setUp
//		// and tearDown methods only once, we will create a base class
//		// and inherit that base class in every child class eliminating
//		// the need to writing repeated setUp and tearDown code.
//	}
	
	@Test(priority = 1)
	public void googleTitleTest() {
		// driver.get("https://www.google.com"); // We could also
		// remove this harcoded URL value and supply
		// this value as parameter from testng runner file (see
		// Google test test block in testng.xml)
		// and utilize the same value in the Base test file
		// using @Parameters annotation of testNG and it will
		// open the respective application url
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	
	@Test(priority = 2)
	public void googleURLTest() {
		Assert.assertTrue(driver.getCurrentUrl().contains("google"));
	}
	
	@Test(priority = 3)
	public void googleSearchTest() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("selenium");
		// submit method will perform
		// action equivalent to pressing
		// enter key on the keyboard
		// for the exact value entered in the search field,
		// not from the suggestions list.
		driver.findElement(By.name("q")).submit();
		Thread.sleep(2000);		
		Assert.assertTrue(driver.getTitle().contains("selenium"));
	}
	
	// Now we have to give priority to the above test cases
	// in such a way that googleTitleTest() runs first then
	// googleURL test runs 2nd then googleSearchTest() runs 3rd.
	// Because if we don't give priorities then tests will run
	// in increasing order alphabetically which means googleSearchTest()
	// will run before googleTitleTest() and when googleSearchTest runs
	// before it will search the required keyword >> hit enter which changes
	// the title of the page that doesn't contain Google in it anywhere
	// which fails the googleTitleTest as it is expecting the text "google/Google"
	// as the page title.
	
//	@AfterTest
//	// This method defines the post-conditions
//	// which you want to perform after performing tests 
//	// like application should be logged out, browser should be closed etc.
//	// We generally name this method as tearDown in
//	// most of the real-time frameworks and it will be
//	// available in most real-time frameworks
//	public void tearDown() {
//		driver.quit();
//	}

}
