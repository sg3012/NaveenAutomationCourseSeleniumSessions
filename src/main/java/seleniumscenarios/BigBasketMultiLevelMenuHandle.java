package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasketMultiLevelMenuHandle{
	
	// This class shows how to handle multi-level
	// menus on any web app and perform
	// actions like mouse over, click etc.
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Steps to pause the DOM:
		// Open dev tools.
		
		// Go to the webelement you want to inspect or create the corresponding scenario to generate
		// it
		
		// Go to sources tab in the dev tool.
		
		// Press fn + f8 and inspect the element now
		
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(3000);
		
//		WebElement level1MenuLink = driver.findElement(By.xpath("//div[contains(@class,'content-start')]"
//				+ "//div[contains(@class,'CategoryMenu___StyledBackdrop')]"
//				+ "//button[contains(@id,'menu-button')]"));
//		Actions act = new Actions(driver);
//		act.moveToElement(level1MenuLink).click().perform();
//		Thread.sleep(1500);
//		
//		WebElement level2MenuLink = driver.findElement(By.linkText("Beverages"));
//		act.moveToElement(level2MenuLink).perform();
//		Thread.sleep(1500);
//		
//		WebElement level3MenuLink = driver.findElement(By.linkText("Tea"));
//		act.moveToElement(level3MenuLink).perform();
//		Thread.sleep(1500);
//		
//		WebElement level4MenuLink = driver.findElement(By.linkText("Green Tea"));
//		level4MenuLink.click();
		
		By level1MenuLink = By.xpath("//div[contains(@class,'content-start')]"
				+ "//div[contains(@class,'CategoryMenu___StyledBackdrop')]"
				+ "//button[contains(@id,'menu-button')]");
		
		multiLevelMenuHandling(level1MenuLink, "Beverages", "Tea", "Green Tea");
		multiLevelMenuHandling(level1MenuLink, "Bakery, Cakes & Dairy", "Dairy", "Cheese");
		multiLevelMenuHandling(level1MenuLink, "Beauty & Hygiene", "Oral Care", "Mouthwash");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	// Generic method to create web element using Link's text
	public static WebElement getLinkElementByText(String linkText) {
		return driver.findElement(By.linkText(linkText));
	}
	
	// Generic method to handle exactly 4 level menus like header navigation
	// and perform actions like click, mouse hover the sub-menu links etc.
	public static void multiLevelMenuHandling(By level1Locator, String level2, String level3, String level4) throws InterruptedException {
		Actions act = new Actions(driver);
		getElement(level1Locator).click();
		Thread.sleep(1500);
		act.moveToElement(getLinkElementByText(level2)).perform();
		Thread.sleep(1500);
		act.moveToElement(getLinkElementByText(level3)).perform();
		Thread.sleep(1500);
		getLinkElementByText(level4).click();	
	}
	
	// Generic method to handle exactly 4 level menus like header navigation
	// and perform actions like click, mouse hover the sub-menu links etc.
	public static void multiLevelMenuHandling(By level1Locator, String level2, String level3) throws InterruptedException {
		Actions act = new Actions(driver);
		getElement(level1Locator).click();
		Thread.sleep(1500);
		act.moveToElement(getLinkElementByText(level2)).perform();
		Thread.sleep(1500);
		getLinkElementByText(level3).click();	
	}

}
