package seleniumassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementRefExceptionOnPagebackForward {
	
	// This class explain how do we get the StaleElementReferenceException
	// when back and forward navigation from the browser to any page.

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		// Navigate to login page
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login"); 
		
		WebElement username = driver.findElement(By.id("input-email")); 
		
		username.sendKeys("sg@gmail.com"); 
		
		Thread.sleep(2000);
		
		// Navigate to Register page
		driver.findElement(By.linkText("Register")).click();
		
		// Enter value in the first name field
		driver.findElement(By.id("input-firstname")).sendKeys("Shubham");
		
		Thread.sleep(1500);
		
		// Navigate back to login page 
		driver.navigate().back();
		
		Thread.sleep(1000);
		
		// Enter the value in the email field using same locator
		username.clear();
		username.sendKeys("RohitSharma@gmail.com"); 
		
		


	}

}
