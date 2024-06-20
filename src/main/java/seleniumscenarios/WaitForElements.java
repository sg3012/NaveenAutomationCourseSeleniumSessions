package seleniumscenarios;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElements {

	// This class explains how we could wait and
	// locate a list of web elements like all links
	// on the footer of a page, a list of drop-down elements etc.

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
		By dropdownOptions = By.cssSelector("select#Form_getForm_Country > option");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		List<WebElement> optionsListElements = wait.until(ExpectedConditions
											.presenceOfAllElementsLocatedBy(dropdownOptions)); // Here
		// until method will give a list of webelement now.
		
		System.out.println(optionsListElements.size());
	 	
		// [INTERVIEW] How is presenceOfAllElementsLocatedBy different from presenceOfElementLocatedBy
		// in the wait library of Selenium?
		// Ans: presenceOfElementLocatedBy doesn't wait for whether an element is
		// actually displayed on the page or not. It just waits for whether the element
		// is present in the DOM and returns it if is there. Whereas presenceOfAllElementsLocatedBy
		// waits for whether at least one element in a list of web elements is actually
		// visible on the page or not and returns the complete list of web elements
		// if at least one single element is visible on the page
		
		
		// [INTERVIEW] How is presenceOfAllElementsLocatedBy different from visibilityOfAllElementsLocatedBy
		// in the wait library of Selenium?
		// Ans: presenceOfAllElementsLocatedBy waits for AT LEAST ONE webelement in a list
		// of web elements on a web page based on whether it is actually
		// visible on the page or not and returns the complete list of web elements
		// based on that one element. Whereas visibilityOfAllElementsLocatedBy waits 
		// for ALL the webelements in a list of web elements on a web page 
		// based on whether they is actually visible on the page or not, in a single go and 
		// returns the complete list of web elements only after waiting for all the elements
		// in that list. 
		
		// [INTERVIEW] What would you prefer in your framework presenceOfAllElementsLocatedBy
		// or visibilityOfAllElementsLocatedBy ?
		// So, performance wise presenceOfAllElementsLocatedBy is better than
		// visibilityOfAllElementsLocatedBy because visibilityOfAllElementsLocatedBy will
		// wait for all the elements in a single go and then only returns the list
		// if all the elements are present but presenceOfAllElementsLocatedBy 
		// will wait for at least one element to be there
		// in the list and returns the complete list if that single element is present.
		// So WE WILL PREFER presenceOfAllElementsLocatedBy in our framework.
	}
	
	/**Generic function to wait for AT LEAST ONE web element on a web page based on
	   if it is actually visible in a List on the web page or not. If it is
	   there then only this method will return the complete list of web elements
	 * @param locator
	 * @param timeOut
	 * @return List of WebElements
	 */
	public static List<WebElement> waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));	
	}
	
	/**Generic function to wait for ALL the web elements on a web page based on
	   if they ALL are present in a List in the HTML code (DOM) of a page
	   as well as its visible on the page. If it is
	   there then only this method will return the complete list of elements.
	   Visibility means the elements are not only visible on the page
	   but also have a height and width Greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return List of WebElements
	 */
	public static List<WebElement> waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));	
	} 

}
