package seleniumscenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalimagesConcept {
	// This class explains how to count
	// total images on a web page
	// Then print the src or alt attribute values

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		// Find all the images on the web page using 'img' tag:

		By images = By.tagName("img");

		List<WebElement> imagesList = driver.findElements(images);
		
		System.out.println("Total images: "+imagesList.size());
		
		// print the src and alt attribute value of each image
		
		for(WebElement ele : imagesList) {
			String srcValue = ele.getAttribute("src");
			String altValue = ele.getAttribute("alt");
			System.out.println(srcValue+ ":"+altValue);
		}

	}

}
