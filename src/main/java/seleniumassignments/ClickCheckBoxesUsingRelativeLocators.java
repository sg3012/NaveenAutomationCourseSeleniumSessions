package seleniumassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ClickCheckBoxesUsingRelativeLocators {
	// This class will automate the following scenario:
	// Go to page: https://naveenautomationlabs.com/opencart
	//       /index.php?route=account/register

	// On the registration form locate Privacy policy check box 
	// at the bottom of the form

	// Click on the check box Radio buttons
	// using Relative locators concept of Selenium 4

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart"
				+ "/index.php?route=account/register");
		Thread.sleep(3000);
		
	    WebElement privacyPlcyBaseEle = driver.findElement(By.
	    		xpath("//a/b[text()='Privacy Policy']"));
	    
	    // Click the privacy policy check box to
	    // the RIGHT of Privacy policy link
	    
	    driver.findElement(with(By.tagName("input"))
	    		.toRightOf(privacyPlcyBaseEle)).click();
	}

}
