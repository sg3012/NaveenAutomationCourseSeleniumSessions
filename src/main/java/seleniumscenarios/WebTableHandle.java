package seleniumscenarios;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	// This class shows how to select a check box
	// and get the textual information
	// on a row inside a web table on a web page using
	// Selenium and verify if the info is correct or not.

	// It also shows the concept of FOLLOWING SIBLING AND PRECEDING SIBLING.

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		// 1. XPATH OF CHECKBOX (USING PRECEDING SIBLING):
		// E.g.:
		// //a[text()='Joe.Root']//parent::td
		   //preceding-sibling::td/input[@type='checkbox'] -->
		
		// xpath to select the Joe Root checkbox on the web table displayed on :
		// https://selectorshub.com/xpath-practice-page/ PAGE.
		// 3 sub-paths for this xpath.

		// 2. XPATH OF TEXTUAL INFO (USING FOLLOWING SIBLING):
		// a[text()='Joe.Root']//parent::td/following-sibling::td -->

		// xpath to get the Joe Root row's textual info on the web table displayed on :
		// https://selectorshub.com/xpath-practice-page/ PAGE.
		// 2 sub-paths for this xpath. Then we can use findelements method
		// in selenium to get all the textual elements on that row,
		// loop through those elements and verify the text.
		
		// FOLLOWING AND PRECEDING IN XPATH:
		// Following - this keyword will list down all the desired elements after the current node/element
		// Preceding - this keyword will list down all the desired elements before the current node/element

		// Find check-box and click:
		webTableCheckBoxSelect("Joe.Root");
		webTableCheckBoxSelect("John.Smith");
		webTableCheckBoxSelect("Garry.White");
		
		// Fetch the textual info on a row and print:
		System.out.println(webTableGetTextualInfoOfRows("Joe.Root"));
		System.out.println(webTableGetTextualInfoOfRows("John.Smith"));
		System.out.println(webTableGetTextualInfoOfRows("Garry.White"));

	}
	
	
	// Generic method to click check-box in a web table
	public static void webTableCheckBoxSelect(String empName) {
		driver
		.findElement(By.xpath("//a[text()='"+empName+"']//parent::td"
				+ "//preceding-sibling::td/input[@type='checkbox']"))
		.click();
	}
	
	// Generic method to get the List of all the textual Read Only information 
	// on a row of a web table
	public static List<String> webTableGetTextualInfoOfRows(String empName) {
		
		List<WebElement> rowTextEleList = 
				driver
		.findElements(By.xpath("//a[text()='"+empName+"']//parent::td/following-sibling::td"));
		System.out.println(rowTextEleList.size());
		List<String> rowCellActTextualInfoList = new ArrayList<String>();
		for(WebElement e : rowTextEleList) {
			String rowCellText = e.getText();
			rowCellActTextualInfoList.add(rowCellText);
		}
		return rowCellActTextualInfoList;
		
		// We can also implement this method by passing index
		// numbers for the columns also as the parameter
		// of this function, for the row which we want the info.
		// But that is not a good practice because what
		// if tomorrow the columns removed or added ? Then
		// the last index passed won't work for the required info.
	}

}
