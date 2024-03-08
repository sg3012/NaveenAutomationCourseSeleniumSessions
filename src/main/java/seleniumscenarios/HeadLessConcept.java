package seleniumscenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadLessConcept {
	
	// This class explains how you can
	// run your automation scripts
	// in headless mode i.e., 
	// no browser UI is visible or
	// scripts are running behind the scenes
	
	// It also explains how to write the logic for running
	// tests in headless mode.
	
	// What is headless ?
	// Headless means a browser which is launched without
	// any visible UI.

	// ADVANTAGES OF HEADLESS:
	// Slightly faster than the normal execution. Because
	// in headed mode it will take some time actually launch
	// the browser, load all the UI elements completely etc.
	
	// WHEN TO USE ?
	// In case we are working on an OS which doesn't have any UI and look
	// and feel like Linux, then we can run our scripts on the platform in
	// headless mode.
	// We can also use when we are running our scripts remotely like Jenkins, Docker
	// So generally we use Headless mode in an environment where there is no Browser UI
	
	// DISADVANTAGES:
	// The headless execution might not work in the cases
	// where there is a lot of complex HTML in the application,
	// where there are lot of navigations involved from one page to the other,
	// when we are doing responsive testing
	public static void main(String[] args) {
		
		// LOGIC TO RUN TESTS IN HEADLESS MODE
		
		// FOR CHROME:
		// Create an Object of ChromeOptions class like this:
		ChromeOptions co = new ChromeOptions();
		
		// USE addarguments() method in ChromeOptions to pass the headless parameter like this:
		co.addArguments("--headless"); // We will use the parameter '--headless=new' for chrome v94 to 108.
		
//		co.addArguments("--headless=chrome"); // We will use the parameter '--headless=chrome' 
//		                                      // for chrome V109+.
		
		// We can also pass the parameter simply like '--headless'
		// for some Selenium versions and it will too open the browser
		// in headless mode
		
//		NOTE: DO NOT use setHeadless() method to set the headless mode
//		if you are using Selenium version 4.7.0 or above as this
//		method is deprecated 4.7.0 onwards.
		
		
		// FOR FIREFOX:
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--headless");
		
		// FOR EDGE:
		EdgeOptions eo = new EdgeOptions();
		eo.addArguments("--headless");
		
		// Pass the chromeoptions class reference to the BrowserDriver constructors like this
		// to run chrome headless:
//		WebDriver driver = new ChromeDriver(co);
			
		// Pass the firefoxoptions class reference to the BrowserDriver constructors like this
		// to run firefox headless:
//		WebDriver driver = new FirefoxDriver(fo);
		
		// Pass the firefoxoptions class reference to the BrowserDriver constructors like this
		// to run firefox headless:
		WebDriver driver = new EdgeDriver(eo);
		
		driver.get("https://www.amazon.com");
		System.out.println("Title: "+driver.getTitle());
		System.out.println("Page URL: "+driver.getCurrentUrl());
		driver.quit();
		
		// NOTE: DO NOT FORGET to pass chromeoptions object reference
		// while creating browserdriver class object. Otherwise it will
		// open the browser and show it while execution.
		
		// FOR EDGE there is NO support for headless mode
		// as of now
	}

}
