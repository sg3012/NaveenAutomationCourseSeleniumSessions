package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownHandle {
	
	// This class explains how to handle
	// the drop-downs in Selenium
	// that have a  <select> HTML tag
	
	// We use Select class of selenium library
	// to handle these drop-downs.
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		Thread.sleep(4000);
		
		By countryDropdown = By.id("Form_getForm_Country");	
		// WebElement country_Ele = driver.findElement(countryDropdown);
		// Select select = new Select(country_Ele);
		//select.selectByIndex(5); // Andorra will be selected 
		// we avoid using selectByIndex as there is no Gurantee
		// that an element which is visible at a certain index
		// will always be visible at that index only. So,
		// to overcome this we use following methods:
		
		// We will use selectByIndex in those cases where
		// the index of an element remains same.
		// For e.g. In a Month drop-down the index
		// for June will always be 6, index for Dec will always be 12 etc.
		
		//select.selectByVisibleText("India"); // India will be selected
		// select.selectByValue("Colombia"); // Colombia will be selected
		
		// The main difference between selectByVisibleText and
		// selectByValue is the former selects a value
		// by that text which is visible, passed as the argument
		// while the later selects that value which 
		// has the <value> attribute in the HTML code 
		// with that value which is passed as the function argument.
		
		// Now if there are 10 select drop-downs on a page then we have to create
		// 10 different select class objects with 10 different web elements.
		// To avoid that repetitive work, we will create a generic function
		
		doSelectDropdownByIndex(countryDropdown, 5);
		doSelectDropdownByVisibleText(countryDropdown, "Brazil");
		doSelectDropdownByValue(countryDropdown, "Colombia");

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	// Generic custom function to select a value from select drop-down using index of the element
	public static void doSelectDropdownByIndex(By locator, int index) {
		if(index < 0) {
			System.out.println("Pls pass the right (+ve) index");
			return;  // only writing return in any code block and return type void
			         // means the same in JAVA. Simply writing return means return nothing
			         // i.e, void and come out of the function body
		}
		
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	// Generic custom function to select a value from select drop-down using visible text of the element
	public static void doSelectDropdownByVisibleText(By locator, String visibleText) {
		if(visibleText == null) {
			System.out.println("Pls pass the right visible text and it cannot be null");
		}
		
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}

	// Generic custom function to select a value from select drop-down using value attribute of the element
	public static void doSelectDropdownByValue(By locator, String valueAttr) {
		if(valueAttr == null) {
			System.out.println("Pls pass the right value of value attribute. It cannot be null");
		}
		
		Select select = new Select(getElement(locator));
		select.selectByValue(valueAttr);
	}

}
