package seleniumscenarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownWithOptions {

	// This class explains how we will count
	// the number of values in a select drop-down
	// and display each one of them on console
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// We will use GETOPTIONS method of select class for
		// achieving our goal as mentioned in the class description above

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		Thread.sleep(4000);

		By countryDropdown = By.id("Form_getForm_Country");
		
		// Check if one country exists in the drop-down or not
		if(getDropdownTextList(countryDropdown).contains("India")) {
			System.out.println("PASS");
		}
		
		// Check if a collection of countries exist in the drop-down in one Go
		// We will make use of CONTAINSALL method of JAVA
		
		// Containsall method takes a collection 
		// as an argument. So we will create our own collection
		// of countries using asList() method of Arrays class like below:
		List<String> expCountriesCollectionList = Arrays.asList("India", "Brazil", "Aruba");
		
		if(getDropdownTextList(countryDropdown).containsAll(expCountriesCollectionList)) {
			System.out.println(expCountriesCollectionList+ " is available");
		}

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	// Generic function to get the count of values from a drop-down
	public static int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();	
	}
	
	// Generic function to get all the actual values from a drop-down in a list
	public static List<String> getDropdownTextList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsElementList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		for (WebElement e : optionsElementList) {
			String optionValue = e.getText();
			System.out.println(optionValue);
			optionsTextList.add(optionValue);
		}
		return optionsTextList;
	}

}
