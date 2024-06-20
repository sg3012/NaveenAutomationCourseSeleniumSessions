package seleniumscenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOMHandle {

	public static void main(String[] args) throws InterruptedException {
		
		// The SHADOW DOM elements are the ones
		// which are written with the keyword '#SHADOW-ROOT'
		// in the DOM.
		
		// We cannot locate the shadow DOM elements directly
		// using findElement(s) method.
		
		// Elements are placed in shadow DOM for the security
		// purposes like to prevent automation etc. That is 
		// why we are not able to locate these elements
		// using findElement() method directly.

		// Shadow DOM elements are displayed on the page like any other
		// element, so they are NOT HIDDEN. The only difference is 
		// they cannot be accessed via DOM programmatically 
		// using findElement process directly.
		
		// (IMPORTANT) To automate the elements inside shadow DOM
		// the shadow-root MUST always
		// be in in OPEN state like '#shadow-root (open)'. If
		// it is in closed state, then you MUST ask your dev team
		// to make it open. Otherwise, you couldn't automate 
		// the element.
		
		// We could ONLY automate the shadow DOM elements using
		// JavaScript commands in the JAVASCRIPTEXECUTOR interface. 
		// There is NO OTHER method.
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		
		Thread.sleep(3000);
		
//		driver.findElement(By.id("pizza")).sendKeys("Veg Pizza"); // We
		// will get NoSuchElementException if we try
		// to locate this element directly as this element
		// is inside SHADOW DOM.
		
		// HOW TO HANDLE SHADOW DOM ELEMENTS ?
		// Ans: See below:
		
		// Path of the shadow DOM element in this case:
		// Browser - Page - shadow DOM - shadow DOM - e1 (e1 is the element in shadow 
		// DOM which we require to automate)
		
		// HANDLE USING JAVASCRIPT EXECUTOR
		// Step 1: Go to browser and open the web page
		// which has shadow root element.
		
		// Step 2: Open the browser dev tools and right click the element
		// which is inside shadow root/DOM, from the elements tab.
		
		// Step 3: From the context menu opened, mouse hover 
		// on copy option >> click copy JS path.
		
		// Step 4: Open the console tab and paste the value copied in
		// previous step and hit enter.
		
		// Step 5 : If the HTML code of correct element pops-up
		// as a result then we could use the same script (as in step 3)
		// in executeScript() method of JAVASCRIPTEXECUTOR interface as shown in below step.
		
		// Step 6: 
		
		String script = "return document.querySelector(\"#userName\")"
				+ ".shadowRoot.querySelector(\"#app2\")"
				+ ".shadowRoot.querySelector(\"#pizza\");";
		
		// We have used return keyword with the script because
		// if we don't use it the script will be executed in the browser
		// and print whatever is returned in the Browser console itself (In this case
		// the input HTML element). But
		// we want the script's value to be returned in our code. So, to return
		// the value from the script in our code we have used return keyword.
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		//jse.executeScript(script);
		// When we execute the script using executeScript() method
		// of JavaScriptExecutor we will get the HTMLElement not
		// the WebElement which selenium recognises. So, we have to
		// type cast the HTML Element into WebElement like below to
		// perform some action. Otherwise we will get 
		// JAVASCRIPTEXCEPTION: Cannot read properties of null
		// if we try to run the script without converting like above.
		
		WebElement pizzaEle = (WebElement)jse.executeScript(script);
		
	    pizzaEle.sendKeys("Veg Pizza");
		
		
		
		// (INTERVIEW - IMPORTANT- RELATED TO SHADOW DOM):
		// Go to Chrome:://settings page
	    // >> Enter any keyword in the search box at the top
		
//		driver.get("chrome://settings");
//	    
//	    String searchScript = "return document.querySelector(\"body > settings-ui\")"
//	    							+ ".shadowRoot.querySelector(\"#toolbar\")"
//	    								+ ".shadowRoot.querySelector(\"#search\")"
//	    									+ ".shadowRoot.querySelector(\"#searchInput\")";
//	    WebElement chromeSettingsPageSearchEle = (WebElement)jse.executeScript(searchScript);
//	    
//	    chromeSettingsPageSearchEle.sendKeys("notification");
		
	}

}
