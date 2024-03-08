package seleniumassignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountTotalInputFieldsOnAWebPage {
	// This class explains how to count total number
	// of input fields on a web page

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By inputs = By.tagName("input");

		List<WebElement> inputFieldsList = driver.findElements(inputs);
		
		int count = inputFieldsList.size();
		
		System.out.println("Total text field : "+ count);

	}

}
