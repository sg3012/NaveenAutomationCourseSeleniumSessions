package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefExceptionConcept {
	
	// This class explains about what is StaleElementReferenceException
	// in Selenium ? When and why do we get it? How could we resolve it? etc.
	
	// It also covers following important interview question:
	
	// [IMPORTANT - INTERVIEW] : What is StaleElementReferenceException?
	// When and why do we get it ? How could we resolve it?
	// Ans: StaleElementreferenceException is the exception which is thrown when 
	// user is trying perform user action on an element which is from a DOM
	// version other than the latest version. For e.g.: We have created 
	// an element username from DOM V1 and suddenly the page got refreshed in between.
	// Then if we try to use the same username element from DOM V1 we will get the exception
	// because the DOM version has been now changed to DOM V2. So to RESOLVE this problem
	// we have reinitialize the element once the DOM is refreshed.
	// To avoid the frequency of this exception from coming in a real-time
	// framework we use the By locator approach i.e., just create the element locators
	// and create the actual only when needed to perform a user action
	
	// In which cases we get the StaleElementReferenceException?
	// Ans: While page refresh, back/forward etc.
	
	
	// How the element gets stale? What is the internal process selenium
	// is using to check the elements?
	// Ans: When we create an element in our script selenium maintains
	// a string ID in alphanumeric format internally for the element.
	// When we refresh the page that ID gets expired/staled and we have to reinitialize
	// the element again so that selenium creates a new ID for the same
	// element.
	
	// [IMPORTANT] How to AVOID the staleElementRefException?
	// Ans: DO NOT use the page refresh method of selenium or
	// do not refresh the page anywhere between your test case execution.
	// Use the refresh only when it is absolutely necessary, otherwise
	// try to AVOID it as much as possible.

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login"); // Let's 
		// say the DOM version is V1 When the page is initially loaded
		
		WebElement username = driver.findElement(By.id("input-email")); // Element
		// is created at this line using DOM V1
		
		// Entering the value in email field before refreshing the page:
		username.sendKeys("sg@gmail.com"); // The value will be entered without any problem
		// because we are using the element from DOM V1
		
		Thread.sleep(2000);
		
		driver.navigate().refresh(); // At this point
		// when the page is refreshed the DOM version gets changed
		// Let's say to DOM V2 (This technique of changing the DOM versions is used by Selenium
		// internally)
		
		username = driver.findElement(By.id("input-email")); // Now,
		// element is created using DOM V2 at this point which
		// is the latest DOM version.
		
		username.sendKeys("RohitSharma@gmail.com"); // StaleElementReferenceException at this
		// point because the page was refreshed and the element
		// which we are looking for with the desired locator becomes stale
		// (old not usable) as the DOM version of the page was changed to V2 and 
		// we are using the element created from version V1.
		
		// So, how to resolve this exception ? 
		// Ans: reinitialize/recreate/again find the element with the same
		// locator after page refresh (as shown below the navigate.refresh command.
	}

}
