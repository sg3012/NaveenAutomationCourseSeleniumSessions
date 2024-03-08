package seleniumscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinksConcept {

	// This class explains how to count
	// total links/URLS on a web page
	// Then print the text of each link
	// on the console.
	// But don't print the empty/blank text (Links having no text)

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		// Find all the links on the web page using 'a' tag:

		By links = By.tagName("a"); // This is the use of tagname locator
		// where we need to find all the elements with similar tag

		List<WebElement> linksList = driver.findElements(links);
		System.out.println(linksList);

		// Store the size of list using size method:
		int linksCount = linksList.size();

		// Print the size of links/list:
		System.out.println("Total Links = " + linksCount);

		// Print the text of each link:

		// Using index based for loop:
//		for (int i = 0; i < linksCount; i++) {
//			String text = linksList.get(i).getText();
//			// Check if the text string is empty or not
//			// if it is empty then don't print the text else print it.
//			if(!text.isEmpty()) {
//				System.out.println(i+ " : "+ text);
//			}
//		}

		// Using for each loop:
		int count = 0;
		for (WebElement ele : linksList) {
			String text = ele.getText();
			if(!text.isEmpty()) {
				System.out.println(count+ ": "+ text);
			}
			count++;
		}

	}

}
