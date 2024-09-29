package seleniumscenarios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLoadTimeOutConcept {
	
	// This class explains about what is PageLoadTimeOut in Selenium and How to configure it
	
	// PageLoadTimeOut is total time Selenium script is going to wait for the complete page
	// to be loaded before throwing an exception. Selenium will not interact with the page
	// until the whole page is loaded or the page load timeout limit is crossed.
	
	// There are 3 types of ready states under which a page goes through when it is loading:
	// loading - Meaning no part of the DOM structure is loaded yet. DOM is still loading
	
	// Interactive - Meaning the DOM is completely loaded and parsed but some of it's sub-resources like
	// some scripts, stylesheets, images and Frames are still loading.
	
	// Complete - Meaning the DOM and all it's sub-resources have finished loading.
	
	// Below is the JavaScript to check the ready state of any web page:
	// 'document.readyState' - this command returns either loading or interactive or complete

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		// Checking if the document's / page's ready state is 'Complete' 
		// and interact with the elements only when the document's
		// ready state is Complete (Meaning the DOM and all it's sub-resources loaded completely)
		
		if(isPageLoaded(10)) {
			System.out.println("page is fully loaded");
		}
		
		

	}
	
	// Generic function to check if the document's / page's ready state is Complete (Meaning DOM
	// and all it's sub-resources are completely loaded) or not. And if it is then 
	// return true otherwise return false
	public static boolean isPageLoaded(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		String flag = wait.until(ExpectedConditions
				.jsReturnsValue("return document.readyState == 'complete'")).toString(); // The JS
		// written as the parameter of jsReturnsValue method will return either true or false. We have applied
		// toString at the end of the statement because the until method will return a JAVAScript Object
		// formatted data (true or false)
		
		return Boolean.parseBoolean(flag);
	}
	
	
	// [IMPORTANT - INTERVIEW] : How many states are there of a web page when it is loading? What are they?
	// How will you check each state when the page is getting loaded?
	// Ans: There are 3 states of a page: 
	// Loading
	// Interactive
	// Complete
	// The script to check all these states is "document.readyState"

}
