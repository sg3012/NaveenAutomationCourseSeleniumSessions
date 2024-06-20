package seleniumscenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElementHandle {

	// There are some classes in the HTML called PSEUDO CLASSES
	// and if any element created on any web page is associated
	// with these classes then they are called PSEUDO ELEMENTS.
	
	// PSEUDO CLASSES always start with :: in the HTML code
	// for an element.
	
	// They are called Pseudo Elements because they are written with
	// either ::before or ::after and they are not real web elements as such.
	// One more reason for them to be called as Pseudo elements because
	// their is no property associated with these web elements written
	// inside the DOM. So, we cannot locate using traditional findelement
	// process directly.
	
	// Pseudo elements couldn't be located with traditional findeelement method.
	// We have to use JAVASCRIPT commands made of JS functions 
	// instead to locate these elements,
	// using JAVASCRIPTEXECUTOR interface of Selenium.
	
	// Pseudo elements are generally created to apply different styles
	// to the webElements.
	
	// NOTE: We MUST use the RETURN KEYWORD in any JavsScript code
	// we are using in our JAVA code. So, that the Script returns
	// the value in our code, instead of the browser console.
	
	static WebDriver driver;
	
	public static void main(String[] args) {
			
	    driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com"
				+ "/opencart/index.php?route=account/register");
	
		// SYNTAX TO FETCH THE STAR FOR A WEBELEMENT
		// APPLIED TO SHOW THE ELEMENT AS MANDATORY
		
		// JAVASCRIPTEXECUTOR : Interface
		
//		String script = "return window.getComputedStyle(document"
//				+ ".querySelector(\"label[for='input-firstname']\"),'::before')"
//				+ ".getPropertyValue('content')";
//		
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		
//		// NOTE: We have put BACKSLASHES in the parameter for querySelector method
//		// in the script variable above because the parameter is enclosed
//		// in double quotes and double quotes in JAVA mean string. So,
//		// when we enclose the whole script variable inside double
//		// quote and compiler starts reading the line, it thinks 
//		// the start of the string is from 'w' and it ends at 'l' (the first
//		// character in string parameter of querySelector method). So, compiler says
//		// to remove characters starting from 'l'. To avoid this confusion
//		// we will ESCAPE the double quotes in the function parameter with 
//		// Backslash.
//		
//		
//		// We have used return keyword with the script because
//		// if we don't use it the script will be executed in the browser
//		// and print whatever is returned in the Browser console itself. But
//		// we want the script's value to be returned in our code. So, to return
//		// the value from the script in our code we have used return keyword.
//		
//		// jse.executeScript(script); // If we used This line as it is, it
//		// will return a JS equivalent text
//		// in our code in the form of JS object when 
//		// executeScript method runs the script
//		// the browser console. So, we will convert that JS
//		// object in the equivalent JAVA String using TOSTRING METHOD to use it here, like below:
//		
//		String mandatoryStarText = jse.executeScript(script).toString();
//		System.out.println(mandatoryStarText);
//		
//		if(mandatoryStarText.contains("*")) {
//			System.out.println("Element is mandatory");
//		}
		
		boolean isMandatory = checkElementIsMandatory("password");
		
		if(isMandatory) {
			System.out.println("Element is mandatory");
		}
		else {
			System.out.println("Element is NOT mandatory");
		}
	}
	
	
	// GENERIC FUNCTION TO CHECK WHETHER AN
	// ELEMENT IS MANDATORY ON A WEB PAGE
	// OR NOT
	public static boolean checkElementIsMandatory(String elementLabel) {
		String script = "return window.getComputedStyle(document"
				+ ".querySelector(\"label[for='input-"+elementLabel+"']\"),'::before')"
				+ ".getPropertyValue('content')";
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String mandatoryStarText = jse.executeScript(script).toString();
		System.out.println(mandatoryStarText);
		if(mandatoryStarText.contains("*")) {
			return true;
		}
		return false;
	}

}
