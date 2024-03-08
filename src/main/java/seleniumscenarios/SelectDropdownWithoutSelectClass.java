package seleniumscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownWithoutSelectClass {
	// (INTERVIEW QUESTION - IMPORTANT)
	// This class explains how to handle
	// the drop-downs in Selenium
	// that have a <select> HTML tag
	// But WITHOUT using SELECT class AT ALL

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		Thread.sleep(4000);

		// Locate options By Using Xpath:
//		By countryDropDownEle = By.xpath("//select[@id='Form_getForm_Country']/option");
		
		// Locate options By Using CSS:
        By countryDropDownEle = By.cssSelector("select#Form_getForm_Country > option");
		
		doClickDropDownValueUsingLocator(countryDropDownEle, "India");
		Thread.sleep(2000);
		doClickDropDownValueUsingLocator(countryDropDownEle, "Australia");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	// Generic method to click any value in a drop-down but
	// WITHOUT using the select class at all
	public static void doClickDropDownValueUsingLocator(By locator, String dropDownValue) {
		List<WebElement> optionsList = driver.findElements(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(dropDownValue)) {
				e.click();
				break;
			}
		}
	}

}
