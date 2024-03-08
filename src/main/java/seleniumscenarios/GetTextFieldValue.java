package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextFieldValue {
	// (INTERVIEW)
	// This class explains how we can fetch the text entered
	// explicitly in a text field on any web page.
	// For e.g. there is a text field called City and
	// user has entered "Delhi" in it then we have to fetch the
	// value "Delhi"

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart"
				+ "/index.php?route=account/register");
		
		By firstName = By.id("input-firstname");
		
		// Enter the value in the first name field
		
		driver.findElement(firstName).sendKeys("testselenium");
		
		// To fetch the text which is entered in a text field manually
		// we will use getAttribute() method of Selenium with
		// 'value' as the parameter. Because when we enter any 'value' in a text
		// field on any web page the HTML code for that element contains
		// an attribute called "value" which holds the text user has entered in it.
		
		String fn_value = driver.findElement(firstName).getAttribute("value");
		System.out.println(fn_value); // testselenium
		
		

		
	}

}
