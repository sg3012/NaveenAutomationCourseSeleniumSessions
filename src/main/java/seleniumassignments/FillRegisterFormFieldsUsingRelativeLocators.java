package seleniumassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class FillRegisterFormFieldsUsingRelativeLocators {

	// This class will automate the following scenario:
	// Go to page: https://naveenautomationlabs.com/opencart
	// /index.php?route=account/register

	// On the registration form locate the text fields on
	// the registration form

	// Fill the first name field using Relative Locators
	// feature of Selenium 4

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart"
				+ "/index.php?route=account/register");
		Thread.sleep(3000);
		
		WebElement firstNameFieldBaseEle = driver.findElement(By.xpath("//label[text()='First Name']"));
		
		// Fill the actual input field to the RIGHT of 
		// first name label on the registration form
		
		driver.findElement(with(By.tagName("input")).toRightOf(firstNameFieldBaseEle))
			.sendKeys("Shubham");
	}

}
