package seleniumscenarios;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CarouselHandling {
	// This class explains how we could
	// handle/automate the scrolling/navigation in a Carousel
	// on a web page using Selenium.

	// This class explains how we could scroll through complete list
	// in a caraousel in one direction until the arrow for scrolling
	// gets hidden
	
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.noon.com/uae-en/");
		
		String xpath = "//h2[text()='Recommended for you']/../..//following-sibling::div"
				+ "//div[@data-qa='product-name']";
		String next_xpath = "//h2[text()='Recommended for you']/../..//following-sibling"
				+ "::div//div[contains(@class,'swiper-button-next')]";
		
		List<WebElement> prodEleList = driver.findElements(By.xpath(xpath));
		
		Set<String> prodSet= new LinkedHashSet<String>(); // We have used
		// the LinkedHashSet here to store the titles because
		// LinkedHashset has 2 important properties:
		// 1. It doesn't allow duplicate values
		// 2. It stores and displays the values in the insertion order
		
		while(!driver.findElement(By.xpath(next_xpath)).getAttribute("class").contains("swiper-button-disabled")) {
			
			// Capture the title of every tile displayed
			// in the carousel list in the current view
			for(WebElement e : prodEleList) {
				String title = e.getAttribute("title");
				// System.out.println(title); // In this example all
				// the titles of the titles in Carousel will be stored in the List
				// at the very first time only. So, this line will
				// print all the titles every time the next button on
				// carousel is hit.
				// To solve this problem we will store the titles
				// in a LinkedHashSet as shown just above the while loop
				prodSet.add(title);
			}
			
			// click on the next button on Carousel to
			// open the next view of the list
			driver.findElement(By.xpath(next_xpath)).click();
		}
		
		// Iterate the product set of titles
		// outside any loop and display all the titles
		// at once and only once.
		for(String e : prodSet) {
			System.out.println(e);
		}
	}

}
