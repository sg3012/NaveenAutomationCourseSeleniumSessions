package seleniumscenarios;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import customexception.FrameWorkException;
// HOW TO CREATE DOCUMENTATION FOR A JAVA UTILITY AT CLASS LEVEL (SEE BELOW):

/**
 * @author Shubham Gupta
 * 
 */
public class BrowserUtil {
	// This class defines some generic utility
	// functions for some actions that
	// a user can perform while interacting with
	// an application inside any browser like
	// launching a browser, fetch the title etc

	private WebDriver driver; // made private
	// to prevent the classes using this utility
	// class to create their own Browser launching logic
	
	// HOW TO CREATE DOCUMENTATION FOR A JAVA UTILITY AT METHOD LEVEL (SEE BELOW):
	
	/**
	 * This method is used to initialize the driver
	 * on the basis of given browser name.
	 * Valid browsers = Chrome,Firefox,Edge,Safari
	 * @param browserName
	 */
	
	// Utility method to launch the Browser:
	public WebDriver launchBrowser(String browserName) {
		System.out.println("browser name is: " + browserName);
		
		// Null check - To avoid null pointer exception in case
		// browsername passed is null
		if(browserName == null) {
			System.out.println("Browser cannot be null");
			throw new FrameWorkException("BROWSERNAMECANNOTBENULL");
		}

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "edge":
			driver = new EdgeDriver();
			break;
			
		default:
			System.out.println("Plz pass the rigt browser name...."+browserName);
			// Because we don't want to Proceed
			// further in case user passes the wrong browser name, 
			// instead of writing break in the default case
			// for wrong browser, we will throw our custom exception
			// with the help of Generic Utility
			// class we have created for throwing custom exception.
			
			throw new FrameWorkException("NOTVALIDBROWSER");
		}
		return driver; // We are returning driver reference from here
		               // so that we can store it in some variable
		               // and supply to some other class's method
		               // required to use/drive the other methods of that class.
	}
	
	/**
	 * 
	 * @param url
	 */
	// Utility method to enter the URL - taking String format URL
	public void enterUrl(String url) {
		if(url.contains("http")) { // check whether the entered URL contains
			                       // either of the 2 protocols http or https
			                        // then only enter the url
			driver.get(url);
		}
		else { // if url doesn't contain http or https
			   // then throw the exception
			throw new FrameWorkException("Url should contain http or https");
			
		}
	}
	
	// Overloaded enterURL method - taking URL format URL
	public void enterUrl(URL url) {
		if(String.valueOf(url).contains("http")) { // first we will convert URL based url to
			                                       // string and then use contains method
			                                       // to check whether it contains protocol or not.
			                                       // Because here the parameter is URL class object
			                                       // not string.
			driver.navigate().to(url);
		}
		else { // if url doesn't contain http or https
			   // then throw the exception
			throw new FrameWorkException("Url should contain http or https");
			
		}
	}
	
	// Utility method to fetch page title
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	// Utility method to fetch current page URL
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	// Utility method to quit the browser
	public void quitBrowser() {
		driver.quit();
	}
	
	// Utility method to quit the browser
	public void closeBrowser() {
		driver.close();
	}
	
	
	// NOTE: 
	// ADVANTAGES OF CREATING GENERIC UTILITIES:
	
	// Code Re-usability - We create generic utility classes in test automation for re-usability
	// purpose. So that the same functions can be used by other developers
	// automating different applications or same applications. Re-usability
	// because these functions don't contain any hard-coded values
	// in them, they just contain some generic steps which every user will perform
	// on any web application. The values will be taken as parameters to functions.
	
	// We can write and throw our own custom exceptions/messages associated with some
	// conditions failures which are more user-friendly as compared to Selenium exceptions.


}
