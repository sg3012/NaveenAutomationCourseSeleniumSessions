package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionScrolling {

	// This class explains how we can
	// scroll down or up on page with finite
	// scrolling i.e, the page has an end,
	// using Actions class

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		
		Actions act = new Actions(driver);

		// We will use PAGE_DOWN feature
		// of the Keys Enum in the Actions class
		// of selenium to scroll DOWN.

		// Any feature in the Enum keys
		// corresponds to a keyboard action
		// a user does manually.
		// So, PAGE_DOWN means pressing
		// down arrow key on the keyboard
		// after opening a web page.
//		act.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
		
//		act.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(1000);
		
		// We will use PAGE_UP feature
		// of the Keys Enum in the Actions class
		// of selenium to scroll UP.
//		act.sendKeys(Keys.PAGE_UP).perform();
		
		// What about if you want to scroll down/up
		// completely to the end of the page in one GO ?
		
		// Ans: We will do it manually be pressing ctrl +
		// end keys /  ctrl +
		// home keys on the keyboard in Windows and
		// cmd (COMMAND) + end/cmd (COMMAND) + home keys on the keyboard
		// in MAC to reach the bottom/up in one go.
		// Now, we will use the same key combinations
		// in Selenium to perform scroll down/up
		// in the respective OS.
		
		// SCROLL DOWN TO THE END | FOR WINDOWS:
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).build().perform(); // END key is used to scroll page down
		
		Thread.sleep(1000);
		
		// SCROLL UP TO THE END | FOR WINDOWS:
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).build().perform(); // HOME key is used to scroll page up
		Thread.sleep(1000);
		
		// SCROLL TO ELEMENT - To scroll up to
		// a particular element on a web page
		
		// To do this we will use scrollToElement() method
		// of actions class
		// Use case 1 - Let's say we have to scroll down to the bottom
		// of the Big basket landing page and click the Link "Yakult"
		// under MTR section in the footer
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		act.scrollToElement(driver.findElement(By.linkText("Yakult")))
					.click(driver.findElement(By.linkText("Yakult")))
						.build()
							.perform();
		Thread.sleep(4000);
		
		// Use case 2 - Let's say we have to scroll up to the SNACKS STORE SECTION
		// of the Big basket landing page and click the Link "CHAI TIME SNACK"
//		act.scrollToElement(driver.findElement(By.xpath("//span[text()='Snacks Store']")))
//					.click(driver.findElement(By.xpath("//a[contains(@href,'chai-time-snack')]")))
//						.build()
//							.perform();
		
		
		// REFRESH A WEB PAGE USING ACTIONS CLASS:
		// We refresh a web page manually using fn + F5 key combinations
		//act.keyDown(Keys.COMMAND).sendKeys(Keys.F5).keyUp(Keys.COMMAND).build().perform();
		
		// However, don't use the above command to refresh the page as
		// MOST OF THE TIME IT FAILS. Use refresh() method of
		// RemoteNavigation class.
		
		driver.navigate().refresh();
		
		
		
		
	}

}
