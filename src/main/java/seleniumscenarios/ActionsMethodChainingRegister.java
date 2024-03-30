package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMethodChainingRegister {

	// (INTERVIEW QUESTION IMPORTANT)Go to any registration form
	// Fill the very first field in the form
	// using it's locator
	// and then got to and fill all the subsequent fields
	// without using their actual locator.
	// Fill the complete form and register the user

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// The MAIN IDEA Here is :
		// How will you switch to other
		// fields without using their locators
		// except the first field ?
		// Ans: How do you switch to the fields
		// manually without using mouse except the first field ?
		// Using the TAB key on the keyboard. So, we will use the
		// tab feature and BUILDER PATTERN in the actions class to achieve the goal.
		
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		
		Actions act = new Actions(driver);
		
		act.sendKeys(firstName, "Tarun")
		.sendKeys(Keys.TAB) // Use to press TAB on keyboard and move to nxt element from current element 
		.pause(1000) // Use to pause the script after entering and coming to nxt field
		.sendKeys("Automation")
		.sendKeys(Keys.TAB)
		.pause(1000)
		.sendKeys("automation@gmail.com")
		.sendKeys(Keys.TAB)
		.pause(1000)
		.sendKeys("9876543210")
		.sendKeys(Keys.TAB)
		.pause(1000)
		.sendKeys("automation@123")
		.sendKeys(Keys.TAB)
		.pause(1000)
		.sendKeys("automation@123")
		.sendKeys(Keys.TAB)
		.pause(1000)
		.sendKeys(Keys.TAB)
		.pause(1000)
		.sendKeys(Keys.TAB)
		.pause(1000)
		.sendKeys(Keys.SPACE)
		.pause(1000)
		.sendKeys(Keys.TAB)
		.pause(1000)
		.sendKeys(Keys.SPACE).build().perform(); 
		

	}

}
