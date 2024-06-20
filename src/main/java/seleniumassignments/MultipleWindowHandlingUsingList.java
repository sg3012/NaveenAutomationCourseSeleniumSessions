package seleniumassignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandlingUsingList {

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

		String parentWindowID = driver.getWindowHandle();

		WebElement twEle = driver.findElement(By.xpath("//a[contains(@href,'twitter')]"));
		WebElement fbEle = driver.findElement(By.xpath("//a[contains(@href,'facebook')]"));
		WebElement linkEle = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));
		WebElement ytEle = driver.findElement(By.xpath("//a[contains(@href,'youtube')]"));

		twEle.click();// window 2 or tab 2
		Thread.sleep(1000);
		fbEle.click(); // window 3 or tab 3
		Thread.sleep(1000);
		linkEle.click(); // window 4 or tab 4
		Thread.sleep(1000);
		ytEle.click(); // window 5 or tab 5

		// Get window IDS of all the opened windows
		Set<String> handles = driver.getWindowHandles();

		// Convert this SET of window handles to
		// LIST OF window handles
		List<String> handlesList = new ArrayList<String>(handles);
		
		for(int i = 0; i<handlesList.size(); i++) {
			String windowId = handlesList.get(i);
			driver.switchTo().window(windowId);
			System.out.println("Window URL: "+ driver.getCurrentUrl());
			Thread.sleep(1500);
			if(!windowId.equals(parentWindowID)) {
				driver.close();
			}
		}
		
		driver.switchTo().window(parentWindowID);
		System.out.println("===================");
		System.out.println("Parent window URL: "+ driver.getCurrentUrl());

	}

}
