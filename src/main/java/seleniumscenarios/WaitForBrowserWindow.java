package seleniumscenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForBrowserWindow {
	
	// This class explains how to implement
	// wait strategy for non-web elements like
	// Browser pop-up windows.
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	    driver = new ChromeDriver(); // blank browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // parent / very first window
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click(); // window2 OR tab2
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		
		// numberOfWindowsToBe method will give you true or false
		// based on the number of windows you are expecting to be opened are
		// correct or not.
		// So, if you have clicked on a link and a single window gets opened with
		// one more parent window already opened, the total number of windows
		// opened at this point should be 2. So if we pass 2 in this (numberOfWindowsToBe)
		// method it will return true if and only if there are actually 2 windows opened.
		// Hence, this method gives us the guarantee that the number of windows
		// we are expecting to be opened are actually opened before we start our switching work
		// and perform actions.
		boolean flag = wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	    System.out.println(flag);
	}
	
	/**
	 * Generic method to check if the number of browser window pop-ups  
	   expected to be opened after clicking a link are correct and actually
	   opened or not 
	 * @param timeOut
	 * @param numberOfWindowsToBe
	 * @return true or false based on if the number of windows opened
	 * are matching the expected number of windows to be opened or not.
	 */
	public static boolean waitForNumberOfBrowserWindows(int timeOut,int numberOfWindowsToBe) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindowsToBe));		
	}
}
