package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSendKeysAndClick {
	
	// This class explains how we can enter
	// values and click on elements on any web form
	// using actions class sendkeys and click method.

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailID = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(emailID), "test@gmail.com").perform();
		Thread.sleep(1500);
		act.sendKeys(driver.findElement(password), "test@123").perform();
		Thread.sleep(1500);
		act.click(driver.findElement(loginBtn)).perform();
		
		
		// DIFFERENCE BETWEEN Actions class sendKeys() and WebElement sendKeys() method
		// The major difference Actions' class sendkeys and WebElement's sendKeys method is 
		// that Actions' class sendkeys first clicks on the desired input field 
		// and then start entering the values whereas the WebElement sendKeys() method 
		// directly starts entering values without clicking the desired i/p field.
		
		// DIFFERENCE BETWEEN Actions class click() and WebElement click() method
		// The major difference Actions' class click and WebElement's click method is 
		// that Actions' class click goes to the MIDDLE of the element and then click
		// on it whereas WebElement click method just click the desired element
		// as soon it is visible on any RANDOM position.
		
		
		
		// WHEN TO USE ACTIONS CLASSES IN REAL TIME?
		
		// Let's say some click element is partially overlapped by any other element
		// on a web page. Now, if use web element click method it will not work
		// and selenium will throw ElementNotInteractable or ElementNotClickable
		// exception. In that case we could use Actions class click
		// which will go to the middle of the element and click on it.
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	// Generic method to click on an element using actions class
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	// Generic method to enter value in an I/P field using actions class
	public static void doActionsSendKeys(By locator, String keys) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), keys).perform();
	}

}
