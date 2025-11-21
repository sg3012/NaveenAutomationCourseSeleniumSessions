package seleniumscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePaginationConcept {

	// This class explains the use case
	// of handling a web table row selection
	// that has pagination implemented and the
	// row to be selected can be at any place
	// inside pagination

	// We will handle following cases:

	// 1. Select a row having specific value with the value
	// on some middle page of the pagination, by clicking next button
	// until the element is visible

	// 2. Select a row having specific value with the value
	// on the first page of the pagination itself, then we don't need to click
	// next button at all

	// 3. Select a row having specific value with the value
	// on the last page of the pagination, then we need to click
	// next button until control reaches the last page and element
	// is found. Once, the element is selected we will break the loop.

	// 4. Select a row having specific value with the value
	// not even present on any page of the pagination, then we need to click
	// next button until control reaches the last page and element
	// is not found. Once, the element is not found will break the
	// loop and print a message that "element is not found"

	// 5. Select multiple rows with multiple values on the pagination

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);
		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// Multi-selection(Select MULTIPLE ROWS in a web table using pagination):
		while (true) {
			if (driver.findElements(By.xpath("//td[text()='Russia']")).size() > 0) {
				selectMultipleCountries("Russia");
			}
			
			// Click the next button irrespective of whether the element is found or not
			WebElement nextBtn = driver.findElement(By.xpath("//button[contains(@class,'next')]"));
			// checking if next button is disabled or not(User is on the last page)
			if(nextBtn.getAttribute("class").contains("disabled")) {
				System.out.println("Pagination is over....Nothing to select....");
				break; // user is on the last page of pagination and country is not found.
				       // So, break the loop here too.
			}
			nextBtn.click();
			Thread.sleep(200);

		}

//		// Single selection(Select only SINGLE ROW in a web table using pagination):
//		while(true) {
//			// Element is on the first page itself
//			if(driver.findElements(By.xpath("//td[text()='Canada']")).size()>0){
//				selectCountry("Canada");
//				break; // country is found, check-box on the row is selected
//				       // task is done. So, break the loop.
//			} // We have
//			  // used findElements() here because if we would have used
//			  // findElement() and the element was not found, then findelement()
//			  // would have given an exception and we would need to handle it.
//			  // But using findElelements() we will get a list of
//			  // webelements of size 0 if no element is found using
//			  // the locator. Hence, we don't have to handle the exception unnecessary.
//			   
//			  // and we have included a check of list size>0 because
//			  // if the list size is > 0 (meaning, the row element we wanted to found
//			  // with a particular text i.e. Denmark) then only we need to perform
//			  // the actions written in the if block
//			else {
//				WebElement nextBtn = driver.findElement(By.xpath("//button[contains(@class,'next')]"));
//				// checking if next button is disabled or not(User is on the last page)
//				if(nextBtn.getAttribute("class").contains("disabled")) {
//					System.out.println("Pagination is over....country is not found....");
//					break; // user is on the last page of pagination and country is not found.
//					       // So, break the loop here too.
//				}
//				nextBtn.click();
//				Thread.sleep(200);
//			}
//		}
	}

	public static void selectMultipleCountries(String countryName) {
		List<WebElement> rowEleList = driver.findElements(
				By.xpath("(//td[text()='" + countryName + "'])" + "/preceding-sibling::td/input[@type='checkbox']"));
		for (WebElement e : rowEleList) {
			e.click();
		}
	}

	public static void selectCountry(String countryName) {
		driver.findElement(
				By.xpath("//td[text()='" + countryName + "']" + "//preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

}
