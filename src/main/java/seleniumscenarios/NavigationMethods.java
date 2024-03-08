package seleniumscenarios;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	// This class explains the concept of various
	// actions user can perform while navigating through
	// a web application in a web browser like navigating back to previous page,
	// navigating forward to a page, refreshing a page, navigating to a specific
	// page etc.
	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		WebDriver driver = new ChromeDriver();
		
		// use get method to navigate to google.com
		driver.get("https://www.google.com");
		
		// use to method to navigate to google.com
		//driver.navigate().to("https://www.google.com");
		
		System.out.println(driver.getTitle()); // Google
		
		// Use to() TAKING STRING FORMAT URL as parameter method to to to a specific page:
		driver.navigate().to("https://www.amazon.com/");
		
		// Use to() method TAKING URL CLASS OBJECT as parameter to go to a specific page:
//		driver.navigate().to(new URL("https://www.amazon.com"));
		
//		driver.get("https://www.amazon.com/");
		
		System.out.println(driver.getTitle()); // Amazon.com. Spend less. Smile more.
		
		Thread.sleep(1000);
		
		// navigate back to previous page
		driver.navigate().back(); // navigated to google.com again
		System.out.println(driver.getTitle()); // Google
		
		Thread.sleep(1000);
		
		// navigate forward to previous page:
		driver.navigate().forward(); // navigated to amazon.com again
		System.out.println(driver.getTitle()); // Amazon.com. Spend less. Smile more.
		
		Thread.sleep(1000);
		
		// navigate back to previous page
		driver.navigate().back(); // navigated to google.com again
		System.out.println(driver.getTitle()); // Google
		
		// REFRESH the page:
		Thread.sleep(1000);
		driver.navigate().refresh();
		
		
		// (INTERVIEW QUESTION) : What is the difference between
		// to() and get() method in Selenium?
		
		// Ans: to() and get() methods are synonyms of each other. There is NO difference
		// officially. get() method is used to launch the URL and to() method 
		// is also used to launch the url. 
		// to() method is calling get() method internally, so there is NO difference in logic also.
		// The only difference is to() method is overloaded, one is taking String format url and the 
		// other is taking URL format url only. But get() method is taking url parameter in 
		// String format only, it's not overloaded.
		
		// RIGHT PRACTICE: 
		// When to use to() method and when get() method ?
		// Ans: Whenever we are launching an application ending with a certain domain
		// and we want to navigate to a third party application ending in a different
		// domain, for e.g. : We go to https://www.abc.com and from there we want to navigate to
		// a social media (third party) site ending in different domain (let's say facebook.com)
		// then to navigate to 3rd party site we use navigate().to() command for better
		// readability. So, that user can recognize from which point in the code
		// we are navigating to a different site.

	}

}
