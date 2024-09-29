package mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	// The base class will not contain any test case.
	// It just implements pre-conditions (setUp) and
	// post-conditions(tearDown).
	
	// Pre-conditions: 
	// They will contain logic for which browser to launch based on some conditions
	// They will contain logic to open every browser instance in maximize mode
	// They will contain logic to clear all cache and cookies after 
	// the browser instance opens.
	
	
	// Post-conditions: 
	// They include the logic to close the browser
	// They will contain the logic to logout from the application
	// post running all the tests, close open DB connections (if any) etc.
	
	// We will use the annotation @Parameters from testNG to
	// read whatever parameter tags we pass in the testNG.xml file
	
	// We will use the value in the "name" attribute of the
	// parameter tag in testNG runner file to be 
	// used as the parameter in the @Parameters annotation.
	// KEEP IN MIND that the value of this name tag
	// to be used in @Parameters is case sensitive.
	// So, make sure to use the exact same value
	// as defined in the test.xml file. 
	
	// NOTE[IMPORTANT]: Make sure
	// the number of parameters used in the methods
	// written under any annotation after the @Parameters annotation
	// MUST always be EQUAL to the number of parameters
	// written in the @Parameters annotation
	WebDriver driver;
	ChromeOptions co;
	FirefoxOptions fo;
	EdgeOptions eo;
	
	@Parameters({"browser", "url", "headless"}) // The value in the double quotes
	// in this annotation is coming from the parameter
	// tag of test runner file. The value
	// for browser will be given to the method
	// written below this annotation i.e., setUp()
	// and it could be any method which is written
	// directly below @Parameter
	@BeforeTest
	public void setUp(String browserName, String url, String headless) {
	  System.out.println("running browser....." + browserName);	
	  switch(browserName.toLowerCase()) {
		case "chrome":
			co = new ChromeOptions();
			if(Boolean.parseBoolean(headless)) {
				co.addArguments("--headless");
			}
			
			driver = new ChromeDriver(co);
			break;
			// driver.get("https://www.google.com"); // Now,
			// this URL in get method will only work
			// for the test Class GoogleTest.java and
			// not the other test classes OpenCartTest.java and
			// OrangeHRMTest.java because the assertions
			// in the other test classes are related
			// to open cart and Orange HRM. 
			// So, to fix this we will remove this URL
			// from the base class and launch the 
			// required application URL the respective test classes only.
			// Meaning the URL for Google.com will be launched
			// in GoogleTest, URL for Open Cart will be launched in
			// OpenCartTest, URL for OrangeHRM will be launched in
			// OrangeHRM test (see the priority 1 methods
			// under the test annotations of GoogleTest, OpenCartTest, OrangeHRMTest)
		case "firefox":
			fo = new FirefoxOptions();
			if(Boolean.parseBoolean(headless)) {
				fo.addArguments("--headless");
			}
			driver = new FirefoxDriver(fo);
			break;
		case "edge":
			eo = new EdgeOptions();
			if(Boolean.parseBoolean(headless)) {
				eo.addArguments("--headless");
			}
			driver = new EdgeDriver(eo);
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Plz pass the right browser.....");
			break;
			
		}
		
	  	driver.get(url); // The value in the url
	  	// parameter in the get function will 
	  	// be automatically resolved using the
	  	// @Parameters annotation and respective application will
	  	// be launched.
	  	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
