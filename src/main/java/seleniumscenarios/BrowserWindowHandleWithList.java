package seleniumscenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandleWithList {

	// This class explains how to open and handle
	// multiple windows in Selenium by storing
	// all window handles or Ids in a LIST
	// instead of SET.
	// We are doing this conversion in order
	// to store all the handles as an order based collection
	// So that we could traverse and access the collection easily.

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver(); // blank browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // parent / very first window
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click(); // window2 OR tab2

		// 1. Fetching new window Ids:
		Set<String> handles = driver.getWindowHandles();

		// 2. Convert above SET to LIST:
		List<String> handlesList = new ArrayList<String>(handles); // SYNTAX
		// for converting a SET to LIST Collection by passing
		// SET reference to ARRAYLIST constructor.

		String parentWindowId = handlesList.get(0);
		String childWIndowId = handlesList.get(1);

		System.out.println(parentWindowId); // O/P - parent window ID
		System.out.println(childWIndowId); // O/P - child window ID

		// SWITCH TO WINDOWS:
		
		// Switch to child window:
		driver.switchTo().window(childWIndowId);
		System.out.println("Child window URL: " + driver.getCurrentUrl());

		// close the child window:
		driver.close();

		Thread.sleep(1500);

		// switch to parent window again:
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window URL: " + driver.getCurrentUrl());

		driver.quit();
		
	}

}
