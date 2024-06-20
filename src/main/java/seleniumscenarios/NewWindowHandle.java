package seleniumscenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindowHandle {

	// This class explains how to open a new blank tab
	// in a window > open an application in that tab >
	// perform any operation on the application in the opened tab
	// Using Selenium

	// In real time context opening a new window meaning opening a
	// whole new browser window and opening a new tab meaning
	// opening a new tab in the same browser window. But
	// in Selenium context opening a new tab and window mean the same
	// thing as we have to write switchTo().window() in both the
	// cases anyways. However, Selenium will open tab and windows
	// exactly like we do manually.
	
	// This feature is available only SELENIUM 4.x ONWARDS
	
	// This feature(opening a new window/tab and do some operations) 
	// is NOT SUPPORTED in CYPRESS. So, it doesn't support MULTI-WINDOW
	// handling which is again a DISADVANTAGE.
	
	// ANOTHER MAJOR DISADVANTGES WITH CYPRESS:
	// Cypress doesn't support Iframes, so you can't interact with
	// elements inside frames.
	
	// Cypress doesn't elements inside shadow DOM.
	
	// Cypress doesn't support PARALLEL EXECUTION in the free version.
	// If you really want to use then you have to pay for it.
	
	// Cypress doesn't support CORS policy natively. Meaning, if your
	// application has some domain name e.g. xyz.com and you are switching
	// to some other domain e.g. abc.com inside or outside the 
	// existing window, Cypress will give you exception. There are
	// some workarounds though to allow this , but there is not native support.

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // Window 1 / Parent window

		String parentWindowId = driver.getWindowHandle();

		Thread.sleep(3000);

		// OPENING A BLANK TAB
//		driver.switchTo().newWindow(WindowType.TAB); // by writting this line
//		// driver is already on the new TAB. So, we don't need to write
//		// extra switch command and getWindowHandles() as we are already
//		// on the TAB/WINDOW.
//
//		driver.get("https://www.google.com");
//
//		System.out.println(driver.getTitle());
//
//		Thread.sleep(1500);
//
//		driver.close();
//
//		driver.switchTo().window(parentWindowId);
//
//		System.out.println(driver.getTitle());

		// OPENING A BLANK WINDOW
		driver.switchTo().newWindow(WindowType.WINDOW); // by writting this line
		// driver is already on the new window. So, we don't need to write
		// extra switch command and getWindowHandles() as we are already
		// on the TAB/WINDOW.

		driver.get("https://www.google.com");

		System.out.println(driver.getTitle());

		Thread.sleep(1500);

		driver.close();

		driver.switchTo().window(parentWindowId);

		System.out.println(driver.getTitle());
	}

}
