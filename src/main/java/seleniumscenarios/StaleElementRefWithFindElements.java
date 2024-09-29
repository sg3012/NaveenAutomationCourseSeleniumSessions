package seleniumscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefWithFindElements {
	// This class explains whether we will get the staleElementRefException
	// when we are working with a list of webelements instead
	// of a single element or not?
	
	// We will get the StaleElementRefExc in case of List of
	// webelements also when the DOM is refreshed. But sometimes
	// what happens is the same webelement may work even
	// after page refresh but we will get the exception for sure
	// at some point while iterating the list.
	
	// How to resolve the exception?
	// Ans: Reinitialize the list as soon the DOM is refreshed 
	// as result of page refresh, back, forward etc.

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		List<WebElement> footerLinks = driver.findElements(By.cssSelector("footer a"));
		
		System.out.println("Number of footer links:"+footerLinks.size());
		
		for(int i=0 ; i<footerLinks.size(); i++) {
			footerLinks.get(i).click(); // StaleElemRefException at this point
			//Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(500);
			// Reinitialize the list of elements immediately
			// after going back to the same page
			footerLinks = driver.findElements(By.cssSelector("footer a"));
		}
	}
}
