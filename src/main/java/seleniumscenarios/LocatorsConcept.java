package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {

	// This class explains how to create and interact with the web elements.
	// It also explains how we can perform various user actions on the web
	// elements after we have located them like click, typing something in text fields,
	// get text of a web element, check element is displayed or not etc.x
	
	// It also explains various approaches of creating and interacting with the web elements.
	
	// Whenever we refresh the page the DOM of the browser also gets refreshed.
	
	// On every page load the DOM of the page comes FIRST from the server in the browser
	// in the form of the HTML code and then browser renders the actual page
	// UI reading the HTML DOM code.
	
	// Any Browser in the market has some inbuilt DOM APIs which they use
	// to read the HTML code in the DOM and render the page elements.
	
	// With the element inspector in any browser dev tool we can only
	// inspect page elements (related to the page of web app opened) like a button,
	// text field, radio button etc. not the browser elements (not related to the page
	// of the web app opened) like back button, forward button, refresh button etc.
	
	// This class explains ONLY the 'ID' locator/attribute to find
	// a Web element on a web page.
	
	static WebDriver driver;
	
	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		// Approaches to create webelements
		
		//1. Find and interact with the element in the same line
//		driver.findElement(By.id("input-email")).sendKeys("naveen@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("naveen@gmail.com");
		
		
		//2. Find the element in one line, store it in Web element type variable 
		// and use/interact it in some other line
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		emailId.sendKeys("naveen@gmail.com");
//		password.sendKeys("naveen@123");
//		emailId.sendKeys("admin@gmail.com");
		
		
		// (INTERVIEW) Which approach among 1 and 2 of finding and interacting with web element is better?
		// Ans : Approach 2 is better because let's say we want to interact with
		// the same email text field and enter the email several times 
		// in the automation script then with the 1st approach we have
		// to create and interact with the web element every time
		// we need to interact with it. But with the 2nd approach
		// we just create it once, store it in a web element type variable
		// and REUSE it anywhere in the code.
		
		//3. Create By locator for a web element, use it as and when you need 
		// to find the web element, store it in a variable of type web element
		// and then interact with the element (BY LOCATOR APPROACH)
		
		// By locators
//		By email_id = By.id("input-email");
//		By pass_id = By.id("input-password");
		
		// Finding the elements:
//		WebElement emailId = driver.findElement(email_id);
//		WebElement password = driver.findElement(pass_id);
//		emailId.sendKeys("naveen@gmail.com");
//		password.sendKeys("naveen@123");
		
		// (INTERVIEW) Which approach among 1,2 and 3 of finding and interacting with web element is better?
		// Ans: 3 is the better approach than 2 and 1 because whenever we find an element using
		// corresponding method for a Browser it sends a request to the selenium server in between
		// which then sends the same requests to the browser to find the element.
		// Now, in the approach 2 we are finding all the elements on a page at the start only
		// using findElement() method at once even when we don't need to interact
		// with all of these elements at the time of running the scripts and sending 
		// unnecessary requests to the selenium server. But in the 3rd approach
		// we are just creating By locator queries and storing them in
		// By class reference which doesn't send any request to the selenium server
		// and just creates a locator. Now, when ever we need to interact with
		// an element then only we will find it (using findElement()) and interact with it
		// accordingly. So, BY LOCATOR approach is the best among 1,2 and 3 as
		// it is overcoming the limitations of 1 and 2 and includes the features
		// of 1,2 and 3.
		
		//4. Create By locator for a web element, create a generic function
		// to find the element (see getElement method below), call that 
		// function as and when you need to find an element (BY LOCATOR APPROACH 
		// WITH GENERIC FIND ELEMENT FUNCTION)
		
		// By locators
//	    By email_id = By.id("input-email");
//		By pass_id = By.id("input-password");
						
		// Finding the elements:
//		getElement(email_id).sendKeys("naveen@gmail.com");
//		getElement(pass_id).sendKeys("naveen@123");
		
		// (INTERVIEW) Which approach among 1,2,3 and 4 of finding 
		// and interacting with web element is better?
		// Ans: 4 is the best approach among 1,2,3 and 4
		// because of the following:
		
		// It gives the feature if re-usability of a web element
		// without being finding that element again, if we have to
		// interact with the same element again and again in the script.
		
		// It reduces the load on the selenium server by eliminating
		// the calls to findelement method for the elements which are not 
		// needed in the script as of now. So, we just create By locators
		// and call the findelement only when we need to interact with an element,
		// else not.
		
		// It reduces the repetitive findelement calls for the elements 
		// that we actually need to interact with, by creating a generic function
		// and write the findelement call in that function and call that function
		// whenever an elements needs to be interacted with.
		
		// Therefore, approach 4 reduces limitations of 1,2 and 3
		// and solves the purpose solved by all above 3 approaches.		
		
		//5. Create By locator for a web element, create a generic function
	    // to find the element as well as user action (see getElement
		// and doSendKeys methods below), call these function as and when you
		// need to find an element and interact with it (BY LOCATOR 
		// APPROACH WITH GENERIC FIND ELEMENT AND USER ACTIONS FUNCTIONS)
		
		// By locators
//		By email_id = By.id("input-email");
//		By pass_id = By.id("input-password");
						
		// Finding the elements and interact:
//		doSendKeys(email_id, "naveen@gmail.com");
//		doSendKeys(pass_id, "naveen@123");
		
		// (INTERVIEW) Which approach among 1,2,3,4 and 5 of finding 
		// and interacting with web element is better?
		// Ans: 5 is the best approach among 1,2,3,4 and 5
		// because of the following:
		
		// All the advantages of approach 4
		
		// By this approach we are also eliminating 
		// repetitive code to call the user action functions
		// like sendKeys(), click() etc by creating
		// a generic function for that also.
		
		// The major ADVANTAGE of creating doSendKeys(By locator, String value) or 
		// any other action generic method is 
		// We can apply our own check like NULL CHECK to verify
		// if user has supplied a null string value or not for the
		// sendKeys() method call inside doSendKeys(By locator, String value), which
		// selenium doesn't check internally in their code for sendKeys().
		// If user has supplied null string then we will not call sendKeys()
		// else we will call it. So, the main advantage of creating
		// our own functions on top of Selenium inbuilt functions
        // is that we can provide our own check inside those custom functions
		// so that user caouldn't enter invalid values.
		
		//6. Create By locator for a web element, create a generic function
	    // to find the element as well as user action in a 
		// separate Utility class (see getElement
		// and doSendKeys methods in ElementUtil.java), 
		// call these functions as and when you need to find an element 
		// and interact with it by creating object
		// of utility class (BY LOCATOR APPROACH WITH GENERIC FIND ELEMENT 
		// AND USER ACTIONS FUNCTIONS IN A UTILITY CLASS)
		
		// By locators
		By email_id = By.id("input-email");
		By pass_id = By.id("input-password");
								
		// Finding the elements and interact:
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(email_id, "naveen@gmail.com");
		eleUtil.doSendKeys(pass_id, "test@123");
		
		// (INTERVIEW) Which approach among 1,2,3,4,5 and 6 of finding 
		// and interacting with web element is better?
		// Ans: 6 is the best approach among 1,2,3,4,5 and 6
		// because of the following:
		
		// All the advantages of approach 5
		
		// By this approach we have moved the generic functions
		// for user actions like findElement, sendKeys etc.
		// to a separate and generic Utility class.
		// By this we could now use this Element utility class
		// in any framework in which need to perform user actions
		// on web elements.
		
		// So, basically approach 6 is used in real-time frameworks
		// as it contains all the features of approaches 1 - 6.
		
		//7. Create By locator for a web element, create a generic function
	    // to find the element as well as user action in a 
		// separate Utility class (see getElement
		// and doSendKeys methods in ElementUtil.java), 
		// call these functions as and when you need to find an element 
		// and interact with it by creating object
		// of utility class, in a separate caller/driver class (BY LOCATOR APPROACH WITH GENERIC FIND ELEMENT 
		// AND USER ACTIONS FUNCTIONS IN A UTILITY CLASS ALONGWITH A SEPARATE CALLER CLASS TO DRIVE
		// THE USER ACTIONS)
	}
	
//	// Generic function to find an element
//	public WebElement getElement(By locator) {
//		return driver.findElement(locator);
//	}
//
//	// Generic function to input string in plain text fields
//	public void doSendKeys(By locator, String keys) {
//	// call the getElement function here
//	// to stop the repetitive to calls to it
//	// in the actual automation script.
//		getElement(locator).sendKeys(keys);
//	}

}
