package seleniumscenarios;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOfBrowserDrivers {
	
	// This class explains why do we use top casting
	// and write WebDriver driver = new ChromeDriver()
	// to launch different browsers through Selenium, in Detail.
	
	// A VERY FAMOUS AND IMPORTANT INTERVIEW QUESTION

	public static void main(String[] args) {
		
		// First of all, below is the code (option 1) if we 
		// have to launch different browsers in Selenium
		
		// Option 1:
//		ChromeDriver driver = new ChromeDriver(); // launch Chrome
//		FirefoxDriver driver = new FirefoxDriver(); // launch Firefox
//		EdgeDriver driver = new EdgeDriver();  // launch Edge
		// Above approaches are valid and recommend ONLY
		// if you want a SINGLE BROWSER execution.
		
		// Secondly, we can use topcasting also to achieve the same purpose:
		
		// Option 2 - TOP CASTING USING SEARCHCONTEXT INTERFACE
		// REFERENCE AS PARENT AND RESPECTIVE BROWSER CLASS OBJECT AS CHILD:
		SearchContext sc = new ChromeDriver();
		// This topcasting is VALID but NOT RECOMMENDED in practical
		// scenarios because I can only access some methods coming
		// from SearchContext like Findelement, findElements()
		// but not the methods of WebDriver which are the major ones
		// get(url), getTitle(), getCurrentUrl() etc.
		// Because object reference is of searchcontext and all the methods
		// of this interface which are available in Chromedriver will only
		// be accessible through search context's reference and reference type
		// check will be failed if we try to access the methods from RemoteWebDriver.
		
		// Option 3 - TOP CASTING USING WEBDRIVER INTERFACE
		// REFERENCE AS PARENT AND RESPECTIVE BROWSER CLASS OBJECT AS CHILD:
//		WebDriver driver = new ChromeDriver();
		// This top casting technique is MOST WIDELY used,
		// VALID and RECOMMENDED technique. I can access all
		// major methods . This is suitable for local execution of Scripts.
		
		// Option 4 - TOP CASTING USING REMOTEWEBDRIVER CLASS
		// REFERENCE AS PARENT AND RESPECTIVE BROWSER CLASS OBJECT AS CHILD:
//		RemoteWebDriver driver = new ChromeDriver();
		// This approach is also VALID and RECOMMENDED
		// because all the major methods from RemoteWebDriver,
		// it's parents and grandparents.This is suitable 
		// for local execution of Scripts.
		
		// Option 5 - TOP CASTING USING CHROMIUMDRIVER CLASS
		// REFERENCE AS PARENT AND CHROMEDRIVER CLASS OBJECT AS CHILD
//		ChromiumDriver driver = new ChromeDriver(); 
		// This approach is VALID AND NOT RECOMMENDED.
		// Because we can use this approach ONLY FOR CHROME/EDGE browsers
		// but NOT firefox browser as Firefox driver is not the child of
		// ChromiumDriver.
//		driver = new EdgeDriver(); // possible
		//driver = new FirefoxDriver(); // not possible
		// as Firefox driver is not the child of
		// ChromiumDriver.
		// So, with this approach I can switch and point
		// the ChromiumDriver ref to either ChromeDriver or EdgeDriver
		// but not FirefoxDriver
		
		// Option 6 - TOP CASTING USING WEBDRIVER INTERFACE
		// REFERENCE AS PARENT AND REMOTEWEBDRIVER CLASS OBJECT AS CHILD
//	    WebDriver driver = new RemoteWebDriver(null, null);
	    // This is also VALID and RECOMMENDED approach but
	    // only for REMOTEEXECUTION (not on your local machine)
	    // of the Selenium script like on selenium GRID or 
	    // some cloud platforms like AWS, Docker, BrowserStack, LambdaTest etc.
		
		
		// OPTION 7 - TOP CASTING USING SEARCHCONTEXT INTERFACE
		// REFERENCE AS PARENT AND REMOTEWEBDRIVER CLASS OBJECT AS CHILD
//		SearchContext driver = new RemoteWebDriver(null, null);
		// This topcasting is VALID but NOT RECOMMENDED in practical
		// scenarios because I can only access some methods coming
		// from SearchContext like Findelement, findElements()
		// but not the methods of WebDriver which are the major ones
		// get(url), getTitle(), getCurrentUrl() etc.		
		


	}

}
