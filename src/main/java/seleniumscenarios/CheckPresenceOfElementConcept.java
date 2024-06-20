package seleniumscenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckPresenceOfElementConcept {
	
	// This class explains how to
	// apply explicit wait for a webelement
	// based on if it is present in the DOM of a page or not.
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

	    driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		
		By username = By.name("username11");
		By password = By.name("password");
		By loginBtn = By.xpath("//button[@type='submit']");
		By forgotPwdLink = By.xpath("//p[text()='Forgot your password? ']");
		
		// Apply explicit wait only for username field not
		// other elements:
		
		// create object of webDriverwait class first:
		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		// Put a condition to wait under for a SPECIFIC element(username)
		// to be present in the DOM. If the condition is not
		// true then don't wait
		// WebElement username_ele = wait.until(ExpectedConditions.presenceOfElementLocated(username));
		// Above line is the 10th APPROACH to create a WEBELEMENT
		// If the element is not found even after wait time then 
		// NOSUCHELEMENTEXCEPTION will be raised
		
		// Perform action on the desired element, if found after the waiting time:
		// username_ele.sendKeys("admin");
		
		// Apply wait and user action for specific element(username) using the generic function below:
		waitForElementPresence(username, 10).sendKeys("admin");
		
		// DON'T WAIT for the other elements and perform action as usual (findelement() method + user action):
		driver.findElement(password).sendKeys("admin");
		driver.findElement(loginBtn).click();
		
		// Apply wait and user action for specific element(forgot password link) 
		// using the generic function below:
		//waitForElementPresence(forgotPwdLink, 5).click();
		waitForElementVisible(forgotPwdLink, 5).click();
		
//		presenceOfElementLocated() method checks if the element in question
//		is present in the DOM or not. It doesn't check if the element is
//		actually visible on the page or not. Meaning, if an element is
//		present in the DOM of the page but not visible on the page
//		it will return you the element but when you try
//		to perform an action then Selenium might throw
//		an exception as the element is still not visible on the page. 
//		On the other hand if an element is visible
//		on the page but not yet loaded in the DOM then this method
//		fails and throws NoSuchElementException.
		
//		So is it a right method to wait for an element an create it
//		on the basis of its presence in the DOM ? 
		
	    // Ans: No. Because selenium might throw an exception
		// as element is not yet visible on the page.
		
		// What is the right way of waiting for an element, create it and perform an action
		// via explicit wait?
		// Ans: On the basis of its presence in the DOM as well as visibility on the PAGE. The method
		// in the ExpectedConditions class to do it is "visibilityOfElementLocated"
	
		// What is the meaning of an element is VISIBLE ON A PAGE?
		// Ans - If an element is visible on a page it means
		// that its height and width are definitely greater than 0.
		
		
	}
		 
	/**Generic function to wait for an element based on
	   if its present in the HTML code (DOM) of a page
	   or not, irrespective of its visibility on the page
	 * @param locator
	 * @param timeOut
	 * @return WebElement
	 */
	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
	}
	
	/**Generic function to wait for an element based on
	   if its visible on the page or not, irrespective of
	   its presence in the DOM. Visible on page means
	   the element's height and width should be greater than 0. 
	 * @param locator
	 * @param timeOut
	 * @return WebElement
	 */
	public static WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
