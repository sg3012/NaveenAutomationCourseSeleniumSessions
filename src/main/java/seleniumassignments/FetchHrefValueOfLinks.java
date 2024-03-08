package seleniumassignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchHrefValueOfLinks {
	// This class explains how to
	// fetch the HREF value of each and every link
	// on a web page and then print it.

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		// Find all the links on the web page using 'a' tag:

		By links = By.tagName("a");

		List<WebElement> linksList = driver.findElements(links);
		
		// Print the HREF value of each and every link:
		for(WebElement ele : linksList) {
			String hrefVal = ele.getAttribute("href");
			System.out.println(hrefVal);
		}

	}

}
