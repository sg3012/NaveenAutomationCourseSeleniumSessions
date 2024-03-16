package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcept {
	
	// This class explains how we can
	// move to a particular element (mouse hover) on
	// a web page using Selenium
	
	// This could be achieved using ACTIONS class
	// in Selenium

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");	
		
//		Thread.sleep(4000);
//		
//		WebElement parentMenu = driver.findElement(By.xpath("//a[text()='Resources']"));
//		
//		// Create object of Actions class using driver object reference
//		Actions act = new Actions(driver);
//		
//		// Move to the desired element using Actions class object reference
//		
//		// act.moveToElement(parentMenu); //  no build, no perform. Invalid will not perform any action
//		// act.moveToElement(parentMenu).build(); //  only build, no perform. Invalid will not perform any action
//		act.moveToElement(parentMenu).perform(); // only perform. Valid for single user action only.
//		// act.moveToElement(parentMenu).build().perform(); // both build and perform. 
//		// Valid for both single and multiple user actions.
//		
//		Thread.sleep(1500);
//		
//		driver.findElement(By.linkText("Blog")).click();
		
		By parentMenu = By.xpath("//a[text()='Resources']");
		By childMenu = By.linkText("eBooks");
		multiLevelMenuHandling(parentMenu, childMenu);
		
			
		// NOTE:  REMEMBER - Actions class object takes driver reference as the parameter but Select class object
		// takes Webelement reference as parameter
		
		// FOR SELENIUM 3 OR LOWER
		// For SINGLE user action we could use either use .build() and .perform()
		// both or only .perform() after user action, it will work
		
		// For MULTIPLE user actions we MUST use .build() and .perform()
		// both otherwise it will not work
		
		// FOR SELENIUM 4 OR ABOVE
		// For SINGLE OR MULTIPLE user action(s) we could use either use .build() and .perform()
		// both or only .perform() after user action, it will work.
		
		// We MUST use .perform() in any case and in any selenium version with Actions class
		// otherwise the action will not work.
		
		// (INTERVIEW): What is the exception that selenium will throw
		// when you don't use perform() method or you only use
		// build() or no build() and no perform()?
		
		// Ans: Selenium DOESN'T throw any EXCEPTION
		
		
		
	}
	
	
	// (INTERVIEW QUESTION - IMPORTANT) How will you create 
	// a generic function / utility for level 2 menu items?
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	// Generic method to handle exactly 2 level menus like header navigation
	// and perform actions like click, mouse hover the sub-menu links etc.
	public static void multiLevelMenuHandling(By level1MenuLocator,By level2MenuLocator ) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(level1MenuLocator)).perform();
		Thread.sleep(1500);
		getElement(level2MenuLocator).click();
	}

}
