package seleniumscenarios;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {
	
	// This class explains how we could automate
	// various user actions/scenarios with the 
	// help of JavaScriptExecutor interface
	// of Selenium Library
	
	// We have to cast our driver reference variable to JavaScriptExecutor type because
	// RemoteWebDriver has 2 parents JavaScriptExecutor and WebDriver and RWD implements both
	// WebDriver and JavaScriptExecutor.And when we create
	// the object of ChromeDriver it has the properties of both RemotewebDriver and chromium driver.
	// but the driver gets the properties from chromium driver only not the JAVASCRIPTEXECUTOR because
	// it is of type WebDriver due to top casting. So, if we try to directly access
	// the properties of JSE from the driver variable the reference type check will be failed.
	// That is why we have to typecast the driver variable to JSE.
	
	
	// [IMPORTANT] : DON'T forget to use the RETURN keyword
	// in the JavaScript code you are writing as a parameter to the executeScript()
	// method if the executeScript() method returns something using the JS code
	// and you want to utilize that value in your code.
	
	
	// [IMPORTANT] : All the selenium code gets executed in the browser only. The difference
	// is it launches a server in between the browser and Selenium code which is called a 
	// driver server. That driver server executes the scripts in the browser. So, whenever
	// we execute a selenium code it launches a driver server between the browser
	// and selenium script and acts as an interpreter of the Selenium scripts
	// written in language other than JS and translates them in JS to the browser
	// instance which is opened.
	
	// [IMPORTANT] : All the selenium code gets converted to JS code only before it
	// gets executed in the actual browser launched by the driver server. Because
	// any browser understands only one language i.e., JS. It doesn't
	// any automation written in any other language like JAVA, Python, C# etc.
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		Thread.sleep(2000);
		
		// JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		// VARIOUS USES OF JAVASCRIPTEXECUTOR INTERFACE USING JS CODE
		
		// Displaying a JS Alert using executeScript():
		//jse.executeScript("alert('This is JS Alert')");
		
		
		// Display the title of the page using JavaScript:
	   //  String pageTitle = jse.executeScript("return document.title").toString();
	    // We are using return in above line because JS code (written as the parameter)
	    // of executeScript() method will return the title value in the browser console only.
	    // To return that value in our code we have to write the return keyword.
	    
	    // We have used toString() method in the above line because the returned value
	    // will a javascript string. To utilize the same string and apply the methods
	    // of the JAVA STRING class, we have to convert the JS string to JAVA string.
		
		// System.out.println(pageTitle);
		
//		driver.getTitle();
//		driver.getCurrentUrl();
		// Above lines of code will be passed on to the
		// driver server which is opened in between the selenium
		// code and the actual browser opened, whenever the
		// selenium scripts open a browser instance for the first time.
		// Then above 2 lines of code will be converted to appropriate JS
		// code before running it into the actual browser opened.
		
		
		// DISPLAY PAGE TITLE USING GENERIC JSEXECUTOR METHOD
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//		System.out.println(jsUtil.getTitleByJS());
		
		// DISPLAY AND HANDLING JS ALERT USING GENERIC JSEXECUTOR METHOD
		
//		jsUtil.generateJSAlert("Hi, this is my JS Alert");
		
		
		
		// DISPLAY ALL THE TEXTUAL CONENT ON A WEB PAGE USING JSEXECUTOR METHOD
//		String pageText = jsUtil.getPageInnerTextByJS();
//		System.out.println(pageText);
//		if(pageText.contains("Calls & Voice")) {
//			System.out.println("PASS -- Calls & Voice");
//		}
	
		// SCROLL TO THE BOTTOM,TOP AND SPECIFIC HEIGHT OF THE PAGE USING JSEXECUTOR METHOD
//		jsUtil.scrollPageDown();
//		Thread.sleep(1000);
//		jsUtil.scrollPageUp();
//		Thread.sleep(1000);
//		jsUtil.scrollPageDown("2000");
		
		// SCROLL DOWN TO THE MIDDLE OF THE PAGE HEIGHT USING JSEXECUTOR METHOD
//		jsUtil.scrollPageDownTheMiddle();
		
		// SCROLL UP TO A SPECIFIC ELEMENT ON THE PAGE UNTIL IT'S VISIBLE USING JSEXECUTOR METHOD
//		WebElement element = driver.findElement(By.xpath("//span[text()='Snacks Store']"));
//		jsUtil.scrollIntoView(element);
		
		// DRAW BORDER AROUND AN ELEMENT
		
		// Draw border on heading named 'Snacks store'
//		jsUtil.drawBorder(element);
		
		// Draw border on search box on top of the page
//		WebElement search = driver.findElement(By.xpath("//div[contains(@class,'content')]"
//				+ "//*[local-name()='svg']"
//				+ "//following-sibling::input[@placeholder='Search for Products...']"));   
//		jsUtil.drawBorder(search);
		
		// Draw boder on entire form element
		WebElement registerFormEle = driver.findElement(By.cssSelector(".form-horizontal"));
		//jsUtil.drawBorder(registerFormEle);
		
		// HIGHLIGHT AN ELEMENT WITH DIFFERENT COLOR
		WebElement firstNameEle = driver.findElement(By.id("input-firstname"));
		WebElement lastNameEle = driver.findElement(By.id("input-lastname"));
		jsUtil.flash(firstNameEle);
		firstNameEle.sendKeys("Shubham");
		jsUtil.flash(lastNameEle);
		lastNameEle.sendKeys("Automation");
		
		// PRACTICAL USE CASE OF GENERATING A SIMPLE JS ALERT:
		// After executing each test case we can show the alert
		// that the test was successful like generating alert
		// that login successful after coming to the landing page,
		// on successful search, on landing to a product page, on
		// landing to a product details page or when we are giving
		// demo to a client then we could generate alert on successful
		// test case execution etc.
		
		// [INTERVIEW] : Which JavaScript method you will use
		// to go back, forward and refresh the same page on the web
		// browser ?
		
		// Ans: We will use the history object with go() method of JavaScript
		// Following is the syntax to use it:
		// history.go(-1); // GO BACK
		// history.go(1); // GO FORWARD
		// history.go(0); // REFRESH THE PAGE
	}
}
