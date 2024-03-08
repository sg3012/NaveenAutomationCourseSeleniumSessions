package seleniumscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterValueInDisabledTextField {
	
	 // This class shows -
	 // HOW TO HANDLE DISABLED TEXT FIELDS AND ENTER VALUES IN THEM?

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com"
				+ "/2016/09/how-to-work-with-disable-textbox-or.html");
		
//		driver.findElement(By.id("pass")).sendKeys("test@123"); 
		// (INTERVIEW) What will you get if you try to enter anything in
		// a disabled text field ?
		// Ans : Now if you run the above
		// script directly without handling the disabled text field
		// it will throw "ElementNotInteractableException: element not interactable"
		//So, how can we handle the disabled text fields? See Below:
		
		// Check element is disabled or not:
		boolean flag = driver.findElement(By.id("pass")).isEnabled();
		System.out.println(flag);
		
		// Check element is displayed or not:
		boolean flag1 = driver.findElement(By.id("pass")).isDisplayed();
		System.out.println(flag1);
		
		// Fetch the "disabled" attribute value from the HTML DOM of the Element:
		String disabled_val = driver.findElement(By.id("pass")).getAttribute("disabled");
		System.out.println(disabled_val);		
	}
	
	public static boolean checkElementIsDisabled(By locator) {
		String disabledValue = getElement(locator).getAttribute("disabled");
		if(disabledValue.equals("true")) {
			return true;
		}
		return false;
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
