package seleniumscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickConcept {

	// This class explains how we could
	// do a right click on an element, open a context, 
	// collect all the menu items available in that
	// context menu and click on a particular item
	// menu on a web app
	
	// we will use CONTEXTCLICK method of
	// Actions class in Selenium for the purpose
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		Thread.sleep(2000);
		
		// WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		// Actions act = new Actions(driver);
		
		// Use context click method to right click on the desired element
		// act.contextClick(rightClickEle).perform(); // only one action, so we could perform directly.
		
		// CLICK ON THE MENU ITEM
		// METHOD 1: Collect all the menu items in a list,
		// iterate that list and click on the desired menu item
		
//		// Find all the context menu items and store in a List
//		List<WebElement> menuItemsList = driver.
//											findElements(By.
//												cssSelector("ul.context-menu-list.context-menu-root span"));
//		// print the size of the items
//		System.out.println(menuItemsList.size());
//		
//		// print the text of each menu item and click on the desired element using loop
//		for(WebElement e : menuItemsList) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.equals("Copy")) {
//				e.click();
//				break; // DO NOT FORGET TO WRITE BREAK
//				       // AFTER YOU CLICK ANY ELEMENT
//				       // INSIDE A LIST OF WEBELEMENT
//				       // TO PREVENT THE LOOP ON KEEP ITERATING
//				       // even after the desired element is clicked. 
//			}
//		}
		
		// METHOD 2: Reach to the specific menu item using xpath directly
		// and click on it
		//driver.findElement(By.xpath("//span[text()='Copy']")).click();
		
		By contextMenuLocator = By.xpath("//span[text()='right click me']");

		clickOnRightClickMenuItem(contextMenuLocator, "Quit");
				
		// NOTE: We CANNOT do right click and open the context menu
		// NATIVE TO BROWSER like Chrome, FF etc. We can only open the
		// context menu via right click on a WEB ELEMENT related to
		// the web app that is opened.
		
		// QUICK TIP (KEYBOARD SHORTCUT): 
		// Whenever we want a particular expression
		// to be assigned to a variable in Eclipse press ctrl + shift + 2,
		// then the context menu opened at the bottom right corner
		// choose the option Quick assist - Assign to local variable
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	// Generic method to right click on an item , open a context menu
	// and click on any of the menu items
	public static void clickOnRightClickMenuItem(By contextMenuLocator, String menuItemValue) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(contextMenuLocator)).perform();
		By menuItemLocator = By.xpath("//*[text()='"+menuItemValue+"']"); // We are using * instead of htmltag
		                                                                  // in this xpath because * in xpath
		                                                                  // means an element with any type
		                                                                  // of html tag but with certain properties
		// So, here this xpath interprets all the elements that having a text irrespective of 
		// the htmltag.
		getElement(menuItemLocator).click();
	}

}
