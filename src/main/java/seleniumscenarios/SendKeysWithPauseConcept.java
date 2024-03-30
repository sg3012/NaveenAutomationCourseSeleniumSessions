package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SendKeysWithPauseConcept {
	// (INTERVIEW QUESTION IMPORTANT)Go to any registration form
	// Fill any of the I/P fields
	// entering each character
	// one by one after a pause/slowly
	// in every i/p field

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		
		Actions act = new Actions(driver);
		
		String value = "TestAutomationSelenium";
		
		// Now break this string and convert into array of 
		// characters like this:
		
		char[] ch = value.toCharArray();
		
		// Iterate this character array
		// and then insert the string value
		// in the desired input field character
		// by character like below:
		
		for(int i =0; i<ch.length; i++) {
			
			// Using the actions class sendkeys method  to enter each character value
			
			// Using the pause method of actions class to have a little pause after
			// a value is entered
//			act.sendKeys(firstName, String.valueOf(ch[i]))
//			.pause(1000).perform();
			
			// what if you want to put space after each character entered?
			act.sendKeys(firstName, String.valueOf(ch[i])+" ")
			.pause(500).perform();
		}
	}
	
	// REAL TIME USE CASE OF THIS FEATURE:
	// In some applications there is elastic search functionality
	// implemented which requires to enter search string slowly
	// because it searches character by character. So, if you type
	// keywords very fast then the search results are gone. In those
	// cases we can use this feature.

}
