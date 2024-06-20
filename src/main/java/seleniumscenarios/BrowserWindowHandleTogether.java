package seleniumscenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandleTogether {

	// This class explains how to handle
	// MULTIPLE BROWSER WINDOW POP-UPs
	// in a single go, WITHOUT closing
	// the parent window. (IMPORTANT INTERVIEW QUESTION)

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver(); // blank browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // parent / very first window
		Thread.sleep(3000);

		String parentWindowID = driver.getWindowHandle();
		// We are capturing the parent window ID
		// in the above line of code because when we will
		// iterate through all the windows using the loop below
		// and close them after doing our work, the loop
		// will attempt to close the parent window as well (which we don't want).
		// So, to avoid this we will apply a check in the loop
		// to only close the non-parent windows
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

		// When there are multiple window IDs
		// stored in the SET they MAY or MAY NOT
		// be stored in the SAME ORDER in which
		// they were opened.

		Iterator<String> it = handles.iterator();

		// Loop through all the window IDs
		// to get the window Id you want and perform
		// desired action
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(1500);
			if (!(windowId.equals(parentWindowID))) {
				driver.close();
			}
		}
		
		// Now to continue your work after the loop
		// on parent window, you MUST SWITCH to
		// the parent window
		
		driver.switchTo().window(parentWindowID);
		System.out.println("================");
		System.out.println("Parent window URL: "
		+driver.getCurrentUrl()); //O/P - https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
	}

}
